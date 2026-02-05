package com.neotech.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.neotech.pages.DashboardPageElements;
import com.neotech.pages.LoginPageElements;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class LoginTest extends CommonMethods {

	@Test(groups = { "smoke", "regression" })
	public void validLogin() {

		LoginPageElements loginPage = new LoginPageElements();
		DashboardPageElements dashboard = new DashboardPageElements();

		// send username
		test.info("Entering username!");
		sendText(loginPage.username, ConfigsReader.getProperty("username"));

		// send password

		test.info("Entering password");
		sendText(loginPage.password, ConfigsReader.getProperty("password"));

		// click login button

		test.info("Clicking the login button");
		click(loginPage.loginBtn);
		// or use jsClick() or Actions.click()

		wait(2);

		// verify the account name
		String expected = "Jacqueline Whitee";
		String actual = dashboard.accountName.getText();

		// Assertion
		test.info("Verifying account name");
		Assert.assertEquals(actual, expected, "Account does not match");

	}

	@Test(groups = "smoke")
	public void emptyPassword() {

		LoginPageElements loginPage = new LoginPageElements();

		sendText(loginPage.username, ConfigsReader.getProperty("username"));

		test.info("Leaving password blank!");

		click(loginPage.loginBtn);

		String expected = "Password cannot be empty";
		String actual = loginPage.passwordError.getText();

		test.info("Checking error message");
		Assert.assertEquals(actual, expected, "The error message does not match");
	}

	@Test(groups = "regression")
	public void invalidPassword() {

		LoginPageElements loginPage = new LoginPageElements();

		sendText(loginPage.username, ConfigsReader.getProperty("username"));

		sendText(loginPage.password, "wewqdsa");

		click(loginPage.loginBtn);

		String expected = "Invalid Credentials";
		String actual = loginPage.invalidPassword.getText();

		Assert.assertEquals(actual, expected, "The error message does not match");

	}

}
