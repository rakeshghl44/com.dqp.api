package com.dqp.api.storyboard;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class CreateUpdateStoryboardNegativeTC {
	
	
	@BeforeSuite
	public void setup() {
		RestAssured.baseURI = "http://192.168.9.11:25200";
	}	
	
	@Test(priority = 0, enabled = false) // change in values
	void createStory() { //Note down ID [e.g. - storyboard_id": 211782,] generated in log while API request
			
			RestAssured.given().contentType("application/json")
				.body("{\"widgets\":[{\"x\":0,\"y\":0,\"template_json\":{\"name\":\"Verify_PM-2959_#$%\",\"id\""
						+ ":162817,\"dqType\":\"ACCURACY\",\"measureName\":\"Verify_PM-2959_#$%\",\"measureId\""
						+ ":162809,\"widget_type\":\"chart\"},\"cols\":6,\"rows\":4,\"user_defined\":\"Y\",\"deleted\""
						+ ":false,\"pos_x\":0,\"pos_y\":0,\"height\":4,\"width\":6}],\"user_id\":1,\"project_id\":3,"
						+ "\"name\":\"My Storyboard - Default - $$$\",\"default_flag\":\"N\"}")
				.post(RestAssured.baseURI + "/api/v1/storyboard").then().log().all();
		}
	
	@Test(priority = 0, enabled = false) 
	void updateStory() { //Replace newly generated storyboard_id wherever it as below code	
			
			RestAssured.given().contentType("application/json")
				.body("{\"storyboard_id\":211813,\"user_id\":1,\"project_id\":3,\"name\":\"My Storyboard - Default - 23\",\"default_flag\":\"N\","
						+ "\"widgets\":[{\"widget_id\":211806,\"storyboard_id\":211813,\"pos_x\":0,\"pos_y\":0,\"width\""
						+ ":6,\"height\":4,\"width_unit\":\"GRID\",\"user_defined\":\"Y\",\"deleted\":false,"
						+ "\"template_json\":{\"name\":\"Verify_PM-2959_ACCURACY\",\"id\":162817,\"dqType\":"
						+ "\"ACCURACY\",\"measureName\":\"Verify_PM-2959_ACCURACY\",\"measureId\":162809,\"widget_type\""
						+ ":\"chart\",\"hasAggregation\":true},\"x\":0,\"y\":0,\"rows\":4,\"cols\":6},{\"x\":6,\"y\":0,"
						+ "\"template_json\":{\"name\":\"limit_exceed_accuracy_New\",\"id\":146101,\"dqType\""
						+ ":\"ACCURACY\",\"measureName\":\"PM-1068_accuracy_New\",\"measureId\":103285,\"widget_type\""
						+ ":\"chart\"},\"cols\":6,\"rows\":4,\"user_defined\":\"Y\",\"deleted\":false,"
						+ "\"storyboard_id\":211813,\"pos_x\":6,\"pos_y\":0,\"height\":4,\"width\":6},{\"x\":0,\"y\""
						+ ":4,\"template_json\":{\"name\":\"Accuracy_partition_Info\",\"id\":145510,\"dqType\""
						+ ":\"ACCURACY\",\"measureName\":\"Accuracy_partition_Info\",\"measureId\":145502,\"widget_type\""
						+ ":\"chart\"},\"cols\":6,\"rows\":4,\"user_defined\":\"Y\",\"deleted\":false,"
						+ "\"storyboard_id\":211813,\"pos_x\":0,\"pos_y\":4,\"height\":4,\"width\":6},{\"x\":6,\"y\""
						+ ":4,\"template_json\":{\"name\":\"PM-2505_accuracy_New_20\",\"id\":145296,\"dqType\""
						+ ":\"ACCURACY\",\"measureName\":\"PM-1068_accuracy_New\",\"measureId\":103285,\"widget_type\""
						+ ":\"chart\"},\"cols\":6,\"rows\":4,\"user_defined\":\"Y\",\"deleted\":false,"
						+ "\"storyboard_id\":211813,\"pos_x\":6,\"pos_y\":4,\"height\":4,\"width\":6},{\"x\":0,\"y\""
						+ ":8,\"template_json\":{\"name\":\"PM-2505_accuracy_New\",\"id\":145241,\"dqType\""
						+ ":\"ACCURACY\",\"measureName\":\"PM-1068_accuracy_New\",\"measureId\":103285,\"widget_type\""
						+ ":\"chart\"},\"cols\":6,\"rows\":4,\"user_defined\":\"Y\",\"deleted\":false,"
						+ "\"storyboard_id\":211813,\"pos_x\":0,\"pos_y\":8,\"height\":4,\"width\":6},{\"x\":6,\"y\""
						+ ":8,\"template_json\":{\"name\":\"PM-2506_accuracy_New\",\"id\":115954,\"dqType\""
						+ ":\"ACCURACY\",\"measureName\":\"PM-1068_accuracy_New\",\"measureId\":103285,\"widget_type\""
						+ ":\"chart\"},\"cols\":6,\"rows\":4,\"user_defined\":\"Y\",\"deleted\":false,"
						+ "\"storyboard_id\":211813,\"pos_x\":6,\"pos_y\":8,\"height\":4,\"width\":6},{\"x\":0,\"y\""
						+ ":12,\"template_json\":{\"name\":\"PM-2505_accuracy_N_times\",\"id\":115523,\"dqType\""
						+ ":\"ACCURACY\",\"measureName\":\"PM-1068_accuracy_New\",\"measureId\":103285,\"widget_type\""
						+ ":\"chart\"},\"cols\":6,\"rows\":4,\"user_defined\":\"Y\",\"deleted\":false,"
						+ "\"storyboard_id\":211813,\"pos_x\":0,\"pos_y\":12,\"height\":4,\"width\":6}]}")
				.post(RestAssured.baseURI + "/api/v1/storyboard").then().log().all();
				
		}	
		
	@Test(priority = 1 , enabled = false) 
	void delete() {   //208957,206576,208968 //path parameter
		String id = "211782";
		given().
			pathParam("StoryboardId", id).
		when().
			delete(RestAssured.baseURI + "/api/v1/storyboard/byStoryboardId/{StoryboardId}").
		then().
		statusCode(204).log().all();
	}
}
