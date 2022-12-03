package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpMultiChatClient {

	public static void main(String[] args) {
		new TcpMultiChatClient().clientStart();
	}
	
	public void clientStart(){
		Socket socket = null;
		
		try {
			socket = new Socket("192.168.144.32", 7777);
			System.out.println("서버에 연결되었습니다.");
			System.out.println();
			// 메세지 전송용 쓰레드와 메시지 수신용 쓰레드를 생성해서 실행한다.
			ClientSender sender = new ClientSender(socket);
			ClientReceiver receiver = new ClientReceiver(socket);
			
			sender.start();
			receiver.start();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}// 시작메서드 끝...
	
	
	// -------------------------------------------
	// 메세지 전송용 쓰레드 만들기
	class ClientSender extends Thread{
		private Socket socket;
		private DataInputStream din;
		private DataOutputStream dout;
		
		private String name;
		private Scanner scan;
		
		public ClientSender(Socket socket) {
			this.socket = socket;
			scan = new Scanner(System.in);
			try {
				din = new DataInputStream(socket.getInputStream());
				dout = new DataOutputStream(socket.getOutputStream());
				
				if(dout !=null) {
					while(true) {
						// 클라이언트는 처음 실행하면 서버에 접속하고 서버에 접속이 성공하면 첫번째로 '대화명' 을 입력받아
						// 전송하고 , '대화명'의 중복여부를 응답으로 받아서 확인한다.
						System.out.println("대화명 >> ");
						String name = scan.nextLine();
						dout.writeUTF(name);
						
						String feedBack = din.readUTF(); // '대화명'의 중복여부를 응답으로 받는다.
						if("대화명중복".equals(feedBack)) { // '대화명'이 중복되면...
							System.out.println(name + "은 대화명이 중복됩니다...");
							System.out.println("다른 대화명을 입력하세요...");
							System.out.println();
						}else { // '대화명'이 중복되지 않을때...
							this.name = name;
							System.out.println(name + " 대화명으로 대화방에 입장했습니다...");
							break; //반복문 탈출
							
						}
					} // while문 끝...
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}//생성자 끝...
		@Override
		public void run() {
			try {
				while(din!=null) {
					// 키보드로 입력한 내용을 대화명과 같이 서버로 전송한다.
					dout.writeUTF("[" + name + "]" + scan.nextLine());
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}// 메세지 전송용 쓰레드 끝..
	
	// ---------------------------------------------------------
	//메세지 수신용 쓰레드 만들기
	class ClientReceiver extends Thread{
		private Socket socket;
		private DataInputStream din;
		//생성자
		public ClientReceiver(Socket socket) {
			this.socket = socket;
			try {
				din = new DataInputStream(socket.getInputStream());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}//생성자 끝
		@Override
		public void run() {
			try {
				while(din!=null) {
					// 서버가 보내온 메세지를 받아서 화면에 출력한다.
					System.out.println(din.readUTF());
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
	
	
	
	
	
}
