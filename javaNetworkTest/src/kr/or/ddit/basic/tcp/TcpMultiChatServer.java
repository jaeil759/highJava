package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TcpMultiChatServer {
	// 접속한 클라이언트 정보를 저장할 변수 선언 ==> (List, 배열, Map, Set 을사용할수있다.) Map객체를 이용하여 처리하는 예제
	// ==> key값 : 접속한 사람 이름, value 값 : 접속한 Socket객체 
	private Map<String, Socket> clientMap;

	public TcpMultiChatServer() {
		//Map객체를 동기화 처리한다.
		clientMap = Collections.synchronizedMap(new HashMap<String, Socket>());
	}


	public static void main(String[] args) {
		new TcpMultiChatServer().serverStart();
	}

	//시작 메서드
	public void serverStart() {
		ServerSocket server = null;
		Socket socket = null;
		try {
			server = new ServerSocket(7777);
			System.out.println("서버가 시작되었습니다...");

			while(true) {
				socket = server.accept(); // 클라이언트의 접속을 기다린다...

				System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "] 에서 접속했습니다....");
				System.out.println();

				//쓰레드 객체를 생성해서 쓰레드를 실행시킨다.
				ServerReceiver serverThread = new ServerReceiver(socket);
				serverThread.start();

			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(server!=null)try {server.close();}catch(IOException e){}
		}

	} // 시작메서드 끝...

	// clientMap 에 저장된 전체 접속자에게 메세지를 전송하는 메서드
	private void sendToAll(String msg) {
		// clientMap의 데이터 개수만큼 반복
		for(String name : clientMap.keySet()) {
			try {
				// key값에 대응하는 Socket객체를 이용하여 출력용 스트림객체를 생성한다
				DataOutputStream dout = new DataOutputStream(clientMap.get(name).getOutputStream());

				// 메세지를 출력한다.
				dout.writeUTF(msg);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	} // sendToAll()메서드 끝,,,

	//----------------------------------------------------------------------------------------
	// Inner Class로 서버에서 클라이언트로 메세지를 전송하는 Thread를 작성한다.
	class ServerReceiver extends Thread{
		private Socket socket;
		private DataInputStream din; 
		private DataOutputStream dout;

		public ServerReceiver(Socket socket) {
			this.socket = socket;

			// 송신용 수신용 스트림 객체 생성
			try {
				// 수신용
				din = new DataInputStream(socket.getInputStream());

				//송신용
				dout = new DataOutputStream(socket.getOutputStream());

			} catch (Exception e) {
				// TODO: handle exception
			}
		}//생성자 끝


		@Override
		public void run() {
			String name = "";
			try {
				// 클라이언트가 연결이 성공되면 첫번째로 '대화명'을 입력받아서 서버로 보낸다
				// 서버에서는 이 '대화명'이 중복되는지 여부를 검사해서 검사결과를 응답으로 클라이언트에게 보낸다.

				// 클라이언트가 보내온 '대화명' 이 중복되지않을때까지 반복한다.

				while(true) {
					name = din.readUTF(); // 클라이언트가 보낸 '대화명'받기

					if(clientMap.containsKey(name)) { // '대화명'이 있으면...(중복되면...)
						dout.writeUTF("대화명중복"); // '대화명중복' 이라는 메세지를 출력한다.

					}else {
						dout.writeUTF("OK"); // "OK" 메세지 전송
						break; //반복문 탈출...
					}

				} // while문 끝...
				// 접속한 사람의 '대화명'을 이용하여 다른 전체 클라이언트에게 대화명 참여 메세지를 전송한다.
				sendToAll("[" + name + "] 님이 대화방에 입장했습니다." );
				//대화명과 접속한 클라이언트의 Socekt객체를 Map에 추가하였습니다.
				clientMap.put(name, socket);
				System.out.println("현재 접속자 수 : " + clientMap.size() + "명.");

				// 한 클라이언트가 보낸 메세지를 받아서 전체 클라이언트에게 보내준다...
				while(din != null) {
					sendToAll(din.readUTF());
				}
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				// 이 finally영역이 실행된다는 것ㅅ은 클라이언트가 접속을 종료했다는 의미이다..
				sendToAll("[" + name + "] 님이 접속을 종료하였습니다.");
				clientMap.remove(name);
				System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "] 에서 접속을 종료했습니다....");
				System.out.println("현재 접속자 수 : " + clientMap.size() + "명.");
				System.out.println();
			}
		}

	}

}
