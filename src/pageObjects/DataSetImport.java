package pageObjects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;

import java.io.FileInputStream;

public class DataSetImport {
	private static HSSFWorkbook wb;
	private static FileInputStream fi;

	/*
	 * This class is used to read content of one cell from the table with test data.
	 * After writing test, I have realized that it calls this method too many time.
	 * More optimal solution is needed here.
	 */

	public static String readCell(int r, int c) throws IOException {

		try {
			fi = new FileInputStream("ITBCzavrsniispit.xls");
			wb = new HSSFWorkbook(fi);
			HSSFSheet sheet = wb.getSheet("data");
			Row row = sheet.getRow(r);
			Cell cell = row.getCell(c);

			if (cell.getCellType() == CellType.STRING) {
				return cell.toString();
			} else if (cell.getCellType() == CellType.NUMERIC) {
				return NumberToTextConverter.toText(cell.getNumericCellValue());
			}

			return cell.toString();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
			return "";
		} catch (IOException e) {

			e.printStackTrace();
			return "";
		}

	}

	/*
	 * This main method is not relevant for the test. But comes in very handy should
	 * you have any trouble reading from the excel file.
	 * 
	 * public static void main (String[] args) throws IOException { String s =
	 * readCell(1, 0); System.out.println(s); }
	 */

}
