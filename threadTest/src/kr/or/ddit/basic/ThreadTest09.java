package kr.or.ddit.basic;

public class ThreadTest09 {
	/*
	 *  3개의 쓰레드가 각각 알파벳 A~Z까지 출력하는데 출력을 끝낸 순서대로 결과를 나타내는 프로그램 작성하기
	 */
	public static void main(String[] args) {
		PrintCharacter[] prnCharArr = new PrintCharacter[] {
			new PrintCharacter("홍길동"),
			new PrintCharacter("이순신"),
			new PrintCharacter("변학도")
		};
		for(PrintCharacter prnChar : prnCharArr) {
			prnChar.start();
		}
			for(PrintCharacter prnChar : prnCharArr) {
			try {
				prnChar.join();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
			System.out.println();
			System.out.println("경기 결과");
			System.out.println("순위 : " + PrintCharacter.setRank);
	}

}


// A ~ Z까지 출력하는 쓰레드
class PrintCharacter extends Thread{
	public static String setRank = "";
	
	private String name;
	
	public PrintCharacter(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		for(char c='A'; c<='Z'; c++) {
			System.out.println(name + "의 출력 문자 : " + c);
			try {
				Thread.sleep((int)(Math.random() * 300));
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println(name + " - 출력 끝...");
		
		// 출력을 끝낸 순서대로 이름을 배치한다.
		setRank += name + " ";
	}
}