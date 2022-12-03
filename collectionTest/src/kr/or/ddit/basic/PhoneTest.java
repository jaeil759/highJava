package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Scanner;

public class PhoneTest {
	
	
	/*
	 * Scanner객체의 next(), nextInt(), nextDouble(),.....
	 * 	==> 사이띄기, tab키, enter키를 구분문자로 분리해서 분리된 자료만 읽어간다.
	 * 	
	 * 	Scanner객체의 nextLine() 
	 * 		==> 한 줄 단위로 입력한다. 즉, 자료를 입력하고 Enter키를 누르면 Enter키값까지 읽어가서 Enter키값을 뺀 나머지를 반환한다.
	 * 
	 * 
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	문제) 이름, 주소, 전화번호 속성을 갖는 Phone클래스를 만들고, 이 Phone클래스를 이용하여 
		  전화번호 정보를 관리하는 프로그램을 완성하시오.
		  이 프로그램에는 전화번호를 등록, 수정, 삭제, 검색, 전체출력하는 기능이 있다.
		  
		  전체의 전화번호 정보는 Map을 이용하여 관리한다.
		  (key는 '이름'으로 하고 value는 'Phone클래스의 인스턴스'로 한다.)


	실행예시)
	===============================================
	   전화번호 관리 프로그램(파일로 저장되지 않음)
	===============================================

	  메뉴를 선택하세요.
	  1. 전화번호 등록
	  2. 전화번호 수정
	  3. 전화번호 삭제
	  4. 전화번호 검색
	  5. 전화번호 전체 출력
	  0. 프로그램 종료
	  번호입력 >> 1  <-- 직접 입력
	  
	  새롭게 등록할 전화번호 정보를 입력하세요.
	  이름 >> 홍길동  <-- 직접 입력
	  전화번호 >> 010-1234-5678  <-- 직접 입력
	  주소 >> 대전시 중구 대흥동 111  <-- 직접 입력
	  
	  메뉴를 선택하세요.
	  1. 전화번호 등록
	  2. 전화번호 수정
	  3. 전화번호 삭제
	  4. 전화번호 검색
	  5. 전화번호 전체 출력
	  0. 프로그램 종료
	  번호입력 >> 5  <-- 직접 입력
	  
	  =======================================
	  번호   이름       전화번호         주소
	  =======================================
	   1    홍길동   010-1234-5678    대전시
	   ~~~~~
	   
	  =======================================
	  출력완료...
	  
	  메뉴를 선택하세요.
	  1. 전화번호 등록
	  2. 전화번호 수정
	  3. 전화번호 삭제
	  4. 전화번호 검색
	  5. 전화번호 전체 출력
	  0. 프로그램 종료
	  번호입력 >> 0  <-- 직접 입력
	  
	  프로그램을 종료합니다...
	  
	*/
	static String name;
	static String phonenum;
	static String addr;
	static Scanner sc = new Scanner(System.in);
	static HashMap<String, Phone>phonebook = new HashMap<String, Phone>();
	public static void main(String[] args) {
		new PhoneTest().phonestart();
		
		}
	private void phonestart() {
		while(true) {
			int choice = displayMenu();
			switch(choice) {
			case 1: 		
				insert();
				break;
			case 2: 
				update();
				break;
			case 3: 
				delete();
				break;
			case 4: 
				select();
				break;
			case 5: 	
				Allprint();
				break;
			case 0 : 
				System.out.println();
				System.out.println("감사합니다...");
				return;
			default : 
				System.out.println("메뉴 선택번호를 잘못입력했습니다.");
			}
		}
	}
	private void Allprint() {
		System.out.println("=======================================");
		System.out.println("이름       전화번호         주소");
		System.out.println("=======================================");
		
		for(String key : phonebook.keySet()) {
			Phone value = phonebook.get(key);
			System.out.println(value);
		}
		
		
		System.out.println("=======================================");
		System.out.println();
		System.out.println();
	}
	private void select() {
		System.out.println("찾으실분의 이름을 입력해주세요");
		name = sc.next();
		System.out.println(phonebook.get(name).getName());
		System.out.println(phonebook.get(name).getPhonenum());
		System.out.println(phonebook.get(name).getAddr());
		System.out.println();
		
	}
	private void delete() {
		System.out.println("이름을 입력해주세요");
		String name = sc.next();
		phonebook.remove(name);
		System.out.println("삭제가 완료되었습니다.");
		System.out.println();
	}
	private void update() {
		System.out.println("수정할 이름, 전화번호, 주소를 입력해주세요");
		System.out.println("이름을 입력해주세요");
		String name = sc.next();
		System.out.println("전화번호를 입력해주세요");
		String phonenum = sc.next();
		System.out.println("주소를 입력해주세요");
		String addr = sc.next();
		phonebook.put(name, new Phone(name, phonenum, addr));
		System.out.println("수정이 완료되었습니다.");
		System.out.println();
		
	}
	private void insert() {
		
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		System.out.println("이름 >> ");
		name = sc.next();
		System.out.println("전화번호 >> ");
		phonenum = sc.next();
		System.out.println("주소 >> ");
		addr = sc.next();
		phonebook.put(name, new Phone(name, phonenum, addr));
		System.out.println("등록이 완료되었습니다.");
		 
	}
	private int displayMenu() {
		System.out.println("==========================");
		System.out.println("전화번호 관리 프로그램");
		System.out.println("--------------------------");
		System.out.println("1. 전화번호 등록");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 전화번호 검색");
		System.out.println("5. 전화번호 전체 출력");
		System.out.println("0. 프로그램 종료");
		System.out.println("==========================");
		System.out.print("메뉴선택");
		return sc.nextInt();
		
	}
}
class Phone {
	private String name;
	private String phonenum;
	private String addr;
	
	public Phone(String name, String phonenum, String addr) {
		this.name = name;
		this.phonenum = phonenum;
		this.addr = addr;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return  name + "   " + phonenum + "\t" +  addr ;
	}
	

	
	
}

