package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	//public static WebDriver driver;    
	
	 public static void captureScreenshot(WebDriver driver,String testID) throws IOException  {
		 
		 TakesScreenshot ts=(TakesScreenshot) driver;
		 File src=ts.getScreenshotAs(OutputType.FILE);
		 Date date=new Date();
		// Random random= new Random();
		 
		 String FileName = date.toString().replace(" ","_").replace(":", " ") ;
		 File dest= new File("test-output\\failedScreeshots\\Test"+testID+" "+FileName+".jpg");
		 FileHandler.copy(src,dest );
}
	 
	 public static String getExcelData(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException {
		 String path= "src/main/resources/data/testdata.xlsx";
			FileInputStream file= new FileInputStream(path);
		Workbook book= WorkbookFactory.create(file);
		Sheet sheet= book.getSheet(sheetName);
		Row row= sheet.getRow(rowNo);
		Cell cell=row.getCell(cellNo);
		
		String excelData;
		try {
		 excelData=cell.getStringCellValue();
		 }
		catch(IllegalStateException e) {
			double value=cell.getNumericCellValue();
			//System.out.println(value);
			//excelData=String.valueOf(value);
			excelData=Double.toString(value);
			
		}
		return excelData;
		 
	 }
}
