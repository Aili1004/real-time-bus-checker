package dao;

import java.sql.*;
import java.util.ArrayList;

import entity.BusEntity;
import entity.BusNumberEntity;
import entity.BusStopEntity;
import entity.ManagerEntity;
import entity.RouteEntity;

public class BusStopDAO {

	public ArrayList<BusStopEntity> getBusStopList(){
		ArrayList<BusStopEntity> list = new ArrayList<BusStopEntity>();
		String sql = "SELECT bs.stopid, bs.stopname, bs.usable, bs.location_x, bs.location_y, bs.description, " +
				"to_char(bs.registerdate, 'YYYY-MM-DD') as registerdate, bs.managerId, m.name " +
		"FROM BUSSTOP bs, manager m " +
		"where bs.managerId = m.managerId"; 

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while(rs.next()){
				BusStopEntity busStop = new BusStopEntity();
				
				busStop.setStopId(rs.getInt("stopId"));
				busStop.setStopName(rs.getString("stopName"));
				busStop.setUsable(rs.getString("usable"));
				busStop.setLocation_x(rs.getInt("location_x"));
				busStop.setLocation_y(rs.getInt("location_y"));
				busStop.setDescription(rs.getString("description"));
				busStop.setRegisterDate(rs.getString("registerdate"));
				busStop.setManagerId(rs.getInt("managerId"));
				
				ManagerEntity manager = new ManagerEntity();
				manager.setName(rs.getString("name"));
				
				busStop.setManager(manager);

				list.add(busStop);
			}


		} catch (SQLException e) {
			System.out.println("[BusStopDAO.getBusStopList]" + e.getMessage());
		}finally{
			DBUtil.close(con, stmt, rs);
		}

