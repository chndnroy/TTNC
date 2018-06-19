package satguru.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static final String filepath = "/home/ttuser10/Desktop/GoogleUAT.xlsx";

public static String readData(String sheetname,int rowNum, int cellNum) 
{
	String data="";
	try{
		XSSFWorkbook h=new XSSFWorkbook("/home/ttuser10/Desktop/GoogleUAT.xlsx");
		XSSFSheet sheet=h.getSheet(sheetname);
		data=sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
		
	}
	catch(EncryptedDocumentException e){
		e.printStackTrace();
		
	}
	catch (IOException e) {
		e.printStackTrace();
	}
	return data;


	
	

}
public static void writeData(String sheetname, int rowNum, int cellNum, String data) {
	 
	try {
		FileInputStream file = new FileInputStream(new File(filepath));

		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		Cell cell = null;
		cell = sheet.getRow(rowNum).getCell(cellNum);
 		cell.setCellValue(data);

		file.close();
		
		FileOutputStream outFile =new FileOutputStream(new File(filepath));
		workbook.write(outFile);
		System.out.println(cell.getStringCellValue());
		outFile.close();
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}



