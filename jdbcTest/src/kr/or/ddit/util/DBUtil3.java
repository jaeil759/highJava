package kr.or.ddit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

//JDBC드라이버를 로딩하고 Connection객체를 생성하는 메서드로 구성된 class 만들기...
//(dbinfo.properties파일의 내용으로 설정하기)
//방법2 => ResourceBundle 객체 이용하기
public class DBUtil3 {
	static final Logger logger = Logger.getLogger(DBUtil3.class);
	private static ResourceBundle bundle; // ResourceBundle 객체 변수 선언
	
	static {	// static 초기화 블럭
		bundle = ResourceBundle.getBundle("kr.or.ddit.config.dbinfo"); // ResourceBundle 객체 생성
		
		logger.info("ResourceBundle 객체 생성 => dbinfo.properties파일 읽기");
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName(bundle.getString("driver"));
			logger.info("db드라이버 로딩 성공~");
		} catch (Exception e) {
			//System.out.println("드라이버 로딩 실패");
			logger.error("드라이버 로딩 실패" + e);
			e.printStackTrace();
			
		}
	}
	//---------------------------------
	{ // 인스턴스 초기화 블럭
	
	}
	
	// 생성자
	public static Connection getConnection() {
		Connection conn = null;
		try {
//			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "KJI95", "java");
			//return DriverManager.getConnection(bundle.getString("url"), bundle.getString("user"), bundle.getString("pass"));
			conn = DriverManager.getConnection(
					bundle.getString("url"),
					bundle.getString("user"), 
					bundle.getString("pass"));
			logger.info("DB연결 성공");
					
		} catch (Exception e) {
//			System.out.println("DB 연결 실패");
			logger.error("DB연결실패", e);
			return null;
		}
		return conn;
	}
}
