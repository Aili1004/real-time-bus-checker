package entity;

public class BusNumberEntity {
	private int busNumberId;
	private String busNumberName;
	private String firstTime;
	private String lastTime;
	private String usable;
	private int managerId;
	private String registerDate;
	private BusEntity bus;
	
	public int getBusNumberId() {
		return busNumberId;
	}
	public void setBusNumberId(int busNumberId) {
		this.busNumberId = busNumberId;
	}
	public String getBusNumberName() {
		return busNumberName;
	}
	public void setBusNumberName(String busNumberName) {
		this.busNumberName = busNumberName;
	}
	public String getFirstTime() {
		return firstTime;
	}
	public void setFirstTime(String firstTime) {
		this.firstTime = firstTime;
	}
	public String getLastTime() {
		return lastTime;
	}
	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}
	public String getUsable() {
		return usable;
	}
	public void setUsable(String usable) {
		this.usable = usable;
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
	public void setBus(BusEntity bus) {
		this.bus = bus;
	}
	public BusEntity getBus() {
		return bus;
	}
	
	
	
}
