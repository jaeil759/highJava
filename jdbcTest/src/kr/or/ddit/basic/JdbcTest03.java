package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

// 문제) lprod_id값을 2개 입력받아서 두값중 작은값부터 큰 값 사이의 자료들을 출력하시오.

public class JdbcTest03 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("첫번째 lprod_id 입력 >>");
		int num1 = sc.nextInt();
		System.out.println("두번째 lprod_id 입력 >>");
		int num2 = sc.nextInt();
		
		int max, min;
		if(num1>num2) {
			max = num1;
			min = num2;
			
		}else {
			max = num2;
			min = num1;
		}
//		try {
//			// 1. 드라이버 로딩
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			// 2. DB연결
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "KJI95", "java");
//			// 3. SQL문 작성
//			String sql = "select * from lprod where lprod_id >=" + min + "and lprod_id <= " + max;
////			String sql = "select * from lprod where lprod_id between" + min + "and" + max;
//			
//			// 4. Statement객체 생성
//			stmt = conn.createStatement();
//			
//			// 5. SQL문을 DB서버로 보내서 결과를 얻어온다.
//			//		(실행할 SQL문이 select문이기 때문에 ResultSet객체에 처리결과가 저장되어 반환된다.)
//			rs = stmt.executeQuery(sql);
//			
//			// 6. 얻어온 결과를 처리한다. ==> 한 레코드씩 화면에 출력하기
//			// rs.next() => rs객체의 데이터를 가리키는 포인터를 다음번째 레코드 위치로 이동시키고 그 곳에 데이터가 있으면 true
////							없으면 false 를 반환한다.
//			while(rs.next()) {
//				// 포인터가 가리키는 곳의 데이터를 가져오는 방법
//				// 형식1) rs.get자료형이름("컬럼명 또는 alias명")
//				// 형식2) rs.get자료형이름(컬럼번호) ==> 컬럼번호는 1번부터 시작...
//				System.out.println("ID : " + rs.getInt("lprod_id"));
//				System.out.println("GU : " + rs.getString("lprod_gu"));
//				System.out.println("NM" + rs.getNString("LPROD_NM"));
//				System.out.println("-------------------------------------------------");
//			}
			
		
		// preparestatement 이용하는방법
		try {
				// 1. 드라이버 로딩
				Class.forName("oracle.jdbc.driver.OracleDriver");
				// 2. DB연결
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "KJI95", "java");
				// 3. SQL문 작성
				
				String sql = "select * from lprod where lprod_id >= ? and lprod_id <= ? ";
//				String sql = "select * from lprod where lprod_id between ? and ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, min);
				pstmt.setInt(2, max);
				rs = pstmt.executeQuery();
//			String sql = "select * from lprod where lprod_id between" + min + "and" + max;
				
				// 4. Statement객체 생성
			
				
				// 5. SQL문을 DB서버로 보내서 결과를 얻어온다.
				//		(실행할 SQL문이 select문이기 때문에 ResultSet객체에 처리결과가 저장되어 반환된다.)
				
				
				// 6. 얻어온 결과를 처리한다. ==> 한 레코드씩 화면에 출력하기
				// rs.next() => rs객체의 데이터를 가리키는 포인터를 다음번째 레코드 위치로 이동시키고 그 곳에 데이터가 있으면 true
//							없으면 false 를 반환한다.
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
			e.printStackTrace();
		}finally {
			// 7. 자원반납
			if(rs!=null)try {rs.close();}catch(Exception e) {}
			if(stmt!=null)try {stmt.close();}catch(Exception e) {}
			if(conn!=null)try {conn.close();}catch(Exception e) {}
		}
		
	}

}
