package com.ultils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public static class ExcelFileReader {

		static XSSFWorkbook workbook;
		static XSSFSheet sheet;

		public ExcelFileReader() {
			try {
				File file = new File(System.getProperty("user.dir")+"/DataProvider/testData.xlsx");
				FileInputStream fileInput = new FileInputStream(file);
				try {
					workbook = new XSSFWorkbook(fileInput);
				} catch (IOException e) {
					e.printStackTrace();
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		public static String getDataString(int index, int rowNum, int cellNum) {

			sheet = workbook.getSheetAt(index);
			String data = sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();

			return data;
		}
		public static double getDataNumeric(int index, int rowNum, int cellNum) {

			sheet = workbook.getSheetAt(index);
			double data = sheet.getRow(rowNum).getCell(cellNum).getNumericCellValue();

			return data;
		}
		public int totalRowsinSheet(int sheet) {
			int rowCount = workbook.getSheetAt(0).getLastRowNum();
//			System.out.println("Total number of Row Count in sheet is: " + rowCount);
			return rowCount;
		}

		public int totalColsinSheet(int sheetIndex) {
			int colCount = workbook.getSheetAt(sheetIndex).getRow(1).getLastCellNum();

			return colCount;
		}

		public static void main(String[] args) {
			ExcelFileReader reader = new ExcelFileReader();
			
			System.out.println("Total number of Row Count in sheet is :" + reader.totalRowsinSheet(0));
			System.out.println("Total number of Column Count in sheet is :" + reader.totalColsinSheet(0));
			
			System.out.println("Data is: "+ getDataNumeric(0,2,1) );

		}
	}
}