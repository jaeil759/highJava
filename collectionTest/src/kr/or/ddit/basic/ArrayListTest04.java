package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest04 {

	public static void main(String[] args) {
	  Scanner sc=new Scanner(System.in);
	  
	  ArrayList<String> aliasList = new ArrayList<String>();
		System.out.println("서로 다른 길이의 별명을 5명 입력하세요");

		for(int i = 1; i <=5; i++) {
			System.out.println(i + "번째 별명 : " );
			String alias = sc.nextLine();
			aliasList.add(alias);
		}
	  //제일긴 별명의 길이가 저장될 변수 선언 ==> 첫번째 별명의 길이로 초기화한다.
		int maxLength = aliasList.get(0).length();
		for(int i = 1; i < aliasList.size(); i++) {
			if(maxLength < aliasList.get(i).length()) {
				maxLength = aliasList.get(i).length();
			}
		}
		System.out.println("제일 긴 별명들...");
		for(String alias : aliasList) {
			if(alias.length() == maxLength) {
				System.out.println(alias);
			}
		}
		
	}
}

