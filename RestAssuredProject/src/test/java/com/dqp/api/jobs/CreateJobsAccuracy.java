package com.dqp.api.jobs;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class CreateJobsAccuracy {
	
	
	@BeforeSuite
	public void setup() {
		RestAssured.baseURI = "http://192.168.9.11:25200";
	}
	
		
	@Test(priority = 0, enabled = true)  
	void createAccuracyMeasureType() { //Open URL with/w/o connecting VPN  /*Name change*/	
			
			RestAssured.given().contentType("application/json")
				.body("")
				.post(RestAssured.baseURI + "/api/v1/jobs").then().log().all();
	}
	
	@Test(priority = 1 , enabled = false) 
	void delete() {   //208957,206576,208968
		when().
			delete(RestAssured.baseURI + "/api/v1/measures/206576").
		then().
		statusCode(204).log().all();
		
	}
	
}
