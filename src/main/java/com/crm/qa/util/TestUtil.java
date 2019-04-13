package com.crm.qa.util;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIMEOUT =20;
	public static long IMPLICIT_WAIT =15;
	public static String TESTDATA_SHEET_PATH="C:\\Users\\DELL\\eclipse-workspace\\CRMAutomation\\src\\main\\java\\com\\crm\\qa\\testdata\\TestDataCRM.xlsx";
    public static Workbook book;
    public static Sheet sheet;
	
	
	public void switchToframe(String frameName) 
	{
		driver.switchTo().frame(frameName);
		
		
	}
	
	
	
	public Object[][] getTestDataFromExcel(String SheetName) 
	{
		try {
		FileInputStream file = new FileInputStream(TESTDATA_SHEET_PATH);
		
		 book = WorkbookFactory.create(file);
	     sheet=book.getSheet(SheetName); 
	     
	     Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	     
	     
	     for(int i =0; i<sheet.getLastRowNum();i++) 
	     {
	    	 for(int k =0;k<sheet.getRow(0).getLastCellNum();k++) 
	    	 {
	    		 
	    		 data[i][k]=sheet.getRow(i+1).getCell(k).toString();
	    		 
	    	 }
	    	 
	    	 
	     }
		 
	     return data;
		}
		
		catch(Exception e) 
		{
			System.out.println(e);
			
		}
		return null;
		
		
	}
	
}
