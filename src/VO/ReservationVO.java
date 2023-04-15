package VO;

public class ReservationVO {

	private int reserno; // �떆�몄뒪 �궗�슜 湲곕낯�궎 number(5)
	private String packno; // package �뀒�씠釉붿쓽 湲곕낯�궎 踰덊샇瑜� �쇅�옒�궎濡� 媛��졇�샂.
	private String id; // member �뀒�씠釉붿쓽 湲곕낯�궎 id瑜� �쇅�옒�궎濡� 媛��졇�샂.
	private String pwd;
	private String packname;
	
	
	public String getPackname() {
		return packname;
	}
	public void setPackname(String packname) {
		this.packname = packname;
	}
	public int getReserno() {
		return reserno;
	}
	public void setReserno(int reserno) {
		this.reserno = reserno;
	}
	public String getPackno() {
		return packno;
	}
	public void setPackno(String packno) {
		this.packno = packno;
	}
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
	
}
