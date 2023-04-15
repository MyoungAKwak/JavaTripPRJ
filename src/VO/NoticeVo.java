package VO;

import java.sql.Timestamp;
import java.util.Date;

public class NoticeVo {
	private String Notice_No;
	private String Title;
	private String content;
	private Date Notice_date;
	
	
	
	
	
	
	public String getNotice_No() {
		return Notice_No;
	}
	public void setNotice_No(String notice_No) {
		Notice_No = notice_No;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		this.Title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getNotice_date() {
		return Notice_date;
	}
	public void setNotice_date(Date notice_date) {
		this.Notice_date = notice_date;
	}
	
	
}
