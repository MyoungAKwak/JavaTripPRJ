package DAO.AirplaneDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import DAO.Abs_Dao;
import VO.AirplaneAccountVo;

public class AirplaneAccountDao extends Abs_Dao{
	Scanner sc = new Scanner(System.in);
	Connection conn;
	String query;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	
	
	private  void connDB() { 
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			System.out.println("connDB()오류");
			
		}
	}//connDB()
	
	public void pwd(AirplaneAccountVo vo) {
		connDB();
		
		try {
		query = "update airplane_table set pwd=? where id=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getPWD());
			pstmt.setString(2, vo.getID());
			int count = pstmt.executeUpdate();
			if(count!=0) {
				System.out.println("수정 되었습니다.");
			}else {
				System.out.println("수정되지 않았습니다.");
			}
			
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			System.out.println("pwd() 오류");
		}
	}
	
	public void name(AirplaneAccountVo vo) {
	connDB();
	
	try {
		query = "update airplane_table set air_name=? where id=?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, vo.getAir_Name());
		pstmt.setString(2, vo.getID());
		int count = pstmt.executeUpdate();
		if(count!=0) {
			System.out.println("수정 되었습니다.");
		}else {
			System.out.println("수정되지 않았습니다.");
		}
		
		pstmt.close();
		conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}//name
	
	public void tel(AirplaneAccountVo vo) {
	connDB();
		
	try {
		query = "update airplane_table set air_tel=? where id=?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, vo.getAir_Tel());
		pstmt.setString(2, vo.getID());
		int count = pstmt.executeUpdate();
		if(count!=0) {
			System.out.println("수정 되었습니다.");
		}else {
			System.out.println("수정되지 않았습니다.");
		}
		
		pstmt.close();
		conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
	}//tel
}//class
