package DAO.UserDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import DAO.Abs_Dao;
import SERVICE.UserService.ServiceForMember;
import VO.User_AccountVo;

public class UserDao_ extends Abs_Dao {
	Scanner sc = new Scanner(System.in);
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	String query;
	ResultSet rs;
	
	private  void connDB() { 
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			System.out.println("connDB()오류");
			
		}
	}//connDB()
	
	
	public List<User_AccountVo> Id(User_AccountVo account) {
	connDB();
	query = "select * from user_table where user_id =? && name =?";
	
	try {
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, account.getID());
		pstmt.setString(2, account.getName());
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
		while(rs.next()) {
		List<User_AccountVo>user_list = new ArrayList<User_AccountVo>();
			
		}
		}else {
			System.out.println("찾으실 아이디가 없습니다.");
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
		
	}
	
	
	//회원가입
	public void insertUser() {
		try {
			Scanner sc = new Scanner(System.in);
			connDB();
			
			System.out.println("아이디를 입력해주세요");
			System.out.println("ID는 시작은 영문만, _제외한 특수문자 불가, 5~12자이하만 가능합니다.");
			String id = sc.next();
			String idpattern = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$";
			boolean idresult = Pattern.matches("^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$", id);
			
			System.out.println("입력하신 아이디는 "+id+"입니다.");

			String id1 = null;
			while(idresult!=true) {   //입력 받은 ID가 패턴에 안맞으면 맞을 때 까지 반복적으로 입력값 받습니다. false면 반복문
				System.out.println("올바르지 않은 아이디입니다.");
				System.out.println("아이디를 다시 입력해주세요");
				id1 = sc.next();

				if(Pattern.matches(idpattern, id1)) {
					idresult=true;
					
					System.out.println("사용가능한 id입니다.");
					System.out.println("입력하신 아이디는"+id1+"입니다.");
					break;   //idresult 값이 true면 반복문 탈출
				}
			}

			
		    	System.out.println("비밀번호를 입력해주세요");
	    		System.out.println("(소문자,숫자,특수문자 조합의 8~15자만 가능합니다.)");
	    		String pwd = sc.next();
	    		String pwdpattern = "^.*(?=^.{8,15}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$";   // 비밀번호 소문자, 숫자, 특수문자 조합의 8~15자
	    		boolean pwdresult = Pattern.matches("^.*(?=^.{8,15}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$", pwd);
	    		
	    		String pwd1 = null;
	    		while(pwdresult!=true) {
	    			System.out.println("올바르지 않은 비밀번호입니다");		//입력 받은 pwd가 패턴에 안맞으면 맞는 값을 입력할 때 까지 반복문을 돌립니다.
	    			System.out.println("비밀번호를 다시 입력해주세요");
	    			pwd1 = sc.next();								//패턴에 맞으면 pwd로 패턴에 안맞으면 pwd1 변수로 값을 받습니다.
	    		
	    		if(Pattern.matches(pwdpattern, pwd1)){
	    			pwdresult=true;
	    			System.out.println("올바른 비밀번호입니다.");		
	    			break;
	    		}
	    	}    	
		    	
		    	System.out.println("이름을 입력해주세요");
		    	String name = sc.next();
		    	
		    	System.out.println("주민등록번호를 입력해주세요");
		    	System.out.println("예시. xxxxxx-xxxxxxx (하이픈)포함");
		    	String citizen_number = sc.next();
		    	String citznumpattern = "\\d{6}\\-[1-4]\\d{6}";     //주민등록번호 xxxxxx-xxxxxx
		    	boolean cinumresult = Pattern.matches("\\d{6}\\-[1-4]\\d{6}", citizen_number);
		    	
		    	String citizen_number1 = null;
		    	while(cinumresult!=true) {
		    		System.out.println("올바르지 않은 주민번호입니다");	//입력 받은 citizen_number가 패턴에 안맞으면 맞는 값을 입력할 때 까지 반복문을 돌립니다.
		    		System.out.println("주민번호를 다시 입력해주세요");
		    		citizen_number1 = sc.next();
		    		
		    	if(Pattern.matches(citznumpattern, citizen_number1)) {	////패턴에 맞으면 citizen_number로 패턴에 안맞으면 citizen_number1 변수로 값을 받습니다.
		    		cinumresult=true;
		    		System.out.println("올바른 주민번호입니다.");
		    		break;
		    	}
		    	
		    }
		    	
		    	
		    	System.out.println("나이를 입력해주세요");
		    	int age = sc.nextInt();
		    	
		    	
		    	System.out.println("전화번호를 입력해주세요. ");
		    	System.out.println("전화번호 예) xxx-xxxx-xxxx(하이픈 모두 포함) ");
		    	String User_Tel = sc.next();
		    	String tel_pattern = "^\\d{3}-\\d{4}-\\d{4}$";     //전화번호 3자리-4자리-4자리입니다
		    	boolean telresult = Pattern.matches("^\\d{3}-\\d{4}-\\d{4}$", User_Tel);
		    	
		    	String User_Tel1 = null;
		    	while(telresult!=true) {
		    		System.out.println("올바르지 않은 전화번호입니다");
		    		System.out.println("전화번호를 다시 입력해주세요");
		    		User_Tel1 = sc.next();
		    	
		    	if(Pattern.matches(tel_pattern, User_Tel1)) {
		    		telresult=true;
		    		System.out.println("올바른 전화번호입니다");
		    		break;
		    	}
		    }

		    	
		    	System.out.print(" 이메일 주소를 입력해주세요.");
		    	System.out.println(" 예) abc@naver.com(@포함) ");
		    	String email = sc.next();
		    	String email_pattern = "^[A-Za-z0-9_\\.\\-]+@[A-Za-z0-9\\-]+\\.[A-Za-z0-9\\-]+$";
		    	boolean emailresult = Pattern.matches("^[A-Za-z0-9_\\.\\-]+@[A-Za-z0-9\\-]+\\.[A-Za-z0-9\\-]+$", email);
		    	
		    	String email1 = null;
		    	while(emailresult!=true) {
		    		System.out.println("올바르지 않은 이메일입니다.");
		    		System.out.println("이메일 주소를 다시 입력해주세요");
		    		email1 = sc.next();
		    	
		    	
		    	if(Pattern.matches(email_pattern, email1))  {
		    		emailresult=true;
		    		System.out.println("사용 가능한 이메일입니다");
		    		break;
		    	}
		    }	
		    	
		    	
	            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO user_table VALUES(?,?,?,?,?,?,?)");
//			    System.out.println("PrepareStatement 생성 성공");

	            if(Pattern.matches(idpattern, id)){	
	            	pstmt.setString(1, id);
				} else {
	            	pstmt.setString(1, id1);
	            }
	            
	            

	            if(Pattern.matches(pwdpattern, pwd)){	
	            	pstmt.setString(2, pwd);
				} else {
	            	pstmt.setString(2, pwd1);
	            }
	            
	            pstmt.setString(3,name);

	            
	            if(Pattern.matches(citznumpattern, citizen_number)){	
	            	pstmt.setString(4, citizen_number);
				} else {
	            	pstmt.setString(4, citizen_number1);
	            }
	            
	            
	            if(Pattern.matches(tel_pattern, User_Tel)) {
	            	pstmt.setString(5, User_Tel);
	            } else {
	            	pstmt.setString(5, User_Tel);
	            }

	            if(Pattern.matches(email_pattern, email)) {
	            	pstmt.setString(6, email);
	            } else {
	            	pstmt.setString(6, email1);
	            }
	            
	            pstmt.setInt(7, age);
	            
	                

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

	
	
	
		//아이디 찾기 메서드
		public void searchID() {
			Scanner sc = new Scanner(System.in);
			List<User_AccountVo> list = new ArrayList<>();
			ServiceForMember user = new ServiceForMember();
			String sql = "select id from user_table where name = ? and citizen_number = ?";
			
			try {
			
				System.out.println("아이디 찾기를 선택하셨습니다.");
	            System.out.println("-----이름을 입력하세요.-----");
	            String name = sc.nextLine();
	            System.out.println("-----주민번호를 입력하세요.-----");
	            String citizen_number = sc.nextLine();
	           /* System.out.println("회원님 아이디는 : " + id + "입니다.");*/
				
				connDB();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, citizen_number);
				rs=pstmt.executeQuery();
				
			if(rs.next()) {
				if(rs.getString("name").equals(name) && (rs.getString("citizen_number")).equals(citizen_number)) {
					User_AccountVo vo = new User_AccountVo();
					vo.setName(rs.getString("name"));
					vo.setCitizen_Number(rs.getString(citizen_number));
					vo.setID(rs.getString("id"));
					list.add(vo);
					
					System.out.println("해당 유저의 아이디를 찾았습니다:"+vo.getID());
					/* return searchPWD(); */
					
			    	} else {
					System.out.println("해당 이름과 주민번호로 찾을 수 있는 아이디가 존재하지 않습니다.");
					
			     	}
			
			  } // rs
		
			}  catch (SQLException e) {
			System.out.println("잘못된 sql문을 날렸습니다.");
			e.printStackTrace();
		  }    
		
		} // 아이디 찾기 메서드 끝		
	
	            
	    // 비밀번호 찾기 메서드        	
		public void searchPWD() {
			Scanner sc = new Scanner(System.in);
			List<User_AccountVo> list = new ArrayList<>();
			System.out.println("----비밀번호 찾기입니다.----");
			System.out.println("아이디를 입력하세요:");
			String id = sc.nextLine();
			System.out.println("주민번호를 입력하세요.");
			String citizen_number = sc.nextLine();
			
			try {
				connDB();
			
				String sql = "select pwd from user_table where id=? and citizen_number=?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, id); //아이디
	            pstmt.setString(2, citizen_number); // 주민번호
	            rs = pstmt.executeQuery();
	            if(rs.next()) {
	            	if(rs.getString("id").equals(id) && (rs.getString("citizen_number")).equals(citizen_number)) { // 이 조건이 맞으면 회원 테이블에서 비밀번호를 가져온다
	            		User_AccountVo vo = new User_AccountVo();
	            		vo.setPWD(rs.getString("pwd"));
	            		list.add(vo);
	            		System.out.println("해당 유저의 비밀번호를 찾았습니다:"+vo.getPWD());
	            
	            	} else {
	            		System.out.println("해당 아이디와 주민등록번호로 비밀번호를 찾을 수가 없습니다.");
	            		
	            	}
	            
	          
	            } // rs
	         
	         
			} catch (SQLException e) {
				System.out.println("잘못된 sql문을 날렸습니다.");
				e.printStackTrace();
			  }    
	
			
		
		} // 비밀번호 찾기 메서드 끝

	
	
	
}
