package com.dqp.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class Positive_TC {
	
		
	@Test(priority = 0) 
	void Test_loginPage() { //Open URL with/w/o connecting VPN
		
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
	void TestStroyboardTab() { //Different URL with http
		
		given()
		.get("http://192.168.9.11:25200/home/storyboard")
	.then()
		.statusCode(200);
	}
	
	@Test(priority = 4) 
	void testEditMeasure() {
		given()
		.get("http://192.168.9.11:25200/api/v1/measures/204706")
	.then()
		.statusCode(200);
	}
	
	@Test(priority = 5) 
	void testSpecificStoryboard() {
		given()
		.get("http://192.168.9.11:25200/api/v1/storyboard/widgets/byStoryboardId/196124")
	.then()
		.statusCode(200);
	}

	@Test(priority = 6) 
	void testMultipleWidgets() {
		given()
		.get("http://192.168.9.11:25200/api/v1/storyboard/widgets/byStoryboardId/103411")
	.then()
		.statusCode(200);
	}
	
	@Test(priority = 7) 
	void testJobsTab() {
		given()
		.get("http://192.168.9.11:25200/home/jobs")
	.then()
		.statusCode(200);
	}
	
	@Test(priority = 8) 
	void testDataAssetsTab() {
		given()
		.get("http://192.168.9.11:25200/home/data-assets")
	.then()
		.statusCode(200);
	}
	
	@Test(priority = 9) 
	void testDashboardTab() {
		given()
		.get("http://192.168.9.11:25200/home/dashboard/anomaly")
	.then()
		.statusCode(200);
	}
	

	@Test(priority = 9) 
	void testProfilingDashboards() {
		given()
		.get("http://192.168.9.11:25200/home/dashboard/profiling")
	.then()
		.statusCode(200);
	}
	
	@Test(priority = 10) 
	void testAnomalyDashboardView() {
		given()
		.get("http://192.168.9.11:25200/home/dashboard/anomaly/182055")
	.then()
		.statusCode(200);
	}
	
	@Test(priority = 11) 
	void testDelete() {   //208957,206576,208968
		when().
			delete("http://192.168.9.11:25200/api/v1/measures/206576").
		then().
		statusCode(204).log().all();
		
	}
	
}
