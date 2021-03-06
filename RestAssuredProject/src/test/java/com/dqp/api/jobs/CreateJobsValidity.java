package com.dqp.api.jobs;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class CreateJobsValidity {
	
	
	@BeforeSuite
	public void setup() {
		RestAssured.baseURI = "http://192.168.9.11:25200";
	}
	
		
	/*
	 * @Test(priority = 0) void loginAuthentication() { //Open URL with/w/o
	 * connecting VPN
	 * 
	 * RestAssured.given().contentType("application/json")
	 * .body("{"+"\"username\": \"data_steward\",\"password\": \"cGFzc3dvcmQ=\"}")
	 * .post(RestAssured.baseURI + "/api/v1/login/authenticate").then();
	 * 
	 * }
	 */
	
	@Test(priority = 0, enabled = true) 
	void createValidityMeasureType() { //Open URL with/w/o connecting VPN  /*Name change*/	
			
			RestAssured.given().contentType("application/json")
				.body("{\"name\":\"Test_validity_11_01\",\"measure.type\":\"griffin\",\"dq.type\":\"VALIDITY\","
						+ "\"rule.description\":{\"details\":[{\"name\":\"lte_duration - Is Not Null\",\"infos\""
						+ ":\"\",\"keys\":[\"lte_duration_is_not_null_valid_count\",\"lte_duration_is_not_null_invalid_count\""
						+ ",\"lte_duration_is_not_null_total_count\",\"lte_duration_is_not_null_valid_percentage\","
						+ "\"lte_duration_is_not_null_invalid_percentage\"]},{\"name\":\"nlte_duration - Is Not Null\","
						+ "\"infos\":\"\",\"keys\":[\"nlte_duration_is_not_null_valid_count\",\"nlte_duration_is_not_null_invalid_count\""
						+ ",\"nlte_duration_is_not_null_total_count\",\"nlte_duration_is_not_null_valid_percentage\","
						+ "\"nlte_duration_is_not_null_invalid_percentage\"]}]},\"process.type\":\"BATCH\",\"owner\""
						+ ":\"data_steward\",\"description\":\"\",\"organization\":\"\",\"data.sources\":[{\"name\":\"source\","
						+ "\"connectors\":[{\"name\":\"source1610361266080\",\"type\":\"HIVE\",\"version\":\"1.2\",\"data.unit\":"
						+ "\"1day\",\"data.time.zone\":\"\",\"config\":{\"sourceType\":\"default\",\"data.time.aggregateData\":false,"
						+ "\"instance\":\"Quantum\",\"cfsProfile\":null,\"database\":\"default\",\"table.name\":\"lte_msisdn_leakage_daily_part_day\","
						+ "\"where\":\"dt=#YYYYMMDD#\"}}]}],\"evaluate.rule\":{\"rules\":[{\"rule\":\"SELECT lte_duration__is_not_null_valid_count,"
						+ "\\n    (lte_duration__is_not_null_total_count - lte_duration__is_not_null_valid_count) AS lte_duration__is_not_null_invalid_count,"
						+ "\\n    lte_duration__is_not_null_total_count, (lte_duration__is_not_null_valid_count/lte_duration__is_not_null_total_count*100) "
						+ "AS lte_duration__is_not_null_valid_percentage,\\n    ((lte_duration__is_not_null_total_count - "
						+ "lte_duration__is_not_null_valid_count)/lte_duration__is_not_null_total_count*100) AS lte_duration__is_not_null_invalid_percentage"
						+ " FROM (SELECT COUNT(1) AS lte_duration__is_not_null_valid_count FROM source\\n         "
						+ " where trim(lte_duration) <> '' and lte_duration is not null) A JOIN (SELECT COUNT(1) AS "
						+ "lte_duration__is_not_null_total_count FROM source ) B\",\"dsl.type\":\"spark-sql\",\"dq.type\":\"VALIDITY\","
						+ "\"out.dataframe.name\":\"lte_duration__is_not_null\",\"out\":[{\"type\":\"metric\",\"name\":"
						+ "\"lte_msisdn_leakage_daily_part_day\"}],\"details\":{\"aggregateBy\":\"market\"}},{\"rule\":"
						+ "\"SELECT nlte_duration__is_not_null_valid_count,\\n    (nlte_duration__is_not_null_total_count - "
						+ "nlte_duration__is_not_null_valid_count) AS nlte_duration__is_not_null_invalid_count,\\n    "
						+ "nlte_duration__is_not_null_total_count, (nlte_duration__is_not_null_valid_count/nlte_duration__is_not_null_total_count*100)"
						+ " AS nlte_duration__is_not_null_valid_percentage,\\n    ((nlte_duration__is_not_null_total_count - nlte_duration__is_not_null_valid_count)/nlte_duration__is_not_null_total_count*100) AS nlte_duration__is_not_null_invalid_percentage FROM (SELECT COUNT(1) AS nlte_duration__is_not_null_valid_count FROM source\\n          where trim(nlte_duration) <> '' and nlte_duration is not null) A JOIN (SELECT COUNT(1) AS nlte_duration__is_not_null_total_count FROM source ) B\",\"dsl.type\":\"spark-sql\",\"dq.type\":\"VALIDITY\",\"out.dataframe.name\":\"nlte_duration__is_not_null\",\"out\":[{\"type\":\"metric\",\"name\":\"lte_msisdn_leakage_daily_part_day\"}],\"details\":{\"aggregateBy\":\"market\"}}]},\"editInfo\":\"{\\\"dsType\\\":\\\"hive\\\",\\\"dataSource\\\":\\\"hive\\\",\\\"schema\\\":\\\"default\\\",\\\"table\\\":\\\"lte_msisdn_leakage_daily_part_day\\\",\\\"process\\\":\\\"BATCH\\\",\\\"config\\\":{\\\"sourceType\\\":\\\"default\\\",\\\"data.time.aggregateData\\\":false,\\\"instance\\\":\\\"Quantum\\\",\\\"cfsProfile\\\":null,\\\"database\\\":\\\"default\\\",\\\"table.name\\\":\\\"lte_msisdn_leakage_daily_part_day\\\",\\\"where\\\":\\\"dt=#YYYYMMDD#\\\"},\\\"partitionConfig\\\":{\\\"where\\\":\\\"dt=#YYYYMMDD#\\\",\\\"timezone\\\":\\\"\\\",\\\"num\\\":1,\\\"timetype\\\":\\\"day\\\",\\\"needpath\\\":false,\\\"path\\\":\\\"\\\",\\\"aggregateData\\\":false,\\\"filepath\\\":\\\"\\\",\\\"org\\\":1},\\\"aggregateBy\\\":\\\"market\\\",\\\"advancedRules\\\":[],\\\"rules\\\":[{\\\"ruleArray\\\":[{\\\"rule\\\":{\\\"id\\\":1,\\\"itemName\\\":\\\"Is Not Null\\\",\\\"type\\\":\\\"none\\\"},\\\"ruleType\\\":\\\"none\\\"}],\\\"name\\\":\\\"lte_duration\\\",\\\"type\\\":\\\"numeric\\\"},{\\\"ruleArray\\\":[{\\\"rule\\\":{\\\"id\\\":1,\\\"itemName\\\":\\\"Is Not Null\\\",\\\"type\\\":\\\"none\\\"},\\\"ruleType\\\":\\\"none\\\"}],\\\"name\\\":\\\"nlte_duration\\\",\\\"type\\\":\\\"numeric\\\"}],\\\"selectCols\\\":[{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"day\\\",\\\"type\\\":\\\"string\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"lte_duration\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"lte_payload\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"market\\\",\\\"type\\\":\\\"string\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"nlte_duration\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"nlte_payload\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"node\\\",\\\"type\\\":\\\"string\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"protocol\\\",\\\"type\\\":\\\"string\\\"}]}\",\"editable\":true,\"id\":null,\"projectId\":8252}")
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
