package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

// 문제) 사용자로부터 Lprod_ID 값을 입력받아 입력한 값보다 Lprod_id가 큰 자료들을 출력하시오.

public class JdbcTest02 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("lprod_id 입력 >>");
		int num = sc.nextInt();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. DB연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "KJI95", "java");
			// 3. SQL문 작성
			String sql = "select * from lprod where lprod_id >" + num;
			
			// 4. Statement객체 생성
			stmt = conn.createStatement();
			
			// 5. SQL문을 DB서버로 보내서 결과를 얻어온다.
			//		(실행할 SQL문이 select문이기 때문에 ResultSet객체에 처리결과가 저장되어 반환된다.)
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				// 포인터가 가리키는 곳의 데이터를 가져오는 방법
				// 형식1) rs.get자료형이름("컬럼명 또는 alias명")
				// 형식2) rs.get자료형이름(컬럼번호) ==> 컬럼번호는 1번부터 시작...
				System.out.println("ID : " + rs.getInt("lprod_id"));
				System.out.println("GU : " + rs.getString("lprod_gu"));
				System.out.println("NM" + rs.getNString("LPROD_NM"));
				System.out.println("-------------------------------------------------");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			// 7. 자원반납
			if(rs!=null)try {rs.close();}catch(Exception e) {}
			if(stmt!=null)try {stmt.close();}catch(Exception e) {}
			if(conn!=null)try {conn.close();}catch(Exception e) {}
		}
	}

}
