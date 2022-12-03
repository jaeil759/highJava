package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileCopyTest {
/*
 *  'd:/d_other/' 폴더에 있는 jpg파일을 
 *  'd:/d_other/연습용/' 폴더에 '복사본jpg 파일로 복사하는 프로그램을 작성하시오.
 */
	public static void main(String[] args) {
		File file = new File("d:/D_other", "캡쳐.png");
//		System.out.println("파일명 : " + file.getName());
//		System.out.println("디렉토리? : " + file.isDirectory());
//		System.out.println("파일? : " + file.isFile());
//		System.out.println();
//		try {
//			File newFile=new File("d:/d_other/연습용","캡쳐.png");
//			boolean isCreate=newFile.createNewFile();
//			System.out.println(">>파일생성여부:"+isCreate);
//		} catch (Exception e) {
//			
//		}
		// 파일있는지없는지 검사
		if(!file.exists()) {
			System.out.println(file.getPath() + "파일이 없습니다.");
			System.out.println("복사작업을 중단합니다.");
			return;
		}
		FileInputStream fin = null;
		FileOutputStream fout = null;
		try {
			//복사할 원본 파일을 읽어올 입력용 스트림객체 생성
			fin = new FileInputStream(file);
			//복사될 대상파일에 쓰기할 출력용 스트림 객체 생성
			fout = new FileOutputStream("d:/d_other/연습용/복사본_캡쳐.png");
			System.out.println("복사 시작...");
			int data; // 읽어온 데이터가 저장될 변수
			while((data = fin.read()) != -1) {
				fout.write(data);
			}
			
			System.out.println("복사 완료...");
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(fout!=null)try{fout.close();}catch(Exception e) {}
			if(fin!=null)try{fin.close();}catch(Exception e) {}
		}
	}

}
