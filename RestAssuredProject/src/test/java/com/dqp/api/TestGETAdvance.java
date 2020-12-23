package com.dqp.api;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;


public class TestGETAdvance {
	
	@Test
	public void test_getID() {
		
		given().
			get("https://reqres.in/api/users?page=2").
		then().
			statusCode(200).
			body("data.id[1]", equalTo(8)).
					log().all();
	}
	
	@Test
	public void test_getFname() {
		
		given().
			get("https://reqres.in/api/users?page=2").
		then().
			statusCode(200).
			body("data.first_name", hasItems("Michael","Lindsay"));
	}
	
	@Test
	public void test_getID_fail() {
		
		given().
			get("https://reqres.in/api/users?page=2").
		then().
			statusCode(200).
			body("data.id[1]", equalTo(0)).
					log().all();
	}
	
	@Test
	public void test_getFname_fail() {
		
		given().
			get("https://reqres.in/api/users?page=2").
		then().
			statusCode(200).
			body("data.first_name", hasItems("Michaesl","Lindsay"));
	}

}
