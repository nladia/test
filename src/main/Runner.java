package main;

import java.util.List;
import java.util.Scanner;

import entity.BusStopEntry;
import entity.BusStopShedule;
import service.BusStopEntryService;
import utils.DataSource;
import utils.EntryParser;

public class Runner {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("Enter path to input file: ");
		String inputFile = new Scanner(System.in).nextLine();
		List<String> entries = DataSource.readFromFile(inputFile);
		List<BusStopEntry> entriesParsed = EntryParser.parseInput(entries);
		BusStopShedule shedule = BusStopEntryService.createShedule(entriesParsed);
		DataSource.writeToFile("output.txt", EntryParser.parseOutput(shedule));
	}

}
