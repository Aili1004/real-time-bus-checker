package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.AdsEntity;

public class AdsDAO {
    public ArrayList<AdsEntity> getAdsList(){
    	ArrayList<AdsEntity> list = new ArrayList<AdsEntity>();
    	String sql = "select adsId, managerId, usable, company, photo, introduction, weight, stoppedname, phone, to_char(registerdate,'YYYY-MM-DD') as registerdate " +
    			     "from ADS"; 
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while(rs.next()){
				AdsEntity Ads = new AdsEntity();
				Ads.setAdsId(rs.getInt("adsId"));
				Ads.setManagerId(rs.getInt("managerId"));
				Ads.setUsable(rs.getString("usable"));
				Ads.setCompany(rs.getString("company"));
				Ads.setPhoto(rs.getString("photo"));
				Ads.setIntroduction(rs.getString("introduction"));
				Ads.setWeight(rs.getInt("weight"));
				Ads.setStoppedName(rs.getString("stoppedname"));
				Ads.setPhone(rs.getString("phone"));
				Ads.setRegisterDate(rs.getString("registerDate"));
				
				list.add(Ads);

			}

		} catch (SQLException e) {
			System.out.println("[AdsDAO().getAdsList]에서 오류 발생" + e.getMessage());
		}finally{
			DBUtil.close(con, stmt, rs);
		}
		return list;
			
    }
    public AdsEntity getAds(int adsId){
    	AdsEntity ads = null;
    	String sql =  "select managerId, usable, company, photo, introduction, weight, stoppedname, phone, to_char(registerdate,'YYYY-MM-DD') as registerdate " +
	                  "from ADS where adsId = ? ";
    	Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try{
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1,adsId);
			rs = stmt.executeQuery();
			if(rs.next()){
				ads = new AdsEntity();
				
				ads.setAdsId(adsId);
				ads.setManagerId(rs.getInt("managerId"));
				ads.setUsable(rs.getString("usable"));
				ads.setCompany(rs.getString("company"));
				ads.setPhoto(rs.getString("photo"));
				ads.setIntroduction(rs.getString("introduction"));
				ads.setWeight(rs.getInt("weight"));
				ads.setStoppedName(rs.getString("stoppedname"));
				ads.setPhone(rs.getString("phone"));
				ads.setRegisterDate(rs.getString("registerDate"));
				
			}
		}catch (SQLException e) {
			System.out.println("[AdsDAO().getAds]에서 오류 발생" + e.getMessage());
		}finally{
			DBUtil.close(con, stmt, rs);
		}
		return ads;
		
    }
    public int addAds(AdsEntity ads){
		
		int affectedRow = 0;
		String sql = "insert into Ads(adsId, managerId, usable, company, photo, introduction, weight, stoppedname, phone, registerdate ) " +
				"values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, ads.getAdsId());
			stmt.setInt(2, ads.getManagerId());
			stmt.setString(3, ads.getUsable());
			stmt.setString(4, ads.getCompany());
			stmt.setString(5, ads.getPhoto());
			stmt.setString(6, ads.getIntroduction());
			stmt.setInt(7, ads.getWeight());
			stmt.setString(8, ads.getStoppedName());
			stmt.setString(9, ads.getPhone());
			stmt.setString(10, ads.getRegisterDate());
			
			affectedRow = stmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("[AdsDAO.addAds]" + e.getMessage());
		}finally{
			DBUtil.close(con, stmt);
		}
		return affectedRow;
	}
    public int updateAds(AdsEntity ads){
		int affectedRow = 0;
		String sql = "update Ads set managerId = ?, usable = ?, company = ?, photo = ?, introduction = ?, weight = ?, stoppedname = ?, phone = ?, registerdate = ?" +
				     " where adsId = ? ";
		Connection con = null;
		PreparedStatement stmt = null;
		
		try{
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, ads.getManagerId());
			stmt.setString(2, ads.getUsable());
			stmt.setString(3, ads.getCompany());
			stmt.setString(4, ads.getPhoto());
			stmt.setString(5, ads.getIntroduction());
			stmt.setInt(6, ads.getWeight());
			stmt.setString(7, ads.getStoppedName());
			stmt.setString(8, ads.getPhone());
			stmt.setString(9, ads.getRegisterDate());
			stmt.setInt(10, ads.getAdsId());
			
			affectedRow = stmt.executeUpdate();
			
		}catch(SQLException e){
			System.out.println("[AdsDAO.updateAds]" + e.getMessage());
		}finally{
			DBUtil.close(con, stmt);
		}
		return affectedRow;
	}
    public int deleteAds(int adsId){
    	
		int affectedRow = 0;
		String sql = "delete from Ads where AdsId = ?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, adsId);
			
			affectedRow = stmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("[AdsDAO.deleteAds]" + e.getMessage());
		}finally{
			DBUtil.close(con, stmt);
		}
		
		return affectedRow;
		
	}
}
