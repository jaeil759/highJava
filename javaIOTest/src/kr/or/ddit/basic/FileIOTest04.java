package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileIOTest04 {

	public static void main(String[] args) {
		try {
			// Scanner sc = new Scanner(System.in);
			// System.in ==> 콘솔(표준 입출력 장치)의 입력장치와 연결된 입력을 byte기반의 스트림객체
//			System.out.print("한 문자 입력>>");
//			int c = System.in.read();
//			System.out.println("입력한 문자 : " + (char)c);
//			입력용 byte기반의 스트림을 문자 기반의 스트림으로 변환해 주는 스트림 객체 생성
			InputStreamReader isr = new InputStreamReader(System.in);
			// 파일 출력용 문자기반 스트림 객체 생성
			FileWriter fw = new FileWriter("d:/d_other/testchar.txt");
			
			System.out.println("아무 내용이나 입력하세요.(입력의 끝은 Ctrl + Z 입니다.)");
			int c;
			
			//콘솔에서 입력할 때 입력의 끝은 'Ctrl' + 'Z'키를 누르면된다.
			while( (c=isr.read()) != -1) {
				fw.write(c);
			}
			//스트림 닫기
			isr.close();
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
