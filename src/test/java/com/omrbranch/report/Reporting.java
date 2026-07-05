package com.omrbranch.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.omrbranch.utility.BaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting extends BaseClass {

  public static void generateJvmReport(String jsonFile) throws FileNotFoundException, IOException {

    File reportFolder = new File(getProjectPath() + getPropertyValue("jvmReportPath"));

    Configuration configuration = new Configuration(reportFolder, "OMRBranch Hotel APP Project");

    String type = getPropertyValue("type");

    // Execution Details
    configuration.addClassifications("Execution Type", type);
    configuration.addClassifications("Environment URL", getPropertyValue("url"));

    // Device Details
    configuration.addClassifications("Device Name", getPropertyValue("deviceName"));
    configuration.addClassifications("Platform Name", getPropertyValue("platformName"));
    configuration.addClassifications("Platform Version", getPropertyValue("platformVersion"));

    // Automation Details
    configuration.addClassifications("Automation Name", getPropertyValue("automationName"));

    // App Execution
    if (type.equalsIgnoreCase("APP")) {

      configuration.addClassifications("App Package", getPropertyValue("appPackage"));
      configuration.addClassifications("App Activity", getPropertyValue("appActivity"));
    }

    // Web Execution
    else if (type.equalsIgnoreCase("WEB")) {

      configuration.addClassifications("Browser Name", getPropertyValue("browserName"));
    }

    // Framework Details
    configuration.addClassifications("Framework", "Appium + Cucumber + JVM Report");
    configuration.addClassifications("Build Tool", "Maven");
    configuration.addClassifications("Language", "Java");

    // Project Details
    configuration.addClassifications("Project", "OMRBranch Hotel App");
    configuration.addClassifications("Sprint", "34");
    configuration.addClassifications("Tester Name", "Velmurugan");

    List<String> jsonFiles = new ArrayList<String>();
    jsonFiles.add(jsonFile);

    ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);

    reportBuilder.generateReports();
  }
}
