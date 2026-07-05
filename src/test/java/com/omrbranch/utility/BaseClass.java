
	package com.omrbranch.utility;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.net.MalformedURLException;
	import java.net.URI;
	import java.net.URL;
	import java.time.Duration;
	import java.util.Arrays;
	import java.util.List;
	import java.util.Properties;

	import org.openqa.selenium.By;
	import org.openqa.selenium.Dimension;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.PointerInput;
	import org.openqa.selenium.interactions.Sequence;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.interactions.PointerInput.Kind;
	import org.openqa.selenium.interactions.PointerInput.MouseButton;
	import org.openqa.selenium.interactions.PointerInput.Origin;

	import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.android.options.UiAutomator2Options;

	public class BaseClass {
	  public static AndroidDriver driver;

	  public byte[] screenshot() {
	    TakesScreenshot screenshot = (TakesScreenshot) driver;
	    byte[] screenshotAs = screenshot.getScreenshotAs(OutputType.BYTES);
	    return screenshotAs;
	  }

	  public static String getProjectPath() {
	    String property = System.getProperty("user.dir");
	    return property;
	  }

	  public static String getPropertyValue(String key) throws FileNotFoundException, IOException {
	    Properties properties = new Properties();
	    properties.load(new FileInputStream(getProjectPath() + "\\config\\Config.properties"));

	    Object object = properties.get(key);
	    String value = (String) object;
	    return value;

	  }

	  public void launch(String type, String browserName, String deviceName, String platformName, String platformVersion,
	      String appPackage, String appActivity, String automationName) throws MalformedURLException {

	    UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
	    uiAutomator2Options.setUdid(deviceName);
	    uiAutomator2Options.setPlatformName(platformName);
	    uiAutomator2Options.setPlatformVersion(platformVersion);
	    uiAutomator2Options.setAutomationName(automationName);

	    switch (type) {
	    case "APP":
	      uiAutomator2Options.setAppPackage(appPackage);
	      uiAutomator2Options.setAppActivity(appActivity);
	      break;
	    case "WEB":
	      uiAutomator2Options.withBrowserName(browserName);
	      break;

	    default:
	      break;
	    }
	    URI uri = URI.create("http://127.0.0.1:4723/");
	    URL url = uri.toURL();
	    driver = new AndroidDriver(url, uiAutomator2Options);
	  }

	  public void enterApplicationUrl(String url) {
	    driver.get(url);
	  }

	  public void implicityWait() {
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  }

	  public void implicityWait(int secs) {
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));
	  }

	  public void sendKeysElement(By by, String data) {
	    findLocator(by).sendKeys(data);
	  }

	  public void clickElement(By by) {
	    findLocator(by).click();
	  }

	  public void switchContext(String contextView) {
	    driver.context(contextView);
	  }

	  public String getTextElement(By by) {
	    String text = findLocator(by).getText();
	    return text;

	  }

	  public WebElement findLocator(By by) {
	    WebElement element = driver.findElement(by);
	    return element;
	  }

	  public List<WebElement> findLocators(By by) {
	    List<WebElement> elements = driver.findElements(by);
	    return elements;
	  }

	  public void swipeToElement(By by) {
	    implicityWait(5);
	    List<WebElement> elements = findLocators(by);
	    while (elements.size() == 0) {
	      swipe();
	      elements = findLocators(by);
	    }
	    implicityWait();

	  }

	  public void swipe() {
	    Dimension size = driver.manage().window().getSize();

	    int width = size.getWidth();
	    int centerX = width / 2;
	    int height = size.getHeight();
	    int startY = (int) (height * 0.80);

	    int endY = (int) (height * 0.20);

	    PointerInput pointerInput = new PointerInput(Kind.TOUCH, "finger 1");

	    Sequence sequence = new Sequence(pointerInput, 1);
	    sequence.addAction(pointerInput.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), centerX, startY));
	    sequence.addAction(pointerInput.createPointerDown(MouseButton.LEFT.asArg()));
	    sequence.addAction(pointerInput.createPointerMove(Duration.ofSeconds(1), Origin.viewport(), centerX, endY));

	    sequence.addAction(pointerInput.createPointerUp(MouseButton.LEFT.asArg()));

	    List<Sequence> asList = Arrays.asList(sequence);

	    driver.perform(asList);

	  }

	  public void selectOptionByText(By by, String data) {
	    Select select = new Select(findLocator(by));
	    select.selectByVisibleText(data);
	  }

	  public void acceptAlert() {
	    driver.switchTo().alert().accept();
	  }

	  public void clickElementJs(By by) {
	    JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].click()", findLocator(by));
	  }
	  public void clickElementJs1(By by) {
		    JavascriptExecutor executor = (JavascriptExecutor) driver;
		    executor.executeScript("arguments[0].click()", findLocator(by));
	  }

	}



