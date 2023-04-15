package SERVICE.UserService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import DAO.UserDao.UserDao__;
import Main.Main;
import VO.PackageVo;
import VO.ReservationVO;
import VO.User_AccountVo;


public class ServiceForMember { // 실질적인 홈페이지 서비스 뷰 역할을 하는 클래스. dao에서 만든 기능을 Ui와 결합.
	Scanner sc = new Scanner(System.in);
	private String id;
	private String pwd;
	public String packname;
	public User_AccountVo meberVO = new User_AccountVo();
	Main main = new Main();

	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public List loginSession() throws SQLException {
		Scanner sc = new Scanner(System.in);
		UserDao__ dao = new UserDao__();
		
		System.out.println("────────────로그인창─────────────");
		System.out.println("ID 입력:");
		id = sc.nextLine();
		System.out.println("비밀번호 입력:");
		pwd = sc.nextLine();
		System.out.println("──────────────────────────────");
		
		return dao.login(id, pwd);

	} // 로그인 세션view 끝

	
	public List session() throws SQLException {
		Scanner sc = new Scanner(System.in);
		UserDao__ dao = new UserDao__();
		List<User_AccountVo> list = new ArrayList<>();
		User_AccountVo vo = new User_AccountVo();
		String select;
		
		try {
		System.out.println();
		System.out.println("───────회원단───────────");
		System.out.println("1.패키지 검색과 예매");
		System.out.println("2.회원 정보 조회 및 수정");
		System.out.println("3.예매 현황 및 취소");
		System.out.println("4.로그아웃");
		System.out.println("──────────────────────");
		select = sc.nextLine();

		
		if (select.equals("1")) {
			return ReservationSession();
		} 
		
		else if (select.equals("2")) {
			
			System.out.println("────회원 정보 조회 및 수정단───");
			System.out.println("비밀번호를 입력해주세요.:");
			String pwd = sc.nextLine();
			
			list = dao.serchingMember(pwd); // 회원 정보 조회및 수정 메서드로 이동
			System.out.println();
			
			
		} else if (select.equals("3")) {
			return MemberReserLookup();
			
		} else if (select.equals("4")) {
			return null;
			
		} else {
			System.out.println("잘못된 입력 값 입니다.");
			return session();
		}
		
		} catch(Exception e) {
			System.out.println("잘 좀 입력하세요.");
			return null;
		}
		
		return null; 
	} // sessiong 스코프

	
	public List ReservationSession() throws SQLException { // 패키지 조회및 예매 사이트 담당 세션
		Scanner sc = new Scanner(System.in);
		UserDao__ dao = new UserDao__();
		PackageVo packvo = new PackageVo();
		List<PackageVo> packlist = new ArrayList<>();
		packlist = dao.AllpacakgeSerching();
		
		try {
		System.out.println("──────현재 게시중인 패키지 목록───────────────────────────────────────────────");
		for(int i=0; i<packlist.size(); i++) {
		packvo=packlist.get(i);
		System.out.print("상품번호:"+packvo.getPackno());
		System.out.print("  "+" 패키지 이름:"+packvo.getPackname());
		System.out.print("  "+" 패키지 가격:"+packvo.getPackprice());
		System.out.print("  "+" 일정:"+packvo.getPackplan());
		System.out.print("  "+" 여행지:"+packvo.getTourist_spot()+"\n");
		System.out.println("─────────────────────────────────────────────────────────────────────");
		System.out.println();
		  } // for문
		System.out.println("──>원하시는 패키지를 예매하세요!─────");
		System.out.println("1.패키지 이름으로 검색");
		System.out.println("2.여행지 이름으로 검색");
		System.out.println("3.회원단으로 돌아가기");
		System.out.println("───────────────────────────");
		String select1 = sc.nextLine();
		
		// 조건문 시작
		if(select1.equals("1")) {
		System.out.println("패키지 이름을 입력하세요:");
		String packname = sc.nextLine();
		System.out.println("─────────────────────────────────────────");
		
		packlist = dao.serchingPack(packname); // 쿼리를 날려 가져온 패키지 정보를 리스트에 담는다.
		
		for (int i = 0; i < packlist.size(); i++){
			packvo = packlist.get(i);
			System.out.println("패키지 이름:──"+packvo.getPackname()+"──");
			System.out.println("가격:──"+packvo.getPackprice()+"──");
			System.out.println("일정:──"+packvo.getPackplan()+"──");
			System.out.println("출발 지점:──"+packvo.getStarting_point()+"──");
			System.out.println("도착 지점:──"+packvo.getDestination()+"──");
			System.out.println("출발 날짜:──"+packvo.getDeparture_time()+"──");
			System.out.println("도착 날짜:──"+packvo.getArrival_time()+"──");
			} // for문
		
		  	System.out.println("────────────────────────────────────────");
		  	System.out.println("───본 상품을 예매 하시겠습니까?───");
		  	System.out.println("1.현재 검색한 상품을 예매한다.");
		  	System.out.println("2.패키지 검색단으로 돌아간다.");
		  	System.out.println("3.회원단으로 돌아간다.");
		  	System.out.println("──────────────────────────");
		  	
		  	String select2 = sc.nextLine(); // 여행지 이름으로 검색인 2번을 입력했을때 입력 받을 변수 select2
		  	
		if(select2.equals("1")) {
		   dao.insertReser(packname, id, pwd);
			
		}  else if(select2.equals("2")) {
			return ReservationSession();
			
		
		}  else if(select2.equals("3")) {
			return session();
		
		}  else { // 지정된 값 1,2,3을 벗어나면 다시 위로 돌아간다.
			System.out.println();
			System.out.println("잘못 입력된 값 입니다.");
			return packlist = dao.serchingPack(packname);
		}
		
		
		} else if(select1.equals("2")) { // 2번 선택 여행지 이름으로 검색 변수명 주시 select1이다.
			PackageVo vo = new PackageVo();
			packlist=dao.touristsopt(); // 현재 활성화되어 있는 여행지를 보여줘서 사용자가 여행지를보고 검색할 수 있게 해줍니다.
			
			System.out.println("현재 활성화 된 여행지 입니다."); // 현재 활성화된 여행지를 보여줍니다.
			for(int i=0; i<packlist.size(); i++) {
				vo = packlist.get(i);
				System.out.println(vo.getTourist_spot());
			} // for문 
			
			System.out.println("위의 활성화된 여행지 이름을 선택해 입력해주세요:");
			/* System.out.println("'이름-이름'식으로 중간에 하이픈을 추가해서 넣어서 입력해야합니다."); */
			String touristSerching = sc.nextLine();
			/* String touristSerching_pattern = "[가-힣]{5}"; */
			packlist=dao.touristsoptSerching(touristSerching);
			System.out.println("여행지로 검색 성공");
			
			for(int i=0; i<packlist.size(); i++) {
				vo = packlist.get(i);
				System.out.println("패키지 이름:──"+packvo.getPackname()+"──");
				System.out.println("가격:──"+packvo.getPackprice()+"──");
				System.out.println("일정:──"+packvo.getPackplan()+"──");
				System.out.println("출발 지점:──"+packvo.getStarting_point()+"──");
				System.out.println("도착 지점:──"+packvo.getDestination()+"──");
				System.out.println("출발 날짜:──"+packvo.getDeparture_time()+"──");
				System.out.println("도착 날짜:──"+packvo.getArrival_time()+"──");
				System.out.println("여행지:──"+packvo.getTourist_spot()+"──");
			}// for문 여행지로 검색 조회 
			
			/*if(Pattern.matches(touristSerching_pattern, touristSerching))  {*/
				 // 여행지로 검색해 찾은 패키지 정보를 list에 담는다.
				
			/*
			 * } else { System.out.println("검색 양식에 맞게 입력하세요."); return ReservationSession();
			 * }
			 */			
			System.out.println();
		  	System.out.println("──────본 상품을 예매 하시겠습니까?─────");
		  	System.out.println("1.현재 검색한 상품을 예매한다.");
		  	System.out.println("2.패키지 검색단으로 돌아간다.");
		  	System.out.println("3.회원단으로 돌아간다.");
		  	System.out.println("─────────────────────────────");
		  	
		  	String select3 = sc.nextLine(); // select3 주목
			
		  	if(select3.equals("1")) {
		  		
		  	return packlist = dao.touristResrvationInsert(touristSerching, id, pwd);
		  	
		  	} else if(select3.equals("2")) {

		  	return ReservationSession();
		  		
		  	} else if(select3.equals("3")) {
		  		
		  	return session();
		  	
		  	}
		  	
		  	else {
		  	System.out.println("잘못 입력한 값입니다.");
		  	
		  	return ReservationSession();
		  	}
		  	
		} else if(select1.equals("3")) { // 주의 selcet1이므로  맨처음에 입력받은 변수이기에 주의 하십시다.
			return session();
			
		} else {
			System.out.println("잘못 입력한 값입니다.");
	  		return ReservationSession();
		}
		
		} catch (Exception e) {
			System.out.println("예기치 못한 오류");
			return session();
		}
		return packlist;
	} // 패키지 조회및 예매 세션	
		
		
	public List MemberReserLookup() throws SQLException { // 회원이 예매한 패키지 조회와 취소
		Scanner sc = new Scanner(System.in);
		UserDao__ dao = new UserDao__();
		ReservationVO vo = new ReservationVO();
		List<ReservationVO> list = new ArrayList<>();
		List<User_AccountVo> list2 = new ArrayList<>();
	
		System.out.println("─────회원님의 예매한 상품을 조회하는 단─────");
		System.out.println("1.예매 조회 및 취소");
		System.out.println("2.회원단으로 돌아가기");
		String select1 = sc.nextLine();
	
	if(select1.equals("1")) {
	
		System.out.println("비밀번호를 입력해주세요:");
		String pwd = sc.nextLine();
		System.out.println();
		
		list=dao.ReserLookup(pwd); // 비밀번호를 입력했을때 예매한 패키지를 가져오는 메서드입니다.
		for(int i=0; i<list.size(); i++) {
		vo=list.get(i);
		System.out.println("─────예매현황─────────");
		System.out.println("회원님의 예약번호:"+vo.getReserno());
		System.out.println("패키지 번호:"+vo.getPackno());
		System.out.println("예약하신 회원님의 ID:"+vo.getId());
		System.out.println("예약 패키지 이름:"+vo.getPackname());
		} // for문
	
	   System.out.println("─────────────────────────");
	   System.out.println("1.회원세션으로 돌아가기");
	   System.out.println("2.예매취소하기");
	   System.out.println("─────────────────────────");
	   String select2 = sc.nextLine();
	
	if(select2.equals("1")) {
	return session(); // 회원단으로 돌아갑니다.
		
	} else if(select2.equals("2")) {
		System.out.println("삭제하실 예매 패키지의 예매번호를 입력하세요.");
		int reserno = sc.nextInt();
		dao.DeleteResr(pwd, reserno);
	} else {
		System.out.println("비밀번호가 일치하지 않습니다.");
		return session();
	}
		
	} else if(select1.equals("2")) {
		return session();
		
	} else { // select1 범위를 벗어난 값에 대한 else
		System.out.println("잘못된 값 입니다.");
		return session();
	}
	
	return list;
	
	} // 예매조회 단 메서드의 끝
} // 서비스 클래스단