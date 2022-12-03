package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class SetTest {

	public static void main(String[] args) {
		/*
		 * 
		 *  - List와 Set의 차이점
		 *   1. List
		 *    - 데이터의 순서(index)가 있다.
		 *    - 중복되는 데이터를 저장할 수 있다.
		 *   2. Set
		 *    - 데이터의 순서(index) 가 없다.
		 *    - 중복되는 데이터를 저장 할 수 없다.
		 */
		HashSet hs1 = new HashSet();
		
		// Set에 데이터를 추가할 때 add() 메서드를 이용한다.
		hs1.add("DDD");
		hs1.add("AAA");
		hs1.add(2);
		hs1.add("CCC");
		hs1.add("BBB");
		hs1.add(1);
		hs1.add(3);
		
		
		System.out.println("set의 개수 : " + hs1.size());
		System.out.println("set 데이터 : " + hs1);
		
		// Set에 중복되는 데이터를 추가하면 add()메서드가 false를 반환하고 데이터는 추가되지 않는다.
		boolean isAdd = hs1.add("FFF");
		System.out.println("중복되지 않을때 : " + isAdd);
		System.out.println("set 데이터 : " + hs1);
		
		isAdd = hs1.add("CCC");
		System.out.println("중복될때 : " + isAdd);
		System.out.println("Set의 데이터 : " + hs1);
		System.out.println();
		
		// Set의 데이터를 수정하기 위한 명령이 따로 없다. 그래서 해당 자료를 삭제한 후 추가해 주는 방법을 이용한다.
		// 삭제하는 메서드 ==> remove(삭제할 자료) ==> 반환값 : 삭제성공(true), 실패(false)
		//						clear() ==> 전체 삭제
		
		// 예) "FFF"데이터를 "EEE"로 변경하기
		hs1.remove("FFF");
		System.out.println("삭제후 : " + hs1);
		
		hs1.add("EEE");
		System.out.println("set의 데이터 : " + hs1);
		System.out.println();
		
//		hs1.clear();
//		System.out.println("set 데이터 : " + hs1);
		
		/*
		 * Set의 데이터는 순서(index)가 없기 때문에 List처럼 index를 이용하여 데이터를 가져올 수 없다.
		 * 그래서 Set에서 데이터를 하나씩 차례로 가져오기 위해서는 Iterator형 객체로 변환해야 한다.
		 * 
		 * - Set형의 데이터들을 Iterator형 객체로 변환해 주는 메서드 ==> iterator()
		*/
		Iterator it = hs1.iterator(); // Set 데이터를 Iterator형으로 변환하기
		
		
		// Iterator의 hasNext()메서드
		//		==> Iterator의 포인터가 가리키는 곳의 다음번쨰에 데이터가 있는지 검사한다.
		//		==> 데이터가 있으면 true, 데이터가 없으면 false를 반환한다.
		while(it.hasNext()) {
			// Iterator의 next()메서드
			// ==> Iterator의 포인터를 다음번째 위치로 이동한 후, 그곳의 데이터를 반환한다.
			System.out.println(it.next());
		}
		System.out.println("-------------------------------------------");
		
		
		
		System.out.println("향상된 for문을 이용한 Set데이터 가져오기");
		for(Object obj : hs1) {
			System.out.println(obj);
		}
		
		System.out.println("-------------------------------------------");
		
		
		
		
		
		
		
		
		
		
		// 우리반 학생들 중 번호를 이용하여 추첨하는 프로그램 작성하기
		// 번호는 1번부터 24번까지 있고, 추첨할 인원은 3명이다.
		// 당첨자를 출력하시오
		
		// 난수 만들기 ( 최소값~ 최대값 사이의 정수형 난수 만들기)
		// int 변수 = (int)(math.random() * (최대값 - 최소값 +1) + 최소값) 
		// Random rnd = new Random();
		// rnd.nextInt(최대값 - 최소값+1) + 최소값;
		HashSet<Integer> testSet = new HashSet<Integer>();
		Random rnd = new Random();
		
		while(testSet.size() < 3) {
//			testSet.add(rnd.nextInt(24-1+1) +1 );
			testSet.add((int)(Math.random() * 24 - 1 + 1) +1 );
			
		}
		
		System.out.println("당첨자 번호 : " + testSet);
	
		//Set유형의 자료를 List형으로 변환하기
		ArrayList<Integer> testList = new ArrayList<Integer>(testSet);
		System.out.println("List 데이터 출력");
		for(int i = 0; i < testList.size(); i++) {
			System.out.println(testList.get(i));
		}
	}

}
