package VO;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Abs_AccountVo {
	protected String ID;    //30
	protected String PWD;	//30
	
	public Abs_AccountVo() {
	}
	
	public Abs_AccountVo(String ID, String PWD) {
		this.ID = ID;
		this.PWD = PWD;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		this.ID = iD;
	}
	public String getPWD() {
		return PWD;
	}
	public void setPWD(String PWD) {
		this.PWD = PWD;
	}
	
	
	
	
}
