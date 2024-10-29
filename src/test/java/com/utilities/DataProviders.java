package com.utilities;

import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.annotations.DataProvider;

public class DataProviders {
	//contains dataproviders methods 
	//DataProviders
	
	@DataProvider(name="LoginData")
	public String [][]getData() throws IOException {
		
		String path="./Opencart2/testData/Book 1(Sheet1).csv";
		ExcelUtility xlUtil=new ExcelUtility(path);
		
		int totalRows=xlUtil.getRowcount("sheet1");
		int totalcols=xlUtil.getCellCount("sheet1",1);
		String logindata[][]=new String[totalRows][totalcols];
		
		for(int i=1;i<=totalRows;i++)//1 is row header
		{
			for(int j=0;j<=totalcols;j++) {// colmns start with 0
			
				// by the above loops raeding data from row=0 and col=1
				//strong into logindata array below
				logindata[i-1][j]=xlUtil.getCellData(path,i, j);
			
			}
			}
			return logindata;//returning two dimensional array
		}
		
	}


