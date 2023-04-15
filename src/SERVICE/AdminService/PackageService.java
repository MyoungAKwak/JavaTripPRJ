package SERVICE.AdminService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DAO.AdminDAO.PackageDao;
import SERVICE.AriplaneService.TravelService;
import VO.PackageVo;
import VO.ReservationVO;

public class PackageService  {
	Scanner sc = new Scanner(System.in);
	TravelService travelservice = new TravelService();
	PackageDao packagedao = new PackageDao();
	public void main() {
		boolean loof = true;
		while(loof) {
		System.out.println("───────────────────────────");
		System.out.println("0.뒤로 가기");
		System.out.println("1.패키지 출력");
		System.out.println("2.패키지 등록");
		System.out.println("3.패키지 수정");
		System.out.println("4.패키지 삭제");
		System.out.println("───────────────────────────");
		int choice = Integer.parseInt(sc.nextLine());
		switch(choice) {
		case 0:
			System.out.println("이전 페이지로 돌아갑니다.");
			loof = false;
			break;
		case 1:
			Select();
			break;
		case 2:
			//Insert();
			packagedao.Insert();
			break; 
//		case 3:
//			Update();
//			break;
		case 4:
			Delete();
			break;
		default:
			System.out.println("잘못 선택하셨습니다.");
		
		}
	}
	}//Package_main()

	
	public void Select() {
		List<PackageVo> package_list = packagedao.Select();
		
		if(package_list.size()!=0) {
			
		
		
		System.out.printf("%s  \t%s \t%s \t%s \t%s \t%s \t%s \t\t\t%s \t\t\t%s\n","번호","이름","가격","계획","출발지","도착지","출발 시간","도착 시간", "항공사");
		System.out.println("───────────────────────────");
		for(int i=0; i<package_list.size(); i++) {
		System.out.printf("%s",package_list.get(i).getPackno());
		System.out.printf("\t%s",package_list.get(i).getPackname());
		System.out.printf("\t%s",package_list.get(i).getPackprice());
		System.out.printf("\t%s",package_list.get(i).getPackplan());
		System.out.printf("\t%s",package_list.get(i).getStarting_point());
		System.out.printf("\t%s",package_list.get(i).getDestination());
		System.out.printf("\t%s",package_list.get(i).getDeparture_time().substring(0,16));
		System.out.printf("\t%s",package_list.get(i).getArrival_time().substring(0,16));
		System.out.printf("\t%s\n",package_list.get(i).getTourist_spot());
		System.out.println("───────────────────────────");
		
		}
	}else {
		System.out.println("패키지가 없습니다.");
	}
	
	}


	
	public void Delete() {
	travelservice.Select();
	System.out.println("삭제할 패캐지의 번호를 입력해주세요.");
	//sString no = sc.nextLine();
	int no = Integer.parseInt(sc.nextLine());
	packagedao.Delete(no);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
