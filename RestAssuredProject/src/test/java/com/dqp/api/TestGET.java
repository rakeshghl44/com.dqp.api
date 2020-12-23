package com.dqp.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class TestGET {
	
		
	@Test(priority = 0) 
	void Test_login() { //Open URL with/w/o connecting VPN
		
		get("http://192.168.9.11:25200/login");
		
	}
	@Test(priority = 2) 
	void Test_google() { //Different URL with https
		
		Response response = get("https://www.google.com");
		
		System.out.println(response.asString());
		System.out.println("\n");
		System.out.println(response.getBody().asString());
		System.out.println("\n");
		System.out.println(response.statusCode());
		System.out.println("\n");
		System.out.println(response.getStatusLine());
		System.out.println("\n");
		System.out.println(response.getHeader("Content-Type"));
		System.out.println("\n");
		System.out.println("Response time - " + response.getTime());
		System.out.println("\n");
		
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode , 200);
		//Assert.assertEquals(statusCode , 201);
		
	}
	
	@Test(priority = 3) 
	void Test_google_http() { //Different URL with http
		
		get("http://www.google.com");		
	}
	
	@Test(priority = 4) 
	void checkBodyValue() {
		given()
		.get("http://192.168.9.11:25200/api/v1/measures/204706")
	.then()
		.statusCode(200)
		.body("data.sources.id[0]", equalTo(204711));
	}
}
