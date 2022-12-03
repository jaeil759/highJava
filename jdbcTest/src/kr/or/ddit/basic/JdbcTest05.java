package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

/*
 *  lprod테이블에 새로운 데이터를 추가하기
 * 
 *  lprod_gu와 lprod_nm은 직접입력받아서 처리하고,
 *  lprod_id는 현재의 lprod_id중에서 제일 큰 값보다 1크게 한다.
 *  입력받은 lprod_gu가 이미 등록되어 있으면 다시 입력 받아서 처리한다.
 */



public class JdbcTest05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DBUtil.getConnection();
			
			// lprod_id는 현재의 lprod_id값 중에서 제일 큰 값 보다 1 크게 한다.
			String sql = "select nvl(max(lprod_id),0) + 1 as maxnum from lprod";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			int maxNum = 0;
			if(rs.next()) { // select문의 처리결과가 1개의 레코드일 경우에는 반복문 대신 if문을 사용해도 된다.
				maxNum = rs.getInt("maxnum");
//				maxNum = rs.getInt(1);
			}
			//---------------------------------------------------------------------
			String gu; // 입력한 상품분류코드(lprod_gu)가 저장될 변수 선언
			int count = 0; // 입력한 상품분류코드의 개수가 저장될 변수 선언
			
			String sql2 = "select count(*) cnt from lprod where lprod_gu = ? ";
			pstmt = conn.prepareStatement(sql2);
			
			do {
				System.out.println("상품 분류 코드 입력 >>");
				gu = sc.next();
				
				// sql문의 물음표자리에 입력한 상품 분류 코드 값을 셋팅한다.
				pstmt.setString(1, gu);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					count = rs.getInt(1);
//					count = rs.getInt("cnt");
				}
				if(count > 0) {
					System.out.println("입력한 상품 분류 코드" + gu + "는 이미 등록된 코드입니다.");
					System.out.println("다시 입력하세요.");
					
				}
			}while(count>0);
			// -------------------------------------------------------------------------------------------
			System.out.println();
			System.out.println("상품 분류명 입력 >> ");
			String nm = sc.next();
			
			String sql3 = "insert into lprod(lprod_id, lprod_gu, lprod_nm) values (?, ?, ?)";
			pstmt = conn.prepareStatement(sql3);
			pstmt.setInt(1, maxNum);
			pstmt.setNString(2, gu);
			pstmt.setNString(3, nm);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println("등록 성공");
			}else {
				System.out.println("등록 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null)try {rs.close();}catch(Exception e) {}
			if(stmt!=null)try {stmt.close();}catch(Exception e) {}
			if(pstmt!=null)try {pstmt.close();}catch(Exception e) {}
			if(conn!=null)try {conn.close();}catch(Exception e) {}
		}
//		
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "KJI95", "java");
//			System.out.println("새로운 데이터 추가");
//			
//			
//			System.out.println("gu");
//			String lgu = sc.next();
//			
//			System.out.println("nm");
//			String lnm = sc.next();
//			
//			String sql = "insert into lprod(LPROD_ID, LPROD_GU, LPROD_NM) values( (select max(lprod_id) + 1 from lprod), ?, ?)";
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setString(1, lgu);
//			pstmt.setString(2, lnm);
//			int cnt = pstmt.executeUpdate();
//			
//			System.out.println("반환값 : " + cnt);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			// 7. 자원반납
//			if(stmt!=null)try {stmt.close();}catch(Exception e) {}
//			if(pstmt!=null)try {pstmt.close();}catch(Exception e) {}
//			if(conn!=null)try {conn.close();}catch(Exception e) {}
//		}
	}

}
