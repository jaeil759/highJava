package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class BufferedIOTest01 {

	public static void main(String[] args) {
		try {
			//입출력의 성능 향상을 위해서 buffered스트림을 사용한다
			FileOutputStream fout = new FileOutputStream("d:/d_other/bufferTest.txt");
			// 버퍼크기가 5인 버퍼스트림 객체 생성
			// 버퍼크기를 지정하지 않으면 기본 크기가 8KB(8192byte)가 된다.
			BufferedOutputStream bout = new BufferedOutputStream(fout, 5);
			for(int i = '1'; i<='9'; i++) {
				bout.write(i);
			}
//			bout.flush(); // 버퍼에 남아 있는 데이터를 강제로 모두 출력시킨다.
			bout.close(); // 보조스트림을 닫으면 보조스트림에 사용한 기반이 되는 스트림도 자동으로 닫힌다.
			
			System.out.println("작업 끝....");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
