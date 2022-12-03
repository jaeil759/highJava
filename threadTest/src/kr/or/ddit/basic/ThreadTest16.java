package kr.or.ddit.basic;

// 은행의 입출금을 쓰레드로 처리하는 예제 ==> 동기화 처리예제

public class ThreadTest16 {
	
	private int balance; 	//잔액이 저장될 변수
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getBalance() {
		return balance;
	}
	
	// 입금하는 메서드
	public void deposit(int money) {
		balance += money;
	}
	
	// 출금하는 메서드( 반환값 ==> 출금 성공 : true, 출금실패 : false)
	public synchronized boolean withdraw(int money) { // synchronized 를 붙히면 동기화처리가 된다. (붙히고 안붙히고 결과가 다름)
		if(balance >= money) {
			for(int i = 1; i<=100_000_000; i++) {}
			balance-=money;
			System.out.println("메서드 안에서 balance = " + balance);
			return true;
		}else {
			System.out.println("메서드 안에서... 잔액부족... ");
			return false;
		}
	}
	
	public static void main(String[] args) {
		ThreadTest16 acount = new ThreadTest16(); // 공통 객체 생성
		
		acount.setBalance(10000); // 잔액을 10000원으로 설정
		
		// 익명 구현체로 쓰레드 구현
		Runnable test = new Runnable() {
			
			@Override
			public void run() {
				boolean result = acount.withdraw(6000); // 6000원을 출금
				System.out.println("쓰레드에서 result = " + result + ", balance = " + acount.getBalance());
			}
		};
		//=========================================
		Thread th1 = new Thread(test);
		Thread th2 = new Thread(test);
		
		th1.start();
		th2.start();
	}

}
