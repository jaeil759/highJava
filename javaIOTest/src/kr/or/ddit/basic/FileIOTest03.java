package kr.or.ddit.basic;

import java.io.FileReader;

public class FileIOTest03 {

	public static void main(String[] args) {
		// 문자 기반의 스트림을 이용하여 파일 내용을 읽어와 화면에 출력하기
		try {
			// 문자 기반의 File 입력용 스트림 객체 생성
			FileReader fr = new FileReader("d:/d_other/test.txt");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
