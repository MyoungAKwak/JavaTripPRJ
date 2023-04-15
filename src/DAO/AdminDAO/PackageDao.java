package DAO.AdminDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DAO.Abs_Dao;
import DAO.AirplaneDAO.TravelDao;
import SERVICE.AriplaneService.TravelService;
import VO.PackageVo;
import VO.ReservationVO;
import VO.TravelVo;

public class PackageDao extends Abs_Dao {
	Scanner sc = new Scanner(System.in);
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String query;
	
	TravelDao travel = new TravelDao();
	TravelService travelService = new TravelService();
	
	private void connDB() { 
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			System.out.println("UserDao.connDB()오류");
			
		}
	}//connDB()
	
	public List<PackageVo> Select() {
	connDB();
	List package_list = new ArrayList();
	query = "select * from package";
	try {
		stmt = conn.createStatement();
		rs = stmt.executeQuery(query);
		if(rs.next()) {
			
		while(rs.next()) {
		PackageVo vo = new PackageVo();
		vo.setPackno(rs.getString(1));
		vo.setPackname(rs.getString(2));
		vo.setPackprice(rs.getString(3));
		vo.setPackplan(rs.getString(4));
		vo.setStarting_point(rs.getString(5));
		vo.setDestination(rs.getString(6));
		vo.setDeparture_time(rs.getString(7));
		vo.setArrival_time(rs.getString(8));
		vo.setTourist_spot(rs.getString(9));
		package_list.add(vo);
		}
	}else {
	}
	}catch (SQLException e) {
		e.printStackTrace();
	}
		return package_list;
		
	}

	
	public List<ReservationVO> Insert(){
		connDB();
		
		String packplan = null;
		String starting_point = null;
		String destination = null;
		String departure_time = null;
		String arrival_time = null;
		System.out.println("───────────────────────────");
		System.out.println("여행지 목록");
		System.out.println("───────────────────────────");

		List<TravelVo> Travel =travelService.Select();
		
		System.out.println("등록할 여행지의 번호를 입력해주세요.");
		int pick = Integer.parseInt(sc.nextLine());
		for(int i =0; i< Travel.size(); i++) {
			if(pick==Travel.get(i).getTravel_no()) {
				System.out.println("같습니다.");
				 packplan = Travel.get(i).getPlan();
				 starting_point = Travel.get(i).getStarting();
				 destination = Travel.get(i).getDestination();
				 arrival_time = Travel.get(i).getArrival_Time().substring(0, 16).replace('-', '.');
				 departure_time =Travel.get(i).getDeparture_Time().substring(0, 16).replace('-', '.');
				 System.out.println(departure_time);
				
			}
		}
		System.out.println("패키지 번호 입력 형식(etp00~000):");
		String packno = sc.nextLine();
		System.out.println("패키지 이름 입력:");
		String packname = sc.nextLine();
		System.out.println("패키지 가격 입력 형식(000원):");
		String packprice = sc.nextLine();
		System.out.println("패키지 여행지 입력  형식(ex일본-오사카 등등..:");
		String tourist_spot = sc.nextLine();
		
		String query = "insert into package values(?,?,?,?,?,?,to_date(?,'YYYY.MM.dd HH24:MI'),to_date(?,'YYYY.MM.dd HH24:MI'),?)";
		System.out.println(departure_time);
		try {
			
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, packno);
			pstmt.setString(2, packname);
			pstmt.setString(3, packprice);
			pstmt.setString(4, packplan);
			pstmt.setString(5, starting_point);
			pstmt.setString(6, destination);
			pstmt.setString(7, departure_time); 
			pstmt.setString(8, arrival_time); 
			pstmt.setString(9, tourist_spot);
			
			
			
			int count = pstmt.executeUpdate();
			if(count !=0) {
			System.out.println("패키지 등록을 완료했습니다.");
				
			}else {
				System.out.println("패지키 등록에 실패하셨습니다.");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	public void Delete(int no) {
	query = "delete from package where packno=?";
	try {
		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, no);
		int count =pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	}
	
	public void Update() {
		
		
	}
	
}
