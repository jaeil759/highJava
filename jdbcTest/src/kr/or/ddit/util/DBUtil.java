package kr.or.ddit.util;

import java.sql.Connection;
import java.sql.DriverManager;

// JDBC드라이버를 로딩하고 Connection객체를 생성하는 메서드로 구성된 class 만들기...

public class DBUtil {
	static {	// static 초기화 블럭
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
			
		}
	}
	//---------------------------------
	{ // 인스턴스 초기화 블럭
	
	}
	
	// 생성자
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "KJI95", "java");
			
		} catch (Exception e) {
			System.out.println("DB 연결 실패");
			return null;
		}
	}
}
