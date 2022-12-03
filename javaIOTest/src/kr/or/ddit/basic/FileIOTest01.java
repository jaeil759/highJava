package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;

public class FileIOTest01 {

	public static void main(String[] args) {
		// byte기반의 스트림을 이용하여 파일 내용 읽어오기
		try {
			// 읽어올 파일을 인수값으로 받는 파일 입력용 스트림 객체 생성
			// 방법1 ==> 읽어올 파일정보를 문자열로 지정하는 방법
			FileInputStream fin = new FileInputStream("d:/d_other/test.txt");
			// 방법2 ==> 읽어올 파일 정보를 File객체로 구성해서 지정하는 방법
//			File file = new File("d:/d_other/test.txt");
//			FileInputStream fin = new FileInputStream(file);
			
			int c;  //읽어온 데이터를 저장할 변수
			
			while((c=fin.read()) != -1) {
				// 읽어온 데이터를 화면에 출력하기
				System.out.print((char)c);
			}
			fin.close(); // 작업 완료 후 스트림 닫기
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
