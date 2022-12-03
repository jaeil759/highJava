package kr.or.ddit.basic.singleton;


/*
 *  Singleton 패턴 ==> 객체가 1개만 만들어지게 하는 패턴
 *  					(외부에서 new명령을 사용하지 못하게 한다.)
 *  
 *  싱글톤 사용 이유 : 메모리 낭비 방지, 데이터의 공유가 쉽다.
 *  
 *  
 *  
 *   - Singleton패턴 클래스를 만드는 방법(필수 구성요소)
 *   1. 자신 class의 참조값이 저장될 변수를 private static으로 선언한다
 *   2. 생성의 접근제한자 private으로 한다
 *   3. 자신 class의 인스턴스를 생성하고 반환하는 메서드를 public static으로 작성한다.
 *   	(이 메서드의 이름은 보통 getInstance로 한다.)
 *   
 */
public class MySingleton {
	//1번
	private static MySingleton single;
	//2번
	private MySingleton() {
		System.out.println("생성자 입니다...");
	}
	//3번
	public static MySingleton getInstance() {
		//1번의 변수가 null이면 객체를 생성해서 1번 변수에 저장한다
		if(single==null)single = new MySingleton();
		// 1번 변수값을 반환한다.
		return single;
	}

	//기타 이 클래스가 처리할 메서드를 작성한다.
	public void displayTest() {
		System.out.println("이 내용은 싱글톤 객체의 메서드 호출입니다...");
	}
}
