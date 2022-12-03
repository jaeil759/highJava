package kr.or.ddit.basic;

public class EnumTest {
	/*
	 * 
	 *  enum(열거형) ==> 서로 관련있는 상수들의 집합을 나타낸다.
	 *  			 ==> 클래스처럼 보이게하는 상수
	 *  만드는 방법	 ==> 클래스처럼 독립된 java파일에 만들수 있고,
	 *  			 ==> 하나의 java파일에 클래스와 같이 만들수 있고,
	 *  			 ==> 클래스 안에 내부 클래스처럼 만들 수 있다.
	 *  
	 *   - 열거형의 속성 및 메서드
	 *    name() ==> 열거형 상수의 이름을 문자열로 반환한다.
	 *    ordinal() ==> 열거형 상수가 정의된 순서(index값)을 반환한다. (0번부터 시작)
	 *    valueOf("열거형상수명") ==> 지정된 '열거형상수명'과 일치하는 열거형 상수를 반환한다.
	 *    열거형이름.상수명 ==> valueOf()메서드와 같다.
	 *    열거형이름.values() ==> 선언된 모든 열거형 상수들을 배열로 변환하여 반환한다.
	 *    
	 *    - 열거형 상수 선언하기
	 *    방법1)
	 *    	enum 열거형 이름{상수명1, 상수명2, 상수명3,...}
	 *    방법2) ==> 상수에 임의의 값을 지정하는 방법
	 *    	enum 열거형이름{
	 *    		상수명1(값들...)
	 *    		상수명2(값들...)
	 *    		상수명3(값들...)
	 *    		...
	 *    		상수명n(값들...)
	 *    		'값들'이 저장될 변수들을 선언한다.
	 *    		private 자료형이름 변수명1;
	 *    		private 자료형이름 변수명2;
	 *    		...
	 *    	
	 *    // 열거형의 생성자를 만든다
	 *    // 열거형의 생성자는 '열거형 상수'에 '값들'을 셋팅하는 역할을 수행한다.
	 *    // private(열거형이름갱성자는 묵시적으로 private이다.
	 *    // 변수명의 개수는 '값들' 의 개수와 같고, 각각의 '값들'과 자료형이 맞아야 한다. 
	 *    // private 열거형이름( 자료형이름 변수명1, 자료형이름 변수명2, ...){
	 *    위에서 선언한 '값들'이 저장될 변수들을 초기화한다.
	 *    }
	 *    // 구성된 '값들'을 외부에서 불러올 수 있는 getter에서 메서드를 만든다.
	 *    	
	 * 
	 */
		public enum Color{ RED, GREEN, BLUE}
		public enum Count{ ONE, TWO, THREE}
		
		// 열거형 상수에 값을 지정하여 만들기

		public enum Season{
			봄("3월부터 5월까지",10),	// 상수명(값들) 형식의 선언
			여름("6월부터 8월가지",30),
			가을("9월부터 12월까지",20),
			겨울("12월부터 2월까지",-5);
			
			// 같이 저장될 변수 선언
			private String span;
			private int temp;
			
			//생성자 
			Season(String months, int temp){ //private Season(String months, int temp){ 와 같다
				span = months;
				this.temp = temp;
			}
			//getter 메서드 생성

			public String getSpan() {
				return span;
			}

			public int getTemp() {
				return temp;
			}
			
		}
		
		
		
		
	public static void main(String[] args) {
//		System.out.println("RED : " + ConstTest.RED);
//		System.out.println("THREE : " + ConstTest.THREE);
//		
//		if(ConstTest.RED == ConstTest.TWO) {
//			System.out.println("....");
//		}else {
//			System.out.println("####");
//		}
		Color mycol = Color.valueOf("GREEN");	// Color.GREEN 과 같다.
		Count mycnt = Count.ONE; // Count.valueOf("ONE") 과 같다.
		System.out.println("mycol : " + mycol.name());
		System.out.println("mycnt : " + mycnt.name());
		System.out.println();
		
		System.out.println("mycol ordinal : " + mycol.ordinal());
		System.out.println("mycnt ordinal : " + mycnt.ordinal());
		System.out.println();
		
//		if(mycol == Count.THREE) {
//			System.out.println("같다..");
//		}else {
//			System.out.println("다르다..");
//		}
//		
		if(mycol == Color.BLUE) {
			System.out.println("같다..");
			}else {
				System.out.println("다르다..");
			}
		System.out.println();
		
		// 열거형을 switch문으로 비교하기
		switch(mycol) {
		// case문에 '상수명'을 지정할때는 '열거형이름'을 반드시 생략해야 한다. 
		// case 열거형이름.상수명 ==> 틀림, case 상수명 ==> 맞음
		case RED : System.out.println("빨강"); break;
		case GREEN : System.out.println("초록"); break;
		case BLUE : System.out.println("파랑"); break;
			
		}
		System.out.println("--------------------------------------------------------------------------");
		
		Season ss = Season.valueOf("봄");
		System.out.println("name : " + ss.name());
		System.out.println("ordinal : " + ss.ordinal());
		System.out.println("span : " + ss.getSpan());
		System.out.println("temp : " + ss.getTemp());
		System.out.println();
		
		for(Season time : Season.values()) {
			System.out.println(time.name() + "==" + time + "==>" + time.getSpan() + "," + time.getTemp());
		}
		System.out.println("---------------------------------------------------------------------------");
		
	}

}
