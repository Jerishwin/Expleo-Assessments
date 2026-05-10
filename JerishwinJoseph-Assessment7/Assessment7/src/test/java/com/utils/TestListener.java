package com.utils;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.test.LoginTest;


public class TestListener extends LoginTest implements ITestListener {
	
	private Logger log=LogManager.getLogger();
	
	@Override
	public void onTestStart(ITestResult result) {
		log.info("Test Started : "+result.getName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		log.info("Test Success : "+result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		log.warn("Test Skipped : "+result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		log.info("Suite Started : "+context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		log.info("Suite Success : "+context.getName());
	}

	public void onTestFailure(ITestResult result) {
		try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(src,new File("./test-output/Screenshots/" + result.getName()+System.currentTimeMillis()+ ".png"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
	}
}
