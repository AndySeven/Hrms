package com.hrms.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	private static FileInputStream fis;
	private static Workbook book;
	private static Sheet sheet;

	public static void readExcel(String filePath) {
		try {
			fis = new FileInputStream(filePath);
			book = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Sheet getSheet(String sheetName) {
		sheet = book.getSheet(sheetName);
		return sheet;
	}

	public static int getNumberRows() {
		return sheet.getPhysicalNumberOfRows();
	}

	public static int getNumberCols(int row) {
		return sheet.getRow(row).getLastCellNum();
	}
	
	public static String cellData(int rowIndex, int colIndex) {
		return sheet.getRow(rowIndex).getCell(colIndex).toString();
	}

	public static Object[][] getExcelData(String filePath, String sheetName) {
		readExcel(filePath);
		getSheet(sheetName);
		int rows = getNumberRows();
		int cols = getNumberCols(0);
		Object[][] data = new Object[rows - 1][cols];
		for (int r = 1; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				data[r - 1][c] = sheet.getRow(r).getCell(c).toString();
			}
		}
		return data;
	}
	public static String getExcelCellValue(String filePath, String sheetName, int row, int col ) {
		readExcel(filePath);
		sheet = getSheet(sheetName);
		String cellValue = sheet.getRow(row).getCell(col).toString();
		return cellValue;
	}
	
	
	public static List<Map<String, String>> excelIntoListOfMaps(String filePath, String sheetName){
		
		readExcel(filePath);
		getSheet(sheetName);
		
		List<Map<String, String>> listMap = new ArrayList<>();
		Map<String, String> excelMap;
		
		for(int r=1; r<getNumberRows(); r++) {
			excelMap = new LinkedHashMap<>();
			for(int c=0; c<getNumberCols(r); c++) {
				excelMap.put(cellData(0, c), cellData(r,c));
			}
			listMap.add(excelMap);
		}
		return listMap;
	}
	
	

}
