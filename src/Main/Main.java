package Main;

import java.sql.SQLException;
import java.util.Scanner;

import DAO.UserDao.UserDao_;
import SERVICE.AdminService.AdminService;
import SERVICE.AdminService.NoticeService;
import SERVICE.AriplaneService.AirplaneService;
import SERVICE.UserService.ServiceForMember;

public class Main {
		
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ServiceForMember user = new ServiceForMember();
		UserDao_ user_ = new UserDao_();
		
		AdminService AdminService = new AdminService();
		AirplaneService AirplaneService = new AirplaneService();
		NoticeService NoticeService = new NoticeService();
		
	
		
		//객체 선언 관리자 유저 항공사 객체 생성
		
		boolean loof = true;
		while(loof){
		//공지사항
		NoticeService.Main_Notice();
		//간판
		AdminService.sign();
		System.out.println("───────────────────────────");
		System.out.println("0.종료");
		System.out.println("1.관리자 로그인");
		System.out.println("2.유저 회원가입");
		System.out.println("3.유저 로그인");
		System.out.println("4.유저 아이디/비밀번호 찾기");
		System.out.println("5.항공사 회원가입");
		System.out.println("6.항공사 로그인");
		System.out.println("7.항공사 아이디/비밀번호 찾기");
		System.out.println("───────────────────────────");
		System.out.println("작업을 선택해주세요.>>");
		
		
		try {
			int choice = Integer.parseInt(sc.nextLine());
			//입력한 값이  메뉴의 숫자와 다를경우 반복문 처음으로 돌아감 (0,1,2,3,4,5,6,7)일 경우만 실행
			//입력한 값이 실수형이나 문자형 문자열 타입일 경우 try캐치룰 이용 처음으로 돌아감
			if( (choice==0) || (choice==1) || (choice==2) || (choice==3) || (choice==4) || (choice==5) || (choice==6) || (choice==7) )   {
				
				switch(choice) {
				case 0:
					loof = false;
					System.out.println("프로그램이 종료 되었습니다.");
					break;
				case 1:
					AdminService.Main();
					break;
				case 2:
					user_.insertUser();
					
					break;
				case 3:
					user.loginSession();
					break;
				case 4:
					//유저 아이디 비밀번호 찾기 메서드 1.아이디 찾기 2.비밀번호 찾기
					
					System.out.println("───────────────────────────");
					System.out.println("0.이전");
					System.out.println("1.아이디 찾기");
					System.out.println("2.비밀번호 찾기");
					System.out.println("작업을 선택해주세요.>>");
					System.out.println("───────────────────────────");
					int find = Integer.parseInt(sc.nextLine());
					if( (find==0) ||(find==1) || (find ==2) ) {
					switch(find){
						
					case 0:
					System.out.println("이전 항목으로 돌아갔습니다.");
					break;
					
					case 1:
						user_.searchID();//아이디 찾기 메서드
					break;
					
					case 2:
						user_.searchPWD();//비밀번호 찾기 메서드
					break;
					}//find switch
					}else {
						System.out.println("잘못 입력하셨습니다.");
					}
					break;
				case 5:
					AirplaneService.insertAirplane();
					break;
					
				case 6:
					//항공사 로그인 
					AirplaneService.Main();
					break;
					
				case 7:
					//항공사 아이디 비밀번호 찾기 메서드 항공사 고유번호 입력
					//System.out.println("항공사 계쩡");
					break;
			}	
			}else {
			System.out.println("잘못 입력하셨습니다.");
				
		}		
		}catch (Exception e) {
			System.out.println("잘못 입력하셨습니다.");
		}
			
		
		
		
		
		
		
		
		}
	}//main method
}//class