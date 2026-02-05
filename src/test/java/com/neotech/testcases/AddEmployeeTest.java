package com.neotech.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;
import com.neotech.utils.ExcelUtility;

public class AddEmployeeTest extends CommonMethods {

	@Test(dataProvider = "excelData", groups = "addEmployee")
	public void addEmployee(String firstName, String lastName, String location, String username, String password) {
		
		//not needed anymore since PageInitializer initializes all page object classes
//		LoginPageElements loginPage = new LoginPageElements();
//		DashboardPageElements dashboard = new DashboardPageElements();
//		AddEmployeePageElements addEmployee = new AddEmployeePageElements();
		
		sendText(loginPage.username, ConfigsReader.getProperty("username"));
		sendText(loginPage.password, ConfigsReader.getProperty("password"));

		click(loginPage.loginBtn);

		click(dashboardPage.PIM);

		click(dashboardPage.addEmployeeLink);

		waitForVisibility(By.id("first-name-box"));

		sendText(addEmployeePage.firstName, firstName);
		sendText(addEmployeePage.lastName, lastName);

		click(addEmployeePage.location);
		click(driver.findElement(By.linkText(location)));

		click(addEmployeePage.loginDetailsToggle);

		sendText(addEmployeePage.username, username);
		sendText(addEmployeePage.password, password);
		sendText(addEmployeePage.confirmPassword, password);

		wait(2);

		click(addEmployeePage.saveButton);

		// executor.executeScript("arguments[0].click();",
		// driver.findElement(By.xpath("//button[text()='Save']")));

		waitForVisibility(By.id("personal_details_tab"));
		personalDetailsPage.firstName.getText();
		//Assert.assertEquals(personalDetailsPage.firstName.getText(), firstName);

		takeScreenshot(username + ".png");

	}

	@DataProvider(name = "employees")
	public Object[][] getData() {

		Object[][] employee = { 
				{ "Ciara", "Flores", "Australian Regional HQ", "c1.flores2", "ciara@123" },
				{ "Burak", "Busche", "Australian Regional HQ", "b.busche32", "burak@123" },
				{ "Ozzy", "B.", "Australian Regional HQ", "ozzy.b12", "ozzy@123" }

		};

		return employee;
	}
	
	@DataProvider(name = "excelData")
	public Object[][] getExcelData() {
		String filePath = System.getProperty("user.dir") + "/testdata/Excel.xlsx";
		String sheetName = "Employee";
		
		return ExcelUtility.excelIntoArray(filePath, sheetName);
	}

}
