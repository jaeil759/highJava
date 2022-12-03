package kr.or.ddit.basic;

/*
 * 
 * 1~20억까지의 합계를 구하는 프로그램을 하나의 쓰레드가 단독으로 처리할 때와 여러개의 쓰레드가 협력해서 처리할 때의 경과 시간을 비교해 보자
 * 
 * 
 */
public class ThreadTest04 {

	public static void main(String[] args) {
		// 단독으로 처리할 쓰레드 객체 생성
		SumThread th1 = new SumThread(1L, 2_000_000_000L);
		
		// 여럿이 협력해서 처리하는 쓰레드 객체 생성
		SumThread[] sums = new SumThread[] {
				new SumThread(1L, 500000000L),
				new SumThread(500_000_001L, 1_000_000_000L),
				new SumThread(1_000_000_001L, 1_500_000_000L),
				new SumThread(1_500_000_001L, 2_000_000_000L)
		};
		// 단독으로 처리하기
		long startTime = System.currentTimeMillis();
		th1.start();
		try {
			th1.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
		long endTime = System.currentTimeMillis();
		System.out.println("단독으로 처리했을 때 경과 시간 : " + (endTime - startTime));
		System.out.println();
		System.out.println("-----------------------------------------------------------------");
		
		// 여러 쓰레드가 협력해서 처리하기
		startTime = System.currentTimeMillis();
		for(int i = 0; i <sums.length; i++) {
			sums[i].start();
		}
		for(SumThread s : sums) {
			try {
				s.join();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		endTime = System.currentTimeMillis();
		
		System.out.println("협력해서 처리한 경과시간 : " + (endTime - startTime));
	}

}
class SumThread extends Thread{
	// 합계를 구할 영역의 시작값과 종료값이 저장될 변수 선언 
	private long startNum;
	private long endNum;
	public SumThread(long startNum, long endNum) {
		this.startNum = startNum;
		this.endNum = endNum;
	}
	@Override
	public void run() {
		long sum = 0L;
		for(long i = startNum; i<=endNum; i++) {
			sum += i;
		}
		System.out.println(startNum + "부터" + endNum + "까지의 합계 : " + sum);
	}
}