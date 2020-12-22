package com.dqp.api;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class get_valid_invalid_URL {
	
		
	@Test(priority = 0) 
	void Test_login() {
		
		RestAssured.get("http://192.168.9.11:25200/login");
	}
	
	@Test(priority = 2) 
	void Test_google() {
		
		RestAssured.get("https://www.google.com");
	}
	
	@Test(priority = 3) 
	void Test_invalid_url() {
		
		RestAssured.get("httpe://www.google.com");
		
	}
	
	

}
