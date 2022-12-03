package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class PhoneTest2 {
	private HashMap<String,Phone2> phoneBookMap;
	private Scanner sc;

	public PhoneTest2() {
		phoneBookMap = new HashMap<String,Phone2>();
		sc = new Scanner(System.in);
	}

	public static void main(String[] args) {
		new PhoneTest2().phonestart();
	}

	public void phonestart() {
		System.out.println("=======================================");
		System.out.println(" 전화번호 관리 프로그램(파일로 저장되지 않음)");
		System.out.println("=======================================");
		System.out.println();
		
		while(true) {
			int choice = displayMenu();
			
			switch(choice) {
			case 1: 		// 등록
				insert();
				break;
			case 2: 		// 수정
				break;
			case 3: 		// 삭제
				break;
			case 4: 		// 검색
				break;
			case 5: 		// 전체 출력
				displayAll();
				break;
			case 0: 		// 종료
				System.out.println("프로그램을 종료합니다...");
				return;
				default : 
					System.out.println("작업 번호를 잘못 입력했습니다.");
					System.out.println("다시 선택하세요...");
			}
		}
		
		
	}
	// 새로운 전화번호 정보를 등록하는 메서드 ==> 이미 등록된 ㄹ
	private void insert() {
		
	}

	// 전체 자료를 출력하는 메서드
	private void displayAll() {
		System.out.println();
		System.out.println("=======================================");
		System.out.println("번호   이름       전화번호         주소");
		System.out.println("=======================================");
		
		Set<String>phoneKeySet = phoneBookMap.keySet();
		if(phoneKeySet.size() == 0) {
			System.out.println("등록된 전화번호 정보가 하나도 없습니다.");
		}else {
			int cnt = 0; //출력한 번호가 저장될 변수
			Iterator<String> keyIt = phoneKeySet.iterator();
			
			while(keyIt.hasNext()) {
				cnt++;	//번호증가
				String key = keyIt.next();	//키값 구하기
				Phone2 p = phoneBookMap.get(key);	//키값을 이용하여 value값(Phone2객체) 구하기
				System.out.println(cnt + "\t" + p.getName() + "\t" + p.getTel() + "\t" + p.getAddr());
			}
		}
		System.out.println("=======================================");
		System.out.println(" 출력 끝...");
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
class Phone2{
	private String name;
	private String tel;
	private String addr;

	public Phone2(String name, String tel, String addr) {
		this.name = name;
		this.tel = tel;
		this.addr = addr;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddr() {
		return addr;	
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Phone2 [name=" + name + ", tel=" + tel + ", addr=" + addr + "]";
	}
}