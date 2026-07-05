package com.omrbranch.pages;

import org.openqa.selenium.By;

public class LoginPage {
	// ==========================================================
		// APP LOCATORS
		// ==========================================================
		public By androidTxtEmail = By.xpath("//android.widget.EditText[@content-desc='Email Address']");
		public By androidTxtPassword = By.xpath("//android.widget.EditText[@content-desc='Password']");
		public By androidBtnLogin = By.xpath("//android.view.ViewGroup[@resource-id='login_button']");
		public By androidLoginErrorMessage = By.xpath("//android.widget.TextView[@resource-id='login_error_message']");

		// ==========================================================
		// MOBILE BROWSER LOCATORS
		// ==========================================================
		public By webTxtEmail = By.id("email");
		public By webTxtPassword = By.id("pass");
		public By webBtnLogin = By.xpath("//button[@value='login']");
		public By webLoginErrorMessage = By.id("errorMessage");

}
