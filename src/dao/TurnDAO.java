package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.TurnEntity;

public class TurnDAO {
	
		
		public ArrayList<TurnEntity> getTurnListWithStopName(String stopName){
			ArrayList<TurnEntity> turnList = new ArrayList<TurnEntity>();
			
			String sql = "select b.busid, b.platenumber, r.busnumberid, s.stopname, " +  
			"((select r.turn from busstop s inner join route r on s.stopid = r.stopid where s.stopname = ?)-r.turn)as turnCount, " +  
			"(((select r.turn from busstop s inner join route r on s.stopid = r.stopid where s.stopname = ?)-r.turn)*2) as timeCount " + 
			"from bus b inner join route r " + 
			"on b.routeid = r.routeid " + 
			"inner join busstop s " + 
			"on r.stopid = s.stopid " + 
			"and (select r.turn from busstop s inner join route r on s.stopid = r.stopid " + 
			"where s.stopname = ?) > r.turn " + 
			"order by turnCount";
			
			Connection con = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			try {
				con = DBUtil.getConnection();
				stmt = con.prepareStatement(sql);
				
				stmt.setString(1, stopName);
				stmt.setString(2, stopName);
				stmt.setString(3, stopName);
				
				rs = stmt.executeQuery();
				
				while(rs.next()){
					TurnEntity turn = new TurnEntity();
					
					turn.setBusId(rs.getInt("busid"));
					turn.setPlateNumber(rs.getString("platenumber"));
					turn.setBusNumberId(rs.getInt("busNumberId"));
					turn.setTurnCount(rs.getInt("turnCount"));
					turn.setTimeCount(rs.getInt("timeCount"));
					turn.setStopName(rs.getString("stopname"));
					
					turnList.add(turn);
				}
				
				
			} catch (SQLException e) {
				System.out.println("[TurnDAO.getTurnListWithStopName]" + e.getMessage());
			}finally{
				DBUtil.close(con, stmt, rs);
			}
			return turnList;
	}
	
	
	
	
	public ArrayList<TurnEntity> getTurnListWithBoth(int busNumberId, String stopName){
		ArrayList<TurnEntity> turnList2 = new ArrayList<TurnEntity>();
		
		String sql2 = "select b.busid, b.platenumber, r.busnumberid, s.stopname, " +  
					"((select r.turn from busstop s inner join route r on s.stopid = r.stopid where s.stopname = ?)-r.turn)as turnCount, " +  
					"(((select r.turn from busstop s inner join route r on s.stopid = r.stopid where s.stopname = ?)-r.turn)*2) as timeCount " + 
					"from bus b inner join route r " + 
					"on b.routeid = r.routeid " + 
					"inner join busstop s " + 
					"on r.stopid = s.stopid " + 
					"and (select r.turn from busstop s inner join route r on s.stopid = r.stopid " + 
					"where s.stopname = ?) > r.turn " +
					"and r.busnumberid = ? " +
					"order by turnCount";
				

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql2);
			
			stmt.setString(1, stopName);
			stmt.setString(2, stopName);
			stmt.setString(3, stopName);
			stmt.setInt(4, busNumberId);
			
			rs = stmt.executeQuery();
			
			while(rs.next()){
				TurnEntity turn2 = new TurnEntity();
				
				turn2.setBusId(rs.getInt("busid"));
				turn2.setPlateNumber(rs.getString("platenumber"));
				turn2.setBusNumberId(busNumberId);
				turn2.setTurnCount(rs.getInt("turnCount"));
				turn2.setTimeCount(rs.getInt("timeCount"));
				turn2.setStopName(rs.getString("stopname"));
				
				turnList2.add(turn2);
			}
			
		} catch (SQLException e) {
			System.out.println("[TurnDAO.getTurnListWithBoth]" + e.getMessage());
		}
		return turnList2;
	}
	
	
	
	public ArrayList<TurnEntity> getTurnListWithBusNumber(int busNumber){
		ArrayList<TurnEntity> turnList3 = new ArrayList<TurnEntity>();
		
		String sql = "select s.stopname,b.routeid from busnumber n inner join route r " +
						"on n.busnumberid = r.busnumberid " +
						"inner join busstop s " +
						"on r.stopid = s.stopid " +
						"left outer join bus b " +
						"on b.routeid = r.routeid " +
						"where n.busnumberid = ? " +
						"order by s.stopid";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, busNumber);
			
			rs = stmt.executeQuery();
			
			while(rs.next()){
				TurnEntity turn3 = new TurnEntity();
				turn3.setStopName(rs.getString("stopName"));
				turn3.setRouteId(rs.getInt("routeId"));
				turn3.setBusNumberId(busNumber);
				
				turnList3.add(turn3);
			}
			
		} catch (SQLException e) {
			System.out.println("[TurnDAO.getTurnListWithBusNumber]" + e.getMessage());
		}finally{
			DBUtil.close(con, stmt, rs);
		}
		
		return turnList3;
		
	}
}
