package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.BusEntity;
import entity.BusNumberEntity;
import entity.BusStopEntity;
import entity.RouteEntity;

public class RouteDAO {
	public ArrayList<RouteEntity> getRouteList(){
		ArrayList<RouteEntity> list = new ArrayList<RouteEntity>();
		String sql = "select routeId, busNumberId, stopId, timeBetweenStops, turn, managerId, registerDate " +
				"from route ";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while(rs.next()){
				RouteEntity route = new RouteEntity();
				route.setRouteId(rs.getInt("routeId"));
				route.setBusNumberId(rs.getInt("busNumberId"));
				route.setStopId(rs.getInt("stopId"));
				route.setTimeBetweenStops(rs.getInt("timeBetweenStops"));
				route.setTurn(rs.getInt("turn"));
				route.setManagerId(rs.getInt("managerId"));
				route.setRegisterDate(rs.getString("registerDate"));
				
				list.add(route);

			}

		} catch (SQLException e) {
			System.out.println("[RouteDAO().getRouteList]에서 오류 발생" + e.getMessage());
		}finally{
			DBUtil.close(con, stmt, rs);
		}
		return list;

	}
	public RouteEntity getRoute(int routeId){
		RouteEntity route = null;
		String sql =  "select busNumberId, stopId, timeBetweenStops, turn, managerId, registerDate " +
				"from route " +
				"where routeId= ?"; 
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try{
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1,routeId);
			rs = stmt.executeQuery();
			if(rs.next()){
				route = new RouteEntity();

				route.setBusNumberId(rs.getInt("busNumberId"));
				route.setStopId(rs.getInt("stopId"));
				route.setTimeBetweenStops(rs.getInt("timeBetweenStops"));
				route.setTurn(rs.getInt("turn"));
				route.setManagerId(rs.getInt("managerId"));
				route.setRegisterDate(rs.getString("registerDate"));
				route.setRouteId(routeId);

			}
		}catch (SQLException e) {
			System.out.println("[RouteDAO().getRoute]에서 오류 발생" + e.getMessage());
		}finally{
			DBUtil.close(con, stmt, rs);
		}
		return route;

	}
	public int addRoute(RouteEntity route){

		int affectedRow = 0;
		String sql = "insert into Route(routeid, busNumberId, stopId, timeBetweenStops, turn, managerId, registerDate) " +
		"values(?, ?, ?, ?, ?, ?, ?)";

		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);

			stmt.setInt(1, route.getRouteId());
			stmt.setInt(2, route.getBusNumberId());
			stmt.setInt(3, route.getStopId());
			stmt.setInt(4, route.getTimeBetweenStops());
			stmt.setInt(5, route.getTurn());
			stmt.setInt(6, route.getManagerId());
			stmt.setString(7, route.getRegisterDate());

			affectedRow = stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("[RouteDAO.addRoute]" + e.getMessage());
		}finally{
			DBUtil.close(con, stmt);
		}
		return affectedRow;
	}
	public int updateRoute(RouteEntity route){
		int affectedRow = 0;
		String sql = "update route " +
				"set busnumberid=?, stopId=?, timebetweenstops=?, turn=?, managerid=?, registerdate=? " +
				"where routeId=? ";
		Connection con = null;
		PreparedStatement stmt = null;

		try{
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);

			stmt.setInt(1, route.getBusNumberId());
			stmt.setInt(2, route.getStopId());
			stmt.setInt(3, route.getTimeBetweenStops());
			stmt.setInt(4, route.getTurn());
			stmt.setInt(5, route.getManagerId());
			stmt.setString(6, route.getRegisterDate());
			stmt.setInt(7, route.getRouteId());

			affectedRow = stmt.executeUpdate();

		}catch(SQLException e){
			System.out.println("[RouteDAO.updateRoute]" + e.getMessage());
		}finally{
			DBUtil.close(con, stmt);
		}
		return affectedRow;
	}
	public int deleteRoute(int routeId){

		int affectedRow = 0;
		String sql = "delete from route where routeid = ?";

		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);

			stmt.setInt(1, routeId);

			affectedRow = stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("[RouteDAO.deleteRoute]" + e.getMessage());
		}finally{
			DBUtil.close(con, stmt);
		}

		return affectedRow;

	}

	public ArrayList<RouteEntity> getRouteList2(int busNumberId, String stopName){
		ArrayList<RouteEntity> list2 = new ArrayList<RouteEntity>();
		String sql = "select b.busnumberid, bs.stopname, b.busid, r.timeBetweenStops " +  
					"from bus b, busNumber bn, route r, busstop bs " + 
					"where b.busnumberid = bn.busnumberid and bn.busnumberid = r.busnumberid and r.stopid = bs.stopid and " + 
					"bn.busnumberid=? and bs.stopname=?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);

			stmt.setInt(1, busNumberId);
			stmt.setString(2, stopName);

			rs = stmt.executeQuery();

			while(rs.next()){

				BusNumberEntity busNumber = new BusNumberEntity();
				busNumber.setBusNumberId(busNumberId);

				BusStopEntity busStop = new BusStopEntity();
				busStop.setStopName(stopName);
				
				BusEntity bus = new BusEntity();
				bus.setBusId(rs.getInt("busId"));

				RouteEntity route = new RouteEntity();
				route.setTimeBetweenStops(rs.getInt("timeBetweenStops"));
				
				busNumber.setBus(bus);
				route.setBusNumber(busNumber);
				route.setBusStop(busStop);
				
				list2.add(route);
			}

		} catch (SQLException e) {
			System.out.println("[RouteDAO().getRouteList2]에서 오류 발생" + e.getMessage());
		}finally{
			DBUtil.close(con, stmt, rs);
		}
		return list2;
	}
}
