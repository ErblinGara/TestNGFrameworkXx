package com.neotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.utils.CommonMethods;

public class DashboardPageElements extends CommonMethods {

	@FindBy(id = "account-name")
	public WebElement accountName;

	@FindBy(xpath = "//span[text()='PIM']")
	public WebElement PIM;

	@FindBy(xpath = "//span[text()='Add Employee']")
	public WebElement addEmployeeLink;

	public DashboardPageElements() {
		PageFactory.initElements(driver, this);
	}

}
