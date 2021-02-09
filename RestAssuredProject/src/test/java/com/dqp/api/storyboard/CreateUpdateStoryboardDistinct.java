package com.dqp.api.storyboard;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class CreateUpdateStoryboardDistinct {
	
	
	@BeforeSuite
	public void setup() {
		RestAssured.baseURI = "http://192.168.9.11:25200";
	}	
	
	@Test(priority = 0, enabled = false) 
	void createStory() { //Note down ID [e.g. - storyboard_id": 211782,] generated in log while API request
			
			RestAssured.given().contentType("application/json")
				.body("{\"widgets\":[{\"x\":0,\"y\":0,\"template_json\":{\"name\":\"test_03_sep\",\"id\":164228,"
						+ "\"dqType\":\"DISTINCTNESS\",\"measureName\":\"test_03_sep\",\"measureId\":164220,"
						+ "\"widget_type\":\"chart\"},\"cols\":6,\"rows\":4,\"user_defined\":\"Y\",\"deleted\""
						+ ":false,\"pos_x\":0,\"pos_y\":0,\"height\":4,\"width\":6}],\"user_id\":1,\"project_id\""
						+ ":3,\"name\":\"My Storyboard - Default - 21\",\"default_flag\":\"N\"}")
				.post(RestAssured.baseURI + "/api/v1/storyboard").then().log().all();
		}
	
	@Test(priority = 0, enabled = true) 
	void updateStory() { //Replace newly generated storyboard_id wherever it as below code	
			
		String idVal="215722";
		String storyboardName = "My Storyboard - Default - 21";
		
			RestAssured.given().contentType("application/json")
				.body("{\"storyboard_id\":"+idVal+",\"user_id\":1,\"project_id\":3,\"name\":"+storyboardName+","
						+ "\"default_flag\":\"N\",\"widgets\":[{\"widget_id\":211790,\"storyboard_id\":"+idVal+",\"pos_x\""
						+ ":0,\"pos_y\":0,\"width\":6,\"height\":4,\"width_unit\":\"GRID\",\"user_defined\":\"Y\","
						+ "\"deleted\":false,\"template_json\":{\"name\":\"test_03_sep\",\"id\":164228,\"dqType\""
						+ ":\"DISTINCTNESS\",\"measureName\":\"test_03_sep\",\"measureId\":164220,\"widget_type\""
						+ ":\"chart\",\"hasAggregation\":false},\"x\":0,\"y\":0,\"rows\":4,\"cols\":6},{\"x\":6,\"y\""
						+ ":0,\"template_json\":{\"name\":\"PM-1068_distinct_test2\",\"id\":158863,\"dqType\""
						+ ":\"DISTINCTNESS\",\"measureName\":\"PM-1068_distinct\",\"measureId\":102798,\"widget_type\""
						+ ":\"chart\"},\"cols\":6,\"rows\":4,\"user_defined\":\"Y\",\"deleted\":false,"
						+ "\"storyboard_id\":"+idVal+",\"pos_x\":6,\"pos_y\":0,\"height\":4,\"width\":6},{\"x\":0,\"y\""
						+ ":4,\"template_json\":{\"name\":\"PM-1068_distinct_test1\",\"id\":150157,\"dqType\""
						+ ":\"DISTINCTNESS\",\"measureName\":\"PM-1068_distinct\",\"measureId\":102798,\"widget_type\""
						+ ":\"chart\"},\"cols\":6,\"rows\":4,\"user_defined\":\"Y\",\"deleted\":false,"
						+ "\"storyboard_id\":"+idVal+",\"pos_x\":0,\"pos_y\":4,\"height\":4,\"width\":6},{\"x\":6,\"y\""
						+ ":4,\"template_json\":{\"name\":\"PK_Dist_937_Job\",\"id\":60344,\"dqType\":\"DISTINCTNESS\","
						+ "\"measureName\":\"PK_Dist_937\",\"measureId\":60338,\"widget_type\":\"chart\"},\"cols\""
						+ ":6,\"rows\":4,\"user_defined\":\"Y\",\"deleted\":false,\"storyboard_id\":"+idVal+",\"pos_x\""
						+ ":6,\"pos_y\":4,\"height\":4,\"width\":6},{\"x\":0,\"y\":8,\"template_json\":{\"name\""
						+ ":\"hskdaufh\",\"id\":55172,\"dqType\":\"DISTINCTNESS\",\"measureName\":\"hskdaufh\","
						+ "\"measureId\":55166,\"widget_type\":\"chart\"},\"cols\":6,\"rows\":4,\"user_defined\""
						+ ":\"Y\",\"deleted\":false,\"storyboard_id\":"+idVal+",\"pos_x\":0,\"pos_y\":8,\"height\""
						+ ":4,\"width\":6},{\"x\":6,\"y\":8,\"template_json\":{\"name\":\"sc_distinctness_898\",\"id\""
						+ ":20687,\"dqType\":\"DISTINCTNESS\",\"measureName\":\"sc_distinctness_898\",\"measureId\""
						+ ":20681,\"widget_type\":\"chart\"},\"cols\":6,\"rows\":4,\"user_defined\":\"Y\",\"deleted\""
						+ ":false,\"storyboard_id\":"+idVal+",\"pos_x\":6,\"pos_y\":8,\"height\":4,\"width\":6}]}")
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
