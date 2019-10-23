package service;

import java.util.ArrayList;
import java.util.List;
import entity.BusStopEntry;
import entity.BusStopShedule;

public class BusStopEntryService {
	
	private static final Long MAXIMUM_STOP_LENGTH = 60l;

	public static BusStopShedule createShedule(List<BusStopEntry> entries) {
		List<BusStopEntry> sortedList = new ArrayList<>();
		entries = removeIllegalEntries(entries);
		for (BusStopEntry e: entries) {
			if (checkAvailability(e, sortedList) && !haveBetterOption(e, entries)) {
				sortedList.add(e);
			}
		}
		
		return new BusStopShedule(sortedList);
	}
	
	private static List<BusStopEntry> removeIllegalEntries(List<BusStopEntry> entries){
		List<BusStopEntry> legalEntries = new ArrayList<>();
		for (BusStopEntry e: entries) {
			if (e.getStopTime() <= MAXIMUM_STOP_LENGTH) {
				legalEntries.add(e);
			}
		}
		return legalEntries;
	}
	
	private static boolean haveBetterOption(BusStopEntry current, List<BusStopEntry> entries) {
		return entries.stream()
				.filter(p -> p.getStopTime() < current.getStopTime() 
						&& (p.getArrival().equals(current.getArrival()) 
								|| p.getDeparture().equals(current.getDeparture()) 
								|| (p.getArrival().isAfter(current.getArrival()) 
										&& p.getDeparture().isBefore(current.getDeparture()))
							)
						|| (p.getCompanyName().equals("Posh")
								&& current.getCompanyName().equals("Grotty")
								&& p.getArrival().equals(current.getArrival()) 
								&& p.getDeparture().equals(current.getDeparture()) 
						)
				)
				.findAny()
				.isPresent();
	}
	
	private static boolean checkAvailability(BusStopEntry current, List<BusStopEntry> entries){
		
		return true;
	}
	
}
