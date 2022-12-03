package kr.or.ddit.poi;
import java.util.List;



public class MainApplicationRead {
	
	public static void main(String[] args) {
		
		CustomerExcelReader excelReader = new CustomerExcelReader();
		
		
		System.out.println("*****xlsx*****");
		List<CustomerVoRead> xlsxList = excelReader.xlsxToCustomerVoReadList("D:/D_other/testWrite.xlsx");
		
		
		printList(xlsxList );
	}
	
	public static void printList(List<CustomerVoRead> list) {
		CustomerVoRead vo;
		
		for (int i = 0; i < list.size(); i++) {
			vo = list.get(i);
			System.out.println(vo.toString());
		}
	}
}
