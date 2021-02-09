package com.dqp.api.measure.clone;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class cloneCompleteMeasure {
	
	
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
	void createCompletenessMeasureType() { //Open URL with/w/o connecting VPN
			
		String measureName = "Test_clone_accuracy_11_01";
		
			RestAssured.given().contentType("application/json")
				.body("{\"measure.type\":\"griffin\",\"deleted\":false,\"process.type\":\"BATCH\",\"data.sources\""
						+ ":[{\"connectors\":[{\"predicates\":[],\"name\":\"source_1610369708816\",\"type\":\"HIVE\","
						+ "\"data.unit\":\"1day\",\"data.time.zone\":\"\",\"config\":{\"sourceType\":\"default\","
						+ "\"data.time.aggregateData\":false,\"instance\":\"Quantum\",\"cfsProfile\":null,\"database\":"
						+ "\"default\",\"table.name\":\"lte_msisdn_leakage_daily_part_day\",\"where\":\"day=#YYYYMMDD#\"}}],"
						+ "\"name\":\"source\"}],\"name\":"+measureName+",\"description\":\"\","
						+ "\"organization\":\"\",\"owner\":\"data_steward\",\"clone\":true,\"evaluate.rule\":{\"rules\""
						+ ":[{\"out\":[{\"type\":\"metric\",\"name\":\"lte_duration__nlte_duration_null_check\",\"flatten\""
						+ ":\"map\"}],\"rule\":\"select sum(total_count) as total_count, sum(complete_count) as "
						+ "complete_count, if(sum(total_count)=0,0,(sum(complete_count)/sum(total_count))*100) as"
						+ " complete_percentage,sum(incomplete_count) as incomplete_count, if(sum(total_count)=0,0,"
						+ "(sum(incomplete_count)/sum(total_count))*100) as incomplete_percentage from (select count(*)"
						+ " as total_count, 0 as complete_count,count(*)-0 as incomplete_count from source UNION ALL"
						+ " select 0 as total_count,count(*) as complete_count,0-count(*) as incomplete_count from source"
						+ " where lte_duration IS NOT NULL OR nlte_duration IS NOT NULL)\",\"dq.type\":\"COMPLETENESS\","
						+ "\"dsl.type\":\"spark-sql\",\"out.dataframe.name\":\"lte_duration__nlte_duration_null_check\","
						+ "\"details\":{\"aggregateBy\":\"market\"}}]},\"rule.description\":{\"details\":[{\"infos\":"
						+ "\"IS NOT NULL\",\"keys\":[\"lte_duration__nlte_duration_null_check\"],\"name\":\"lte_duration,"
						+ "nlte_duration\"}]},\"dq.type\":\"COMPLETENESS\",\"projectId\":3,\"editInfo\":\"{\\\"dsType\\\":\\\"hive\\\",\\\"dataSource\\\":\\\"hive\\\",\\\"schema\\\":\\\"default\\\",\\\"table\\\":\\\"lte_msisdn_leakage_daily_part_day\\\",\\\"process\\\":\\\"BATCH\\\",\\\"config\\\":{\\\"sourceType\\\":\\\"default\\\",\\\"data.time.aggregateData\\\":false,\\\"instance\\\":\\\"Quantum\\\",\\\"cfsProfile\\\":null,\\\"database\\\":\\\"default\\\",\\\"table.name\\\":\\\"lte_msisdn_leakage_daily_part_day\\\",\\\"where\\\":\\\"day=#YYYYMMDD#\\\"},\\\"partitionConfig\\\":{\\\"where\\\":\\\"day=#YYYYMMDD#\\\",\\\"timezone\\\":\\\"\\\",\\\"num\\\":1,\\\"timetype\\\":\\\"day\\\",\\\"needpath\\\":false,\\\"path\\\":\\\"\\\",\\\"aggregateData\\\":false,\\\"filepath\\\":\\\"\\\",\\\"org\\\":1},\\\"aggregateBy\\\":\\\"market\\\",\\\"advancedRules\\\":[],\\\"totalRows\\\":[{\\\"data\\\":[{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"day\\\",\\\"type\\\":\\\"string\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"lte_duration\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"lte_payload\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"nlte_duration\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"nlte_payload\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"node\\\",\\\"type\\\":\\\"string\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"protocol\\\",\\\"type\\\":\\\"string\\\"}],\\\"selectedItems\\\":[\\\"lte_duration\\\",\\\"nlte_duration\\\"]}],\\\"columnList\\\":[{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"day\\\",\\\"type\\\":\\\"string\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"lte_duration\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"lte_payload\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"market\\\",\\\"type\\\":\\\"string\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"nlte_duration\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"nlte_payload\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"node\\\",\\\"type\\\":\\\"string\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"protocol\\\",\\\"type\\\":\\\"string\\\"}],\\\"aggregatorOption\\\":[{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"day\\\",\\\"type\\\":\\\"string\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"lte_payload\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"market\\\",\\\"type\\\":\\\"string\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"nlte_payload\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"node\\\",\\\"type\\\":\\\"string\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"protocol\\\",\\\"type\\\":\\\"string\\\"}]}\",\"editable\":true}")
					.post(RestAssured.baseURI + "/api/v1/measures").then();
				
		}
	
	
	@Test(priority = 1 , enabled = false) 
	void delete() {   //208957,206576,208968
		when().
			delete(RestAssured.baseURI + "/api/v1/measures/206576").
		then().
		statusCode(204).log().all();
		
	}
	
}
