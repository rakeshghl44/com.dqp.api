package com.dqp.api;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PositiveTC {
	
	
	@BeforeSuite
	public void setup() {
		RestAssured.baseURI = "http://192.168.9.11:25200";
	}
	
		
	@Test(priority = 1) 
	void loginPage() { //Open URL with/w/o connecting VPN
		
		get(RestAssured.baseURI + "/login");
		
	}
	
	@Test(priority = 0) 
	void loginAuthentication() { //Open URL with/w/o connecting VPN
			
			RestAssured.given().contentType("application/json")
				.body("{"+"\"username\": \"data_steward\",\"password\": \"cGFzc3dvcmQ=\"}")
					.post(RestAssured.baseURI + "/api/v1/login/authenticate").then();
				
		}
	
	
	@Test(priority = 2 , enabled = false) 
	void google() { //Different URL with https
		
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
	void stroyboardTab() { //Different URL with http
		
		given()
		.get(RestAssured.baseURI + "/home/storyboard")
	.then()
		.statusCode(200);
	}
	
	@Test(priority = 4) 
	void editMeasure() {
		given()
		.get(RestAssured.baseURI +"/api/v1/measures/204706")
	.then()
		.statusCode(200);
	}
	
	@Test(priority = 5) 
	void specificStoryboard() {
		given()
		.get(RestAssured.baseURI + "/api/v1/storyboard/widgets/byStoryboardId/196124")
	.then()
		.statusCode(200);
	}

	@Test(priority = 6) 
	void multipleWidgets() {
		given()
		.get(RestAssured.baseURI + "/api/v1/storyboard/widgets/byStoryboardId/103411")
	.then()
		.statusCode(200);
	}
	
	@Test(priority = 7) 
	void jobsTab() {
		given()
		.get(RestAssured.baseURI + "/home/jobs")
	.then()
		.statusCode(200);
	}
	
	@Test(priority = 8) 
	void dataAssetsTab() {
		given()
		.get(RestAssured.baseURI + "/home/data-assets")
	.then()
		.statusCode(200);
	}
	
	@Test(priority = 9) 
	void dashboardTab() {
		given()
		.get(RestAssured.baseURI + "/home/dashboard/anomaly")
	.then()
		.statusCode(200);
	}
	

	@Test(priority = 9) 
	void profilingDashboards() {
		given()
		.get(RestAssured.baseURI + "/home/dashboard/profiling")
	.then()
		.statusCode(200);
	}
	
	@Test(priority = 10) 
	void anomalyDashboardView() {
		given()
		.get(RestAssured.baseURI + "/home/dashboard/anomaly/182055")
	.then()
		.statusCode(200);
	}
	
	@Test(priority = 11) 
	void delete() {   //208957,206576,208968
		when().
			delete(RestAssured.baseURI + "/api/v1/measures/206576").
		then().
		statusCode(204).log().all();
		
	}
	
}
