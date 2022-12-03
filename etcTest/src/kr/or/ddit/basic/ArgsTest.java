package kr.or.ddit.basic;

public class ArgsTest {

	// 매개변수로 받은 정수들의 합계를 구해서 반환하는 메서드(개수 3개)
	public int sum(int a, int b, int c) {
		return a+b+c;
	}
	// 매개변수로 받은 정수들의 합계를 구해서 반환하는 메서드(개수는 상황에 따라 다를 수 있다.)
	public int sumArr(int[] data) {
		int s = 0;
		for(int i = 0; i <data.length; i++) {
			s += data[i];
		}
		return s;
	}
	/*
	 *  가변형 인수 ==> 메서드의 인수의 개수가 실행될 때마다 다를 때 사용한다.
	 *   - 가변형 인수는 메서드 안에서 배열로 처리한다.
	 *   - 가변형 인수는 한가지 자료형만 사용 할 수 있다.
	 */
	public int sumArg(int...data) {
		int s= 0;
		for(int i = 0; i <data.length; i++) {
			s += data[i];
		}
		return s;
	}
	
	// 가변형 인수와 일반적인 인수를 같이 사용 할 경우에는 가변형 인수를 제일 뒤쪽에 배치해야 한다.
	public String sumArg2(String name, int...data) {
		int s = 0;
		for(int i = 0; i <data.length; i++) {
			s += data[i];
		}
		return name + "씨 점수 : " + s;
	}
	public static void main(String[] args) {
		ArgsTest at = new ArgsTest();
		// 합계를 구할 데이터는 100, 200, 300 이다. 
		int[] nums = {100, 200, 300};
		System.out.println("합계 : " + at.sumArr(nums));
		System.out.println("합계 : " + at.sumArr(new int[] {1,2,3,4,5})); // 합계를 구할 데이터 : 1,2,3,4,5
		System.out.println("---------------------------------------------------------");
		System.out.println("가변형 합계 : " + at.sumArr(new int[] {1,2,3,4,5})); // 합계를 구할 데이터 : 1,2,3,4,5
		System.out.println("가변형 합계 : " + at.sumArg(1,2,3,4,5));
		System.out.println("---------------------------------------------------------");
		System.out.println(at.sumArg2("홍길동", 90,80,70,60));
	}

}
