package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcTest04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "KJI95", "java");
			
			System.out.println("계좌번호 정보 추가 하기");
			System.out.print("계좌번호 >> ");
			String bankNo = sc.next();
			
			System.out.print("은행명 >> ");
			String bankName = sc.next();
			
			System.out.println("예금주명 >> ");
			String name = sc.next();
			/*
			// Statement 객체를 이용하여 데이터 추가하기
			String sql = " insert into bankinfo(bank_no,bank_name,bank_user_name,bank_date) "+ 
					   " values ('" + bankNo +"', '"+ bankName +"','"+ name + "',sysdate)";
			stmt = conn.createStatement();
			
			// select문을 실행할 때는 executeQuery() 메서드를 사용하고, select문이 아닌 insert,update, delete등의 쿼리문을 실행할때는 
			// executeUpdate()메서드를 사용한다.
			
			// executeUpdate() 메서드의 반환값 ==> 작업에 성공한 레코드 수
			int cnt = stmt.executeUpdate(sql);
			*/
			// PrepareStatement 객체를 이용하여 데이터 추가하기
			// SQL문을 작성할 때 SQL문에 데이터가 들어갈 자리를 물음표(?)로 표시하여 작성한다.
			String sql = " insert into bankinfo(bank_no,bank_name,bank_user_name,bank_date) "+ 
					   " values ( ?, ?, ?, sysdate)";
			// PrepareStatement 객체를 생성 ==> 처리할 SQL문을 인수값으로 넣어준다.
			pstmt = conn.prepareStatement(sql);
			
			// SQL문의 물음표(?) 자리에 들어갈 데이터를 셋팅한다.
			// 형식) pstmt.set자료형 이름(물음표번호, 데이터); ==> 물음표번호는 1번부터 시작....
			pstmt.setString(1, bankNo);
			pstmt.setString(2, bankName);
			pstmt.setString(3, name);
			
			// 데이터 셋팅이 완료되면 SQL문을 실행한다.
			// SQL문이 select문이면 executeQuery()메서드를 사용하고,
			// select문이 아니면 executeUpdate()메서드를 사용한다.
			int cnt = pstmt.executeUpdate();
			
			System.out.println("반환값 : " + cnt);
			
		} catch (Exception e) {
			
		}finally {
			// 7. 자원반납
			if(stmt!=null)try {stmt.close();}catch(Exception e) {}
			if(pstmt!=null)try {pstmt.close();}catch(Exception e) {}
			if(conn!=null)try {conn.close();}catch(Exception e) {}
		}
	}

}
