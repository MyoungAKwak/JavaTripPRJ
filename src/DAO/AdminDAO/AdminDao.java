package DAO.AdminDAO;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DAO.Abs_Dao;
import SERVICE.AdminService.AdminService;
import VO.AdminAccountVo;
import VO.NoticeVo;
import VO.User_AccountVo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDao extends Abs_Dao {
	Scanner sc = new Scanner(System.in);
	AdminAccountVo Admin_VO;
	User_AccountVo User_VO;
	
	Connection conn;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	String id;
	String pwd;
	String query;
	
	
	private  void connDB() { 
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			System.out.println("connDB()오류");
			
		}
	}//connDB()
	

	
	public List<AdminAccountVo> Admin_List(){
		connDB();
		List<AdminAccountVo> Admin_List = new ArrayList<AdminAccountVo>();
		
		
		try {
			stmt = conn.createStatement();
			query = "select * from admin_table";
			rs = stmt.executeQuery(query);
			while(rs.next()) {
			 Admin_VO = new AdminAccountVo();
			Admin_VO.setID(rs.getString("id"));
			Admin_VO.setPWD(rs.getString("pwd"));
			Admin_List.add(Admin_VO);	
			}
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("Admin_List() 오류");
		}
		
		
	
		
		return Admin_List;
		
		
	}//Admin_List
	

	
	
	
	
	
	
}
