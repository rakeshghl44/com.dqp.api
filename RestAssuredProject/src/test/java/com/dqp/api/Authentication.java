package com.dqp.api;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Authentication {	
		
		public static WebDriver driver ;
		
		@Test
		public static void main() throws InterruptedException {
			
						
			/*
			 * RestAssured.baseURI = System.getProperty("http://192.168.9.11:25200/login");
			 * PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
			 * authScheme.setUserName("data_stewardeee");
			 * authScheme.setPassword("cGFzc3dvcmQ="); RestAssured.authentication =
			 * authScheme;
			 */
			RequestSpecification code = RestAssured.given()
					.auth().preemptive().basic("username", "password");
					
			given().
			get("http://192.168.9.11:25200/api/v1/measures/204706").
		then().
			statusCode(200).
			log().all();
			
			
			/*
			 * RestAssured.baseURI = "http://192.168.9.11:25200/api/v1/login/authenticate";
			 * RequestSpecification request = RestAssured.given();
			 * 
			 * Response response = request.post(); System.out.println("Status code: " +
			 * response.getStatusCode()); System.out.println("Status message " +
			 * response.body().asString());
			 */
			}
}
			  
			
	//given().auth().basic("data_steward", "cGFzc3dvcmQ=").when().post("http://192.168.9.11:25200/api/v1/login/authenticate").then().statusCode(200);
			
	//given().auth().preemptive().basic("data_steward", "cGFzc3dvcmQ=").post("http://192.168.9.11:25200/api/v1/login/authenticate").then().statusCode(200);

	//given().auth().form("data_steward", "cGFzc3dvcmQ=").when().post("http://192.168.9.11:25200/api/v1/login/authenticate").then().statusCode(200);		}

