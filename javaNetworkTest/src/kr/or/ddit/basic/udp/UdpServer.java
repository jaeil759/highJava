package kr.or.ddit.basic.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpServer {
	/*
	 *  UDP방식 : 비연결 지향, 신뢰성이 없다, 데이터가 순서대로 도착한다는 보장이 없다.
	 *  		  그렇지만 TCP방식보다 속도가 빠르다.
	 *  
	 *  DatagramSocket객체와 DatagramPacket객체를 이용해서 통신한다.
	 *  - DatagramSocket : 데이터의 송수신과 관련된 작업을 수행한다.(우체부)
	 *  - DatagramPacket : 주고 받는 데이터와 관련된 작업을 수행한다. (소포)
	 *  				   ==> 수신용 생성자와 송신용 생성자를 따로 제공한다.
	 *  
	 *  
	 *  TCP방식은 스트림을 이용해서 송수신하지만
	 *  UDP방식은 Datagram을 이용해서 송수신한다.
	 *  
	 */
	public static void main(String[] args) {
		try {
			// 통신할 포트번호를 지정하여 소켓을 생성한다.
			DatagramSocket socket = new DatagramSocket(8888);

			// 수신용 패킷객체변수와 송신용  패킷객체 변수 선언
			DatagramPacket inpacket, outpacket;

			System.out.println("서버 실행중...");

			while(true) {

				// 수신한 데이터가 저장될 byte형 배열 선언
				byte[] bMsg = new byte[1024];

				// 수신용 패킷객체 생성
				// 		  ==> 데이터가 저장될 byte형 배열, 배열의 길이를 지정하여 생성한다.
				inpacket = new DatagramPacket(bMsg, bMsg.length);

				//데이터를 수신한다. ==> receive()메서드를 이용한다.
				// 이 메서드는 데이터가 올때까지 기다린다.
				// 수신된 데이터의 패킷정보는 지정한 패킷객체 변수에 저장된다.
				socket.receive(inpacket);

				// 수신받은 패킷에서 상대방의 주소, 포트번호 등 알수있다.
				InetAddress address = inpacket.getAddress();
				int port = inpacket.getPort();

				System.out.println("상대방의 IP정보 : " + address);
				System.out.println("상대방의 port번호 : " + port);
				System.out.println();

				// 상대방이 보낸 메시지 출력하기
				// 수신용패킷객체변수.getLength() ==> 실제 수신받은 데이터의 길이를 반환한다.
				// 수신용패킷객체변수.getData() ==> 실제 수신받은 데이터를 byte형 배열로 반환한다.
				// 					--> 수신받은 데이터는 수신용 패킷객체를 생성할때 지정한 byte형 배열에도 저장된다.
				// 수신받은 데이터는 byte형 배열이기 때문에 String으로 변환해서 출력해야 한다.
				String msg = new String(bMsg, 0, inpacket.getLength(), "utf-8"); // 방법1
				//				String msg = new String(inpacket.getData(), 0, inpacket.getLength(), "utf-8"); // 방법2
				
				// 수신받은 메시지가 '/end' 이면 통신을 멈춘다.
				if("/end".equals(msg)) {
					break; // 반복문 탈출...
				}
				
				System.out.println("상대방이 보낸 메세지 : " + msg);
				System.out.println();

				// ------------------------------------------------------------------------------

				// 상대방에게 메세지 보내기(수신받은 메세지를 그대로 송신한다.)

				// 송신할 메세지를 byte형 배열로 변환한다.
				byte[] sendMsg = msg.getBytes("utf-8");

				//송신용 패킷 객체 생성
				//		==> 전송할 데이터가 저장된 byte형 배열, 전송할 데이터의 길이(배열의 길이)
				//			상대방의 주소 정보,상대방의 포트번호, 이렇게 4가지를 지정하여 생성한다.
				outpacket = new DatagramPacket(sendMsg, sendMsg.length, address, port);

				// 데이터 송신하기 ==> send()메서드 이용
				//				==> 전송할 데이터 정보가 들어있는 패킷을 인수값으로 넣어준다.
				socket.send(outpacket);
				System.out.println("송신 완료...");

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
