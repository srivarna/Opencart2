 package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.streaming.DeferredSXSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook WorkBook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;

	public ExcelUtility(String path) {
		this.path = path;
	}

//gettters
	public int getRowcount(String sheetName) throws IOException {
		fi = new FileInputStream(path);
		WorkBook = new XSSFWorkbook(fi);
		sheet = WorkBook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		WorkBook.close();
		fi.close();
		return rowCount;

	}

	public int getCellCount(String sheetName, int rownum) throws IOException {
		fi = new FileInputStream(path);
		WorkBook = new XSSFWorkbook(fi);
		sheet = WorkBook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		int cellCount = row.getLastCellNum();
		WorkBook.close();
		fi.close();
		return cellCount;

	}
	// to know t he cell data need row data and cell data..

	public String getCellData(String sheetName, int rownum, int colnum) throws IOException {

		fi = new FileInputStream(path);
		WorkBook = new XSSFWorkbook(fi);
		sheet = WorkBook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);

		DataFormatter formatter = new DataFormatter();
		String data;
		try {
			data = formatter.formatCellValue(cell);// returns the formatter value of a cell regardless of string

		} catch (Exception e) {
			data = "";
		}
		WorkBook.close();
		fi.close();
		return data;
	}

	public void setCellData(String sheetName, int rownum, int colnum, String data) throws IOException {
		File xlfile = new File(path);
		if (!xlfile.exists()) {// if file not exists create a file
			WorkBook = new XSSFWorkbook();
			fo = new FileOutputStream(path);
			WorkBook.write(fo);
		}
		fi = new FileInputStream(path);
		WorkBook = new XSSFWorkbook(fi);
		if (WorkBook.getSheetIndex(sheetName) == -1) {// if sheet not exists then create a sheet
			WorkBook.createSheet(sheetName);
			sheet = WorkBook.getSheet(sheetName);
			if (sheet.getRow(rownum) == null)// if row not exists create row
				sheet.createRow(rownum);
			row = sheet.getRow(rownum);// storing in row

			cell = row.createCell(colnum);
			cell.setCellValue(data);
			fo = new FileOutputStream(path);

			WorkBook.write(fo);
			WorkBook.close();
			fi.close();
			fo.close();
			
		}

		else {

		}

	}

}