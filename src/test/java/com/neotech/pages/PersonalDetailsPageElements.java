package com.neotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.utils.CommonMethods;

public class PersonalDetailsPageElements extends CommonMethods {
	
	
	@FindBy(id = "firstName")
	public WebElement firstName;
	

	public PersonalDetailsPageElements() {
		PageFactory.initElements(driver, this);
	}

}
