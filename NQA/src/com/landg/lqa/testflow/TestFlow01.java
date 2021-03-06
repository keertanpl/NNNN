package com.landg.lqa.testflow;

import java.io.IOException;
import java.util.Arrays;

import java.util.Properties;

//import org.apache.xalan.xsltc.compiler.util.TestGenerator;
import org.junit.runners.Suite;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import junit.framework.TestSuite;

import org.testng.TestNG;

import com.landg.lqa.utility.Init;
import com.landg.lqa.utility.Utils;

public class TestFlow01 {

	public static void start(String testcase, String browser,
			String environment, String testPack) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		TestNG testNG = new TestNG();
		XmlTest xmlTest;

		XmlSuite suite = new XmlSuite();
		suite.setName("NQA Smoke  Test");
		suite.setParallel("classes");
		suite.setThreadCount(2);
		xmlTest = new XmlTest(suite);
		xmlTest.setName("Test1");

		xmlTest.addParameter("Input", System.getProperty("user.dir")
				+ "\\Test Data" + "\\TestData.xlsx");

		xmlTest.addParameter("Output", System.getProperty("user.dir"));

		xmlTest.addParameter("Testcase", testcase);

		xmlTest.addParameter("Browser", browser);
		xmlTest.addParameter("Environment", environment);
		xmlTest.addParameter("testPack", testPack);

		XmlClass xmlClass2 = new XmlClass(
				com.landg.lqa.testflow.TestFlow02.class);

		xmlTest.getClasses().add(xmlClass2);

		testNG.setXmlSuites(Arrays.asList(suite));

		testNG.run();
	}

	public static void main(String args[]) throws Exception {
		// TODO Auto-generated method stub
		TestNG testNG = new TestNG();
		XmlTest xmlTest;
		XmlSuite suite = new XmlSuite();
		suite.setName("NQA Smoke  Test");
		suite.setParallel("classes");
		suite.setThreadCount(2);
		xmlTest = new XmlTest(suite);
		xmlTest.setName("Test1");
		Properties prop = new Properties();
		// prop.load(ClassLoader.getSystemResourceAsStream("config.properties"));

		xmlTest.addParameter("Input", System.getProperty("user.dir")
				+ "\\Test Data" + "\\TestData.xlsx");

		xmlTest.addParameter("Output", System.getProperty("user.dir"));
		System.out.println(args[0]);
		xmlTest.addParameter("Browser", args[0]);

		xmlTest.addParameter("Testcase", "");
		
		xmlTest.addParameter("Environment", args[1]);
		xmlTest.addParameter("testPack", args[2]);

		XmlClass xmlClass2 = new XmlClass(
				com.landg.lqa.testflow.TestFlow02.class);

		xmlTest.getClasses().add(xmlClass2);

		testNG.setXmlSuites(Arrays.asList(suite));

		testNG.run();

	}

}
