package SERVICE.AriplaneService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DAO.AirplaneDAO.TravelDao;
import VO.AirplaneAccountVo;
import VO.TravelVo;

public class TravelService   {
	Scanner sc = new Scanner(System.in);
	VO.TravelVo TravelVo = new TravelVo();
	TravelDao TravelDao = new TravelDao();
	
	String query;
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public void main(AirplaneAccountVo account) {
		boolean loof =true;
		while(loof) {
		System.out.println("───────────────────────────");
		System.out.println("0.뒤로 가기");
		System.out.println("1.여행지 출력");
		System.out.println("2.여행지 등록");
		System.out.println("3.여행지 수정");
		System.out.println("4.여행지 삭제");
		System.out.println("───────────────────────────");
		System.out.println("작업을 선택해주세요.>>");
		int choice = Integer.parseInt(sc.nextLine());
		
		switch(choice) {
		
		case 0:
			loof=false;
			System.out.println("이전 페이지로 돌아갑니다");
			break;
		case 1:
			Select();
			break;
		case 2:
			Insert(account);
			break;
		case 3:
			Update(account);
			break;
		case 4:
			Delete(account);
			break;
		}
		
		}
	}
	
	
	public List Select() {
	List<TravelVo> Travel_List = TravelDao.Travel_List();
	//SimpleDateFormat sDate = new SimpleDateFormat("YYYY.MM.dd HH24:MI");
	SimpleDateFormat sDate = new SimpleDateFormat("YYYY.MM.dd");
	System.out.printf("%s \t%s \t%s \t%s \t%s \t\t\t%s \t\t\t%s\n","번호","출발지","도착지","항공사","출발시간","도착시간","여행날짜");
	System.out.println("───────────────────────────");

	for(int i =0; i<Travel_List.size(); i++) {
	System.out.printf("%s",Travel_List.get(i).getTravel_no());
	System.out.printf("\t%s",Travel_List.get(i).getStarting());
	System.out.printf("\t%s",Travel_List.get(i).getDestination());
	System.out.printf("\t%s",Travel_List.get(i).getAirplane_name());
	System.out.printf("\t%s",Travel_List.get(i).getDeparture_Time().substring(0, 16));
	System.out.printf("\t%s",Travel_List.get(i).getArrival_Time().substring(0,16));
//	System.out.println(sDate.format(Travel_List.get(i).getDeparture_Time()));
//	System.out.println(sDate.format(Travel_List.get(i).getArrival_Time()));
	System.out.printf("\t%s\n",Travel_List.get(i).getPlan());
	//System.out.println(sDate.format(Travel_List.get(i).getPlan()) );
	}
	System.out.println("───────────────────────────");
	return Travel_List;

	}//Travel_List()

	
	public void Select_Where(AirplaneAccountVo account) {
	List<TravelVo> Travel_List = TravelDao.Select(account);
	SimpleDateFormat sDate = new SimpleDateFormat("YYYY.MM.dd");

	System.out.printf("%s %s %s %s %s %s\n","출발지","도착지","항공사","출발시간","도착시간","여행날짜");
	System.out.println("───────────────────────────");
	for(int i =0; i<Travel_List.size(); i++) {
	System.out.println(Travel_List.get(i).getStarting());
	System.out.println(Travel_List.get(i).getDestination());
	System.out.println(Travel_List.get(i).getAirplane_name());
	System.out.println(sDate.format(Travel_List.get(i).getDeparture_Time()));
	System.out.println(sDate.format(Travel_List.get(i).getArrival_Time()));
	System.out.println(Travel_List.get(i).getPlan());
	}
	System.out.println("───────────────────────────");
	}
	



	public void Insert(AirplaneAccountVo account) {
	TravelVo vo = new TravelVo();
	System.out.println("출발지를 입력해주세요.>>");
	String starting = sc.nextLine();
	vo.setStarting(starting);
	
	System.out.println("도착지를 입력해주세요.>>");
	String destination = sc.nextLine();
	vo.setDestination(destination);
	
	vo.setAirplane_name(account.getAir_Name());
	System.out.println("ex)2023.12.20 06:30");
	System.out.println("출발시간을 입력해주세요.");
	
	String depature_time =sc.nextLine();
	vo.setDeparture_Time(depature_time);
	
	System.out.println("ex)2023.12.20 06:30");
	System.out.println("도착시간을 입력해주세요.");
	String arrival_time = sc.nextLine();
	vo.setArrival_Time(arrival_time);
	
	
	
	System.out.println("숙박일정을 입력해주세요.");
	String plan = sc.nextLine();
	vo.setPlan(plan);
	TravelDao.Insert(vo);
	}


	public void Delete(AirplaneAccountVo account) {
		Select_Where(account);
	
	}


	public void Update(AirplaneAccountVo account) {
		
	}


	
	
	
}//class
