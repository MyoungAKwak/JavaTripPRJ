package SERVICE.UserService;

import java.util.List;
import java.util.Scanner;

import DAO.AdminDAO.*;
import DAO.AdminDAO.UserDao;
import DAO.UserDao.UserDao_;
import VO.User_AccountVo;

public class UserService {
	Scanner sc = new Scanner(System.in);
	AdminDao AdminDao = new AdminDao();
	UserDao AdminUserDao = new UserDao();
	UserDao_ UserDao = new UserDao_();
	
	public void signUp() {
		
		//UserDao.insertUser();
		
	}
	
	public void UserAccountMain() {
		boolean loof = true;
		while(loof) {
		System.out.println("───────────────────────────");
		System.out.println("0.뒤로가기");
		System.out.println("1.아이디 찾기");
		System.out.println("2.비밀번호 찾기");
		System.out.println("───────────────────────────");
		int choice = Integer.parseInt(sc.nextLine());
		
		switch(choice) {
		
		case 0:
			loof = false;
			System.out.println("이전 페이지로 돌아갑니다.");
			break;
		case 1:
			Id();
			break;
			
		case 2:
			Pwd();
			break;
		}

		
		}
	}//Main()
	
	
	public User_AccountVo Id() {
		User_AccountVo vo = new User_AccountVo();
		
		System.out.println("찾으실 ID를 입력해주세요.");
		String id = sc.nextLine();
		vo.setID(id);
		
		System.out.println("찾으실 ID의 이름을 입력해주세요.");
		String name = sc.nextLine();
		vo.setName(name);
		
		
		List<User_AccountVo> User_list = UserDao.Id(vo);
		if(User_list.size()!=0) {
		
		System.out.println("아이디 : " + User_list.get(0).getID());
	
		}
				
			
			
			
		
			return vo;
	} 
	
	public void Pwd() {
		User_AccountVo vo = new User_AccountVo();
		
		System.out.println("비밀번호를 찾으실 ID를 입력해주세요.");
		String id = sc.nextLine();
		vo.setID(id);
		
		
		
		
	}
	
	
	
}//class
