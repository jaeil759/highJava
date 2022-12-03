package kr.or.ddit.poi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class CustomerExcelWriter {
	
	///////////////////////////////////////////////////////////////////////////////////////////
	//순서대로 1.워크북 생성 -> 2.시트 생성 -> 3. 행 생성 -> 4.셀 생성 (탐색의 순서도 동일하다.)
	//xls : HSSFWorkbook생성->HSSFSheet생성->HSSFRow생성->HSSFCell생성 
	public void xlsWiter(List<CustomerVoWrite> list) {
		// 워크북 생성
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 워크시트 생성
		HSSFSheet sheet = workbook.createSheet();
		// 행 생성
		HSSFRow row = sheet.createRow(0);
		// 쎌 생성
		HSSFCell cell;
		
		// 헤더 정보 구성
		cell = row.createCell(0);
		cell.setCellValue("아이디");
		
		cell = row.createCell(1);
		cell.setCellValue("이름");
		
		cell = row.createCell(2);
		cell.setCellValue("나이");
		
		cell = row.createCell(3);
		cell.setCellValue("이메일");
		
		// 리스트의 size 만큼 row를 생성
		CustomerVoWrite vo;
		for(int rowIdx=0; rowIdx < list.size(); rowIdx++) {
			vo = list.get(rowIdx);
			
			// 행 생성
			row = sheet.createRow(rowIdx+1);
			
			cell = row.createCell(0);
			cell.setCellValue(vo.getCustId());
			
			cell = row.createCell(1);
			cell.setCellValue(vo.getCustName());
			
			cell = row.createCell(2);
			cell.setCellValue(vo.getCustAge());
			
			cell = row.createCell(3);
			cell.setCellValue(vo.getCustEmail());
			
		}
		
		// 입력된 내용 파일로 쓰기
		File file = new File("D:/D_other/testWrite.xlsx");
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream(file);
			workbook.write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(workbook!=null) workbook.close();
				if(fos!=null) fos.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	///////////////이게 최신/////////////////////////////////////////////////////////////////////////////
	//순서대로 1.워크북 생성 -> 2.시트 생성 -> 3. 행 생성 -> 4.셀 생성 (탐색의 순서도 동일하다.)
	//xlsx : XSSFWorkbook생성->XSSFSheet생성->XSSFRow생성->XSSFCell생성  
	
	public void xlsxWiter(List<CustomerVoWrite> list) {
		// 워크북 생성
		XSSFWorkbook workbook = new XSSFWorkbook();
		// 워크시트 생성
		XSSFSheet sheet = workbook.createSheet();
		// 행 생성
		XSSFRow row = sheet.createRow(0);
		// 쎌 생성
		XSSFCell cell;
		
		// 헤더 정보 구성( DB로 치면 컬럼명 )
		cell = row.createCell(0);
		cell.setCellValue("아이디"); 
		
		cell = row.createCell(1);
		cell.setCellValue("이름");
		
		cell = row.createCell(2);
		cell.setCellValue("나이");
		
		cell = row.createCell(3);
		cell.setCellValue("이메일");
		
		// 리스트의 size 만큼 row를 생성 
		CustomerVoWrite vo; //행 추가 vo
		
		for(int rowIdx=0; rowIdx < list.size(); rowIdx++) {
			vo = list.get(rowIdx); //list의 데이터를 vo에 넣어준다.
			
			// 행 생성
			row = sheet.createRow(rowIdx+1); //+1하는 이유는 0번째 행에는 헤더 정보가 들어가있음.
			//실제 엑셀 사용과 달리 행이 미리 만들어져있지 않으므로
			//데이터를 추가하기위해선 우선 행을 추가해야함
			
			
			cell = row.createCell(0); //아이디 //row행의 0번째 열에 cell을 만들겠다.
			cell.setCellValue(vo.getCustId());
			
			
			cell = row.createCell(1); //이름 //row행의 1번째 열에 cell을 만들겠다.
			cell.setCellValue(vo.getCustName());
			
			
			cell = row.createCell(2); //나이 //row행의 2번째 열에 cell을 만들겠다.
			cell.setCellValue(vo.getCustAge());
		
			
			cell = row.createCell(3); //이메일 //row행의 3번째 열에 cell을 만들겠다.
			cell.setCellValue(vo.getCustEmail());
			
		}
		
		// 입력된 내용 파일로 쓰기
		File file = new File("D:/D_other/testWrite.xlsx"); //원하는 경로 지정
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream(file);
			//workbook객체의 write()메서드를 이용해서 fos에 엑셀 데이터를 담는다.
			workbook.write(fos); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(workbook!=null) workbook.close();
				if(fos!=null) fos.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
