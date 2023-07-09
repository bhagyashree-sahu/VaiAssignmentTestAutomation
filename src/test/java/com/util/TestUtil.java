package com.util;

import static com.util.TestUtil.getJsonData;
import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.github.javafaker.Faker;
import com.google.gson.Gson;

import io.restassured.http.Header;

public class TestUtil {

	public static String timeStampforJobCreation() {

		Date d1 = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.000Z'");
		return dateFormat.format(d1);
	}

	public static String[][] readExcel(String fileName, String sheetName) {

		XSSFWorkbook myWorkBook = null;
		try {
			myWorkBook = new XSSFWorkbook(System.getProperty("user.dir") + "\\testData\\" + fileName + ".xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet mySheet = myWorkBook.getSheet(sheetName);
		int lastRowIndex = mySheet.getLastRowNum();
		XSSFRow rowHeader = mySheet.getRow(0);
		int lastCellIndex = rowHeader.getLastCellNum() - 1;

		XSSFRow rowData;
		XSSFCell cellData;
		String data[][] = new String[lastRowIndex][lastCellIndex + 1];

		for (int rowIndex = 1; rowIndex <= lastRowIndex; rowIndex++) {
			for (int cellIndex = 0; cellIndex <= lastCellIndex; cellIndex++) {
				rowData = mySheet.getRow(rowIndex);
				cellData = rowData.getCell(cellIndex);
				data[rowIndex - 1][cellIndex] = cellData.toString();
			}
		}

		return data;

	}

	public static Map<String, String> createFakeParams() {
		Faker faker = new Faker();
		Map<String, String> formParams = new HashMap<>();
		formParams.put("email", faker.internet().emailAddress());
		formParams.put("password", "Iv1^TDCZSjo@!oZ");
		formParams.put("first_name", faker.name().firstName());
		formParams.put("last_name", faker.name().lastName());
		formParams.put("type", "Individual");
		formParams.put("companyname", "VAI");
		return formParams;
	}

	public static String getJsonData(Object object) {
		Gson gson = new Gson();
		String data = gson.toJson(object);
		return data;
	}

	public static String readProp(String key) {
		// TODO Auto-generated method stub
		Properties properties = new Properties();

		try {
			FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "//config//qa.properties");
			properties.load(file);
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String baseUrl = properties.getProperty(key);
		return baseUrl;

	}
}
