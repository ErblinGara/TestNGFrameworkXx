package com.neotech.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GroupDemo {
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Creating a pretty report...");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("Saving the pretty report...");
	}
	
	@BeforeMethod
	public void beforeMethod () {
		System.out.println("Opening the browser...");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Closing the browser...");
	}
	
	@Test(priority = 3, groups = {"group1", "group2"})
	public void test1() {
		System.out.println("Adding an employee");
		
		Assert.assertTrue(false);
	}
	

	@Test(priority = 1, groups = "group1", dependsOnMethods = "test1")
	public void test2() {
		System.out.println("Deleting an employee");
	}
}
