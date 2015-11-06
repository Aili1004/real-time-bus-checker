package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.BusEntity;

public class BusDAO {
	public ArrayList<BusEntity> getBusList(){
		ArrayList<BusEntity> list = new ArrayList<BusEntity>();

		String sql = "select busId, busNumberId, position_x, position_y, plateNumber, status,  managerId, " +
		"updateTime, routeId, closestStopId " +
		"from bus ";


		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);

			rs = stmt.executeQuery();

			while(rs.next()){
				BusEntity bus = new BusEntity();
				bus.setBusId(rs.getInt("busId"));
				bus.setBusNumberId(rs.getInt("busNumberId"));
				bus.setPosition_x(rs.getInt("position_x"));
				bus.setPosition_y(rs.getInt("position_y"));
				bus.setPlateNumber(rs.getString("plateNumber"));
				bus.setStatus(rs.getString("status"));
				bus.setManagerId(rs.getInt("managerId"));
				bus.setUpdateTime(rs.getString("updateTime"));
				bus.setRouteId(rs.getInt("routeId"));
				bus.setClosestStopId(rs.getInt("closestStopId"));

				list.add(bus);

			}

		} catch (SQLException e) {
			System.out.println("[BusDAO().getBusList]에서 오류 발생" + e.getMessage());
		}finally{
			DBUtil.close(con, stmt, rs);
		}
		return list;

	}
	public BusEntity getBus(int busId){
		BusEntity bus = null;
		String sql = "select busNumberId, position_x, position_y, plateNumber, status,  managerId, " +
		"updateTime, routeId, closestStopId" +
		"from bus " +
		"where busId = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try{
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1,busId);
			rs = stmt.executeQuery();
			if(rs.next()){
				bus = new BusEntity();
				bus.setBusId(busId);
				bus.setBusNumberId(rs.getInt("busNumberId"));
				bus.setPosition_x(rs.getInt("position_x"));
				bus.setPosition_y(rs.getInt("position_y"));
				bus.setPlateNumber(rs.getString("plateNumber"));
				bus.setStatus(rs.getString("status"));
				bus.setManagerId(rs.getInt("managerId"));
				bus.setUpdateTime(rs.getString("updateTime"));
				bus.setRouteId(rs.getInt("routeId"));
				bus.setClosestStopId(rs.getInt("closestStopId"));



			}
		}catch (SQLException e) {
			System.out.println("[BusDAO().getBusList]에서 오류 발생");
		}finally{
			DBUtil.close(con, stmt, rs);
		}
		return bus;

	}
	public int addBus(BusEntity bus){

		int affectedRow = 0;
		String sql = "insert into Bus( busId, busNumberId, position_x, position_y, plateNumber, status,  managerId, " +
		"updateTime, routeId, closestStopId) " +
		"values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);

			stmt.setInt(1, bus.getBusId());
			stmt.setInt(2, bus.getBusNumberId());
			stmt.setInt(3, bus.getPosition_x());
			stmt.setInt(4, bus.getPosition_y());
			stmt.setString(5, bus.getPlateNumber());
			stmt.setString(6, bus.getStatus());
			stmt.setInt(7, bus.getManagerId());
			stmt.setString(8, bus.getUpdateTime());
			stmt.setInt(9, bus.getRouteId());
			stmt.setInt(10, bus.getClosestStopId());

			affectedRow = stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("[BusDAO.addBus]" + e.getMessage());
		}finally{
			DBUtil.close(con, stmt);
		}
		return affectedRow;
	}
	public int updateBus(BusEntity bus){
		int affectedRow = 0;
		String sql = "update Bus " +
		"set busNumberId = ?, position_x = ?, position_y = ?, plateNumber = ?, status = ?,  managerId = ?, " +
		"updateTime = ?, routeId = ?, closestStopId = ? " +
		"where busId=? ";
		Connection con = null;
		PreparedStatement stmt = null;

		try{
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);

			stmt.setInt(1, bus.getBusNumberId());
			stmt.setInt(2, bus.getPosition_x());
			stmt.setInt(3, bus.getPosition_y());
			stmt.setString(4, bus.getPlateNumber());
			stmt.setString(5, bus.getStatus());
			stmt.setInt(6, bus.getManagerId());
			stmt.setString(7, bus.getUpdateTime());
			stmt.setInt(8, bus.getRouteId());
			stmt.setInt(9, bus.getClosestStopId());
			stmt.setInt(10, bus.getBusId());

			affectedRow = stmt.executeUpdate();

		}catch(SQLException e){
			System.out.println("[BusDAO.updateBus]" + e.getMessage());
		}finally{
			DBUtil.close(con, stmt);
		}
		return affectedRow;
	}
	public int deleteBus(int busId){

		int affectedRow = 0;
		String sql = "delete from Bus where busId = ?";

		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);

			stmt.setInt(1, busId);

			affectedRow = stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("[BusDAO.deleteBus]" + e.getMessage());
		}finally{
			DBUtil.close(con, stmt);
		}

		return affectedRow;
	}

	public ArrayList<BusEntity> getBusSearchList(int busNumberId){
		ArrayList<BusEntity> list2 = new ArrayList<BusEntity>();

		String sql = "select busId, busNumberId, position_x, position_y, plateNumber, status,  managerId, " +
		"updateTime, routeId, closestStopId " +
		"from bus " +
		"where busNumberId = ?";


		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);

			stmt.setInt(1, busNumberId);

			rs = stmt.executeQuery();

			while(rs.next()){
				BusEntity bus = new BusEntity();
				bus.setBusId(rs.getInt("busId"));
				bus.setBusNumberId(rs.getInt("busNumberId"));
				bus.setPosition_x(rs.getInt("position_x"));
				bus.setPosition_y(rs.getInt("position_y"));
				bus.setPlateNumber(rs.getString("plateNumber"));
				bus.setStatus(rs.getString("status"));
				bus.setManagerId(rs.getInt("managerId"));
				bus.setUpdateTime(rs.getString("updateTime"));
				bus.setRouteId(rs.getInt("routeId"));
				bus.setClosestStopId(rs.getInt("closestStopId"));

				list2.add(bus);
			}

		} catch (SQLException e) {
			System.out.println("[BusDAO().getBusSearchList]에서 오류 발생" + e.getMessage());
		}finally{
			DBUtil.close(con, stmt, rs);
		}
		return list2;

	}
}
