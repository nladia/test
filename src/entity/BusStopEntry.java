package entity;

import java.time.LocalTime;

public class BusStopEntry {
	
	private String companyName;
	private LocalTime arrival;
	private LocalTime departure;
	private Long stopTime;
	
	public BusStopEntry() {
		super();
	}

	public BusStopEntry(String companyName, LocalTime arrival, LocalTime departure, Long stopTime) {
		super();
		this.companyName = companyName;
		this.arrival = arrival;
		this.departure = departure;
		this.stopTime = stopTime;
	}

	@Override
	public String toString() {
		return companyName + " " + arrival + " " + departure;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public LocalTime getArrival() {
		return arrival;
	}

	public void setArrival(LocalTime arrival) {
		this.arrival = arrival;
	}

	public LocalTime getDeparture() {
		return departure;
	}

	public void setDeparture(LocalTime departure) {
		this.departure = departure;
	}

	public Long getStopTime() {
		return stopTime;
	}

	public void setStopTime(Long stopTime) {
		this.stopTime = stopTime;
	}
	
}
