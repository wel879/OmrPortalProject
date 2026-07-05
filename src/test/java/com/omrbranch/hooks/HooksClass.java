package com.omrbranch.hooks;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.omrbranch.utility.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksClass extends BaseClass {

  @Before
  public void beforeScenario() throws FileNotFoundException, IOException {

    launch(getPropertyValue("type"), getPropertyValue("browserName"), getPropertyValue("deviceName"),
        getPropertyValue("platformName"), getPropertyValue("platformVersion"), getPropertyValue("appPackage"),
        getPropertyValue("appActivity"), getPropertyValue("automationName"));

    implicityWait();

    if (getPropertyValue("type").equalsIgnoreCase("WEB")) {
      enterApplicationUrl(getPropertyValue("url"));
    }
  }

  @After
  public void afterScenario(Scenario scenario) {

    if (scenario.isFailed()) {

      byte[] screenshot = screenshot();

      scenario.attach(screenshot, "image/png", "Failed Scenario Screenshot");
    }

    if (driver != null) {
      driver.quit();
    }
  }
}