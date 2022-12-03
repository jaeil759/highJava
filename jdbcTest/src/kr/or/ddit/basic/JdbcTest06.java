package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;
import kr.or.ddit.util.DBUtil2;
import kr.or.ddit.util.DBUtil3;

/*
 *  회원을 관리하는 프로그램을 작성하시오. (mymember 테이블 이름)
 *  
 *  아래 메뉴의 기능을 모두 구현하시오 (CRUD 구현하기)
 *  메뉴에서)
 *  ===================
 *  1.자료추가             --> insert (c)
 *  2.자료삭제			   --> Delete (D)
 *  3.자료수정	           --> update (U)
 *  4.전체 자료 출력       --> select (R)
 *  0.작업 끝.
 *  ===================
 *  
 *  조건)
 *  1) '자료 추가' 에서 '회원ID' 는 중복되지 않는다. (중복되면 다시 입력 받는다)
 *  2) '자료 삭제' 에서는 '회원ID'를 입력 받아서 처리한다.
 *  3) '자료 수정' 에서 '회원ID'는 변경되지 않는다.
 *  
 */


public class JdbcTest06 {
	// DB작업에 필요한 객체
	Scanner sc = new Scanner(System.in);
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public static void main(String[] args) {
		new JdbcTest06().memberStart();

	}
	//시작메서드
	public void memberStart() {
		while(true) {
			int choice = displayMenu();

			switch(choice) {
			case 1: 	// 자료 추가
				insertMember();
				break;	
			case 2: 	// 자료 삭제
				deleteMember(); 
				break;
			case 3: 	// 자료 수정
				updateMember();
				break;
			case 4: 	// 전체 출력
				displayMember();
				break;
			case 5: 	// 자료 수정
				updateMember2();
				break;
			case 0: 	// 작업끝
				System.out.println("작업을 마칩니다...");
			default : 
				System.out.println("번호를 잘못입력했습니다 다시 입력해주세요.");
			}
		}
	}

