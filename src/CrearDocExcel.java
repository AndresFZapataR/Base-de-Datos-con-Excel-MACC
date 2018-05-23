
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class CrearDocExcel {


	static final int NUM_COLUMS = 6;

	public static void editarPotrero (String landName, String paddockName, Vector<String> v) {

		try {
			File file = new File(landName);
			FileInputStream excel = new FileInputStream(file);
			try {
				XSSFWorkbook book = new XSSFWorkbook(excel);
				Sheet sheet = book.getSheet(paddockName);
				int lastrow = sheet.getLastRowNum();
				int x = 0;
				for (int i = lastrow; i < lastrow + (v.size()/ NUM_COLUMS); i++) {
					Row row = sheet.createRow(i);
					for(int j = 0; j < NUM_COLUMS; j++){
						Cell celda = row.createCell(j);
						int sum = j + x*NUM_COLUMS;
						celda.setCellValue(v.get(sum));
					}
					x++;
				}
				FileOutputStream salida = new FileOutputStream(landName);
				book.write(salida);
				excel.close();
				book.close();
				salida.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Object[] encabezado() {
		Object[] v = new Object[NUM_COLUMS];
		v[0] = (Object) "No Animal";
		v[0] = (Object)"Sexo";
		v[0] = (Object)"Peso";
		v[0] = (Object)"Raza";
		v[0] = (Object)"Color";
		v[0] = (Object)"Fecha";
		return v;
	}

	public static void crearPotrero(String nameLand,String paddockName) {
		try {
			FileInputStream file = new FileInputStream(new File(nameLand ));
			try {
				XSSFWorkbook book = new XSSFWorkbook(file);
				book.createSheet(paddockName);
				FileOutputStream file2 = new FileOutputStream(new File (nameLand));
				book.write(file2);
				book.close();
				file.close();
				file2.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void deletePaddock(String landName, String paddockName) {

		try {
			File file = new File(landName);
			FileInputStream excel = new FileInputStream(file);
			try {
				XSSFWorkbook book = new XSSFWorkbook(excel);
				int sheet = book.getSheetIndex(paddockName);
				book.removeSheetAt(sheet);
				FileOutputStream salida = new FileOutputStream(landName);
				book.write(salida);
				excel.close();
				book.close();
				salida.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void saveUserData(String user, String password) {

		try {
			FileInputStream file = new FileInputStream(new File(Principal.NOM_FINCA));
			try {
				XSSFWorkbook book = new XSSFWorkbook(file);
				Sheet hoja = book.getSheetAt(0);
				Row row = hoja.createRow(0);
				row.createCell(0).setCellValue(user);
				row.createCell(1).setCellValue(password);
				FileOutputStream file2 = new FileOutputStream(new File (Principal.NOM_FINCA));
				book.write(file2);
				book.close();
				file.close();
				file2.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
