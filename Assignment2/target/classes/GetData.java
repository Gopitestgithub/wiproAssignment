package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

public class GetData extends DriverFactory {

	public ArrayList<String> a = new ArrayList<String>();
	public ArrayList<String> jsonData = new ArrayList<String>();
	
	public ArrayList<String> getExcelData(String file, String sheet, String col_name, String TC_name) throws IOException {
		
		a.clear();
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
	
	public ArrayList<String> getJsonData(String file) throws IOException, ParseException {

		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader(file);
		Object obj = jsonParser.parse(reader);
		JSONObject userObj = (JSONObject) obj;
		
		jsonData.add((String) userObj.get("url"));
		jsonData.add((String) userObj.get("email"));
		jsonData.add((String) userObj.get("password"));
		jsonData.add((String) userObj.get("country"));
		jsonData.add((String) userObj.get("fname"));
		jsonData.add((String) userObj.get("lname"));
		jsonData.add((String) userObj.get("address"));
		jsonData.add((String) userObj.get("city"));
		jsonData.add((String) userObj.get("pin"));
		jsonData.add((String) userObj.get("DOB"));
		jsonData.add((String) userObj.get("land"));
		jsonData.add((String) userObj.get("user"));
		
		return jsonData;
	}
	
	@DataProvider
	public Object[][] getUrl() throws IOException, ParseException {
				
		Object [][] url = new Object [4][12];
		
		Random rand = new Random();
		int n = rand.nextInt(100000);
		String str = "gk"+Integer.toString(n)+"@gmail.com";
				
		
		url[0][0] = "https://www.olay.co.uk/en-gb";
		url[0][1] = str;
		url[0][2] = "1234567g";
		url[0][3] = "UK";
		url[0][4] = "Gopi";
		url[0][5] = "Krishna";
		url[0][6] = "Wipro";
		url[0][7] = "Bangalore";
		url[0][8] = "562125";
		url[0][9] = "29/04/1991";
		url[0][10]= "NA";
		url[0][11]= "New";
				
		getExcelData(System.getProperty("user.dir")+"\\Resources\\TestData.xlsx", "Assignment2_Register", "Test Scenario", "Germany");
		url[1][0] = a.get(1);
		url[1][1] = a.get(2);
		url[1][2] = a.get(3);
		url[1][3] = a.get(4);
		url[1][4] = a.get(5);
		url[1][5] = a.get(6);
		url[1][6] = a.get(7);
		url[1][7] = a.get(8);
		url[1][8] = a.get(9);
		url[1][9] = a.get(10);
		url[1][10]= a.get(11);
		url[1][11]= a.get(12);
		
		getJsonData(System.getProperty("user.dir")+"\\Resources\\TestData.json");
		url[2][0] = jsonData.get(0);
		url[2][1] = Integer.toString(n)+jsonData.get(1);
		url[2][2] = jsonData.get(2);
		url[2][3] = jsonData.get(3);
		url[2][4] = jsonData.get(4);
		url[2][5] = jsonData.get(5);
		url[2][6] = jsonData.get(6);
		url[2][7] = jsonData.get(7);
		url[2][8] = jsonData.get(8);
		url[2][9] = jsonData.get(9);
		url[2][10]= jsonData.get(10);
		url[2][11]= jsonData.get(11);
		
		url[3][0] = "https://www.olay.co.uk/en-gb";
		url[3][1] = str;
		url[3][2] = "1234567g";
		url[3][3] = "UK";
		url[3][4] = "Gopi";
		url[3][5] = "Krishna";
		url[3][6] = "Wipro";
		url[3][7] = "Bangalore";
		url[3][8] = "562125";
		url[3][9] = "29/04/1991";
		url[3][10]= "NA";
		url[3][11]= "Existing";
		
		return url;
	}

	@DataProvider
	public Object[][] getsignindetails() throws IOException, ParseException {
		
		Object [][] signin = new Object [2][4];
				
		signin[0][0] = "https://www.olay.co.uk/en-gb";
		signin[0][1] = "gopi1212@gmail.com";
		signin[0][2] = "1234567g";
		signin[0][3] = "uk";

		signin[1][0] = "https://www.olay.es/es-es";
		signin[1][1] = "sheeja1212@gmail.com";
		signin[1][2] = "1234567g";
		signin[1][3] = "spain";
		
		return signin;
	}
}
