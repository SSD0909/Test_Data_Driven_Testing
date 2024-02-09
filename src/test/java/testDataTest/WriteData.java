package testDataTest;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		FileOutputStream file= new FileOutputStream(System.getProperty("user.dir")+"\\testData\\newfile.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet();
		
		XSSFRow row=sheet.createRow(0);
		XSSFRow row1=sheet.createRow(1);
		
		row.createCell(0).setCellValue("Hello");
		row.createCell(1).setCellValue("123");
		row.createCell(2).setCellValue("xyz");
		
		row1.createCell(0).setCellValue("Hello1");
		row1.createCell(1).setCellValue("321");
		row1.createCell(2).setCellValue("zyx");
		
		workbook.write(file);
		
		file.close();
	
		
	}

}

