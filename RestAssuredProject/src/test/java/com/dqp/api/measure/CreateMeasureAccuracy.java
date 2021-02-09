package com.dqp.api.measure;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class CreateMeasureAccuracy {
	
	
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
	void createAccuracyMeasureType() { //Open URL with/w/o connecting VPN  /*Name change*/	
		
		String measureName = "Test_accuracy_11_01";
		
			RestAssured.given().contentType("application/json")
				.body("{\"measure.type\":\"griffin\",\"name\":\"+measureName+\",\"owner\":\"data_steward\","
						+ "\"description\":\"\",\"organization\":\"\",\"dq.type\":\"ACCURACY\",\"rule.description\""
						+ ":{\"details\":[{\"name\":\"ACCURACY\",\"infos\":\"source.lte_duration=target.lte_duration AND "
						+ "source.nlte_duration=target.nlte_duration\",\"key\":[{\"source\":\"lte_duration\",\"type\":\"double\",\"rule\""
						+ ":\"\",\"target\":\"lte_duration\",\"operator\":\"=\",\"targetType\":\"double\"},{\"source\":\"nlte_duration\","
						+ "\"type\":\"double\",\"rule\":\"\",\"target\":\"nlte_duration\",\"operator\":\"=\",\"targetType\":\"double\"}]}]},"
						+ "\"process.type\":\"BATCH\",\"data.sources\":[{\"name\":\"source\",\"connectors\":[{\"name\":\"source1610362368738\","
						+ "\"type\":\"HIVE\",\"version\":\"1.2\",\"data.unit\":\"1day\",\"data.time.zone\":\"\",\"config\":{\"sourceType\""
						+ ":\"default\",\"data.time.aggregateData\":false,\"instance\":\"Quantum\",\"cfsProfile\":null,\"database\":\"default\""
						+ ",\"table.name\":\"lte_msisdn_leakage_daily_part_day\",\"where\":\"dt=#YYYYMMDD#\"},\"predicates\":[]}]},{\"name\""
						+ ":\"target\",\"connectors\":[{\"name\":\"target1610362368738\",\"type\":\"HIVE\",\"version\":\"1.2\",\"data.unit\""
						+ ":\"1day\",\"data.time.zone\":\"\",\"config\":{\"sourceType\":\"default\",\"data.time.aggregateData\":false,"
						+ "\"instance\":\"Quantum\",\"cfsProfile\":null,\"database\":\"default\",\"table.name\":"
						+ "\"lte_msisdn_leakage_daily_part_day_2019_temp\",\"where\":\"dt=#YYYYMMDD#\"},\"predicates\":[]}]}],\"evaluate.rule\""
						+ ":{\"rules\":[{\"dsl.type\":\"griffin-dsl\",\"dq.type\":\"ACCURACY\",\"out.dataframe.name\":\"accuracy\",\"rule\""
						+ ":\"source.lte_duration=target.lte_duration AND source.nlte_duration=target.nlte_duration\",\"name\":\"ACCURACY\","
						+ "\"out\":[{\"type\":\"metric\",\"name\":\"accuracy\"}],\"details\":{\"aggregateBy\":\"market\",\"targetAggregateBy\""
						+ ":\"protocol\"}}]},\"projectId\":8252,\"editInfo\":\"{\\\"source\\\":{\\\"dsType\\\":\\\"hive\\\",\\\"dataSource\\\""
						+ ":\\\"hive\\\",\\\"schema\\\":\\\"default\\\",\\\"table\\\":\\\"lte_msisdn_leakage_daily_part_day\\\",\\\"process\\\""
						+ ":\\\"BATCH\\\",\\\"config\\\":{\\\"sourceType\\\":\\\"default\\\",\\\"data.time.aggregateData\\\":false,"
						+ "\\\"instance\\\":\\\"Quantum\\\",\\\"cfsProfile\\\":null,\\\"database\\\":\\\"default\\\",\\\"table.name\\\""
						+ ":\\\"lte_msisdn_leakage_daily_part_day\\\",\\\"where\\\":\\\"dt=#YYYYMMDD#\\\"},\\\"partitionConfig\\\":{\\\"where\\\""
						+ ":\\\"dt=#YYYYMMDD#\\\",\\\"timezone\\\":\\\"\\\",\\\"num\\\":1,\\\"timetype\\\":\\\"day\\\",\\\"needpath\\\""
						+ ":false,\\\"path\\\":\\\"\\\",\\\"aggregateData\\\":false,\\\"filepath\\\":\\\"\\\",\\\"org\\\":1},\\\"aggregateBy\\\""
						+ ":\\\"market\\\",\\\"advancedRules\\\":[],\\\"selectCols\\\":[{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"lte_duration\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"nlte_duration\\\",\\\"type\\\":\\\"double\\\"}]},\\\"target\\\":{\\\"dsType\\\":\\\"hive\\\",\\\"dataSource\\\":\\\"hive\\\",\\\"schema\\\":\\\"default\\\",\\\"table\\\":\\\"lte_msisdn_leakage_daily_part_day_2019_temp\\\",\\\"process\\\":\\\"BATCH\\\",\\\"config\\\":{\\\"sourceType\\\":\\\"default\\\",\\\"data.time.aggregateData\\\":false,\\\"instance\\\":\\\"Quantum\\\",\\\"cfsProfile\\\":null,\\\"database\\\":\\\"default\\\",\\\"table.name\\\":\\\"lte_msisdn_leakage_daily_part_day_2019_temp\\\",\\\"where\\\":\\\"dt=#YYYYMMDD#\\\"},\\\"partitionConfig\\\":{\\\"where\\\":\\\"dt=#YYYYMMDD#\\\",\\\"timezone\\\":\\\"\\\",\\\"num\\\":1,\\\"timetype\\\":\\\"day\\\",\\\"needpath\\\":false,\\\"path\\\":\\\"\\\",\\\"aggregateData\\\":false,\\\"filepath\\\":\\\"\\\",\\\"org\\\":1},\\\"aggregateBy\\\":\\\"protocol\\\",\\\"advancedRules\\\":[],\\\"selectCols\\\":[{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"lte_duration\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"nlte_duration\\\",\\\"type\\\":\\\"double\\\"}]},\\\"destColumnList\\\":[{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"market\\\",\\\"type\\\":\\\"string\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"protocol\\\",\\\"type\\\":\\\"string\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"node\\\",\\\"type\\\":\\\"string\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"lte_duration\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"nlte_duration\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"lte_payload\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"nlte_payload\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"day\\\",\\\"type\\\":\\\"string\\\"}],\\\"sourceColumnList\\\":[{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"market\\\",\\\"type\\\":\\\"string\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"protocol\\\",\\\"type\\\":\\\"string\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"node\\\",\\\"type\\\":\\\"string\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"lte_duration\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"nlte_duration\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"lte_payload\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"nlte_payload\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"day\\\",\\\"type\\\":\\\"string\\\"}],\\\"rules\\\":[{\\\"source\\\":\\\"lte_duration\\\",\\\"type\\\":\\\"double\\\",\\\"rule\\\":\\\"\\\",\\\"target\\\":\\\"lte_duration\\\",\\\"operator\\\":\\\"=\\\",\\\"targetType\\\":\\\"double\\\"},{\\\"source\\\":\\\"nlte_duration\\\",\\\"type\\\":\\\"double\\\",\\\"rule\\\":\\\"\\\",\\\"target\\\":\\\"nlte_duration\\\",\\\"operator\\\":\\\"=\\\",\\\"targetType\\\":\\\"double\\\"}],\\\"storeMissedRecords\\\":{\\\"shouldStore\\\":false}}\",\"editable\":true,\"id\":null}")
				.post(RestAssured.baseURI + "/api/v1/measures").then().log().all();
				
		}
	
	
	@Test(priority = 1 , enabled = false) 
	void delete() {   //208957,206576,208968
		when().
			delete(RestAssured.baseURI + "/api/v1/measures/206576").
		then().
		statusCode(204).log().all();
		
	}
	
}
