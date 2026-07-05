package com.omrbranch.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.omrbranch.utility.BaseClass;

import io.appium.java_client.android.AndroidDriver;

public class ExploreHotelPage extends BaseClass {
	
	  public By androiddndstate = By.xpath("//android.view.ViewGroup[@resource-id=\"search_select_state_container\"]/android.view.ViewGroup");
	  public By androidoptiontamilnadu = By.xpath("//android.widget.TextView[@text=\"Tamil Nadu\"]");
	 
	  public By androidddcity = By.xpath("//android.view.ViewGroup[@resource-id=\"search_select_city_container\"]/android.view.ViewGroup");
	  public By androidoptionpuducherry = By.xpath("//android.widget.TextView[@text=\"Puducherry\"]");
	    
	    
	    public By androidddroomtype = By.xpath("//android.widget.TextView[@text=\"Select Room Type\"]");
	 public By androidoptionstudio = By.xpath("//android.widget.TextView[@text=\"Studio\"]");
		
		public By androidcheck_in = By.xpath("//android.widget.EditText[@content-desc=\"search_select_checkin\"]");
		public By androidselectcheck_in = By.xpath("//android.view.View[@content-desc=\"08 June 2026\"]");
		public By androidbtncheckin_ok = By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]");
	  
	    public By androidcheck_out = By.xpath("//android.widget.EditText[@content-desc=\"search_select_checkout\"]");
	    public By androidselectcheck_out = By.xpath("//android.view.View[@content-desc=\"11 June 2026\"]");
	    public By androidbtncheckout_ok = By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]");
	  
	   public By androidddnoofrooms = By.xpath("//android.widget.TextView[@text=\"No. Of Room\"]");
	   public By androidoptionfive = By.xpath("//android.widget.TextView[@text=\"5-Five\"]");
	  
	  public By androidddnoofadults = By.xpath("//android.widget.TextView[@text=\"No. Of Adults\"]");
	  public By androidoptionadultsfour = By.xpath("//android.widget.TextView[@text=\"4-Four\"]");
	  
	  
	  public By androidddnoofchildren = By.xpath("//android.widget.EditText[@content-desc=\"search_no_of_children\"]");
	  public By androidbtnsearch = By.xpath("//android.view.ViewGroup[@resource-id=\"search_button\"]");

	  
	}
