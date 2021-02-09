package com.dqp.api.storyboard;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class CreateUpdateStoryboardComplete {
	
	
	@BeforeSuite
	public void setup() {
		RestAssured.baseURI = "http://192.168.9.11:25200";
	}	
	
	@Test(priority = 0, enabled = false) 
	void createStory() { //Note down ID [e.g. - storyboard_id": 211782,] generated in log while API request
			
			RestAssured.given().contentType("application/json")
				.body("{\"widgets\":[{\"x\":0,\"y\":0,\"template_json\":{\"name\":\"PK_Completeness_937\",\"id\""
						+ ":60310,\"dqType\":\"COMPLETENESS\",\"measureName\":\"PK_Completeness_937\",\"measureId\""
						+ ":60302,\"widget_type\":\"chart\"},\"cols\":6,\"rows\":4,\"user_defined\":\"Y\","
						+ "\"deleted\":false,\"pos_x\":0,\"pos_y\":0,\"height\":4,\"width\":6}],\"user_id\":1,"
						+ "\"project_id\":3,\"name\":\"My Storyboard - Default - 22\",\"default_flag\":\"N\"}")
				.post(RestAssured.baseURI + "/api/v1/storyboard").then().log().all();
		}
	
	@Test(priority = 0, enabled = false) 
	void updateStory() { //Replace newly generated storyboard_id wherever it as below code	
			
		String idVal="215722";
		String storyboardName = "My Storyboard - Default - 22";		
		
			RestAssured.given().contentType("application/json")
				.body("{\"storyboard_id\":"+idVal+",\"user_id\":1,\"project_id\":3,\"name\":"+storyboardName+","
						+ "\"default_flag\":\"N\",\"widgets\":[{\"widget_id\":211799,\"storyboard_id\":"+idVal+",\"pos_x\""
						+ ":0,\"pos_y\":0,\"width\":6,\"height\":4,\"width_unit\":\"GRID\",\"user_defined\":\"Y\","
						+ "\"deleted\":false,\"template_json\":{\"name\":\"PK_Completeness_937\",\"id\":60310,\"dqType\""
						+ ":\"COMPLETENESS\",\"measureName\":\"PK_Completeness_937\",\"measureId\":60302,\"widget_type\""
						+ ":\"chart\",\"hasAggregation\":true},\"x\":0,\"y\":0,\"rows\":4,\"cols\":6},{\"x\":6,\"y\":0,"
						+ "\"template_json\":{\"name\":\"SC_Online_Completeness_1\",\"id\":203662,\"dqType\":"
						+ "\"COMPLETENESS\",\"measureName\":\"Online_Completeness_1\",\"measureId\":202880,\"widget_type\""
						+ ":\"chart\"},\"cols\":6,\"rows\":4,\"user_defined\":\"Y\",\"deleted\":false,"
						+ "\"storyboard_id\":"+idVal+",\"pos_x\":6,\"pos_y\":0,\"height\":4,\"width\":6},{\"x\":0,\"y\""
						+ ":4,\"template_json\":{\"name\":\"Online_Completeness_12\",\"id\":203160,\"dqType\""
						+ ":\"COMPLETENESS\",\"measureName\":\"Online_Completeness_1\",\"measureId\":202880,"
						+ "\"widget_type\":\"chart\"},\"cols\":6,\"rows\":4,\"user_defined\":\"Y\",\"deleted\""
						+ ":false,\"storyboard_id\":"+idVal+",\"pos_x\":0,\"pos_y\":4,\"height\":4,\"width\":6},{\"x\""
						+ ":6,\"y\":4,\"template_json\":{\"name\":\"Online_completeness_2\",\"id\":202971,\"dqType\""
						+ ":\"COMPLETENESS\",\"measureName\":\"Online_completeness_2\",\"measureId\":202964,"
						+ "\"widget_type\":\"chart\"},\"cols\":6,\"rows\":4,\"user_defined\":\"Y\",\"deleted\":false,"
						+ "\"storyboard_id\":"+idVal+",\"pos_x\":6,\"pos_y\":4,\"height\":4,\"width\":6},{\"x\":0,\"y\""
						+ ":8,\"template_json\":{\"name\":\"Online_Completeness_1\",\"id\":202887,\"dqType\":"
						+ "\"COMPLETENESS\",\"measureName\":\"Online_Completeness_1\",\"measureId\":202880,\"widget_type\""
						+ ":\"chart\"},\"cols\":6,\"rows\":4,\"user_defined\":\"Y\",\"deleted\":false,"
						+ "\"storyboard_id\":"+idVal+",\"pos_x\":0,\"pos_y\":8,\"height\":4,\"width\":6},{\"x\":6,\"y\""
						+ ":8,\"template_json\":{\"name\":\"PM-1068-completeness-clone_job1\",\"id\":158392,\"dqType\""
						+ ":\"COMPLETENESS\",\"measureName\":\"PM-1068-completeness-clone\",\"measureId\":158380,"
						+ "\"widget_type\":\"chart\"},\"cols\":6,\"rows\":4,\"user_defined\":\"Y\",\"deleted\":false,"
						+ "\"storyboard_id\":"+idVal+",\"pos_x\":6,\"pos_y\":8,\"height\":4,\"width\":6}]}")
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
