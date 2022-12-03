package kr.or.ddit.basic.tcp;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpFileServer {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(8888);
			
			System.out.println("서버가 준비중입니다.");
			Socket socket = server.accept();
			
			System.out.println("클라이언트와 연결이 완료되었습니다.");
			System.out.println();
			
					
			File file = new File("d:/d_Other/별빛등대.png");
			FileInputStream f = new FileInputStream(file); 
                        
			
			OutputStream is = socket.getOutputStream(); 
                     
			
			int c;
			
			// is에 툐끼파일을 담았슴미다
			while((c=f.read())!=-1){
				is.write(c); //c의 내용을 출력할 수 있도록 is에.
			}
			
			socket.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}