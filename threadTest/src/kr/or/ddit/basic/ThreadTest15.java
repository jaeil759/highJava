package kr.or.ddit.basic;

public class ThreadTest15 {

	public static void main(String[] args) {
		ShareObject sObj= new ShareObject();
		
		TestThread th1 = new TestThread("쓰레드1", sObj);
		TestThread th2 = new TestThread("쓰레드2", sObj);
		
		th1.start();
		th2.start();
	}

}

// Test용 쓰레드
class TestThread extends Thread{
	private ShareObject sObj;
	
	//생성자
	public TestThread(String name, ShareObject sObj) {
		super(name);
		this.sObj = sObj;
	}
	@Override
	public void run() {
		for(int i =1; i <=10; i++) {
			sObj.add();
		}
	}
}



// 공통객체
class ShareObject{
	private int sum = 0;
	
	// 동기화 처리하기
//	public synchronized void add() { // 방법 1 ==> 메서드에 동기화 설정을 한다.
		public void add() { // 방법 1 ==> 메서드에 동기화 설정을 한다.
			synchronized(this){ // 방법 2 ==> 
				
				int n = sum;
				
				n += 10; //10증가
				sum = n;
				
				System.out.println(Thread.currentThread().getName() + "합계 : " + sum);
			}
	}
}