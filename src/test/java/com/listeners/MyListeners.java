package com.listeners;

import java.io.File;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.restassured.response.Response;

public class MyListeners implements ITestListener {

	private static ExtentTest extentTest;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("**************** Starting Test" + result.getMethod().getMethodName() + "**************** ");
		extentTest = ExtentManager.getInstance().createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("**************** Test Passed" + result.getMethod().getMethodName() + "**************** ");
		extentTest.pass("Test Executed Successfully!!!");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("**************** Test Failed" + result.getMethod().getMethodName() + "**************** ");
		extentTest.fail("Test failed!!!");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("**************** Test Skipped" + result.getMethod().getMethodName() + "**************** ");
		

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("**************** Starting TestNg SUITE **************** ");

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("**************** Comnpleted TestNg SUITE **************** ");
		ExtentManager.getInstance().flush();
	}

	
}
