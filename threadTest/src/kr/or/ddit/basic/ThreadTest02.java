package kr.or.ddit.basic;

public class ThreadTest02 {

	public static void main(String[] args) {
		// 멀티 쓰레드 프로그램

		// Thread를 사용하는 방법

		// 방법1
		// Thread 클래스를 상속한 class를 작성한 후 이 class의 인스턴스를 생성한다.
		// 그리고 이 인스턴스의 start()메서드를 호출해서 실행한다.
		MyThread1 th1 = new MyThread1(); // 인스턴스 생성
		th1.start();	//쓰레드 실행

		// 방법2
		// Runnable인터페이스를 구현한 class를 작성한 후 이 class의 인스턴스를 생성한다.
		// 그리고, Thread객체를 생성할 때 이 인스턴스를 Thread객체의 생성자에 인수값을 넣어준다.
		// 이 때 생성된 Thread객체의 start() 메서드를 호출해서 실행한다.
		MyRunner1 runner = new MyRunner1(); // Runnable을 구현한 클래스의 인스턴스 생성
		Thread th2 = new Thread(runner);  // Thread객체 생성할 때 위에서 만든 인스턴스를 주입한다.
		th2.start();


		// 방법3 ==> 익명구현체를 이용하는방법
		Runnable runner2 = new Runnable() {
			@Override
			public void run() {
				for(int i = 1; i <=200; i++) {
					System.out.print("@");
					try {
						Thread.sleep(100);
					} catch (Exception e) {

					}
				}
			}
		};
		Thread th3 = new Thread(runner2);
		th3.start();
		System.out.println("main() 메서드끝...");
	}

}

// 방법1 ==> Thread를 상속한 class 작성하기
class MyThread1 extends Thread{
	//run() 메서드를 재정의 한다.
	@Override
	public void run() {
		// 이 run()메서드에서는 쓰레드가 처리할 내용을 구현한다.
		for(int i=1; i<=200; i++) {
			System.out.print("*");
			try {
				// Thread.sleep(시간) ==> 주어진 '시간'동안 작업을 잠시 멈춘다.
				//									  ==> '시간'은 밀리세컨드 단위를 사용한다. (즉, 1초==1000)
				Thread.sleep(100);
			} catch (Exception e) {

			}

		}
	}

}

// 방법2 ==> Runnable을 구현한 class 만들기
class MyRunner1 implements Runnable{
	//run() 메서드를 재정의 한다.
	@Override
	public void run() {
		// 쓰레드가 처리할 내용을 run() 메서드에 작성한다.
		for(int i = 1; i<=200; i++) {
			System.out.print("$");
			try {
				// Thread.sleep(시간) ==> 주어진 '시간'동안 작업을 잠시 멈춘다.
				//									  ==> '시간'은 밀리세컨드 단위를 사용한다. (즉, 1초==1000)
				Thread.sleep(100);
			} catch (Exception e) {

			}
		}
	}
}


