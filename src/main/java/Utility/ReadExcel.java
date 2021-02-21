package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel {
	
	public static ArrayList<String> ExcelReader(String sheetname,String excelname) throws IOException {
		
		ArrayList<String> list = new ArrayList<String>();
		
		String excelFilePath = System.getProperty("user.dir")+ "\\" + excelname;
		String fileName = excelname;
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        String fileExtensionName = fileName.substring(fileName.indexOf("."));
        Workbook workbook = null;
        System.out.println(fileExtensionName);
        try {
            if (fileExtensionName.equals(".xlsx")) {
                workbook = new XSSFWorkbook(inputStream);
            } else if (fileExtensionName.equals(".xls")) {
                workbook = new HSSFWorkbook(inputStream);

            }
        } catch (NullPointerException e) {
            System.out.println(e);
        }
        
        org.apache.poi.ss.usermodel.Sheet newsheet = workbook.getSheet(sheetname);
        int rowCount = newsheet.getLastRowNum();
        System.out.println(rowCount);
        for (int i = 2; i < rowCount+1; i++) {
        	
        	Row row = newsheet.getRow(i);
        	list.add(row.getCell(4).getStringCellValue());
        	        				
		}
        
        return list;
	}
	
//	public static void main(String...strings) throws IOException {
//		
//		System.out.println(ExcelReader("sheet1","Vamsi_Test sim 1_BatchAssessmentPerformanceReport_46784.xlsx"));
//		
//	}

}
