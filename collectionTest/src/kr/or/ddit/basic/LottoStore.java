package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class LottoStore {
	/*
	로또를 구매하는 프로그램 작성하기
	 
	 사용자는 로또를 구매할 때 구매할 금액을 입력하고
	 입력한 금액에 맞게 로또번호를 출력한다.
	 (단, 로또 한 장의 금액은 1000원이며 최대 100장까지만 구입할 수 있고,
	      거스름돈도 계산하여 출력한다.)

		==========================
	         	Lotto 프로그램
		--------------------------
		 1. Lotto 구입
		 2. 프로그램 종료
		==========================		 
		메뉴선택 : 1  <-- 입력
				
		 Lotto 구입 시작
			 
		(1000원에 로또번호 하나입니다.)
		금액 입력 : 2500  <-- 입력
				
		행운의 로또번호는 아래와 같습니다.
		로또번호1 : 2,3,4,5,6,7
		로또번호2 : 20,21,22,23,24,25
				
		받은 금액은 2500원이고 거스름돈은 500원입니다.

		==========================
	         	Lotto 프로그램
		--------------------------
		 1. Lotto 구입
		 2. 프로그램 종료
		==========================		 
		메뉴선택 : 1  <-- 입력
				
		 Lotto 구입 시작
			 
		(1000원에 로또번호 하나입니다.)
		금액 입력 : 900  <-- 입력
		
		입력 금액이 너무 적습니다. 로또번호 구입 실패!!!

		==========================
	         	Lotto 프로그램
		--------------------------
		 1. Lotto 구입
		 2. 프로그램 종료
		==========================		 
		메뉴선택 : 1  <-- 입력
				
		 Lotto 구입 시작
			 
		(1000원에 로또번호 하나입니다.)
		금액 입력 : 101000  <-- 입력
		
		입력 금액이 너무 많습니다. 로또번호 구입 실패!!!
				
	   	 ==========================
	         	Lotto 프로그램
		--------------------------
		  1. Lotto 구입
		  2. 프로그램 종료
		==========================		 
		메뉴선택 : 2  <-- 입력
			
		감사합니다
		*/
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		new LottoStore().lottoStart();
	}

	private void lottoStart() {
		while(true) {
			int choice = displayMenu();
			switch(choice) {
			case 1: 		//로또 구입
				buyLotto();
				break;
			case 2: 	//프로그램 종료
				System.out.println();
				System.out.println("감사합니다...");
				return;
			default : 
				System.out.println("메뉴 선택번호를 잘못입력했습니다.");
			}
		}
	}
	// Lotto구입을 처리하는 메서드
	private void buyLotto() {
		System.out.println();
		System.out.println("Lotto 구입 시작\n");
		System.out.println("(1000원에 로또번호 하나입니다.)");
		System.out.println("금액 입력 : ");
		int money = sc.nextInt();
		
		System.out.println();
		
		if(money < 1000) {
			System.out.println("입력 금액이 너무 적습니다. 로또번호 구입 실패!!");
			return;
		}
		if(money >= 101000) {
			System.out.println("입력금액이 너무 많습니다. 로또번호 구입 실패!!");
			return;
		}
		// 로또번호 생성하기
		// 생성할 로또번호 개수 구하기
		int count = money / 1000;
		
		Set<Integer> lottoSet = new HashSet<Integer>();
		System.out.println();
		System.out.println("행운의 로또번호는 아래와 같습니다.");
		
		for(int i = 1; i <= count; i++) { //생성할 로또번호 개수만큼 반복 처리
			while(lottoSet.size() < 6) {
				lottoSet.add((int)(Math.random() * 45 + 1));
			}
			
			// Set에 저장된 로도번호를 List에 저장한다.
			List<Integer> lottoList = new ArrayList<Integer>(lottoSet);
			
			// List의 로또번호를 정렬한다.
			Collections.sort(lottoList);
			
			System.out.println("로또번호" + i + " : " + lottoList);
			
			lottoSet.clear();  // Set의 모든 자료 삭제하기
		} // for문
		System.out.println();
		System.out.println("받은금액은" + money + "이고 거스름돈은"  + (money%1000) + "원입니다.");
		
		
		
		
	}
	
	
	//메뉴를 출력하고 작업 번호를 입력받아 반환하는 메서드
	private int displayMenu() {
		System.out.println("==========================");
		System.out.println("Lotto 프로그램");
		System.out.println("--------------------------");
		System.out.println("1. Lotto 구입");
		System.out.println("2. 프로그램 종료");
		System.out.println("==========================");
		System.out.print("메뉴선택");
		return sc.nextInt();
	}

}
