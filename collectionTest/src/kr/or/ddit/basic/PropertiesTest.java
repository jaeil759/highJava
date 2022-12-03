package kr.or.ddit.basic;

import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
		/*
		 * 	Properties객체는 Map객체보다 축소된 기능의 객체라고 할 수 있다.
		 * 
		 * 	Map은 key값과 value값에 모든 종류의 자료형을 사용할 수 있지만,
		 * 	Properties는 key값과 value값에 String만 사용 할 수 있다. (그래서 제네릭을 사용하지 않는다.)
		 * 	
		 * 	Map은 put(), get() 메서드를 이용하여 데이터를 입출력 하지만, 
		 * 	Properties는 setProperty(), getProperty() 메서드를 통해서 데이터를 입출력 한다.
		 * 
		 *  Properties는 데이터를 파일로 저장할 수 있고, 파일의 내용을 읽어와 Properties객체에 저장하는 기능도 있다.
		 */
		
		Properties prop = new Properties();
		
		// 데이터추가 ==> setProperty(key값, value값)
		prop.setProperty("name", "홍길동");
//		prop.setProperty("age", "20");
		int age = 20;
//		prop.setProperty("age", "" + age); //"" + 값 ==> "값"
		prop.setProperty("age", String.valueOf(age));  // String.valueOf(값) ==> "값"
		prop.setProperty("tel", "010-0000-0000");
		prop.setProperty("addr", "대전");
		
		//=======================================================
		// 데이터 읽기 ==> getProperty(key값)
		String name = prop.getProperty("name");
		String strAge = prop.getProperty("age");
		String tel = prop.getProperty("tel");
		String addr = prop.getProperty("addr");
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + strAge);
		System.out.println("전화 : " + tel);
		System.out.println("주소 : " + addr);
		 
		
		
		
		
	}

}
