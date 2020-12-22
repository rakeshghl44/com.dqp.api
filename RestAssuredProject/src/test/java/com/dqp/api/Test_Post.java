package com.dqp.api;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

//import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Test_Post {
	
	@Test
	public void testPost() {
		
		Map<String, Object> map = new HashMap<String, Object>(); 
		
		map.put("Name", "Rakesh");
		map.put("Job", "QA");
		System.out.println(map);
		
		JSONObject request = new JSONObject(map);
		
		System.out.println(request.toJSONString());
	}
	@Test
	void checkBodyValue() {
		given()
		.post("http://192.168.9.11:25200/api/v1/login/authenticate")
	.then()
		.statusCode(200)
		.log().all();
		
		//.body("data.id[0]", equalTo(7))
	}

	@Test(enabled = false) 
	public void testPostJson() {
		
		/*
		 * Map<String, Object> map = new HashMap<String, Object>();
		 * 
		 * map.put("Name", "Rakesh"); map.put("Job", "QA"); System.out.println(map);
		 */
		
		JSONObject request = new JSONObject();
		
		request.put("username", "data_steward");
		request.put("password", "cGFzc3dvcmQ=");
		
		given().
			body(request.toJSONString()).
		when().
			post("http://192.168.9.11:25200/api/v1/login/authenticate").
		then().
			statusCode(200);

		
		//data_steward", "cGFzc3dvcmQ=
	}
	
}
