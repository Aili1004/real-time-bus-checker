package entity;

public class BusEntity {
	private int busId;//pk
	private String plateNumber;//��ȣ��
	private int position_x;
	private int position_y;
	private String updateTime;//���������� ��ġ ����
	private int routeId;//�μ��� fk
	private String status;//����� Ȥ�� �̻��
	private int closestStopId;//������ ��ġ�� ���� ����� ��
	private int busNumberId;//����
	private int managerId;//������ ���̵�
	
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public int getBusNumberId() {
		return busNumberId;
	}
	public void setBusNumberId(int busNumberId) {
		this.busNumberId = busNumberId;
	}
	public int getPosition_x() {
		return position_x;
	}
	public void setPosition_x(int position_x) {
		this.position_x = position_x;
	}
	public int getPosition_y() {
		return position_y;
	}
	public void setPosition_y(int position_y) {
		this.position_y = position_y;
	}
	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public void setClosestStopId(int closestStopId) {
		this.closestStopId = closestStopId;
	}
	public int getClosestStopId() {
		return closestStopId;
	}
	
	
}
