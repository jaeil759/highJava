package kr.or.ddit.basic.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer01 {

	public static void main(String[] args) throws IOException {
		//TCP 소켓통신을 하기 위해 SERVERSOCKET객체를 생성한다
		ServerSocket server = new ServerSocket(7777);
		System.out.println("서버가 준비되었습니다..");
		System.out.println("접속을 기다립니다...");
		System.out.println();
		
		// accept()메서드 ==> 클라이언트의 연결 요청이 올때까지 계속 기다린다.
		// 				  ==> 연결요청이 오면 새로운 Socket 객체를 생성해서 클라이언트의 Socket과 연결한다.
		Socket socket = server.accept();
		
		// accept() 메서드 이후의 내용은 클라이언트와 연결이 완료된 후로 생각하면 된다.
		System.out.println("클라이언트와 연결이 되었습니다.");
		System.out.println();
		
		// Socket을 이용해서 접속 정보를 확인해보기
		
		// 상대방의 정보 출력하기
		System.out.println("접속한 상대(클라이언트) 정보");
		System.out.println("IP 주소 : " + socket.getInetAddress().getHostAddress());
		System.out.println("Port번호 : " + socket.getPort());
		System.out.println();
		
		//연결된 자신의 정보 출력하기
		System.out.println("연결된 자신(서버) 정보");
		System.out.println("IP 주소 : " + socket.getLocalAddress());
		System.out.println("Port 번호 : " + socket.getLocalPort());
		System.out.println();
		
		// 연결된 클라이언트에게 메세지 보내기
		//  ==> Socket의 OutputStream을 이용하여 데이터를 전송한다.(getOutputStream() 메서드이용)
		OutputStream out = socket.getOutputStream();
		DataOutputStream dout = new DataOutputStream(out);
		
		// 메세지 출력하기( ==> 상대방에게 전송하기)
		dout.writeUTF("환영합니다. 어서오세요....");
		
		System.out.println("메세지를 보냈습니다.");
		
		// 소켓과 스트림 닫기
		dout.close();
		socket.close();
		server.close();
		
		
		
		
		
		
	}

}
