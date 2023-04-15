package VO;

public class PackageVo { // 여행패키지 정보에 관한 테이블입니다.
	
	private String packno; // 패키지 기본키를 가진 번호입니다 타입:varchar2
	private String packname; // 패키지 명칭입니다. 타입:varchar2
	private String packprice; // 가격입니다. 00원으로 쓰고 싶어 varchar2로 해봤습니다.
	private String packplan; // 숙박 일정입니다. ex) 2박 3일 타입:varchar2
	private String starting_point; //출발 장소입니다. 타입:varchar2
	private String destination; // 목적지입니다. 타입:varchar2
	private String departure_time; // 출발 월일과 시간입니다. 타입: date
	private String arrival_time; // 도착 월일과 시간입니다. 타입: date
	private String tourist_spot;
	public String getPackno() {
		return packno;
	}
	public void setPackno(String packno) {
		this.packno = packno;
	}
	public String getPackname() {
		return packname;
	}
	public void setPackname(String packname) {
		this.packname = packname;
	}
	public String getPackprice() {
		return packprice;
	}
	public void setPackprice(String packprice) {
		this.packprice = packprice;
	}
	public String getPackplan() {
		return packplan;
	}
	public void setPackplan(String packplan) {
		this.packplan = packplan;
	}
	public String getStarting_point() {
		return starting_point;
	}
	public void setStarting_point(String starting_point) {
		this.starting_point = starting_point;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDeparture_time() {
		return departure_time;
	}
	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}
	public String getArrival_time() {
		return arrival_time;
	}
	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}
	public String getTourist_spot() {
		return tourist_spot;
	}
	public void setTourist_spot(String tourist_spot) {
		this.tourist_spot = tourist_spot;
	}
	
	
	
	
	

}