	private void updateMember2() {
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요.");
		System.out.print("회원 ID >>");
		String memId = sc.next();

		int count = getMemberCount(memId);
		if(count==0) {
			System.out.println(memId + "은(는) 없는 회원ID 입니다.");
			System.out.println("수행 작업을 종료합니다");
			return;
		}
		int num;
		String updateField = null; // 수정할 컬럼명이 저장될 변수
		String updateTitle = null; // 수정할 내용을 입력할 때 출력할 내용이 저장될 변수

		do {
			System.out.println();
			System.out.println("수정할 항목을 선택하세요...");
			System.out.println(" 1.비밀번호 2.회원이름 3.전화번호 4.회원주소");
			System.out.println("----------------------------------------------------");
			System.out.print("수정 항목 선택 >>");
			num = sc.nextInt();
			switch(num) {
			case 1: updateField = "mem_pass"; updateTitle = "비밀번호"; break;
			case 2: updateField = "mem_name"; updateTitle = "회원이름"; break;
			case 3: updateField = "mem_tel"; updateTitle = "전화번호"; break;
			case 4:	updateField = "mem_addr"; updateTitle = "회원주소"; break;
			default : 
				System.out.println("수정 항목을 잘못 선택했습니다. 다시 선택하세요.");
			}
		}while(num < 1 || num > 4);

		System.out.println();
		sc.nextLine();
		System.out.print("새로운" + updateTitle + ">>");
		String updateData = sc.nextLine(); // 변경될 값 입력

		try {
			conn = DBUtil.getConnection();

			String sql = "update mymember set " + updateField + " = ? where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, updateData);
			pstmt.setString(2, memId);

			int cnt = pstmt.executeUpdate();
			if(cnt > 0) {
				System.out.println("수정 작업 성공!");
			}else {
				System.out.println("수정 작업 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnect();   
		}
		
	}
	private void updateMember() {
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요.");
		System.out.print("회원 ID >>");
		String memId = sc.next();

		int count = getMemberCount(memId);
		if(count==0) {
			System.out.println(memId + "은(는) 없는 회원ID 입니다.");
			System.out.println("수행 작업을 종료합니다");
			return;

		}
		System.out.println();
		System.out.println("수정할 내용을 입력하세요");
		System.out.print("새로운 비밀번호 >> ");
		String newPass = sc.next();
		System.out.print("새로운 회원이름 >> ");
		String newName = sc.next();
		System.out.print("새로운 전화번호 >> ");
		String newTel = sc.next();
		System.out.print("새로운 회원주소 >> ");
		String newAddr = sc.nextLine();
		try {
			conn = DBUtil.getConnection();
			String sql = "update mymember set mem_pass = ?, mem_name = ?, mem_tel = ?, mem_addr = ? where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newPass);
			pstmt.setString(2, newName);
			pstmt.setString(3, newTel);
			pstmt.setString(4, newAddr);
			pstmt.setString(5, memId);
			int cnt = pstmt.executeUpdate();
			if(cnt > 0) {
				System.out.println(memId + "회원 정보 수정 완료!!");
			}else {
				System.out.println(memId + "회원 정보 수정 실패~~");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}

	}
	private void displayMember() {
		System.out.println("-----------------------------------------------");
		System.out.println(" ID		비밀번호	이름	전화번호	주소");
		System.out.println("-----------------------------------------------");

		try {
			//conn = DBUtil.getConnection();
//			conn = DBUtil2.getConnection();
			conn = DBUtil3.getConnection();
			String sql = "select * from mymember";
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while(rs.next()) {
				String id = rs.getString("mem_id");
				String pass = rs.getString("mem_pass");
				String name = rs.getString("mem_name");
				String tel = rs.getString("mem_tel");
				String addr = rs.getString("mem_addr");

				System.out.println(id + "\t" + pass + "\t" + name + "\t" + tel + "\t" + addr);

			}
			System.out.println("---------------------------------------------");

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}



	}
	// 회원정보를 삭제하는 메서드
	private void deleteMember() {
		System.out.println();
		System.out.println("삭제할 회원정보를 입력하세요.");
		System.out.print("삭제할 회원ID >> ");
		String memId = sc.next();

		try {
			conn = DBUtil.getConnection();
			String sql = "delete from mymember where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			int cnt = pstmt.executeUpdate();
			if(cnt > 0) {
				System.out.println("회원 ID가 " + memId + "인 회원정보 삭제 성공!!");
			}else {
				System.out.println(memId + "회원은 없는 회원이거나 삭제작업에 실패하였습니다.");
			}



		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			disConnect();
		}

	}
	// 회원정보를 추가하는 메서드
	private void insertMember() {
		System.out.println();
		System.out.println("추가할 회원 정보를 입력하세요.");
		int count = 0;			// 해당 회원id개수가 저장될 변수
		String memId = null; 	// 회원ID가 저장될 변수
		do{
			System.out.print("회원 ID >>");
			memId = sc.next();
			count = getMemberCount(memId);

			if(count > 0) {
				System.out.println(memId + "은(는) 이미 중복된 회원 ID입니다");
				System.out.println("다른 회원 id를입력하세요");
			}

		}while(count > 0); 

		System.out.print("비밀번호 >>");
		String memPass = sc.next();

		System.out.print(" 회원이름 >> ");
		String memName = sc.next();

		System.out.print("전화번호 >> ");
		String memTel = sc.next();

		sc.nextLine();
		System.out.print("회원 주소 >> ");
		String memAddr = sc.nextLine();
		try {
			conn = DBUtil.getConnection();

			String sql = "insert into mymember(MEM_ID, MEM_PASS, MEM_NAME, MEM_TEL, MEM_ADDR) values(?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			pstmt.setString(2, memPass);
			pstmt.setString(3, memName);
			pstmt.setString(4, memTel);
			pstmt.setString(5, memAddr);

			int cnt = pstmt.executeUpdate();

			if(cnt > 0) {
				System.out.println(memId +"회원 정보 추가 완료!!");
			}else {
				System.out.println(memId + "회원정보 추가 실패!!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}

	}
	// 회원ID를 인수값으로 받아서 해당 회원ID의 개수를 반환하는 메서드
	private int getMemberCount(String memId) {
		int count = 0;
		try {
			conn = DBUtil.getConnection();

			String sql = "select count(*) cnt from mymember where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);

			rs = pstmt.executeQuery();

			if(rs.next()) {
				count = rs.getInt("cnt");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			disConnect();
		}
		return count;
	}

	// 메뉴를 출력하고 선택한 작업번호를 반환하는 메서드
	private int displayMenu() {
		System.out.println();
		System.out.println("===================================================");
		System.out.println("1.자료추가");
		System.out.println("2.자료삭제");
		System.out.println("3.자료수정");
		System.out.println("4.전체 자료 출력");
		System.out.println("5.회원정보수정");
		System.out.println("0.작업 끝.");
		System.out.println("===================================================");
		System.out.println("작업 번호 입력 >>");
		return sc.nextInt();
	}


	private void disConnect() {
		if(rs !=null)try{ rs.close(); }catch(Exception e) {}
		if(pstmt !=null)try{ pstmt.close(); }catch(Exception e) {}
		if(stmt !=null)try{ stmt.close(); }catch(Exception e) {}
		if(conn !=null)try{ conn.close(); }catch(Exception e) {}

	}
}