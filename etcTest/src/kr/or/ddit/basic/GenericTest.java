package kr.or.ddit.basic;


/*
 *  제네릭 클래스 만드는 방법
 *  형식) 
 *  class 클래스명<제네릭타입글자>{
 *  	private 제네릭타입글자 변수명;	// 변수 선언에 제네릭을 사용한 경우
 *  	...
 *  
 *  	public 제네릭타입글자 메서드명(){ // 메서드의 반환값에 제네릭을 사용한 경우
 *  	....
 *  	return 값;
 *  	}
 *  	public void 메서드명(제네릭타입글자 변수명, ...){ // 메서드의 매개변수에 제네릭을 사용한 경우
 *  	...
 *  	}
 *  }
 *  
 *  	--제네릭 타입 글자
 *  	T 	==> Type
 *  	K	==> Key
 *  	V	==> Value
 *  	E	==> Element
 */


// 모든 종류의 자료를 저장할 수 있는 class만들기
class NonGeneric{
	private Object value;
	
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
}

// 제네릭을 적용한 class 만들기
class MyGeneric<T>{
	private T value;
	
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
}

public class GenericTest {

	public static void main(String[] args) {
		NonGeneric ng1 = new NonGeneric();
		ng1.setValue("가나다라");
		
		NonGeneric ng2 = new NonGeneric();
		ng2.setValue(100);
		
		// 자료 꺼내오기
		String temp = (String)ng1.getValue();
		System.out.println("문자열 반환값 : " + temp);
		
		int intTemp = (int)ng2.getValue();
		System.out.println("정수형 반환값 : " + intTemp);
		System.out.println("-----------------------------------------------------------------");

		MyGeneric<String> mg1 = new MyGeneric<String>();
		MyGeneric<Integer> mg2 = new MyGeneric<Integer>();
		
		mg1.setValue("우리나라");
//		mg1.setValue(1000);
		
		mg2.setValue(200);
//		mg2.setValue("대전");
		
		temp = mg1.getValue();
		intTemp = mg2.getValue();
		System.out.println("제네릭 문자열 반환값 : " + temp);
		System.out.println("제네릭 정수형 반환값 : " + intTemp);
		
		String temp2 = (String)ng2.getValue(); // 이렇게쓰면 문법적으로는 오류가 아니지만 형변환할떄 오류가 발생한다.
		System.out.println("temp2 = " + temp2);
		
		
		
	}

}
