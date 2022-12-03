package kr.or.ddit.poi;
import java.util.ArrayList;
import java.util.List;


public class MainApplicationWrite {
	
	public static void main(String[] args) {
		// 엑셀로 쓸 데이터 생성
		
		List<CustomerVoWrite> list = new ArrayList<CustomerVoWrite>(); //추가할 행 리스트
		
		
		//생성자에 파라미터 값 채우기
		list.add(new CustomerVoWrite("asdf1", "채진영", "31", "asdf1@naver.com"));
		list.add(new CustomerVoWrite("asdf2", "김진호", "31", "asdf2@naver.com"));
		list.add(new CustomerVoWrite("asdf3", "송서영", "30", "asdf3@naver.com"));
		list.add(new CustomerVoWrite("asdf4", "고재일", "28", "asdf4@naver.com"));
		list.add(new CustomerVoWrite("asdf5", "우리집", "35", "asdf5@naver.com"));
		
		CustomerExcelWriter excelWriter = new CustomerExcelWriter();
		
//		//xls 파일 쓰기
//		excelWriter.xlsWiter(list);
		
		//xlsx 파일 쓰기
		excelWriter.xlsxWiter(list); //여기에선 list.size() = 5
		System.out.println("파일이 생성되었습니다.");
	}
}
