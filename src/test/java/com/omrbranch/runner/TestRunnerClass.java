package com.omrbranch.runner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.omrbranch.report.Reporting;
import com.omrbranch.utility.BaseClass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)

@CucumberOptions(tags = "@Login", dryRun = true, stepNotifications = false, snippets = SnippetType.CAMELCASE, publish = true, monochrome = true,

    plugin = { "pretty", "json:target\\output.json" },

    glue = { "com.omrbranch.stepdefinition", "com.omrbranch.hooks" },

    features = "src\\test\\resources")

public class TestRunnerClass extends BaseClass {

  @AfterClass
  public static void afterClass() throws FileNotFoundException, IOException {

    Reporting.generateJvmReport(getProjectPath() + "//target//output.json");
  }
}