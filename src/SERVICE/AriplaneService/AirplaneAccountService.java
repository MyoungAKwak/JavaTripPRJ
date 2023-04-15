package SERVICE.AriplaneService;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.security.auth.login.AccountException;

import DAO.AirplaneDAO.AirplaneAccountDao;
import DAO.AirplaneDAO.AirplaneDao;
import VO.AirplaneAccountVo;

public class AirplaneAccountService {
	Scanner sc= new Scanner(System.in);
	String query;
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	AirplaneAccountDao AirplaneAccountDao = new AirplaneAccountDao();
	
	public void main(AirplaneAccountVo vo) {
		AirplaneAccountVo Account = vo;
		boolean loof = true;
		while(loof) {
		System.out.println("───────────────────────────");
		System.out.println("0.뒤로가기");
		System.out.println("1.항공사 비밀번호 수정");
		System.out.println("2.항공사 이름 수정");
		System.out.println("3.항공사 전화번호 수정");
		System.out.println("───────────────────────────");
		System.out.println("작업을 선택해주세요.>>");
		int choice = Integer.parseInt(sc.nextLine());
		
		switch(choice) {
		
		case 0:
		loof = false;
		System.out.println("이전 화면으로 돌아갑니다.");
		break;
		
		case 1:
		pwd(Account);
		break;	
		
		case 2:
		name(Account);
		break;
		
		case 3:
		tel(Account);
		break;	
		}
		
		}
	}
	
	private void pwd(AirplaneAccountVo vo) {
		System.out.println("변경하실 비밀번호를 입력해주세요.");
		String pwd = sc.nextLine();
		
		if(pwd.trim().isEmpty()||pwd == null) {
			System.out.println("수정 할수 없습니다.");
		}else {
		vo.setPWD(pwd);
		AirplaneAccountDao.pwd(vo);
		}
	}
	
	private void name(AirplaneAccountVo vo) {
	System.out.println("변경하실 항공사 이름을 입력해주세요.>>");
	String Air_name = sc.nextLine();
	if(Air_name.trim().isEmpty()||Air_name == null) {
		System.out.println("수정 할수 없습니다.");
	}else {
	vo.setAir_Name(Air_name);
	AirplaneAccountDao.name(vo);
	}
	}
	
	private void tel(AirplaneAccountVo vo) {
	System.out.println("변경하실 항공사 전화번호를 입력해주세요.");
	
	String air_tel = sc.nextLine();
	if(air_tel.trim().isEmpty()||air_tel == null) {
		System.out.println("수정 할수 없습니다.");
	}else {
	vo.setAir_Tel(air_tel);
	AirplaneAccountDao.tel(vo);
	}
	}
	
}//class
