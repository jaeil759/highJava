package kr.or.ddit.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

// JDBC드라이버를 로딩하고 Connection객체를 생성하는 메서드로 구성된 class 만들기...
// (dbinfo.properties파일의 내용으로 설정하기)
// 방법1 => Properties객체 이용하기 

public class DBUtil2 {
	private static Properties prop;			// Properties객체 변수 선언
	
	
	
	static {	// static 초기화 블럭
		prop = new Properties();	// Properties객체 생성
		
		File f = new File("res/kr/or/ddit/config/dbinfo.properties");
		FileInputStream fin = null;
		
		try {
			fin = new FileInputStream(f);
			prop.load(fin); // 읽기 완료
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName(prop.getProperty("driver"));
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
			
		} catch (IOException e) {
			System.out.println("입출력 오류... ==> 드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	//---------------------------------
	{ // 인스턴스 초기화 블럭
	
	}
	
	// 생성자
	public static Connection getConnection() {
		try {
//			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "KJI95", "java");
			return DriverManager.getConnection(
					prop.getProperty("url"),
					prop.getProperty("user"),
					prop.getProperty("pass"));
		} catch (Exception e) {
			System.out.println("DB 연결 실패");
			return null;
		}
	}
}
