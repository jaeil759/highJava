package kr.or.ddit.basic;

import java.util.ArrayList;

public class ArrayListTest01 {

	public static void main(String[] args) {
		// ArrayList는 기본적인 사용법이 Vector와 같다.
		
		ArrayList list1 = new ArrayList();
		
		// add()메서드를 이용하여 추가한다.
		list1.add("aaa");
		list1.add("bbb");
		list1.add(123);
		list1.add('k');
		list1.add(true);
		list1.add(123.45);
		
		System.out.println("list1 => " + list1.toString());
		System.out.println("size => " + list1.size());
		
		
		// get() 메서드로 데이터를 꺼내온다.
		System.out.println("1번째 자료 : " + list1.get(1));
		
		// 데이터 끼워넣기도 같다.
		list1.add(3,"yyy");
		System.out.println("list => " + list1);
		
		//데이터 변경하기
		String temp = (String)list1.set(3, "zzz");
		System.out.println("temp => " + temp);
		System.out.println("list1 = > " + list1);
		
		//삭제도 같다.
		list1.add(3);
		System.out.println("list1 => " + list1);
		
		list1.remove("bbb");
		System.out.println("list1 => " + list1);
		
		//제네릭을 사용할수 있다.
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("AAAA");
		list2.add("BBBB");
		list2.add("CCCC");
		list2.add("DDDD");
		list2.add("EEEE");
		
		for(int i = 0; i < list2.size(); i++) {
			System.out.println(i + " ==> " + list2.get(i));
		}
		System.out.println("-----------------------------------------------------------------------");
		for(String str : list2) {
			System.out.println(str);
		}
		System.out.println("---------------------------------------------------------------------------");
		
		
		//contains(비교객체) ==> 리스트에 '비교객체'가 있으면 true, 없으면 false를 반환한다.
		System.out.println("DDDD값 : " + list2.contains("DDDD"));
		System.out.println("ZZZZ값 : " + list2.contains("ZZZZ"));
		
		list2.add("FFFF");
		list2.add("GGGG");
		list2.add("DDDD");
		list2.add("HHHH");
		System.out.println("list2 => " + list2);
		//indexOf( 비교객체 ), lastIndexOf( 비교객체 )
		// 		=> 리스트에 '비교객체'가 있으면 '비교객체'가 있는 index값을 반환하고
		//		=> 없으면 -1을 반환한다.
		// 		indexOf()메서드는 앞에서 뒤쪽 방향으로 검색하고, lastIndexOf() 메서드는 뒤에서 앞쪽 방향으로 검색한다.
		System.out.println("DDDD의 위치값1 : " + list2.indexOf("DDDD"));
		System.out.println("ZZZZ의 위치값1 : " + list2.indexOf("ZZZZ"));
		System.out.println();
		System.out.println("DDDD의 위치값2 : " + list2.lastIndexOf("DDDD"));
		System.out.println("ZZZZ의 위치값2 : " + list2.lastIndexOf("ZZZZ"));
		
		System.out.println("---------------------------------------------------------------------------");
		
		//toArray() ==> List안의 데이터를 배열로 변환하여 반환한다.
		// 			==> 기본적으로 Object형 배열로 반환된다.
		
		// toArray(new 제네릭타입[0]) ==> 제네릭타입의 배열로 변환한다.
		Object[] strArr = list2.toArray();
		//String[] strArr2 = (String[])list2.toArray(); //이런식의 형변환은 안된다.
		
//		System.out.println(strArr2.length);
		
		System.out.println("리스트 개수 : " + list2.size());
		System.out.println("배열의 개수 : " + strArr.length);
		System.out.println();
		
		for(int i = 0; i < strArr.length; i++) {
			System.out.println(i + "번째 자료 : " + strArr[i]);
			System.out.println("-----------------------------------------------------------------------");
			
			String[] strArr2 = list2.toArray(new String[0]);
			for(String str : strArr2) {
				System.out.println(str);
			}
		}
		
	}

}
