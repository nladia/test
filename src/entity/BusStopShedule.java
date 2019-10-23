package entity;

import java.util.ArrayList;
import java.util.List;

public class BusStopShedule {

	List<BusStopEntry> entries;

	
	public BusStopShedule() {
		super();
	}

	public BusStopShedule(List<BusStopEntry> entries) {
		super();
		this.entries = entries;
	}

	public List<BusStopEntry> getEntries() {
		return entries != null ? entries : new ArrayList<>();
	}

	public void setEntries(List<BusStopEntry> entries) {
		this.entries = entries;
	}

}
