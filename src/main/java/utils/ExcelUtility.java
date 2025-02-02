package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtility {
	
	private static Workbook workbook;
	
	private static Sheet sheet;
	
	private static FileInputStream fileInputStream;
	
	public static void initializeExcel(String filePath,String sheetName) throws IOException
	{
		fileInputStream = new FileInputStream(new File("src/test/resources/ExcelData2.xlsx"));
		
		workbook = new XSSFWorkbook(fileInputStream);
		
		sheet = workbook.getSheet(sheetName);
		//test
		
	}
	
	public static String getCellData(int row,int column)
	{
		Row r = sheet.getRow(row);
		
		Cell c = r.getCell(column);
		
		return c.getStringCellValue();
	}
	
	   
    public static void setCellData(int row, int column, String data) throws IOException {
        Row r = sheet.getRow(row);
        if (r == null) {
            r = sheet.createRow(row);
        }
        Cell c = r.createCell(column);
        c.setCellValue(data);
        FileOutputStream fileOut = new FileOutputStream("src/test/resources/ExcelData3.xlsx");
        workbook.write(fileOut);
        fileOut.close();
    }

    
    public static int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    // Close the Excel file
    public static void closeExcel() throws IOException {
        fileInputStream.close();
        workbook.close();
    }

}
