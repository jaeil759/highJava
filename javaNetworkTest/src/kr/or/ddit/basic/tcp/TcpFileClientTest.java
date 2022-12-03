package kr.or.ddit.basic.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class TcpFileClientTest {

	private Socket socket;
	private BufferedInputStream bin;
	private BufferedOutputStream bout;
	private DataOutputStream dout;
	public static void main(String[] args) {
		new TcpFileClientTest().clientStart();
	}
	public void clientStart() {
	File file = new File("d:/d_other/별빛등대.png");
	
	String fileName = file.getName();
	if(!file.exists()) {
		System.out.println(fileName + "파일이 없습니다.");
		System.out.println("전송작업을 종료합니다...");
		return;
		}
		try {
			socket = new Socket("localhost", 7777);
			System.out.println("파일 전송 시작...");
			// 서버에 접속하면 클라이언트는 맨처음 '파일명'을 서버로 전송한다.
			dout = new DataOutputStream(socket.getOutputStream());
			
			dout.writeUTF(fileName); // 파일명 전송
			
			// 파일명 전송이 끝나면 파일 내용을 읽어서 서버로 전송한다.
			
			// 파일 읽기용 스트림 객체 생성
			bin = new BufferedInputStream(new FileInputStream(file));
			
			// 서버로 전송할 출력용 스트림 객체 생성
			bout = new BufferedOutputStream(dout);
			
			// 실제 파일내용을 읽어서 서버로 출력한다.
			byte[] tmp = new byte[1024];
			int length = 0;
			
			while((length = bin.read(tmp)) > 0) {
				bout.write(tmp, 0, length);
				
			}
			bout.flush();
			System.out.println("파일전송 완료...");
		} catch (Exception e) {
			System.out.println("파일 전송 실패!!");
			e.printStackTrace();
		}finally {
			if(dout!=null) try {dout.close();}catch(IOException e) {}
			if(bout!=null) try {bout.close();}catch(IOException e) {}
			if(bin!=null) try {bin.close();}catch(IOException e) {}
			if(socket!=null) try {socket.close();}catch(IOException e) {}
		}
	}
}
