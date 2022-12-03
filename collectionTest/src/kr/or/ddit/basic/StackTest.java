package kr.or.ddit.basic;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Browser b = new Browser();
		System.out.println("방문전...");
		b.history();
		
		b.goURL("1.네이버");
		b.history();
		
		b.goURL("2.야후");
		b.history();
		
		b.goURL("3.구글");
		b.goURL("4.다음");
		b.history();
		
		System.out.println("뒤로가기 후...");
		b.goBack();
		b.history();
		System.out.println("뒤로가기 후...");
		b.goBack();
		b.history();
		System.out.println("앞으로 가기 후...");
		b.goForward();
		b.history();
	}

}


// 웹브라우저의 앞으로가기, 뒤로가기 기능 구현하기(스택기능)
class Browser{
	private Stack<String> back; // 이전 방문 내역이 저장될 스택 변수
	private Stack<String> forward; // 다음 방문 내역이 저장될 스택 변수
	private String currentURL;
	
	//생성자
	public Browser() {
		back = new Stack<String>();
		forward = new Stack<String>();
		currentURL = "";
	}
	//사이트를 방문하는 메서드 ==> 매개변수 url에는 방문할 사이트의 주소가 저장된다.
	public void goURL(String url) {
		System.out.println(url + "사이트에 접속합니다.");
		if(currentURL != null && !"".equals(url)) { // 현재 페이지가 있으면
			back.push(currentURL); // 현재페이지를 back스택에 추가한다.
		}
		
		currentURL = url; // 현재 페이지를 방문할 페이지로 변경한다.
	}
	
	//뒤로가기
	public void goBack() {
		// isEmpty() ==> 컬렉션객체에 데이터가 없으면 true, 있으면 false 를 반환한다.
		if(!back.isEmpty()) { // back 스택이 비어있지 않으면 작동한다.
			forward.push(currentURL);   // 현재페이지를 forward스택에 추가한다.
			currentURL = back.pop();	// back스택에서 1개의 요소를 꺼내와 현재 페이지로 지정한다.
			
		}
	}
	public void goForward() {
		if(!forward.isEmpty()) { // forward스택이 비어있지 않으면...
			back.push(currentURL); // 현재페이지를 back스택에 추가한다.
			currentURL = forward.pop(); // forward스택에서 1개의 요소를 꺼내와 현재 페이지로 지정한다.
		}
	}
		// 방문기록 확인하기
	public void history() {
		System.out.println("-----------------------------------------------");
		System.out.println("       방문기록      ");
		System.out.println("-----------------------------------------------");
		System.out.println("back ==> " + back);
		System.out.println("현 재 ==> " + currentURL);
		System.out.println("forward ==> " + forward);
		System.out.println("------------------------------------------------");
	}
}