package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
	 *  JDBC(Java DataBase Connectivity)라이브러리를 이용한 DB자료 처리하기
	 */



public class JdbcTest01 {
	/*
	 * JDBC를 이용한 DB처리 순서
	 * 1. 드라이버 로딩 --> 라이브러리를 사용할 수 있게 메모리로 읽어 들이는 작업 Calss.forName("oracle.jdbc.driver.OracleDriver");
	 * 2. DB에 접속하기 ==> 접속이 완료되면 Connection객체가 반환된다. DriverManager.getConnection() 메서드를 이용한다.
	 * 3. 처리할 SQL문을 문자열로 작성한다.
	 * 4. 3번에서 작성한 SQL문을 서버로 보내서 처리하고 처리한 결과를 얻어올 객체를 생성한다.
	 * 		(Statement객체 또는 PreparedStatement객체를 생성한다. ==> Connection객체를 이용해서 생성한다.)
	 * 5. 4번에서 생성한 객체를 이용해서 DB에 쿼리문을 보내 처리한 결과를 얻어온다.
	 * 		1) SQL문이 select문일 경우에는 select한 결과가 ResultSet객체에 저장되어 반환된다.
	 * 		2) SQL문이 select문이 아닐경우(insert문, update문, delete문 등)에는 정수값이 반환된다.
	 * 		 (이 정수값은 보통 실행에 성공한 레코드 수가 된다.)
	 * 6. 사용한 자원을 반납한다. ==> DB작업에서 생성된 객체들의 close()메서드를 이용한다.
	 */
	public static void main(String[] args) {
		// DB작업에 필요한 변수선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. DB연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "KJI95", "java");
			// 3. SQL문 작성
			String sql = "select * from lprod";
			
			// 4. Statement객체 생성
			stmt = conn.createStatement();
			
			// 5. SQL문을 DB서버로 보내서 결과를 얻어온다.
			//		(실행할 SQL문이 select문이기 때문에 ResultSet객체에 처리결과가 저장되어 반환된다.)
			rs = stmt.executeQuery(sql);
			
			// 6. 얻어온 결과를 처리한다. ==> 한 레코드씩 화면에 출력하기
			System.out.println(" == 쿼리문 처리 결과 == ");
			// rs.next() => rs객체의 데이터를 가리키는 포인터를 다음번째 레코드 위치로 이동시키고 그 곳에 데이터가 있으면 true
//							없으면 false 를 반환한다.
			while(rs.next()) {
				// 포인터가 가리키는 곳의 데이터를 가져오는 방법
				// 형식1) rs.get자료형이름("컬럼명 또는 alias명")
				// 형식2) rs.get자료형이름(컬럼번호) ==> 컬럼번호는 1번부터 시작...
				System.out.println("LPROD_ID : " + rs.getInt("lprod_id"));
				System.out.println("LPROD_GU : " + rs.getString(2));
				System.out.println("LPROD_NM" + rs.getNString("LPROD_NM"));
				System.out.println("-------------------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 7. 자원반납
			if(rs!=null)try {rs.close();}catch(Exception e) {}
			if(stmt!=null)try {stmt.close();}catch(Exception e) {}
			if(conn!=null)try {conn.close();}catch(Exception e) {}
		}
	}

}
