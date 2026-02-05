package com.neotech.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.pages.AddEmployeePageElements;
import com.neotech.pages.DashboardPageElements;
import com.neotech.pages.LoginPageElements;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;
import com.neotech.utils.ExcelUtility;

public class AddEmployeeTest extends CommonMethods {

	@Test(dataProvider = "excelData", groups = "addEmployee")
	public void addEmployee(String firstName, String lastName, String location, String username, String password) {
		
		LoginPageElements loginPage = new LoginPageElements();
		DashboardPageElements dashboard = new DashboardPageElements();
		AddEmployeePageElements addEmployee = new AddEmployeePageElements();
		
		sendText(loginPage.username, ConfigsReader.getProperty("username"));
		sendText(loginPage.password, ConfigsReader.getProperty("password"));

		click(loginPage.loginBtn);

		click(dashboard.PIM);

		click(dashboard.addEmployeeLink);

		waitForVisibility(By.id("first-name-box"));

		sendText(addEmployee.firstName, firstName);
		sendText(addEmployee.lastName, lastName);

		click(addEmployee.location);
		click(driver.findElement(By.linkText(location)));

		click(addEmployee.loginDetailsToggle);

		sendText(addEmployee.username, username);
		sendText(addEmployee.password, password);
		sendText(addEmployee.confirmPassword, password);

		wait(2);

		click(addEmployee.saveButton);

		// executor.executeScript("arguments[0].click();",
		// driver.findElement(By.xpath("//button[text()='Save']")));

		waitForVisibility(By.id("personal_details_tab"));

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
