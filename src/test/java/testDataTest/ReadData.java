package testDataTest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"\\testData\\data.xlsx");

XSSFWorkbook workbook=new XSSFWorkbook(file);

XSSFSheet sheet =workbook.getSheet("Sheet1");//index of sheet xwb.getSheetAt(0);

int totalrows = sheet.getLastRowNum();
int totalcells=sheet.getRow(1).getLastCellNum();

System.out.println("Number of rows"+totalrows);

System.out.println("Number of cells"+totalcells);
	}

}
	