
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
	public  Vector <Cell> leerDatos1(String fileName, String sheetName) {

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

	public static Object[][] leerDatos2(String fileName, String sheetName) throws IOException{

		Object[][] data = new Object[CrearDocExcel.NUM_COLUMS][getNumRow(sheetName)];

		try {
			File file = new File(fileName);
			FileInputStream excel = new FileInputStream(file);
			try {
				XSSFWorkbook workbook = new XSSFWorkbook(excel); // abre el archivo
				XSSFSheet hoja = workbook.getSheet(sheetName); // abre la hoja correspondiente al potrero

				int numFilas = hoja.getLastRowNum(); //lee el numero de filas

				for(int i = 0; i < numFilas; i++) {
					Row fila = hoja.getRow(i);

					for (int x = 0; x < CrearDocExcel.NUM_COLUMS; x++) {
						Cell celda = fila.getCell(x);
						switch(celda.getCellTypeEnum().toString()) {
						case "NUMERIC":
							int dato = (int) celda.getNumericCellValue();
							data[i][x] = (Object) Integer.toString(dato);
							break;
						case "STRING":
							data[i][x] = (Object) celda.getStringCellValue();
							break;
						}

						}
					}

				workbook.close();
				excel.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(data);
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

	public static int getNumRow(String paddockName){
		int tam = 0;
		try {
			File file = new File(Principal.NOM_FINCA);
			FileInputStream excel = new FileInputStream(file);
			try {
				XSSFWorkbook workbook = new XSSFWorkbook(excel);
				XSSFSheet hoja = workbook.getSheet(paddockName);
				tam = hoja.getLastRowNum();
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

	public static String[] readUserData() {

		String[] data = new String[2];

		try {
			File file = new File(Principal.NOM_FINCA);
			FileInputStream excel = new FileInputStream(file);
			try {
				XSSFWorkbook workbook = new XSSFWorkbook(excel);
				XSSFSheet hoja = workbook.getSheetAt(0);
				Row row = hoja.getRow(0);
				data[0] = row.getCell(0).toString();
				data[1] = row.getCell(1).toString();
				workbook.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return data;

	}

}
