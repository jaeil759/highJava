package kr.or.ddit.basic;

public class ThreadTest12 {
	
	public static void main(String[] args) {
		YieldTest th1 = new YieldTest("1번 스레드");
		YieldTest th2 = new YieldTest("2번 스레드");
		
		th1.start();
		th2.start();
		
		try {
			Thread.sleep(5);
		} catch (Exception e) {
			
		}
		System.out.println("-------------------------------------------------------------");
		th1.work = false;
		
		try {
			Thread.sleep(5);
		} catch (Exception e) {
			
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		th1.work = true;
		
		try {
			Thread.sleep(5);
		} catch (Exception e) {
			
		}
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		th1.stop = true;
		th2.stop = true;
	}
}

class YieldTest extends Thread{
	public boolean stop = false;
	public boolean work = true;
	
	public YieldTest(String name) {
		super(name);
	}
	
	
	@Override
	public void run() {
		while(!stop) {
			if(work) {
				System.out.println(getName() + "작업중!!!...");
			}else {
				System.out.println(getName() + "양보중***...");
				Thread.yield();
			}
		}
		
	}
}