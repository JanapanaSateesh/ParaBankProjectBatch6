package com.parabankautomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

	public  static Object[][] getData(String ExcelName, String Sheetname) throws IOException {
		// TODO Auto-generated method stub
       File file=new File("./TestData/"+ExcelName+".xlsx");
       FileInputStream fi=new FileInputStream(file);
       
       XSSFWorkbook workbook=new XSSFWorkbook(fi);
       XSSFSheet sheet= workbook.getSheet(Sheetname);
       int rowCount=  sheet.getPhysicalNumberOfRows();
       int columnCount= sheet.getRow(0).getLastCellNum();
       System.out.println(rowCount);
       System.out.println(columnCount);
       
      Object[][] data=new Object[rowCount-1][columnCount]; //[1][4]
      
      for(int r=0;r<rowCount-1;r++) //0<2, 1<2
      {
    	  XSSFRow row= sheet.getRow(r+1);//1//2
    	  
    	  for(int c=0;c<columnCount;c++) //0,1
    	  {
    		 XSSFCell cell= row.getCell(c);//1,0, [1,1]
    		 CellType  celltype= cell.getCellType();
    		 
    		 switch(celltype) 
    		 {
    		 case STRING: data[r][c]=cell.getStringCellValue();  //data[0][0]="Raju K", data[0][1], 02, 03
    		 break;
    		 
    		 case NUMERIC: data[r][c]=cell.getNumericCellValue();
    		 break;
    		 
    		 case BOOLEAN: data[r][c]=cell.getBooleanCellValue();
    		 break;
    		 
    		 }
    	  }
      }
      
      
      return data;
      
       
	}
}
