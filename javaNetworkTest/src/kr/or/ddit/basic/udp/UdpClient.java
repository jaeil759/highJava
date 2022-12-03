package kr.or.ddit.basic.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpClient {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 수신 받은 데이터가 저장될 byte형 배열 생성
		byte[] bMsg = new byte[1024];
		
		try {
			DatagramSocket socket = new DatagramSocket();
			
			// 접속할 곳의 주소 정보 객체 생성
			InetAddress address = InetAddress.getByName("localhost");
			
			while(true) {
				System.out.println("보낼 메시지 입력 >> ");
				String msg = sc.nextLine();
				
				// 전송용 패킷 객체 생성
				DatagramPacket outpacket = new DatagramPacket(msg.getBytes("utf-8"), msg.getBytes("utf-8").length, address, 8888);
				
				// 데이터 전송
				socket.send(outpacket);
				if("/end".equals(msg)) {
					System.out.println("통신 끝...");
					break;
				}
				//----------------------------------------------
				// 서버에서 온 메시지를 받아서 출력하기
				// 수신용 패킷 객체 생성
				DatagramPacket inPacket = new DatagramPacket(bMsg, bMsg.length);
				
				// 데이터 수신
				socket.receive(inPacket);
				
				System.out.println("서버의 응답 메시지 : " + new String(inPacket.getData(), 0, inPacket.getLength(), "utf-8"));
				System.out.println();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
