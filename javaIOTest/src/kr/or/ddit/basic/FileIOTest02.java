package kr.or.ddit.basic;

import java.io.FileOutputStream;

public class FileIOTest02 {

	public static void main(String[] args) {
		// byte기반의 File 출력용 스트림을 이용하여 데이터 출력하기
		try {
			
			// 출력용 스트림 객체생성
			FileOutputStream fout = new FileOutputStream("d:/d_other/out.txt");
			
			for(char ch='A'; ch<='Z'; ch++) {
				fout.write(ch);	//ch변수의 데이터를 파일로 출력한다.
			}
			
			System.out.println("쓰기 작업 완료...");
			fout.close(); // 스트림 닫기
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
