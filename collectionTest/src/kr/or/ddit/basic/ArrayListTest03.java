package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 *  문제1) 5명의 별명을 입력받아 ArrayList에 추가한 후 이들중에서 별명의 길이가 제일 긴 별명을 출력하시오.
 *  	(단, 각 별명의 길이는 모두 다르게 입력한다.)
 *	문제2) 문제1에서 별명의 길이가 같은 것을 입력하는 조건으로 변경되었을 때 결과를 출력하시오.
 *
 *
 */
public class ArrayListTest03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		/*		ArrayList<String> nickname = new ArrayList<String>();
		System.out.println("5명의 이름을 입력하세요");
		for(int i = 1; i <=5; i++) {
			System.out.println(i + "번째 이름 : ");
			String name = sc.next();
			nickname.add(name);
			System.out.println();
		}
			int longsetindex = 0;
			for(int i = 1; i < nickname.size(); i++) {
				if(nickname.get(i).length() > nickname.get(longsetindex).length()) {
					longsetindex = i;
				}
			}
			System.out.println("닉네임이 제일 긴사람은 : " + nickname.get(longsetindex));

		 */
		// 선생님답
		ArrayList<String> aliasList = new ArrayList<String>();
		System.out.println("서로 다른 길이의 별명을 5명 입력하세요");

		for(int i = 1; i <=5; i++) {
			System.out.println(i + "번째 별명 : " );
			String alias = sc.nextLine();
			aliasList.add(alias);
		}
		// 제일 긴 별명이 저장될 변수 선언 ==> List의 첫번째 데이터로 초기화 한다.
		String maxAlias = aliasList.get(0);

		for(int i = 1; i < aliasList.size(); i++ ) {
			if(maxAlias.length() < aliasList.get(i).length()) {
				maxAlias = aliasList.get(i);

			}
		}
		System.out.println("제일 긴 별명은 : " + maxAlias);
	}
}


