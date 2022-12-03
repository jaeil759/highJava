package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
		// 읽어온 정보를 저장할 properties객체 생성
		Properties prop = new Properties();
		
		// 읽어올 properties파일을 지정한 File객체 생성
		File f = new File("res/kr/or/ddit/config/dbinfo.properties");
		FileInputStream fin = null;
		
		
		try {
			// 스트림 객체 생성
			fin = new FileInputStream(f);
			
			// 스트림 객체를 이용하여 파일 내용을 읽어와 Properties객체에 저장하기
			// 파일 내용을 읽어와 key값과 value값을 분류한 후 Properties객체에 추가한다.
			prop.load(fin);
			//읽어온 정보 출력해 보기..
			System.out.println("driver : " + prop.getProperty("driver"));
			System.out.println("url : " + prop.getProperty("url"));
			System.out.println("user : " + prop.getProperty("user"));
			System.out.println("pass : " + prop.getProperty("pass"));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(fin!=null)try {fin.close();}catch(Exception e) {}
		}
	}

}
