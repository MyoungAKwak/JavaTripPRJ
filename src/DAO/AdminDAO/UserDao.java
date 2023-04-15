package DAO.AdminDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DAO.Abs_Dao;
import VO.AdminAccountVo;
import VO.User_AccountVo;

public class UserDao extends Abs_Dao {
	
	Scanner sc = new Scanner(System.in);
	User_AccountVo vo;
	
	Connection conn;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	String id;
	String pwd;
	String query;
	
	private void connDB() { 
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			System.out.println("UserDao.connDB()오류");
			
		}
	}//connDB()

	//유저 전체 리스트
	public List<User_AccountVo> User_List(){
		connDB();
		List<User_AccountVo> User_List = new ArrayList<User_AccountVo>();
		
		try {
			stmt = conn.createStatement();
			query = "select * from user_table";
			rs = stmt.executeQuery(query);
		
			while(rs.next()) {
				User_AccountVo user_AccountVO = new User_AccountVo();
				user_AccountVO.setID(rs.getString("id"));
				user_AccountVO.setName(rs.getString("name"));
				user_AccountVO.setCitizen_Number(rs.getString("citizen_number"));
				user_AccountVO.setAge(rs.getInt("age"));
				user_AccountVO.setUser_Tel(rs.getString("tell"));
				user_AccountVO.setEmail((rs.getString("email")));
				User_List.add(user_AccountVO);
			}
		} catch (Exception e) {
			System.out.println("User_All_List() 오류");
		}
		
			return User_List;
	}//User_All_List
	
	
	//유저 검색 리스트
		public List<User_AccountVo> User_Search_List(int choice){
			connDB();
			List<User_AccountVo> User_Search_list = null;
			
			query = "select * from user_table where ";
			
			try {
				
			if(choice==1 || choice==2 || choice==3 || choice==4 || choice==5 || choice==6) {
				switch(choice) {
				case 1:
					System.out.println("검색할 아이디를 입력해주세요.>>");
					String id = sc.nextLine();
					query +="id like ";
					query +="'%"+ id +"%'";
					break;
				case 2:
					System.out.println("검색할 이름을 입력해주세요.>>");
					String name = sc.nextLine();
					query +="name like '%" +name + "%'";
					break;
				case 3:
					System.out.println("검색할 주민등록번호 를 입력해주세요.>>");
					String citizen_Number = sc.nextLine();
					query +="citizen_number like '%" +citizen_Number + "%'";
					break;
				case 4:
					System.out.println("검색할 나이 입력해주세요.>>");
					String age = sc.nextLine();
					query +="age = " +age;
					break;
				case 5:
					System.out.println("검색할 전화번호를 입력해주세요.>>");
					String user_Tel = sc.nextLine();
					query +="tell like '%" +user_Tel + "%'";
					break;
				case 6:
					//String match = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
					System.out.println("검색할 이메일을 입력해주세요.>>");
					String email = sc.nextLine();
					query +="email like '%" +email+ "%'";
					break;
				default :
					System.out.println("잘못 입력하셨습니다.");
				}
				
				stmt = conn.createStatement();
				rs = stmt.executeQuery(query);
				
				if(rs.next()==true) {
					while(rs.next()) {
						
						User_AccountVo user_AccountVO = new User_AccountVo();
						user_AccountVO.setID(rs.getString("id"));
						user_AccountVO.setPWD(rs.getString("pwd"));
						user_AccountVO.setName(rs.getString("name"));
						user_AccountVO.setCitizen_Number(rs.getString("citizen_number"));
						user_AccountVO.setAge(rs.getInt("age"));
						user_AccountVO.setUser_Tel(rs.getString("tell"));
						user_AccountVO.setEmail(rs.getString("email"));
						User_Search_list.add(user_AccountVO);
						
					}
					
					
				}
				else {
					System.out.println("해당하는 목록이 없습니다.");
				}
			}else if(choice==0) {
				System.out.println("이전 페이지로 돌아갑니다.");
			}else {
				System.out.println("잘못입력하셨습니다.");
			}

				

			
			} catch (Exception e) {
				System.out.println("User_Search_List() 오류");
			}
			return User_Search_list;
			
			
			
		}//User_Search_list
		
		public List Id(String id) {
			connDB();
			List<User_AccountVo> User_Search_list = new ArrayList<User_AccountVo>();
			query = "select * from user_table where id like \'%?%\'";
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					while(rs.next()) {
					User_AccountVo vo = new User_AccountVo();
					vo.setID(rs.getString(1));
					vo.setPWD(rs.getString(2));
					vo.setName(rs.getString(3));
					vo.setCitizen_Number(rs.getString(4));
					vo.setUser_Tel(rs.getString(5));
					vo.setEmail(rs.getString(6));
					vo.setAge(rs.getInt(7));
					User_Search_list.add(vo);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return User_Search_list;
			
		}
	
	
}//class
