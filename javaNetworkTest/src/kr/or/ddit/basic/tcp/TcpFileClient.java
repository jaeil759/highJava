package kr.or.ddit.basic.tcp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpFileClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		String serverIp = "192.168.144.10"; 
		System.out.println(serverIp+"서버에 연결중입니다.");
		System.out.println();
		
		Socket socket = new Socket(serverIp, 7777); 
		
		System.out.println("서버에 연결되었습니다.");
		System.out.println();
		
		try {
			
			
			InputStream is = socket.getInputStream(); 
            
			
			
			FileOutputStream fo 
                        = new FileOutputStream("d:/d_Other/upload/별빛등대.png"); 
		
			int c;
			
			while((c=is.read())!=-1){
				fo.write(c);
			}
			
	
			fo.close();
			is.close();
			
			socket.close();
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}