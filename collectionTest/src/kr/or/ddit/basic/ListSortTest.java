package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * 정렬과 관련된 interface는 Comparable, comparator 이렇게 두가지가 있다.
 * 
 * Comparable은 Collection에 추가되는 데이터 자체에 정렬 기준을 넣고 싶을때 사용하는 인터페이스 이다. 
 * 	--> 내부정렬기준
 * 
 * Comparator은 외부에 별도로 정렬 기준을 구현하고 싶을 때 사용하는 인터페이스이다.
 * 	--> 외부정렬 기준을 구현하는 인터페이스
 * 
 * Comparable 에서는 compareTo()메서드를 재정의 하고 
 * Comparator 에서는 compare() 메서드를 재정의 해야한다.
 * 
 * 
 * 	String클래스, Wrapper클래스, Date클래스, File클래스에는 내부정렬 기준이 이미 구현되어 있다.
 * 	(내부 정렬 기준은 오름차순으로 처리되도록 구현되어있다.)
 * 
 */


public class ListSortTest {
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("일지매");
		list.add("홍길동");
		list.add("성춘향");
		list.add("변학도");
		list.add("이순신");
		
		System.out.println("정렬전 : " + list);
		
		// 정렬은 Collection.sort()메서드를 이용하여 정렬한다.
		// Collections.sort() 메서드는 기본적으로 내부 정렬 기준으로 정렬한다.
		
		Collections.sort(list);
		System.out.println("정렬후 : " + list);
		
		Collections.shuffle(list);   // 자료를 섞어준다.
		System.out.println("자료 섞기 후 : " + list);
		
		// 외부정렬 기준을 적용해서 정렬하기
		Collections.sort(list, new StrDesc());
	}
}


// 정렬 방식을 정해주는 class 만들기(외부 정렬 기준 클래스라고 한다.)
//				==> Comparator인터페이스를 구현해서 작성한다.
class StrDesc implements Comparator<String>{
	
	// compare() 메서드를 이용하여 정렬하고자 하는 기준을 정한다.
	// 정렬기준은 compare() 메서드의 반환값을 이용한다.
	// -반환값의 의미
	//	1. 반환값이 0이면 두 값이 같다.
	//  2. 반환값이 양수이면 앞, 뒤의 순서를 바꾼다.
	//  3. 반환값이 음수이면 앞, 뒤의 순서를 바꾸지 않는다.
	
	//  오름차순일 경우 ==> 앞의 값이 크면 양수, 같으면 0 
//							앞의 값이 작으면 음수를 반환하도록 구현하면 된다.
	
	@Override
	public int compare(String str1, String str2) {
		// 내림차순으로 정렬되도록 구현하려고 한다.
		if(str1.compareTo(str2) > 0) {
			return -1;
		}else if(str1.compareTo(str2)<0){
			return 1;
		}else {
			return 0;
		}
			
		
	}
	
}
