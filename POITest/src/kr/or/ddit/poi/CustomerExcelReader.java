package kr.or.ddit.poi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class CustomerExcelReader {
	
	/**
	 * XLS 파일을 분석하여 List<CustomerVoRead> 객체로 반환
	 * @param filePath
	 * @return
	 */
	@SuppressWarnings("resource")
	public List<CustomerVoRead> xlsToCustomerVoReadList(String filePath) {
		
		// 반환할 객체를 생성
		List<CustomerVoRead> list = new ArrayList<CustomerVoRead>();
		
		FileInputStream fis = null;
		HSSFWorkbook workbook = null;
		
		try {
			
			fis= new FileInputStream(filePath);
			// HSSFWorkbook은 엑셀파일 전체 내용을 담고 있는 객체
			workbook = new HSSFWorkbook(fis);
			
			// 탐색에 사용할 Sheet, Row, Cell 객체
			HSSFSheet curSheet;
			HSSFRow   curRow;
			HSSFCell  curCell;
			CustomerVoRead vo;
			
			// Sheet 탐색 for문
			for(int sheetIndex = 0 ; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
				// 현재 Sheet 반환
				curSheet = workbook.getSheetAt(sheetIndex);
				// row 탐색 for문
				for(int rowIndex=0; rowIndex < curSheet.getPhysicalNumberOfRows(); rowIndex++) {
					// row 0은 헤더정보이기 때문에 무시
					if(rowIndex != 0) {
						// 현재 row 반환
						curRow = curSheet.getRow(rowIndex);
						vo = new CustomerVoRead();
						String value;
						
						// row의 첫번째 cell값이 비어있지 않은 경우 만 cell탐색
						if(!"".equals(curRow.getCell(0).getStringCellValue())) {
							
							// cell 탐색 for 문
							for(int cellIndex=0;cellIndex<curRow.getPhysicalNumberOfCells(); cellIndex++) {
								curCell = curRow.getCell(cellIndex);
								
								if(true) {
									value = "";
									// cell 스타일이 다르더라도 String으로 반환 받음
									switch (curCell.getCellType()){
					                case FORMULA:
					                	value = curCell.getCellFormula();
					                    break;
					                case NUMERIC:
					                	value = curCell.getNumericCellValue()+"";
					                    break;
					                case STRING:
					                    value = curCell.getStringCellValue()+"";
					                    break;
					                case BOOLEAN:
					                    value = curCell.getBooleanCellValue()+"";
					                    break;
					                case ERROR:
					                    value = curCell.getErrorCellValue()+"";
					                    break;
					                default:
					                	value = new String();
										break;
					                }
									
									// 현재 column index에 따라서 vo에 입력
									switch (cellIndex) {
									case 0: // 아이디
										vo.setCustId(value);;
										break;
										
									case 1: // 이름
										vo.setCustName(value);;
										break;
										
									case 2: // 나이
										vo.setCustAge(value);
										break;
										
									case 3: // 이메일
										vo.setCustEmail(value);
										break;
		
									default:
										break;
									}
								}
							}
							// cell 탐색 이후 vo 추가
							list.add(vo);
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			try {
				// 사용한 자원은 finally에서 해제
				if( workbook!= null) workbook.close();
				if( fis!= null) fis.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	/**
	 * XLSX 파일을 분석하여 List<CustomerVoRead> 객체로 반환
	 * @param filePath
	 * @return
	 */
	public List<CustomerVoRead> xlsxToCustomerVoReadList(String filePath) { //파라미터는 읽어들일 파일의 경로.
		
		//반환된 데이터를 담아서 반환할 객체 생성
		List<CustomerVoRead> list = new ArrayList<CustomerVoRead>(); 
		
		FileInputStream fis = null;
		XSSFWorkbook workbook = null;
		
		try {
			
			fis= new FileInputStream(filePath);
			// XSSFWorkbook은 엑셀파일 전체 내용을 담고 있는 객체
			//XSSFWorkbook -> XSSFSheet -> XSSFRow -> XSSFCell  
			//1.워크북 -> 2.시트 -> 3. 행 -> 4.셀//의 형태로 데이터가 담겨있기 때문에 
			//워크북을 불러오면 모든 정보가 불러와진다.
			workbook = new XSSFWorkbook(fis); //XSSFWorkbook 객체의 파라미터로 xlsx파일의 워크북 정보가 저장된다.
			
			// 탐색에 사용할 Sheet, Row, Cell 객체
			XSSFSheet curSheet;
			XSSFRow   curRow;
			XSSFCell  curCell;
			CustomerVoRead vo;
			
			// Sheet 탐색 for문					//XSSFWorkbook 객체의 시트 수를 반환하는 getNumberOfSheets()메서드(인덱스는
																									//				1부터 시작)
			for(int sheetIndex = 0 ; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
				// 현재 Sheet 반환
				curSheet = workbook.getSheetAt(sheetIndex);
				
				// row 탐색 for문 //getPhysicalNumberOfRows(); 메서드로 문서의 row수를 알 수 있다.
				for(int rowIndex=0; rowIndex < curSheet.getPhysicalNumberOfRows(); rowIndex++) {
					// row 0은 헤더정보이기 때문에 무시
					if(rowIndex != 0) {
						// 현재 row 반환
						curRow = curSheet.getRow(rowIndex);
						
						vo = new CustomerVoRead(); //vo객체 생성.
						String value;
						
						// row의 첫번째 cell값이 비어있지 않은 경우 만 cell탐색
						if(!"".equals(curRow.getCell(0).getStringCellValue())) {
							
							// cell 탐색 for 문 //getPhysicalNumberOfCells(); 메서드로 현재 row의 셀 수를 알 수 있다.
							for(int cellIndex=0; cellIndex<curRow.getPhysicalNumberOfCells(); cellIndex++) {
								curCell = curRow.getCell(cellIndex);
								
								if(true) {
									value = "";
									// cell 스타일이 다르더라도 String으로 반환 받음
									
								//아파치 POI 3.7버전 이후 셀 데이터에 빈값이 있으면 ERROR가 발생하므로
								//셀 데이터에 빈값이 있으면 안된다.
									
								switch (curCell.getCellType()){ //데이터 타입이 아닌 셀 타입에 대한 switch
					                case FORMULA://수식자체를 가져올때
					                	value = curCell.getCellFormula() + "";
					                    break;
					                
					                case NUMERIC: //정수 또는 소수 값을 저장하는 데이터타입. numeric(10,2) = 정수10자리 소숫점2자리.
					                	value = curCell.getNumericCellValue()+"";		//소수점자리는 특정 값이 없으면 0으로 채워진다.
					                    break;
					                case STRING: //문자타입일때
					                    value = curCell.getStringCellValue()+"";
					                    break;
					                case BLANK: 
					                    value = curCell.getBooleanCellValue()+"";
					                    break;
					                case ERROR:
					                    value = curCell.getErrorCellValue()+"";
					                    break;
					                default:
					                	value = new String();
										break;
					                }
									// 현재 column index에 따라서 vo에 입력
									switch (cellIndex) {
									case 0: // 아이디
										vo.setCustId(value);
										break;
										
									case 1: // 이름
										vo.setCustName(value);
										break;
										
									case 2: // 나이
										vo.setCustAge(value);
										break;
										
									case 3: // 이메일
										vo.setCustEmail(value);
										break;
		
									default:
										break;
									}
								}
							}
							// cell 탐색 이후 vo 추가
							//cell 4개 만들었으면 list에 추가.
							list.add(vo);
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			try {
				// 사용한 자원은 finally에서 해제
				if( workbook!= null) workbook.close();
				if( fis!= null) fis.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
}
