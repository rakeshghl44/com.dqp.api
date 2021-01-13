package com.dqp.api.jobs;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class CreateJobsDistinct {
	
	
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
	
	@Test(priority = 0, enabled = true)  //Rakesh/TMO_Metrics project workspace
	void createDistinctMeasureType() { //Open URL with/w/o connecting VPN
			
			RestAssured.given().contentType("application/json")
				.body("{\"measure.type\":\"griffin\",\"deleted\":false,\"process.type\":\"BATCH\",\"data.sources\":"
						+ "[{\"connectors\":[{\"predicates\":[],\"name\":\"source_1610360498828\",\"type\":\"HIVE\","
						+ "\"data.unit\":\"1day\",\"data.time.zone\":\"\",\"config\":{\"sourceType\":\"default\","
						+ "\"data.time.aggregateData\":false,\"instance\":\"Quantum\",\"cfsProfile\":null,\"database\""
						+ ":\"default\",\"table.name\":\"lte_msisdn_leakage_daily_part_day\",\"where\":\"dt=#YYYYMMDD#\"}}],"
	/*Name change*/		+ "\"name\":\"source\"}],\"name\":\"Test_Disctinctness_11_01\",\"description\":\"\",\"organization\":"
						+ "\"\",\"owner\":\"data_steward\",\"id\":null,\"clone\":false,\"dq.type\":\"DISTINCTNESS\","
						+ "\"evaluate.rule\":{\"rules\":[{\"out\":[{\"type\":\"metric\",\"name\":\"lte_duration__nlte_duration_dup\""
						+ ",\"flatten\":\"map\"}],\"rule\":\"SELECT distinct,total,(total - distinct) as duplicate, "
						+ "if(total=0,0,(distinct/total)*100) as distinct_percentage, if(total=0,0,((total - distinct)/total)*100) "
						+ "as duplicate_percentage from ( select count(distinct(lte_duration,nlte_duration)) as distinct, count(*) "
						+ "as total FROM source)\",\"dq.type\":\"DISTINCTNESS\",\"dsl.type\":\"spark-sql\",\"out.dataframe.name\""
						+ ":\"lte_duration__nlte_duration_dup\",\"details\":{\"aggregateBy\":\"market\"}}]},\"rule.description\":{\"details\""
						+ ":[{\"infos\":\"IS DISTINCT\",\"keys\":[],\"name\":\"lte_duration,nlte_duration\"}]},\"projectId\":8252,\"editInfo\""
						+ ":\"{\\\"dsType\\\":\\\"hive\\\",\\\"dataSource\\\":\\\"hive\\\",\\\"schema\\\":\\\"default\\\",\\\"table\\\""
						+ ":\\\"lte_msisdn_leakage_daily_part_day\\\",\\\"process\\\":\\\"BATCH\\\",\\\"config\\\":{\\\"sourceType\\\""
						+ ":\\\"default\\\",\\\"data.time.aggregateData\\\":false,\\\"instance\\\":\\\"Quantum\\\",\\\"cfsProfile\\\""
						+ ":null,\\\"database\\\":\\\"default\\\",\\\"table.name\\\":\\\"lte_msisdn_leakage_daily_part_day\\\",\\\"where\\\""
						+ ":\\\"dt=#YYYYMMDD#\\\"},\\\"partitionConfig\\\":{\\\"where\\\":\\\"dt=#YYYYMMDD#\\\",\\\"timezone\\\":\\\"\\\",\\\"num\\\""
						+ ":1,\\\"timetype\\\":\\\"day\\\",\\\"needpath\\\":false,\\\"path\\\":\\\"\\\",\\\"aggregateData\\\":false,\\\"filepath\\\""
						+ ":\\\"\\\",\\\"org\\\":1},\\\"aggregateBy\\\":\\\"market\\\",\\\"advancedRules\\\":[],\\\"totalSourceRows\\\""
						+ ":[{\\\"data\\\":[{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"day\\\",\\\"type\\\""
						+ ":\\\"string\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"lte_duration\\\","
						+ "\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\""
						+ ":\\\"lte_payload\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\""
						+ ":true,\\\"name\\\":\\\"nlte_duration\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\""
						+ ":null,\\\"isNum\\\":true,\\\"name\\\":\\\"nlte_payload\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\""
						+ ":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"node\\\",\\\"type\\\":\\\"string\\\"},{\\\"selectedRules\\\""
						+ ":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"protocol\\\",\\\"type\\\":\\\"string\\\"}],"
						+ "\\\"selectedItems\\\":[\\\"lte_duration\\\",\\\"nlte_duration\\\"]}],\\\"sourceColumnList\\\":[{\\\"selectedRules\\\""
						+ ":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"day\\\",\\\"type\\\":\\\"string\\\"},{\\\"selectedRules\\\""
						+ ":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"lte_duration\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"lte_payload\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"market\\\",\\\"type\\\":\\\"string\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"nlte_duration\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"nlte_payload\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"node\\\",\\\"type\\\":\\\"string\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"protocol\\\",\\\"type\\\":\\\"string\\\"}],\\\"aggregatorOption\\\":[{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"day\\\",\\\"type\\\":\\\"string\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"lte_payload\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"market\\\",\\\"type\\\":\\\"string\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"nlte_payload\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"node\\\",\\\"type\\\":\\\"string\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"protocol\\\",\\\"type\\\":\\\"string\\\"}]}\",\"editable\":true}")
				.post(RestAssured.baseURI + "/api/v1/jobs").then().log().all();
				
		}
	
	
	@Test(priority = 1 , enabled = false) 
	void delete() {   //208957,206576,208968
		when().
			delete(RestAssured.baseURI + "/api/v1/measures/211259").
		then().
		statusCode(204).log().all();
		
	}
	
}
