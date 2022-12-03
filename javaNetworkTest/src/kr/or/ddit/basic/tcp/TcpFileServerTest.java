package kr.or.ddit.basic.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// 클라이언트가 보내온 파일내용을 받아서 'd:/d_other/downFiles'폴더에 저장한다
public class TcpFileServerTest {
	private ServerSocket server;
	private Socket socket;
	private DataInputStream din;
	private BufferedInputStream bin;
	private BufferedOutputStream bout;
	public static void main(String[] args) {
		new TcpFileServerTest().serverStart();
	}
	public void serverStart() {
		// 저장할 폴더 정보를 갖는 File객체 생성
		File saveDir = new File("d:/d_other/downFiles");
		if(!saveDir.exists()) { // 저장폴더가 없으면...
			saveDir.mkdirs(); // 저장폴더를 새로만든다.
		}
		try {
			server = new ServerSocket(7777);
			System.out.println("서버가 준비되었습니다...");
			System.out.println();
			socket = server.accept();
			System.out.println("파일 수신 시작...");
			
			//클라이언트가 접속이 완료되면 첫번째로 보내는 '파일명'을 수신하기위한 스트림 객체 생성 
			din = new DataInputStream(socket.getInputStream());
			
			String fileName = din.readUTF(); // 파일명 수신
			
			// 저장할 폴더와 파일명을 지정하여 File객체 생성
			File file = new File(saveDir, fileName); 
			
			// 파일내용 수신용 스트림 객체 생성
			bin = new BufferedInputStream(din);
			
			// 파일 저장용 스트림 객체 생성
			bout = new BufferedOutputStream(new FileOutputStream(file));
			
			byte[] tmp = new byte[1024];
			int length = 0;
			
			while((length=bin.read(tmp)) > 0) {
				bout.write(tmp, 0, length);
			}
			bout.flush();
			System.out.println("파일 수신 및 저장 완료");
			
		} catch (Exception e) {
			System.out.println("파일 수신 작업 실패!!");
		}finally {
			if(din!=null) try {din.close();}catch(IOException e) {}
			if(bout!=null) try {bout.close();}catch(IOException e) {}
			if(bin!=null) try {bin.close();}catch(IOException e) {}
			if(socket!=null) try {socket.close();}catch(IOException e) {}
			if(server!=null) try {server.close();}catch(IOException e) {}
			
		}
	}
}
