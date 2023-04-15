package DAO.AirplaneDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import DAO.Abs_Dao;
import VO.AirplaneAccountVo;

public class AirplaneDao extends Abs_Dao{

	Scanner sc = new Scanner(System.in);
	Connection conn;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	String query;
	AirplaneAccountVo vo;
	
	String Airplane_INSERT = "insert into airplane values(?, ?, ?,?)";
	
	protected  void connDB() { 
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			System.out.println("connDB()오류");
			
		}
	}//connDB()
	
	public List<AirplaneAccountVo> Airplane_list(){
		connDB();
		List<AirplaneAccountVo> Airplane_list = new ArrayList<AirplaneAccountVo>();
		
		try {
		stmt = conn.createStatement();
		query = "select * from airplane_table";
		rs = stmt.executeQuery(query);
		
		while(rs.next()) {
			vo =  new AirplaneAccountVo();
			vo.setID(rs.getString("id"));
			vo.setPWD(rs.getString("pwd"));
			vo.setAir_Name(rs.getString("air_name"));
			vo.setAir_Tel(rs.getString("air_tel"));
			vo.setAir_code(rs.getString("air_code"));
			
			Airplane_list.add(vo);
		}
		} catch (Exception e) {
			System.out.println("Airplane_list() 오류");
		}
		return Airplane_list;
	}//Airplane_list()
	
	//항공사 회원가입
		public void insertAirplane() {
			
		
			try {
				
				System.out.print("아이디를 입력하세요 : ");
				String id = sc.nextLine();
				System.out.println("id"+id);
				
				System.out.println("비밀번호를 입력하세요.");
				String pwd = sc.nextLine();

				
				System.out.print("항공사 번호를 입력해주세요");  //db에서 회원번호 기본키로 처리
				System.out.println("(숫자만 입력 가능합니다)");
				String air_code = sc.next();
				String Nopattern = "^[0-9]*$";	//숫자만 입력가능
				boolean Noresult = Pattern.matches("^[0-9]*$", air_code);
				
				System.out.println("입력하신 항공사 코드는 "+air_code+"입니다.");
				
				
				String air_No1 = null;
				while(Noresult!=true) {  //false면 반복문
					System.out.println("올바르지 않은 회원번호입니다.");
					System.out.println("회원번호를 다시 입력해주세요");
					air_No1 = sc.next();
					
					if(Pattern.matches(Nopattern, air_No1)) {
						Noresult=true;
						
						System.out.println("사용가능한 항공사 번호입니다.");
						System.out.println("입력하신 아이디는"+air_No1+"입니다.");
						break;
					}
				}
				
				
				
				System.out.println("항공사 이름을 입력해주세요");
				String air_Name = sc.nextLine();
				
				
				System.out.println("전화번호를 입력해주세요.");
				System.out.println("전화번호 예시 xxx-xxxx-xxxx(하이픈 모두 포함) ");
				String air_Tel = sc.nextLine();	
				String airTel_pattern = "^\\d{3}-\\d{4}-\\d{4}$";
				boolean airTelresult = Pattern.matches("^\\d{3}-\\d{4}-\\d{4}$", air_Tel); 
				
				String air_Tel1 =null;
				while(airTelresult!=true) {
					System.out.println("올바르지 않은 전화번호입니다");
					System.out.println("전화번호를 다시 입력해주세요");
					air_Tel1 = sc.nextLine();
				
					
					
				if(Pattern.matches(airTel_pattern, air_Tel1)) {
					airTelresult=true;
					System.out.println("올바른 전화번호입니다");
					break;
				}
				}
				

				

				
				
				
				
				
				PreparedStatement pstmt = conn.prepareStatement("INSERT INTO AIRPLANE_TABLE VALUES(?,?,?,?,?)");
				
				pstmt.setString(1, id);
				pstmt.setString(2, pwd);
				pstmt.setString(3, air_Name);
				pstmt.setString(4, air_Tel);	
				pstmt.setString(5, air_code);

		
				int result = pstmt.executeUpdate();
				if(result == 1) {
					System.out.println("회원가입 되었습니다.");
				} else if(result == 0) {
					System.out.println("회원가입에 실패하였습니다.");
				}
				
				
	   		}catch(SQLException e) {

	   			e.printStackTrace();

	   		}catch(Exception e) {

	   			e.printStackTrace();

	   		}finally {
	   			
	   		}
		}
	

}//class
