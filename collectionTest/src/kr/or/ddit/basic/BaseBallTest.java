package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BaseBallTest {

	/*
	 *  문제) Set을 이용하여 숫자 야구 게임 프로그램을 작성하시오.
	 *  	컴퓨터에 숫자는 난수를 이용해서 구한다.(숫자는 1~9사이의 값을 사용한다.)
	 *  	(스트라이크는 S, 볼은 B로 나타낸다.)
	 *  
	 *  예시) 컴퓨터 난수 ==> 9 5 7 
	 *  
	 *  실행예시)
	 *  	숫자입력 >> 3 5 6
	 *  	3 5 6 ==> 1s 0B
	 *  	숫자 입력 >> 7 8 9 
	 *  	7 8 9 ==> 0s 2B
	 *  	숫자 입력 >> 9 7 5
	 *  	9 7 5 ==> 1S 2B
	 *  	숫자 입력 >> 9 5 7
	 *  	9 5 7 ==> 3S 0B
	 *  
	 *  	축하합니다...
	 *  	당신은 4번째만에 맞췄습니다.
	 */
	private Scanner sc = new Scanner(System.in);
	private ArrayList<Integer> numList; // 난수가 저장될List
	private ArrayList<Integer> userList; // 사용자가 입력한 값이 저장될 List
	
	private int strike; // 스트라이크 개수
	private int ball; // 볼의 개수
	
	//게임이 시작되는 메서드
	public void baseBallStart() {
		System.out.println("숫자 야구게임을 시작합니다.");
		System.out.println();
		// 난수 만드는 메서드 호출
		getNum();
		
		// 확인용 출력 
		//System.out.println("컴퓨터 난수 : " + numList);
		
		int cnt = 0; //몇번만에 맞췄는지 저장하는 변수
		
		do {
			cnt++;
			
			// 사용자가 입력받는 메서드 호출
			inputData();
			// 볼카운트를 구하는 메서드 호출
			ballCount();
		}while(strike != 3); // 스트라이크 개수가 3이 될 때까지 반복한다.
		
		System.out.println("축하합니다...");
		System.out.println("당신은" + cnt + "번째만에 맞췄습니다.");
		
		
	}
	
	// 1 ~ 9 사이의 서로 다른 난수 3개를 만들어서 List에 저장하는 메서드(Set이용)
	private void getNum(){
		Set<Integer> numSet = new HashSet<Integer>();
		
		// 난수 3개 만들기
		while(numSet.size() < 3) {
			numSet.add((int)(Math.random() * 9 + 1));
		}
		
		// 만들어진 난수를 List에 저장하기
		numList = new ArrayList<Integer>(numSet);
		
		// List의 데이터를 섞어준다.
		Collections.shuffle(numList);
	}
	//------------------------------------------------------
	
	// 사용자로부터 3개의 정수를 입력 받아서 List에 저장하는 메서드
	private void inputData() {
		int n1,n2,n3; //입력한 정수가 저장될 변수 선언
		
		do {
			System.out.print("숫자 입력 >> ");
			n1 = sc.nextInt();
			n2 = sc.nextInt();
			n3 = sc.nextInt();
			if(n1==n2 || n1==n3 || n2==n3) {
				System.out.println("중복되는 숫자는 입력할 수 없습니다. 다시 입력하세요.");
			}
		}while(n1==n2 || n1==n3 || n2==n3);
		userList = new ArrayList<Integer>();
		userList.add(n1);
		userList.add(n2);
		userList.add(n3);
		
	}
	//----------------------------------------------------------------
	
	//스트라이크와 볼의 개수를 구하고 결과를 출력하는 메서드
	private void ballCount() {
		strike = 0;
		ball = 0; // 스트라이크와 볼의 개수 초기화
		
		for(int i = 0; i < userList.size(); i++) {
			for(int j = 0; j < numList.size(); j++) {
				
				if(userList.get(i)==numList.get(j)) {//값이 같은지 비교
					if(i==j) { //인덱스값이 같은지 비교
						strike++;
					}else {
						ball++;
					}
				}
			} //for문 j
		} //for문 i
		// 스트라이크와 볼의 판정결과를 출력한다.
		System.out.println(userList.get(0) + " " + userList.get(1) + " " + userList.get(2) + " ==> " + strike + " S " + ball + " B ");
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		new BaseBallTest().baseBallStart();
	}
}
