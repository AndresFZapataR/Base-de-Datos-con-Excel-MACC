import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
		/**
		 * Metodo que lee la informacion de las celdas de un archivo de Excel (.xlsx)
		 * y guarda esa informacion dentro de un Vector 
		 * @param ruta Path del archivo .xlsx a leer
		 * @return Vector con la informacion de las celdas;
		 */
	public Vector <Cell> leer(String ruta) {
			
		Vector<Cell> data = new Vector<Cell>();
	
		try {
			File file = new File(ruta);
			FileInputStream excel = new FileInputStream(file);
			try {
				XSSFWorkbook workbook = new XSSFWorkbook(excel); // abre el archivo
				XSSFSheet hoja = workbook.getSheetAt(0); // abre la primera hoja
					
				int numFilas = hoja.getLastRowNum(); //lee el numero de filas
					
				for(int i = 0; i < numFilas; i++) {
					Row fila = hoja.getRow(i);
					int numceldas = fila.getLastCellNum(); //lee el numero de celdas en la fila i
						
					for (int x = 0; x < numceldas; x++) {
						Cell celda = fila.getCell(x);
						data.add(celda);
						}
					}
					
				workbook.close(); // cierra el archivo
					
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			
		return data;
	}

}
