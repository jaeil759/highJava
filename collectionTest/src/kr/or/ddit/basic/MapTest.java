package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		/*
		 * 	Map => key 값과 value값을 한쌍으로 관리하는 객체
		 * 		- key값은 중복을 허용하지않고 순서가 없다. (Set의 특징을 가지고있다.)
		 * 		- value값은 중복을 허용한다.
		 */
		
		HashMap<String, String>map = new HashMap<String, String>();
		
		//자료추가 --> put(key값, value값)
		map.put("name", "홍길동");
		map.put("addr", "대전");
		map.put("tel", "010-9876-5432");
		
		System.out.println("map ==> " + map.toString());
		
		// 자료수정 ==> 데이터를 추가할 때 key값이 같으면 나중에 추가한 값이 저장된다.
		map.put("addr", "서울");
		System.out.println("map ==> " + map);
		
//		// 자료삭제 ==> remove(key값) : key값이 같은 자료를 찾아 삭제한다.
//		//					   반환값 : 삭제된 자료의 value값이 반환된다.
//		String removeTel = map.remove("tel");
//		System.out.println("map ==> " + map);
//		System.out.println("반환값 : " + removeTel);
		// 자료읽기 ==> get(key값) : key값과 같이 저장된 value값을 반환한다.
		System.out.println("이름 : " + map.get("name"));
		System.out.println();
		
		// key 값이 존재하는지 여부를 나타내는 메서드 : containsKey(key값)
		// 			==> 해당 'key'값이 있으면 true, 없으면 false
		System.out.println("tel 키값의 존재여부 : " + map.containsKey("tel"));
		System.out.println("age 키값의 존재여부 : " + map.containsKey("age"));
		System.out.println();
		
		// Map에 저장된 모든 key값을 읽어와 Map의 모든 데이터를 차례대로 처리하는 방법
		
		// keySet() 메서드 이용하기
		//		==> Map의 모든 key값들을 읽어와서 Set형으로 반환한다.
		Set<String> keyset = map.keySet();
		
		// 방법1) keySet데이터를 Iterator 로 처리하는방법
		Iterator<String>keyit = keyset.iterator();
		while(keyit.hasNext()) {
			String key = keyit.next();
			String value = map.get(key);
			System.out.println(key + " : " + value);
		}
		System.out.println("----------------------------------------------------------");
		
		// 방법2) keySet데이터를 향상된 for문으로 처리하는 방법
		for(String key : keyset) {
			String value = map.get(key);
			System.out.println(key + " => " + value);
		}
		System.out.println("----------------------------------------------------------");
		
		// value 값만 가져와 처리하기 ==> values() 메서드 이용
		for(String value : map.values()) {
			System.out.println(value);
		}
		
	}

}
