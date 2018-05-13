import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	public static void main(String[] args) {
	crearExcel();		
	}
	public static void crearExcel() {
		
		Workbook book = new XSSFWorkbook();
		
		Sheet sheet = book.createSheet("abc");//crea el documento en excel con la hoja llamada "abc"
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("hola");
		
		try {
			FileOutputStream fileout = new FileOutputStream("Excel.xlsx");
			book.write(fileout);
			fileout.close();
		
		}
		catch (FileNotFoundException ex) {
			Logger.getLogger(Excel.class.getName()) .log(Level.SEVERE, null, ex);
			
		}
		catch (IOException ex) {
			Logger.getLogger(Excel.class.getName()) .log(Level.SEVERE, null, ex);
			
		}
		
	}
}

