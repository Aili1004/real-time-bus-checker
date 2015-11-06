package entity;

public class RouteEntity {
	private int routeId;
	private int busNumberId;
	private int stopId;
	private int timeBetweenStops;
	private int managerId;
	private String registerDate;
	private int turn;
	private BusNumberEntity busNumber;
	private BusStopEntity busStop;
	
	
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public int getBusNumberId() {
		return busNumberId;
	}
	public void setBusNumberId(int busNumberId) {
		this.busNumberId = busNumberId;
	}
	public int getStopId() {
		return stopId;
	}
	public void setStopId(int stopId) {
		this.stopId = stopId;
	}
	public int getTimeBetweenStops() {
		return timeBetweenStops;
	}
	public void setTimeBetweenStops(int timeBetweenStops) {
		this.timeBetweenStops = timeBetweenStops;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public void setBusNumber(BusNumberEntity busNumber) {
		this.busNumber = busNumber;
	}
	public BusNumberEntity getBusNumber() {
		return busNumber;
	}
	public void setBusStop(BusStopEntity busStop) {
		this.busStop = busStop;
	}
	public BusStopEntity getBusStop() {
		return busStop;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}
	public int getTurn() {
		return turn;
	}
	
	
	
	
}
