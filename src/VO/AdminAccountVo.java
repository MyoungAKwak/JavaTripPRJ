package VO;

import java.util.Iterator;

public class AdminAccountVo extends Abs_AccountVo {
	
	 public AdminAccountVo() {
//		this.ID = "ADMIN";
//		this.PWD = "1234";
	 }
	
	
//	private static Admin_AccountVO Admin_vo  = null;
	
//	private Admin_AccountVO() {
//		this.ID = "ADMIN";
//		this.PWD = "1234";
//	}
	
//	public static Admin_AccountVO getInstance() {
//		
//		if(Admin_vo  == null) {
//			Admin_vo = new Admin_AccountVO();
//			return Admin_vo;
//		}else {
//			System.out.println("Admin 객체는 하나입니다.");
//			return Admin_vo;
//		}
//	}
	
	@Override
	public String toString() {
		return "Admin [ID=" + ID + ", PWD=" + PWD + "]";
	}

	
	
	@Override
	public void setID(String iD) {
		super.setID(iD);
	}

	@Override
	public void setPWD(String PWD) {
		super.setPWD(PWD);
	}

	@Override
	public String getID() {
		return super.getID();
	}
	@Override
	public String getPWD() {
		// TODO Auto-generated method stub
		return super.getPWD();
	}
	
}
