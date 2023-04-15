package SERVICE.AdminService;

import java.text.SimpleDateFormat;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DAO.AdminDAO.AdminDao;
import DAO.AdminDAO.UserDao;
import VO.AdminAccountVo;
import VO.NoticeVo;
import VO.User_AccountVo;

public class AdminService {
	Scanner sc = new Scanner(System.in);
	AdminDao dao = new AdminDao();
	UserDao UserDAO = new UserDao();
	
	
	
	String id;
	String pwd;
	AdminAccountVo vo;
	
	
	UserService User = new UserService();
	NoticeService Notice = new NoticeService();
	PackageService Package = new PackageService();
	
	public void sign() {
		System.out.println("┌──────────────────────────┐");
		System.out.println("│          자 바 투 어                     │");
		System.out.println("└──────────────────────────┘");
	}
	
	private AdminAccountVo login() {
		List<AdminAccountVo> Admin_List = dao.Admin_List();
		
		
		try {
			System.out.println("아이디를 입력해주세요.>>");
			id = sc.nextLine();
			System.out.println("비밀번호를 입력해주세요.>>");
			pwd =sc.nextLine();
			
			for(int i =0; i<Admin_List.size(); i++) {
				
				if(Admin_List.get(i).getID().equals(id) && Admin_List.get(i).getPWD().equals(pwd)) {
					
					
					System.out.println("로그인중.....");
					//Thread.sleep(2000);
					vo = Admin_List.get(i);
				}
				
			}
			
		} catch (Exception e) {
			System.out.println("잘못 입력하셨습니다.");
		}
		return vo;
		
	}//login

	
	
	
	
	//어드민 로그인시 화면 메서드 
	public void Main() {
		
		AdminAccountVo Account = login();
		System.out.println(Account.getID() +"에서 로그인 했습니다.");
		boolean loof = true;
		while(loof) {
			System.out.println("───────────────────────────");
		System.out.println("0.로그아웃");
		System.out.println("1.회원정보 전체 출력");
		System.out.println("2.회원정보 검색 출력");
		System.out.println("3.공지사항 삽입/수정/삭제");
		System.out.println("4.패키지 삽입/수정/삭제");
		System.out.println("───────────────────────────");
		System.out.println("작업을 선택해주세요.>>");
		int choice = Integer.parseInt(sc.nextLine());
		
		switch(choice) {
		
		case 0:
			loof = false;
			System.out.println("로그아웃 하셨습니다.");
			break;
		case 1:
			User.Select();
			break;
		case 2:
			User.main();
			break;

		case 3:
			Notice.main();
			break;

		case 4:
			Package.main();
			break;
		
		}
		}//while
		
	}//Admin_Menu()
	


	
	
	



	

	

	
	
	
	
	
	
	
}//class
