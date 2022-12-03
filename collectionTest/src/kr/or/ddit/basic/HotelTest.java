package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class HotelTest {
	private Scanner sc = new Scanner(System.in);
	private HashMap<Integer, Room>hotelMap;
	
	//생성자 ==> 호텔의 각 방을 초기화 한다.
	public HotelTest() {
		hotelMap = new HashMap<Integer, Room>();
		
	//객실 초기화
		for(int i = 2; i <=4; i++) {
			String roomType = null;
			switch(i) {
			case 2 : roomType = "싱글룸"; break;
			case 3 : roomType = "더블룸"; break;
			case 4 : roomType = "스위트룸"; break;
			}
			for(int j = 1; j <= 9; j++) {
				int roomNum = i * 100 + j;
				Room r = new Room(roomNum, roomType);
				hotelMap.put(roomNum, r);
			} // 반복문 j
		} // 반복문 i
	}// 생성자 끝...
	
	public static void main(String[] args) {
		new HotelTest().hotelStart();
	}
	// 시작 메서드
	public void hotelStart() {
		System.out.println("*********************************************");
		System.out.println(" 호텔문을 열었습니다. 어서오십시요.");
		System.out.println("*********************************************");
		while(true) {
			int choice = displayMenu();
			switch(choice){
			case 1 : 		// 체크인
				checkIn(); break;
			case 2 : 		// 체크아웃
				checkout();break;
			case 3 : 		// 객실상태
				showRoom(); break;
			case 4 : 		// 업무종료
				System.out.println("*********************************************");
				System.out.println("호텔문을 닫았습니다.");
				System.out.println("*********************************************");
			       return;
				default : 
					System.out.println("잘못 입력하셨습니다. 다시입력해주세요");
			}
		}
	}
	
	private void checkout() {
		System.out.println("----------------------------------------------");
		System.out.println("체크아웃 작업");
		System.out.println("----------------------------------------------");
		System.out.println("체크아웃 할 방 번호를 입력하세요.");
		System.out.print("방 번호 입력 >> ");
		int num = sc.nextInt();
		
		if(!hotelMap.containsKey(num)) {
			System.out.println(num + " 호 객실은 존재하지 않습니다...");
			return;
		}
		//입력한 객실에 손님이 있는지 여부검사 ==> 손님이 있으면 해당 객실의 guestName에 손님이름이 저장된다.
		if(hotelMap.get(num).getGuestName() ==null) {
			System.out.println(num + "호 객실에는 체크인한 손님이 없습니다...");
			return;
		}
		// 체크아웃 작업 ==> 해당 객실의 guestName을 null로 변경한다.
		String name = hotelMap.get(num).getGuestName(); // 현재의 투숙객 이름 구하기
		hotelMap.get(num).setGuestName(null); //투숙객 이름 null로 설정( 체크아웃작업)
		System.out.println(num + "호 객실의" + name + "님이 체크아웃 했습니다");
		
	}

	// 객실 상태를 출력하는 메서드
	private void showRoom() {
		System.out.println();
		
		// 방번호를 순서대로 나오게 하기 위해서 방번호( Map의 key값)만 List에 넣은 후 정렬하여 사용한다.
		ArrayList<Integer>roomNumList = new ArrayList<Integer>(hotelMap.keySet());
		Collections.sort(roomNumList); // 정렬하기
		System.out.println("----------------------------------------------");
		System.out.println("현재 객실 상태");
		System.out.println("----------------------------------------------");
		System.out.println("방 번호\t 방 종류\t 투숙객 이름");
		System.out.println("----------------------------------------------");
			
		// List에서 방번호를 하나씩 차례로 꺼내와 Map에서 해당 방번호를 key값으로 갖는 Room객체를 구해서 출력한다.
		for(int roomNum : roomNumList) {
			Room r = hotelMap.get(roomNum);
			System.out.print(r.getRoomNum() + "\t" + r.getRoomType() + "\t");
			System.out.println(r.getGuestName()==null ? "-" : r.getGuestName());
		}
		System.out.println("----------------------------------------------");
		System.out.println();
	}

	// 체크인 메서드
	private void checkIn() {
		System.out.println("----------------------------------------------");
		System.out.println("체크인 작업");
		System.out.println("----------------------------------------------");
		System.out.println("* 201~209 : 싱글룸");
		System.out.println("* 301~309 : 더블룸");
		System.out.println("* 401~409 : 스위트룸");
		System.out.println("----------------------------------------------");
		System.out.print("방 번호 입력 >> ");
		int num = sc.nextInt();
		
		// 존재하는 객실인지 여부 검사 ==> Map의 key값에 없으면 존재하지 않는 방번호이다.
		if(!hotelMap.containsKey(num)) {
			System.out.println(num + " 호 객실은 존재하지 않습니다...");
			return;
		}
		//입력한 객실에 손님이 있는지 여부검사 ==> 손님이 있으면 해당 객실의 guestName에 손님이름이 저장된다.
		if(hotelMap.get(num).getGuestName() !=null) {
			System.out.println(num + "호 객실에는 이미 손님이 있습니다...");
			return;
		}
		System.out.println("누구를 체크인 하시겠습니까");
		System.out.print("이름 입력 >> ");
		String name = sc.next();
		
		// 입력받은 투숙객 이름을 해당 객실의 guestName에 저장한다.
		hotelMap.get(num).setGuestName(name);
		System.out.println(name + "씨가" + num + "호 객실에 체크인 했습니다.");
	}

	private int displayMenu() {
		System.out.println();
		System.out.println("-----------------------------------------------------------");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료");
		System.out.println("-----------------------------------------------------------");
		System.out.print("선택 >> ");
		return sc.nextInt();
	}
}
class Room{
	private int roomNum;
	private String roomType;
	private String guestName;
	public Room(int roomNum, String roomType) {
		this.roomNum = roomNum;
		this.roomType = roomType;
		this.guestName = guestName;
		
	}
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	@Override
	public String toString() {
		return "Room [roomNum=" + roomNum + ", roomType=" + roomType + ", guestName=" + guestName + "]";
	}
	
}