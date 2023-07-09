package com.listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

public class ExtentManager {

	private static ExtentReports extentReports;

	public static ExtentReports getInstance() {
		File reportFolder = new File(System.getProperty("user.dir") + "//reports");
		try {
			if (reportFolder.isDirectory()) {
				FileUtils.deleteDirectory(reportFolder);
			}
			reportFolder.mkdir();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (extentReports == null) {
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY-hh-mm");
			String dateString = dateFormat.format(date);
			extentReports = createReportInstance("Reports" + dateString + ".html");
		}
		return extentReports;
	}

	private static ExtentReports createReportInstance(String file) {
		// TODO Auto-generated method stub
		File reportFile = new File(System.getProperty("user.dir") + "//reports//" + file);
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(reportFile);
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		return extentReports;
	}
}
