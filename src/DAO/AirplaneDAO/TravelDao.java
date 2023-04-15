package DAO.AirplaneDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.Abs_Dao;
import VO.AirplaneAccountVo;
import VO.TravelVo;



public class TravelDao extends Abs_Dao{
	
	
	Connection conn;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	String query;
	
	
	private void connDB() { 
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			System.out.println("UserDao.connDB()오류");
			
		}
	}//connDB()
	
	public List<TravelVo> Travel_List(){
		connDB();
		List<TravelVo> Travel_List = new ArrayList<TravelVo>();
		
		try {
		query = "select * from travel";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(query);
		
		while(rs.next()) {
		TravelVo TravelVo = new TravelVo();
		TravelVo.setTravel_no(rs.getInt(1));
		TravelVo.setStarting(rs.getString(2));
		TravelVo.setDestination(rs.getString(3));
		TravelVo.setAirplane_name(rs.getString(4));
		TravelVo.setDeparture_Time(rs.getString(5));
		TravelVo.setArrival_Time(rs.getString(6));
		TravelVo.setPlan(rs.getString(7));
		Travel_List.add(TravelVo);
		
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		System.out.println("Travel_List()오류");
		}
		return Travel_List;
	}
	
	
	public void Insert(TravelVo vo) {
		connDB();
		try {
			query = "insert into travel values(travel_seq.nextval,?,?,?,to_date(?,'YYYY.MM.dd HH24:MI'),to_date(?,'YYYY.MM.DD HH24:MI'),?)";
			
//			"insert into package values(?,?,?,?,?,?,"
//			+ "to_date(?,'RRRR.MM.DD HH24:MI'),to_date(?,'RRRR.MM.DD HH24:MI'),?)
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getStarting());//시퀀스);
			pstmt.setString(2, vo.getDestination());
			pstmt.setString(3, vo.getAirplane_name());
			
			pstmt.setString(4, vo.getDeparture_Time());
			pstmt.setString(5, vo.getArrival_Time());
			pstmt.setString(6, vo.getPlan());
		
			int count = pstmt.executeUpdate();
			if(count ==1) {
				System.out.println(count + "행이 추가 되었습니다.");
			}else {
				System.out.println("추가된 행이 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
	
	}

	public List<TravelVo> Select(AirplaneAccountVo account) {
	connDB();	
	List<TravelVo> Travel_List = new ArrayList<TravelVo>();
	query = "select * from travel where airplane_name=?";
	try {
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1,account.getAir_Name());
		rs = pstmt.executeQuery();
		
		if(rs.next()==true) {
			while(rs.next()) {
			TravelVo vo = new TravelVo();
			}
		}else {
			System.out.println("해당하는 목록이 없습니다.");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return Travel_List;
	
	
	}
	
	public void Delete() {
		
	}
	
}
