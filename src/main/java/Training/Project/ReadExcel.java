package Training.Project;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.CellType;
import jxl.LabelCell;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcel {

	public String readData(String searchString) {

		Cell cell = null;
		String str = null;

		try {

			String filename = System.getProperty("user.dir")+"/src/test/resources/InputReader.xls";
			// user.dir tells eclipse to use the current directory - which is
			// also shown if you right click the project
			// and select properties
			// String filename = "input.xls";
			Workbook workbook = Workbook.getWorkbook(new File(filename)); // load
																			// the
																			// file
																			// associated
																			// to
																			// the
																			// path
																			// i.e
																			// filename
																			// variable
																			// String
		//	System.out.println("File Loaded"); // confirms

			Sheet s = workbook.getSheet(0); // confirms to look at sheet 0

			LabelCell lc = s.findLabelCell(searchString);
			int col = lc.getColumn();
			int row = lc.getRow();

			cell = s.getCell(++col, row);

			if (cell.getType() == CellType.LABEL) {

				LabelCell labelCell = (LabelCell) cell;
				str = (String) labelCell.getContents();

			}

			else if (cell.getType() == CellType.NUMBER) {

				NumberCell numCell = (NumberCell) cell;
				str = numCell.getContents();

			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.err.println("Null Pointer Exception caught");
			e.printStackTrace();
		}

		return str;
	}

}