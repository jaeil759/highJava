package kr.or.ddit.basic.tcp;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

// 이 쓰레드 클래스는 소켓을 통해서 메세지를 전송하는 역할을 한다.
public class Sender extends Thread {
	private Socket socket;
	private DataOutputStream dout;
	private String name;
	private Scanner scan;
	
	
	public Sender(Socket socket) {
		this.socket = socket;
		scan = new Scanner(System.in);
		
		System.out.println("이름 입력 >> ");
		name = scan.nextLine();
		
		try {
			dout = new DataOutputStream(socket.getOutputStream());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Override
	public void run() {
		while(dout!=null) {
			try {
				dout.writeUTF(name + " " + scan.nextLine());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
