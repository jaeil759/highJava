package kr.or.ddit.basic;

public class ThreadTest08 {

	public static void main(String[] args) {
		AutoSaveThread auto = new AutoSaveThread();
		auto.setDaemon(true); // 데몬쓰레드로 설정하기 ==> 반드시 start()메서드 호출전에 설정해야한다.
		auto.start();
		try {
			for(int i = 1; 1<=20; i++) {
				System.out.println(i);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			
		}
		System.out.println("main 쓰레드 종료");
	}

}

// 자동 저장하는 쓰레드 작성(3초에 한번씩 자동 저장 하는 쓰레드)
class AutoSaveThread extends Thread{
	private void save() {
		System.out.println("작업 내용을 저장합니다.");
	}
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				
			}
			save();
		}
	}
}