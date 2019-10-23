package utils;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import entity.BusStopEntry;
import entity.BusStopShedule;

public class EntryParser {

	public static List<BusStopEntry> parseInput(List<String> stringEntries) {
		List<BusStopEntry> entries = new ArrayList<>();

		stringEntries.forEach(s -> {
			String[] entryParts = s.split(" ");
			if (entryParts.length == 3) {
				LocalTime start = LocalTime.parse(entryParts[1]);
				LocalTime end = LocalTime.parse(entryParts[2]);
				BusStopEntry entry = new BusStopEntry(entryParts[0], start, end, ChronoUnit.MINUTES.between(start, end));
				entries.add(entry);
			}
		});
		return entries;
	}
	
	public static List<String> parseOutput(BusStopShedule shedule) {
		List<String> lines = new ArrayList<>();
		shedule.getEntries().stream()
			.filter(e -> e.getCompanyName().equals("Posh"))
			.forEach(e -> lines.add(e.toString()));
		
		if (lines.size() != 0 && lines.size() < shedule.getEntries().size()) lines.add("");
		
		shedule.getEntries().stream()
			.filter(e -> e.getCompanyName().equals("Grotty"))
			.forEach(e -> lines.add(e.toString()));
		return lines;
	}
}
