package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient01 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// 현재 자신의 컴퓨터를 나타내는 방법
		// 1) 원래의 IP 주소 : 예) 192.168.144.10
		// 2) 지정된 IP 주소 : 127.0.0.1
		// 3) 원래의 컴퓨터 이름 : 예) DESKTOP-ADHCFPN
		// 4) 지정된 컴퓨터 이름 : localhost
		
		String serverIp = "localhost";
		System.out.println(serverIp + "에 연결중입니다...");
		System.out.println();
		
		// 서버의 IP주소와 Port번호를 지정하여 Socket객체를 생성한다.
		// Socket객체는 생성이 완료되면 
		Socket socket = new Socket(serverIp, 7777);
		
		// 이 부분 이후의 내용은 서버와 연결된 이후에 처리할 내용들이다.
		System.out.println("서버에 연결되었습니다...");
		System.out.println();
		
		// 서버가 보낸 메세지를 받아서 화면에 출력하기
		// Socket객체를 이용하여 입력용 스트림 객체를 구한다 (getInputStream()메서드 이용)
		InputStream in = socket.getInputStream();
		DataInputStream din = new DataInputStream(in);
		
		//메세지를 읽어온다 ( 수신작업)
		System.out.println("서버에서 보내온 메세지 : " + din.readUTF());
		System.out.println();
		System.out.println("연결을 종료합니다");
		
		// 소켓과 스트림닫기
		din.close();
		socket.close();
		
	}

}
