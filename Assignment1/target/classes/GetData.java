package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetData extends DriverFactory {

	public ArrayList<String> a = new ArrayList<String>();
	
	public ArrayList<String> getExcelData(String file, String sheet, String col_name, String TC_name) throws IOException {
		
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet(sheet);
		Iterator <Row> rw = sh.iterator();
		Row firstrow = rw.next();
		Iterator <Cell> ce = firstrow.cellIterator();
		int col =0, k=0;
		while (ce.hasNext()) {
			Cell Cvalue = ce.next();
			if(Cvalue.getStringCellValue().equalsIgnoreCase(col_name)) {
				col =k;
				break;
			}
			k++;
		}
		while(rw.hasNext()) {
			Row Rvalue = rw.next();
			if(Rvalue.getCell(col).getStringCellValue().equalsIgnoreCase(TC_name)) {
				Iterator<Cell> value = Rvalue.cellIterator();
				while(value.hasNext()) {
					DataFormatter formatter = new DataFormatter();
					a.add(formatter.formatCellValue(value.next()));
				}
			}
		}
		return a;
	}
}