		return list;
	}


	public BusStopEntity getBusStop(int stopId){

		String sql = "SELECT bs.stopname, bs.usable, bs.location_x, bs.location_y, bs.description, " +
				"to_char(bs.registerdate, 'YYYY-MM-DD') as registerdate, bs.managerId, m.name " +
		"FROM busstop bs, manager m " +
		"WHERE bs.managerId = m.managerId and stopId = ?";

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		BusStopEntity busStop = null;

		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);

			stmt.setInt(1, stopId);
			rs = stmt.executeQuery();

			if(rs.next()){
				busStop = new BusStopEntity();

				busStop.setStopId(stopId);
				busStop.setStopName(rs.getString("stopname"));
				busStop.setUsable(rs.getString("usable"));
				busStop.setDescription(rs.getString("description"));
				busStop.setLocation_x(rs.getInt("location_x"));
				busStop.setLocation_y(rs.getInt("location_y"));
				busStop.setRegisterDate(rs.getString("registerdate"));
				busStop.setManagerId(rs.getInt("managerId"));

				ManagerEntity manager = new ManagerEntity();
				manager.setName(rs.getString("name"));

				busStop.setManager(manager);
			}

		} catch (SQLException e) {
			System.out.println("[BusStopDAO.getBusStop]" + e.getMessage());
		}finally{
			DBUtil.close(con, stmt, rs);
		}
		return busStop;
	}


	public int addBusStop(BusStopEntity busStop){

		int affectedRow = 0;
		String sql = "insert into BusStop(stopid, stopname, usable, location_x, location_y, description, registerdate, managerId) " +
		"values(?, ?, ?, ?, ?, ?, ?, ?)";

		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);

			stmt.setInt(1, busStop.getStopId());
			stmt.setString(2, busStop.getStopName());
			stmt.setString(3, busStop.getUsable());
			stmt.setInt(4, busStop.getLocation_x());
			stmt.setInt(5, busStop.getLocation_y());
			stmt.setString(6, busStop.getDescription());
			stmt.setString(7, busStop.getRegisterDate());
			stmt.setInt(8, busStop.getManagerId());

			affectedRow = stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("[BusStopDAO.addBusStop]" + e.getMessage());
		}finally{
			DBUtil.close(con, stmt);
		}
		return affectedRow;
	}


	public int updateBusStop(BusStopEntity busStop){
		int affectedRow = 0;
		String sql = "update BusStop " +
		"SET stopname = ?, usable = ?, location_x = ?, location_y = ?, description = ?, registerdate = ?, managerId = ? " +
		"WHERE stopid = ?";

		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);

			stmt.setString(1, busStop.getStopName());
			stmt.setString(2, busStop.getUsable());
			stmt.setInt(3, busStop.getLocation_x());
			stmt.setInt(4, busStop.getLocation_y());
			stmt.setString(5, busStop.getDescription());
			stmt.setString(6, busStop.getRegisterDate());
			stmt.setInt(7, busStop.getManagerId());
			stmt.setInt(8, busStop.getStopId());

			affectedRow = stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("[BusStopDAO.updateBusStop]" + e.getMessage());
		}finally{
			DBUtil.close(con, stmt);
		}

		return affectedRow;

	}

	public int deleteBusStop(int stopId){

		int affectedRow = 0;
		String sql = "delete from BUSSTOP where stopid= ?";

		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);

			stmt.setInt(1, stopId);

			affectedRow = stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("[BusStopDAO.deleteBusStop]" + e.getMessage());
		}finally{
			DBUtil.close(con, stmt);
		}

		return affectedRow;

	}

	public ArrayList<RouteEntity> getRouteList(){

		ArrayList<RouteEntity> list1 = new ArrayList<RouteEntity>();

		String sql1 = "select bs.stopName from " +
						"busstop bs, route r, busnumber bn " +
						"where bs.stopId = r.stopId and r.busnumberid = bn.busnumberid ";

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql1);
			rs = stmt.executeQuery();

			while(rs.next()){
				BusStopEntity busStop = new BusStopEntity();
				busStop.setStopName(rs.getString("stopName"));

				RouteEntity route = new RouteEntity();
				
				BusNumberEntity busNumber = new BusNumberEntity();

				route.setBusNumber(busNumber);
				route.setBusStop(busStop);

				list1.add(route);
			}
		}catch (SQLException e) {
			System.out.println("[BusStopDAO.getRouteList]" + e.getMessage());
		}finally{
			DBUtil.close(con, stmt, rs);
		}

		return list1;

	}
	
	
	public RouteEntity getBusStop2(int busNumber){

		String sql = "select busstop.stopName " +
				"from busstop, route, busnumber " +
				"where busstop.stopid = route.stopid and route.busnumberid = busnumber.busnumberid " +
				"and busnumber.busnumberid = ?";

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		BusStopEntity busStopEntity = null;
		RouteEntity routeEntity = null;

		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);

			stmt.setInt(1, busNumber);
			rs = stmt.executeQuery();

			if(rs.next()){
				busStopEntity = new BusStopEntity();
				busStopEntity.setStopName(rs.getString("stopName"));
				
				BusNumberEntity busNumberEntity = new BusNumberEntity();
				busNumberEntity.setBusNumberId(busNumber);
				
				routeEntity = new RouteEntity();

				routeEntity.setBusNumber(busNumberEntity);
				
			}

		} catch (SQLException e) {
			System.out.println("[BusStopDAO.getBusStop]" + e.getMessage());
		}finally{
			DBUtil.close(con, stmt, rs);
		}
		return routeEntity;
	}
	
	
	
	public ArrayList<BusStopEntity> getRouteList2(int busNumberId){

		ArrayList<BusStopEntity> list2 = new ArrayList<BusStopEntity>();

		String sql2 = "select busstop.stopName " +
				"from busstop, route, busnumber " +
				"where busstop.stopid = route.stopid and route.busnumberid = busnumber.busnumberid " +
				"and busnumber.busnumberid = ?";

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql2);
			
			stmt.setInt(1, busNumberId);
			
			rs = stmt.executeQuery();

			while(rs.next()){
				BusStopEntity busStop = new BusStopEntity();
				busStop.setStopName(rs.getString("stoppedName"));

				list2.add(busStop);
			}
		}catch (SQLException e) {
			System.out.println("[BusStopDAO.getRouteList2]" + e.getMessage());
		}finally{
			DBUtil.close(con, stmt, rs);
		}

		return list2;

	}
	
	public ArrayList<RouteEntity> getRouteList3(String stopName){

		ArrayList<RouteEntity> list3 = new ArrayList<RouteEntity>();

		String sql3 = "select b.busid, bn.busnumberid, bs.stopname, r.timeBetweenStops " + 
					"from bus b, busnumber bn, route r, busstop bs " + 
					"where b.busnumberid = bn.busnumberid and bn.busnumberid = r.busnumberid and " +
					"r.stopid = bs.stopid and bs.stopname=?";

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql3);
			
			stmt.setString(1, stopName);
			
			rs = stmt.executeQuery();

			while(rs.next()){
				
				BusNumberEntity busNumber = new BusNumberEntity();
				busNumber.setBusNumberId(rs.getInt("busNumberId"));
				
				BusEntity bus = new BusEntity();
				bus.setBusId(rs.getInt("busId"));
				
				busNumber.setBus(bus);
				
				BusStopEntity busStop = new BusStopEntity();
				busStop.setStopName(rs.getString("stopName"));
				
				RouteEntity route = new RouteEntity();
				route.setTimeBetweenStops(rs.getInt("timeBetweenStops"));
				
				route.setBusNumber(busNumber);
				route.setBusStop(busStop);

				list3.add(route);
			}
		}catch (SQLException e) {
			System.out.println("[BusStopDAO.getRouteList3]" + e.getMessage());
		}finally{
			DBUtil.close(con, stmt, rs);
		}

		return list3;
	}
	
	public ArrayList<BusStopEntity> getBusStopListSpinner(){
		ArrayList<BusStopEntity> list = new ArrayList<BusStopEntity>();
		String sql = "select stopId, stopName from busStop";

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while(rs.next()){
				BusStopEntity busStop = new BusStopEntity();
				
				busStop.setStopId(rs.getInt("stopId"));
				busStop.setStopName(rs.getString("stopName"));
				
				list.add(busStop);
			}


		} catch (SQLException e) {
			System.out.println("[BusStopDAO.getBusStopListSpinner]" + e.getMessage());
		}finally{
			DBUtil.close(con, stmt, rs);
		}

		return list;
	}
}
