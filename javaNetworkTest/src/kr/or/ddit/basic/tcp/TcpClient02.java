package kr.or.ddit.basic.tcp;

import java.io.IOException;
import java.net.Socket;

public class TcpClient02 {

	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("localhost", 7777);
			System.out.println("서버에 연결되었습니다.");
			System.out.println();
			
			// 서버와 연결된 Socket객체를 전송용 쓰레드와 수신용 쓰레드에 주입하여 실행한다.
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			
			sender.start();
			receiver.start();
		} catch (Exception e) {
		}
		
	}

}
