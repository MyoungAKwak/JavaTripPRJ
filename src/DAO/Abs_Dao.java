package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import VO.AdminAccountVo;

public abstract class Abs_Dao {
	protected static String driver = "oracle.jdbc.driver.OracleDriver";
	protected static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	protected static String user = "travel";
	protected static String password = "1234";
	

	

}
