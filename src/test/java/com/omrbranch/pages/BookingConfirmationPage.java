package com.omrbranch.pages;

import org.openqa.selenium.By;

import com.omrbranch.utility.BaseClass;

public class BookingConfirmationPage extends BaseClass {
	
		
		public  By androidbtnpayment = By.xpath("//android.widget.TextView[@text=\"Credit/Debit/ATM Card\"]");
	    
		public	By androidddcardtype = By.xpath("//android.view.View[@resource-id=\"payment_type\"]");
			
			
			
		public	By androidoptiondebitcard = By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Debit Card\"]");
			
			
		    
		public By androidddcard = By.xpath("//android.view.View[@resource-id=\"card_type\"]");
			
		public  By androidoptionvisa = By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Visa\"]");
			
		public	By androidtxtcardno = By.xpath("//android.widget.EditText[@resource-id=\"card_no\"]");
			
			
		public By androidtxtcardname = By.xpath("//android.widget.EditText[@resource-id=\"card_name\"]");
			
			
		public	By androidddmonth = By.xpath("//android.view.View[@resource-id=\"card_month\"]");
			
		public	By androidoptionjuly = By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"July\"]");
			
		public By androidtxtcvv = By.xpath("//android.widget.EditText[@resource-id=\"cvv\"]");
			
		public	By androidbtnsubmit = By.xpath("//android.widget.Button[@resource-id=\"submitBtn\"]");
			


	

	
	
		
	

}

