package com.dqp.api.storyboard;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class CreateUpdateStoryboardProfiling {
	
	
	@BeforeSuite
	public void setup() {
		RestAssured.baseURI = "http://192.168.9.11:25200";
	}	
	
	@Test(priority = 0, enabled = true) 
	void createStory() { //Note down ID [e.g. - storyboard_id": 211782,] generated in log while API request
			
			RestAssured.given().contentType("application/json")
				.body("{\"widgets\":[{\"x\":0,\"y\":0,\"template_json\":{\"name\":\"Online_Completeness_12\",\"id\":203162,"
						+ "\"dqType\":\"COMPLETENESS\",\"measureName\":\"Online_Completeness_1\",\"measureId\":202880,\"widget_type\""
						+ ":\"chart\"},\"cols\":6,\"rows\":4,\"user_defined\":\"Y\",\"deleted\":false,\"pos_x\":0,\"pos_y\""
						+ ":0,\"height\":4,\"width\":6}],\"user_id\":1,\"project_id\":3,\"name\":\"My Storyboard - Default - 20\","
						+ "\"default_flag\":\"N\"}")
				.post(RestAssured.baseURI + "/api/v1/storyboard").then().log().all();
		}
	
	@Test(priority = 0, enabled = false) 
	void updateStory() { //Replace newly generated storyboard_id on below code	
		
		String idVal="215722";
		String storyboardName = "My Storyboard - Default - 20";	
			
			RestAssured.given().contentType("application/json")
				.body("{\"storyboard_id\":"+idVal+",\"user_id\":1,\"project_id\":3,\"name\":"+storyboardName+","
/* Replace id*/			+ "\"default_flag\":\"N\",\"widgets\":[{\"widget_id\":211754,\"storyboard_id\":"+idVal+",\"pos_x\":0,\"pos_y\""
						+ ":0,\"width\":6,\"height\":4,\"width_unit\":\"GRID\",\"user_defined\":\"Y\",\"deleted\":false,"
						+ "\"template_json\":{\"name\":\"Online_Completeness_12\",\"id\":203160,\"dqType\":\"COMPLETENESS\","
						+ "\"measureName\":\"Online_Completeness_1\",\"measureId\":202880,\"widget_type\":\"chart\",\"hasAggregation\""
						+ ":false},\"x\":0,\"y\":0,\"rows\":4,\"cols\":6},{\"x\":6,\"y\":0,\"template_json\":{\"name\":\"RG_TEST_Notif\""
						+ ",\"id\":206658,\"dqType\":\"PROFILING\",\"measureName\":\"RG_TEST_Notif\",\"measureId\":206647,"
						+ "\"widget_type\":\"chart\"},\"cols\":6,\"rows\":4,\"user_defined\":\"Y\",\"deleted\":false,"
/* Replace id*/			+ "\"storyboard_id\":"+idVal+",\"pos_x\":6,\"pos_y\":0,\"height\":4,\"width\":6},{\"x\":0,\"y\":4,\"template_json\""
						+ ":{\"name\":\"RG_test_prof\",\"id\":206596,\"dqType\":\"PROFILING\",\"measureName\":\"DP_test_delta_agg_dev_1\","
						+ "\"measureId\":201848,\"widget_type\":\"chart\"},\"cols\":6,\"rows\":4,\"user_defined\":\"Y\",\"deleted\""
/* Replace id*/ 		+ ":false,\"storyboard_id\":"+idVal+",\"pos_x\":0,\"pos_y\":4,\"height\":4,\"width\":6},{\"x\":6,\"y\":4,"
						+ "\"template_json\":{\"name\":\"DP_test_delta_agg_year_month_1\",\"id\":203863,\"dqType\":\"PROFILING\","
						+ "\"measureName\":\"DP_test_delta_agg_year_month_1\",\"measureId\":203857,\"widget_type\":\"chart\"},\"cols\""
/* Replace id*/			+ ":6,\"rows\":4,\"user_defined\":\"Y\",\"deleted\":false,\"storyboard_id\":"+idVal+",\"pos_x\":6,\"pos_y\":4,"
						+ "\"height\":4,\"width\":6},{\"x\":0,\"y\":8,\"template_json\":{\"name\":\"DP_delta_agg_dev_1\",\"id\":204374,"
						+ "\"dqType\":\"PROFILING\",\"measureName\":\"DP_delta_agg_dev_1\",\"measureId\":204366,\"widget_type\":\"chart\"},"
/* Replace id*/ 		+ "\"cols\":6,\"rows\":4,\"user_defined\":\"Y\",\"deleted\":false,\"storyboard_id\":"+idVal+",\"pos_x\":0,\"pos_y\":8,"
						+ "\"height\":4,\"width\":6},{\"x\":6,\"y\":8,\"template_json\":{\"name\":\"DP_test_delta_migration\","
						+ "\"id\":203757,\"dqType\":\"PROFILING\",\"measureName\":\"DP_test_delta_migration\",\"measureId\":203751,"
						+ "\"widget_type\":\"chart\"},\"cols\":6,\"rows\":4,\"user_defined\":\"Y\",\"deleted\":false,"
/* Replace id*/ 		+ "\"storyboard_id\":"+idVal+",\"pos_x\":6,\"pos_y\":8,\"height\":4,\"width\":6}]}")
				.put(RestAssured.baseURI + "/api/v1/storyboard").then().log().all();
				
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
