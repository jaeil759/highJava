package kr.or.ddit.basic;

import javax.swing.JOptionPane;

/*
 * 컴퓨터와 가위바위보를 진행하는 프로그램을 작성하시오.
 * 
 * 컴퓨터의 가위바위보는 난수를 이용하여 구하고, 
 * 사용자의 가위바위보는 showInputDialog()메서드를 이용하여 입력받는다.
 * 입력시간은 5초로 제한하고 카운트다운을 실행한다.
 * 5초안에 입력이 없으면 게임에 진것으로 처리하고 프로그램을 끝낸다.
 * 
 * 
 * 5초안에 입력이 완료되면 승패를 구해서 출력한다
 * 
 * 결과 예시)
 * 1) 5초안에 입력을 못했을 경우
 * 		-- 결 과 --
 * 		시간초과로 당신이 졌습니다.
 * 2) 5초안에 입력했을 경우
 * 		-- 결 과 --
 * 		컴퓨터 : 가위
 * 		사용자 : 바위
 * 		결과 : 당신이 이겼습니다.
 * 
 * 
 */


public class ThreadTest07 {
	public static boolean inputCheck;
	public static void main(String[] args) {
		GameTimer timer = new GameTimer();
		
		// 난수를 이용하여 컴퓨터의 가위 바위 보 정하기
		String[] data = {"가위","바위","보"};
		int index = (int)(Math.random() * 3); //0~2사이에 난수만들기
		String com = data[index]; // 컴퓨터의 가위 바위 보를 정한다.
		
		// 사용자의 가위 바위 보 입력 받기
		timer.start();
		String man = null;
		
		do {
		man = JOptionPane.showInputDialog("가위 바위 보 를 입력하세요...");
		
		}while( !("가위".equals(man) || "바위".equals(man) || "보".equals(man)));
		inputCheck = true;
		
		// 결과 판정하기
		String result = "";
		if(com.equals(man)) {
			result = "비겼습니다.";
		}else if(man.equals("가위") && com.equals("보") || man.equals("바위") && com.equals("가위") || man.equals("보") && com.equals("바위")) {
			result = "당신이 이겼습니다.";
		}else {
			result = "당신이 졌습니다.";
		}
		//결과 출력하기
		System.out.println(" -- 결 과 --");
		System.out.println("컴퓨터 : " + com);
		System.out.println("사용자 : " + man);
		System.out.println("결 과 : " + result);
	}

}
class GameTimer extends Thread{
	@Override
	public void run() {
		System.out.println("카운트다운 시작...");
		for(int i = 5; i >=1; i--) {
			
			if(ThreadTest07.inputCheck==true) {
				return;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println(" -- 결 과 --");
		System.out.println("시간초과로 당신이 패배하였습니다.");
		System.out.println(0);
	}
}
