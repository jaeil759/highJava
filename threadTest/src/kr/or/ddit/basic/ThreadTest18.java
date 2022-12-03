package kr.or.ddit.basic;

/*
 * 	wait(), notify() 메서드를 이용해서 두 쓰레드가 번갈아 한번씩 실행되는 예제
 * 
 * 	wait(), notifu() notifyAll() 메서드는 동기화 영역에서만사용 가능하다.
 */


public class ThreadTest18 {

	public static void main(String[] args) {
		WorkObject workObj = new WorkObject();
		
		Thread thA = new ThreadA(workObj);
		Thread thB = new ThreadB(workObj);
		
		thA.start();
		thB.start();
	}

}


// 공통객체의 methodA()메서드만 호출하는 쓰레드
class ThreadA extends Thread{
	private WorkObject workObj;

	public ThreadA(WorkObject workObj) {
		super();
		this.workObj = workObj;
	}
	@Override
	public void run() {
		for(int i = 1; i <=10; i++) {
			workObj.methodA();
		}
		synchronized (workObj) {
			workObj.notify();
		}
	}
}
// 공통객체의 methodA()메서드만 호출하는 쓰레드
class ThreadB extends Thread{
	private WorkObject workObj;
	
	public ThreadB(WorkObject workObj) {
		super();
		this.workObj = workObj;
	}
	@Override
	public void run() {
		for(int i = 1; i <=10; i++) {
			workObj.methodB();
		}
		synchronized (workObj) {
			workObj.notify();
		}
	}
}





class WorkObject{
	public synchronized void methodA() {
		System.out.println("methodA 메서드 실행중....");
		notify();
		try {
			wait();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public synchronized void methodB() {
		System.out.println("methodB 메서드 실행중 @@@@");
		notify();
		try {
			wait();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}