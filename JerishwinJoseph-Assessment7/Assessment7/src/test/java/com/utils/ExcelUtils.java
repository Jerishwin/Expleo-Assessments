package com.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	
	@DataProvider(name="newSignupData")
	public Object[][] excelDataProvider() throws IOException{
		Object[][] data = getExcelData("E:\\JerishwinJoseph-Assessment7\\Assessment7\\src\\test\\resources\\data.xlsx","Sheet1");
		return new Object[][] {data[0]};
	}
	
	@DataProvider(name="loginData")
	public Object[][] excelData() throws IOException{
		Object[][] data = getExcelData("E:\\JerishwinJoseph-Assessment7\\Assessment7\\src\\test\\resources\\data.xlsx","Sheet2");
		return new Object[][] {data[0]};
	}
	
	@DataProvider(name="invalidloginData")
	public Object[][] excelDatainvalid() throws IOException{
		Object[][] data = getExcelData("E:\\JerishwinJoseph-Assessment7\\Assessment7\\src\\test\\resources\\data.xlsx","Sheet2");
		return new Object[][] {data[1]};
	}
	
	public String[][] getExcelData(String fileName,String sheetName)throws IOException{
		String[][]data = null;
		try {
			FileInputStream fis = new FileInputStream(fileName);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			XSSFRow row = sheet.getRow(0);
			int noOfRows = sheet.getPhysicalNumberOfRows();
			int noOfCols = row.getLastCellNum();
			Cell cell;
			data = new String[noOfRows-1][noOfCols];
			
			for(int i=1;i<noOfRows;i++) {
				for(int j=0;j<noOfCols;j++) {
					row = sheet.getRow(i);
					cell=row.getCell(j);
					data[i-1][j]=cell.getStringCellValue();
				}
			}
			workbook.close();
			
		}catch(Exception e) {
			System.out.println("The exception is: "+e.getMessage());
		}
		
		return data;
	}
}

