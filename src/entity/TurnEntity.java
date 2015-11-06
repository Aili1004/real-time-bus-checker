package entity;

public class TurnEntity {
	private int busId;
	private String plateNumber;
	private int busNumberId;
	private int turn;
	private String stopName;
	private int routeId;
	private int turnCount;
	private int timeCount;
	
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public int getBusNumberId() {
		return busNumberId;
	}
	public void setBusNumberId(int busNumberId) {
		this.busNumberId = busNumberId;
	}
	public int getTurn() {
		return turn;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}
	public String getStopName() {
		return stopName;
	}
	public void setStopName(String stopName) {
		this.stopName = stopName;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public int getRouteId() {
		return routeId;
	}
	public void setTurnCount(int turnCount) {
		this.turnCount = turnCount;
	}
	public int getTurnCount() {
		return turnCount;
	}
	public void setTimeCount(int timeCount) {
		this.timeCount = timeCount;
	}
	public int getTimeCount() {
		return timeCount;
	}
}
