package kr.or.ddit.basic;

	/*
	 * 
	 * Thread의 stop()메서드를 호출하면 쓰레드가 바로 멈춘다.
	 * 이때 사용하던 자원을 정리하지 못하고 쓰레드가 종료되어 다른 프로그램이나 쓰레드에 영향을 줄 수 있다.( 오동작의 원인)
	 * 그래서 stop()메서드는 비추천으로 되어있다.
	 * 
	 */

public class ThreadTest13 {

	public static void main(String[] args) {
		
//		ThreadStopTest1 th1 = new ThreadStopTest1();
//		th1.start();
//		
//		try {
//			Thread.sleep(1000);
//		} catch (Exception e) {
//		}
////		th1.stop(); // 비추천명령이라는 뜻
//		th1.setStop(true);
		
//		interrupt() 메서드를 이용한 쓰레드 멈추기
		ThreadStopTest2 th2 = new ThreadStopTest2();
		th2.start();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			
		}
		th2.interrupt();
	}

}
class ThreadStopTest1 extends Thread{
	private boolean stop;
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	@Override
	public void run() {
		while(!stop) {
			System.out.println("쓰레드 실행중...");
			
		}
		System.out.println("자원정리...");
		System.out.println("쓰레드 종료....");
	}
}

//interrupt() 메서드를 이용하여 쓰레드를 멈추게하는 쓰레드
class ThreadStopTest2 extends Thread{
	@Override
	public void run() {
//		//방법 1 ==> interrupt()메서드와 sleep() 메서드를 이용해서 자리하는 방법
//		try {
//			while(true) {
//				System.out.println("쓰레드 실행중...***");
//				Thread.sleep(1);
//			}
//		} catch (Exception e) {
//			
//		}
		
		//방법 2 ==> interrupt()메서드가 호출되었는지 검사하는 방법
//		while(true) {
//			System.out.println("Thread 실행중@@@@");
//			
//			// 검사방법1 ==> Thread의 인스턴스 메서드인 isInterrupted()메서드 이용하기
//			// isInterrupted() 메서드 ==> interrupt()메서드가 호출되면 true반환한다.
//			if(this.isInterrupted()) {
//				break;
//			}
//			
//		}
		while(true) {
			System.out.println("Thread 실행중@@@@");
			// 검사방법2 ==> Thread의 정적 메서드인 interrupted() 메서드 이용하기
			// interrupted()메서드 ==> interrupt()메서드가 호출되면 true로 반환한다.
			if(Thread.interrupted()) {
				break;
			}
			
		}
		System.out.println("자원 정리....");
		System.out.println("쓰레드 종료....");
	}
}

