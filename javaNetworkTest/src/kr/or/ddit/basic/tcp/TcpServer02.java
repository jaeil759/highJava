package kr.or.ddit.basic.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer02 {

	public static void main(String[] args) {
		ServerSocket server = null;
		Socket socket = null;
		try {
			// ServerSocket 객체를 생성하고, 클라이언트가 접속해 오면 Socket객체를 만들어서
			// 메세지를 전송하는 쓰레드와 메세지를 수신하는 쓰레드에 이 Socket객체를 주입하여 생성한다.
			
			server = new ServerSocket(8888);
			System.out.println("서버가 준비중입니다....");
			System.out.println();
			
			//접속을 기다린다.
			socket = server.accept();
			
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			
			sender.start();
			receiver.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
