package kr.or.ddit.basic;
// JavaDoc 문서 파일 만들기 예제

/**
 * 
 * @author PC-17
 * @version 1.0
 * 
 * <p>
 *  파일명 : JavaDocTest.java <br>
 *  설명 : JavaDoc 문서 작성을 위한 Interface<br><br>
 *  
 *  수정이력<br>
 *  ----------------------------------<br>
 *  변경날자 : 2020-09-19 <br>
 *  변경자 : 홍길동<br>
 *  변경내용 : 최초생성<br>
 *  ----------------------------------<br>
 * </p>
 */

public interface JavaDocTest {
	/**
	 * 메서드명 : methodTest<br>
	 * 실행 : 반환값이 없는 메서드<br>
	 * 
	 * @param a 첫번째 매개변수(정수형)
	 * @param b 두번째 매개변수(정수형)
	 */
	
	public void methodTest(int a, int b);
	/**
	 *  메서드명 : methodAdd<br>
	 *   설명 : 반환값이 있는 메서드<br>
	 * @param x : 첫번째 정수형 데이터
	 * @param y : 두번째 정수형 데이터
	 * @return 처리된 결과를 정수형으로 반환한다
	 */
	
	public int methodAdd(int x, int y);
	/**
	 *  메서드명 : methodSub<br>
	 *  설명 : 반환값은 있고매개변수가 없는 메서드<br>
	 *  
	 * @return 정수형으로 반환한다.
	 */
	public int methodsub();
}
