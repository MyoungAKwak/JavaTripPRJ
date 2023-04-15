package SERVICE.AriplaneService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import DAO.AirplaneDAO.AirplaneAccountDao;
import DAO.AirplaneDAO.AirplaneDao;
import VO.AirplaneAccountVo;

public class AirplaneService {
	Connection conn;
	AirplaneDao dao = new AirplaneDao();
	Scanner sc = new Scanner(System.in);
	AirplaneAccountVo vo;
	
	
	AirplaneAccountService AccountService = new AirplaneAccountService();;
	TravelService TravelService = new TravelService();
	AirplaneDao airplanedao = new AirplaneDao();
	
	
	private AirplaneAccountVo login() {
	List<AirplaneAccountVo> Airplane_list = dao.Airplane_list();
	AirplaneAccountVo vo = new AirplaneAccountVo();
	try {
		System.out.println("아이디를 입력해주세요.>>");
		String id = sc.nextLine();
		System.out.println("비밀번호를 입력해주세요.>>");
		String pwd = sc.nextLine();
		
		for(int i =0; i<Airplane_list.size(); i++) {
			if(Airplane_list.get(i).getID().equals(id) && 
			   Airplane_list.get(i).getPWD().equals(pwd)) {
				vo = Airplane_list.get(i);
				
				
				System.out.println("로그인중.....");
				Thread.sleep(2000);
				
			}
			
		}
	} catch (Exception e) {
	System.out.println("login() 오류");
	}
	return vo;
	
	}//login()
	
	public void Main() {
		AirplaneAccountVo Account = login();
		boolean loof = true;
		while(loof) {
		System.out.println("───────────────────────────");
		System.out.println("0.로그아웃");
		System.out.println("1.여행지 등록/수정/삭제");
		System.out.println("2.여행사 정보 수정");
		System.out.println("3.여행사 정보 출력");
		System.out.println("───────────────────────────");
		System.out.println("작업을 선택해주세요.>>");
		
		int choice = Integer.parseInt(sc.nextLine());
		
		switch(choice) {
		
		case 0:
			System.out.println("로그아웃 하셨습니다.");
			loof = false;
			break;
		
		case 1:
			//여행지 신규 등록
			TravelService.main(Account);
			break;

		case 2:
			//여행사 정보 수정
			AccountService.main(Account);
			break;
		case 3:
			Select(Account);
			break;
		}
		
		}
		
	}//Airplane_Main()
	
	public void Select(AirplaneAccountVo vo) {
	System.out.println("───────────────────────────");
	System.out.printf("\t%s \t%s \t%s \t%s \t%s\n","아이디","비밀번호","항공사","전화번호","코드");
	System.out.println("───────────────────────────");
	System.out.printf("\t%s",vo.getID());
	System.out.printf("\t%s",vo.getPWD());
	System.out.printf("\t%s",vo.getAir_Name());
	System.out.printf("\t%s",vo.getAir_Tel());
	System.out.printf("\t%s\n",vo.getAir_code());
	}
	
	
	public void insertAirplane() {
		airplanedao.insertAirplane();
	}
	

	
	
	
}//class
