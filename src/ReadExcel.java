

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
		 * @param fileName nombre del archivo .xlsx a leer
		 * @param sheetName nombre del potrero
		 * @return Vector con la informacion de las celdas;
		 */
	public  Vector <Cell> leerDatos(String fileName, String sheetName) {

		Vector<Cell> data = new Vector<Cell>();

		try {
			File file = new File(fileName);
			FileInputStream excel = new FileInputStream(file);
			try {
				XSSFWorkbook workbook = new XSSFWorkbook(excel); // abre el archivo
				XSSFSheet hoja = workbook.getSheet(sheetName); // abre la hoja correspondiente al potrero

				int numFilas = hoja.getLastRowNum(); //lee el numero de filas

				for(int i = 1; i < numFilas; i++) {
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
	
	public static int getNumSheet(String landName){
		int tam = 0;
		try {
			File file = new File(landName);
			FileInputStream excel = new FileInputStream(file);
			try {
				XSSFWorkbook workbook = new XSSFWorkbook(excel);
				tam = workbook.getNumberOfSheets();
				
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return tam;
	}
	
	public static String[] getPaddocks(String landName) {
		int tam = getNumSheet(landName);
		String[] paddocks = new String[tam];
		try {
			File file = new File(landName);
			FileInputStream excel = new FileInputStream(file);
			try {
				XSSFWorkbook workbook = new XSSFWorkbook(excel);
				for(int i = 1; i < tam; i++) {
					paddocks[i] = workbook.getSheetName(i);
				}
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return paddocks;
	}

}
