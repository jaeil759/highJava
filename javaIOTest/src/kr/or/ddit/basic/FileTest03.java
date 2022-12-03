package kr.or.ddit.basic;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest03 {

	public static void main(String[] args) {
		FileTest03 test  = new FileTest03();
		
		File file = new File("c:/windows");
				
		test.displayFileList(file);
	}
	public void displayFileList(File dir) {
		if(!dir.isDirectory()) {
			System.out.println("디렉토리(폴더) 만 가능합니다.");
			return;
		}
		System.out.println("[" + dir.getAbsolutePath() + "] 디렉토리 내용");
		
		//해당 디렉토리 안에 있는 모든 파일과 디렉토리 목록을 구해서 가져온다.
		File[] files = dir.listFiles();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		
		// 가져온 파일과 디렉토리 목록 개수만큼 반복
		for(File file : files) {
			String fileName = file.getName();
			String attr = "";
			String size = "";
			
			if(file.isDirectory()) {
				attr = "<DIR>";
			}else {
				attr = file.canRead() ? "R" : "";
				attr += file.canWrite() ? "W" : "";
				attr += file.isHidden() ? "H" : "";
				
				size = file.length() + "";
			}
			System.out.printf("%s %5s %12s %s\n", df.format(new Date(file.lastModified())), attr,size,fileName);
			
		}
		
	}

}
