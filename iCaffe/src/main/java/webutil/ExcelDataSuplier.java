package webutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataSuplier {

//	public static void main(String[] args) throws IOException {
//
//		readData();
//
//	}

	@DataProvider(name = "ReadDataFromExcel")
	public static String[][] readAllData() throws IOException {
		File excelFile = new File("./src/test/resources/TestByDataprovider.xlsx");
		System.out.println(excelFile.exists());
		FileInputStream fInputStreamObj = new FileInputStream(excelFile);

		XSSFWorkbook workBook = new XSSFWorkbook(fInputStreamObj);
		XSSFSheet sheet = workBook.getSheet("TestSheet");
		int noOfRows = sheet.getPhysicalNumberOfRows();
		int noOfCoulmn = sheet.getRow(0).getLastCellNum();

		String[][] arrData = new String[noOfRows - 1][noOfCoulmn];
		for (int i = 0; i < noOfRows - 1; i++) {
			for (int j = 0; j < noOfCoulmn; j++) {
				DataFormatter df = new DataFormatter();
				arrData[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
			}
		}
		workBook.close();
		fInputStreamObj.close();
		for (String[] strArrData : arrData) {
			System.out.println(Arrays.toString(strArrData));
		}
		return arrData;

	}

	public static Map<String, String> setExcelFile(String sheetName, String expDataId) {
		FileInputStream fls;
		Map<String, String> dataMap = new HashMap<String,String>();
		try {
			File excelFile = new File("src\\test\\resources\\logindataread.xlsx");

			System.out.println(excelFile.exists());
			 fls = new FileInputStream(excelFile);
			Workbook workBook = new XSSFWorkbook(fls);
			Sheet sheet = workBook.getSheet(sheetName);
			int lastRowNumber = sheet.getLastRowNum();

			int dataRowNumber = 0;

			for (int i = 0; i <= lastRowNumber; i++) {
				Row row = sheet.getRow(i);
				Cell cell = row.getCell(0, MissingCellPolicy.CREATE_NULL_AS_BLANK);
				String actDataIdValue = cell.getStringCellValue();
				if (actDataIdValue.equalsIgnoreCase(expDataId)) {
					dataRowNumber = i;
				}
			}
			Row dataRow = sheet.getRow(dataRowNumber);
			Row firstRow = sheet.getRow(0);

			for (int j = 1; j <= firstRow.getLastCellNum() - 1; j++) {
				Cell cellKey = firstRow.getCell(j, MissingCellPolicy.CREATE_NULL_AS_BLANK);
				Cell cellData = dataRow.getCell(j, MissingCellPolicy.CREATE_NULL_AS_BLANK);

				String coulmnName = cellKey.getStringCellValue();
				String dataValue = cellData.getStringCellValue();
				System.out.println(coulmnName + " :- " + dataValue);
				dataMap.put(coulmnName, dataValue);

			}
		} catch (IOException e) {

		}

		return dataMap;
	}
	
	
	public static List<Map<String,String>> setExcelFile(String sheetName) {
		FileInputStream fls;
		List<Map<String,String>> listMap =	new ArrayList<Map<String,String>>();
		try {
			File excelFile = new File("src\\test\\resources\\logindataread.xlsx");

			System.out.println(excelFile.exists());
			 fls = new FileInputStream(excelFile);
			Workbook workBook = new XSSFWorkbook(fls);
			Sheet sheet = workBook.getSheet(sheetName);
			int lastRowNumber = sheet.getLastRowNum();

			
			for(int j=1;j<=sheet.getLastRowNum();j++) {
				Map<String, String> dataMap = new HashMap<String,String>();
	
			Row dataRow = sheet.getRow(j);
			Row firstRow = sheet.getRow(0);

			for (int i = 1; i <= firstRow.getLastCellNum() - 1; i++) {
				Cell cellKey = firstRow.getCell(i, MissingCellPolicy.CREATE_NULL_AS_BLANK);
				Cell cellData = dataRow.getCell(i, MissingCellPolicy.CREATE_NULL_AS_BLANK);

				String coulmnName = cellKey.getStringCellValue();
				String dataValue = cellData.getStringCellValue();
				System.out.println(coulmnName + " :- " + dataValue);
				dataMap.put(coulmnName, dataValue);
			}
			listMap.add(dataMap);
			}
		} catch (IOException e) {

		}

		return listMap;
	}
	
//	@DataProvider(name = "WriteDataToExcel")
//	public static void writeData() throws IOException {
//		
//		XSSFWorkbook workBook = new XSSFWorkbook();
//		XSSFSheet sheet = workBook.createSheet("TestSheet");
//		int noOfRows = sheet.getPhysicalNumberOfRows();
//		int noOfCoulmn = sheet.getRow(0).getLastCellNum();
//			String[][] arrData = new String[noOfRows - 1][noOfCoulmn];
//			for (int i = 0; i < noOfRows - 1; i++) {
//				for (int j = 0; j < noOfCoulmn; j++) {
//					DataFormatter df = new DataFormatter();
//					df.createFormat(sheet.createRow(i).createCell(j));
//					
//					
////					sheet.createRow(0);
////					sheet.getRow(0).createCell(0).setCellValue("Hello");
////					sheet.getRow(0).createCell(1).setCellValue("Java");
//				}
//			}
//
//	}

}

