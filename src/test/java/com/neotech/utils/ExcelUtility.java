package com.neotech.utils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static Object[][] excelIntoArray(String filePath, String sheetName) {
		try {

			// open a channel to the excel file
			FileInputStream fis = new FileInputStream(filePath);
			Workbook book = new XSSFWorkbook(fis);

			Sheet sheet = book.getSheet(sheetName);

			int rowNumber = sheet.getPhysicalNumberOfRows();
			int colNumber = sheet.getRow(0).getLastCellNum();

			Object[][] data = new Object[rowNumber -1][colNumber];

			for (int row = 1; row < rowNumber; row++) {
				for (int col = 0; col < colNumber; col++) {
					String cellData = sheet.getRow(row).getCell(col).toString();
					data[row - 1][col] = cellData;
				}
			}
			
			return data;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
