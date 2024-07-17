import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingDataExcel {

	public static void main(String[] args) throws IOException 
	{
		//Create an object of fileInputstream
		FileInputStream fis = new FileInputStream("./src/test/resources/ExcelTestData.xlsx");
		
		//Create workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Fetching values
	//	System.out.println(wb.getSheet("sheet1").getRow(0).getCell(0).getStringCellValue());
	//	System.out.println(wb.getSheet("sheet1").getRow(2).getCell(1).getNumericCellValue());
	//	System.out.println(wb.getSheet("sheet1").getRow(3).getCell(3).getBooleanCellValue());
		

		Cell cell1 = wb.getSheet("sheet1").getRow(0).getCell(0);
		Cell cell2 = wb.getSheet("sheet1").getRow(2).getCell(1);
		Cell cell3 = wb.getSheet("sheet1").getRow(3).getCell(3);
		DataFormatter data = new DataFormatter();
		
	System.out.println(data.formatCellValue(cell1));	
	System.out.println(data.formatCellValue(cell2));
	System.out.println(data.formatCellValue(cell3));

	}

	
}
