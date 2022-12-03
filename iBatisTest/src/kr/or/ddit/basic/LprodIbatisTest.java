package kr.or.ddit.basic;

import java.io.Reader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Scanner;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class LprodIbatisTest {
	// iBatis를 이용하여 DB자료를 처리하는 순서 및 방법
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		try {
			// 1. iBatis의 환경설정 파일(sqlMapConfi.xml) 을 읽어와서 저장한다.
			// 1-1 문자 인코딩 캐릭터셋 설정
			Charset charset = Charset.forName("utf-8");
			Resources.setCharset(charset);
			
			//1-2 환경 설정 변수 파일을 읽어올 스트림
			Reader rd = Resources.getResourceAsReader("kr/or/ddit/config/sqlMapConfig.xml");
			
			//1-3 생성된 스트림 객체를 이요하여 환경설정파일을 읽어와 환경설정 내용을 처리한다.
			// 이때 iBatis사용할 객체가 생성된다.
			SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			
			// 1-4 스트림닫기
			rd.close();
			
			//------------------------------------------------------------------------------------------------
			//2. insert 연습
//			System.out.println("insert작업 시작");
//			
//			System.out.print("lprod_id 입력 >> ");
//			int lpordId = sc.nextInt();
//			System.out.print("lprod_gu 입력 >> ");
//			String lprodGu = sc.next();
//			System.out.print("lprod_nm 입력 >> ");
//			String lprodNm = sc.next();
//			
//			// 1)입력한 데이터를 Vo객체에 담는다
//			LprodVO lvo = new LprodVO();
//			lvo.setLprod_id(lpordId);
//			lvo.setLprod_gu(lprodGu);
//			lvo.setLprod_nm(lprodNm);
//			
//			// 2) SqlMapClient 객체변수를 이용하여 처리할 쿼리문을 호출하여 실핸한다.
//			// 형식) smc.insert("namespace속성값,id속성값",vkfkalxjzmffotm)
//			//   반환값 : insert성공 : null, insert실패:  오류객체
//			Object obj = smc.insert("lprod.insertlprod",lvo);
//			if(obj==null) {
//				System.out.println("insert 작업 성공!");
//			}else {
//				System.out.println("insert 작업 실패");
//			}
			
			// 2-2 update연습
//			System.out.println("update 작업시작...");
//			System.out.println("수정할 lpord_gu입력 >> ");
//			String lprodGu2 = sc.next();
//			
//			System.out.println("새로운 lprod_id 입력 >> ");
//			int newLprodId = sc.nextInt();
//			
//			System.out.println("새로운 lprod_nm 입력 >> ");
//			String newLprodNm = sc.next();
//			
//			//입력한 값을 VO객체에 저장한다.
//			LprodVO lvo2 = new LprodVO();
//			lvo2.setLprod_gu(lprodGu2);
//			lvo2.setLprod_id(newLprodId);
//			lvo2.setLprod_nm(newLprodNm);
//			
//			// 2)실행하기
//			// 형식) smc.update("namespace속성값.id속성값, 파라미터 클래스);
//			// 		반환값 : 작업에 성공한 레코드 수 
//			int cnt = smc.update("lprod.updatelprod", lvo2);
//			
//			if(cnt>0) {
//				System.out.println("update 작업 성공");
//			}else {
//				System.out.println("update 작업 실패");
//			}
			
			// 2-3. delete 연습
//			System.out.println("delete 작업 시작...");
//			System.out.print("삭제할 Lprod_gu입력");
//			String delLprod_GU = sc.next();
//			
//			// 1)실행하기
//			// 형식) smc.delete("namespace속성값, id속성값, 파라미터클래스);
//			// 		반환값 : 작업에 성공한 레코드 수 
//			int cnt2 = smc.delete("lprod.deletelprod", delLprod_GU);
//			
//			if(cnt2>0) {
//				System.out.println("update 작업 성공");
//			}else {
//				System.out.println("update 작업 실패");
//			}
			
			//2-4 select연습
			
			// 1) 응답 결과가 여러개인 경우
//			System.out.println("select작업 시작(응답결과가 여러개일 경우)...");
//			// 응답 결과가 여러개일 경우에는 queryForList()메서드를 사용하는데
//			// 이 메서드는 여러개의 레코드를 각각 VO객체에 담은 후 이 VO객체를 
//			// List에 추가해 주는 작업을 자동으로 수령한다.
//			// 형식) smc.queryForList("namespace속성값.id속성값", 파라미터클래스);
//			//		반환값 : List객체
//			
//			List<LprodVO> lprodList = smc.queryForList("lprod.getAlllprod");
//			for(LprodVO lvo3 : lprodList) {
//				System.out.println("ID : " + lvo3.getLprod_id());
//				System.out.println("GU : " + lvo3.getLprod_gu());
//				System.out.println("NM : " + lvo3.getLprod_nm());
//				System.out.println("--------------------------------------------------");
//			}
//			System.out.println("출력 끝...");
			
			
			// 2)응답 결과가 1개인 경우
			System.out.println("select작업 시작( 응답 결과가 1개일 경우)");
			System.out.println("검색할 Lprod_gu 입력 >> ");
			String searchLprodGu = sc.next();
			
			//응답 결과가 1개가 확실할 경우에는 queryForObject()메서드를 사용한다.
			// 형식) smc.queryForObject("namespace속성값 : id속성값", 파라미터값);
			// 반환값 : 처리 결과가 여러개일 경우 => Exception 리턴
			// 			처리 결과가 1개일 경우 ==> 해당 객체 리턴
			
			LprodVO lvo4 = (LprodVO) smc.queryForObject("lprod.getlprod", searchLprodGu);
			if(lvo4==null) {
				System.out.println(searchLprodGu + "는 없는 상품 분류 코드 입니다..");
				return;
			}
			System.out.println(" == 검색 결과 ==");
			System.out.println("ID : " + lvo4.getLprod_id());
			System.out.println("GU : " + lvo4.getLprod_gu());
			System.out.println("NM : " + lvo4.getLprod_nm());
			System.out.println("-------------------------------------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
