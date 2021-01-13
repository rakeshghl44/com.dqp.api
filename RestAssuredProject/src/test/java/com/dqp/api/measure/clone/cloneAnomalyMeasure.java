package com.dqp.api.measure.clone;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class cloneAnomalyMeasure {
	
	
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
	void createAnomalyMeasureType() { //Open URL with/w/o connecting VPN  /*Name change*/	
			
			RestAssured.given().contentType("application/json")
				.body("{\"measure.type\":\"griffin\",\"deleted\":false,\"process.type\":\"BATCH\",\"data.sources\""
						+ ":[{\"connectors\":[{\"predicates\":[],\"name\":\"source_1610367877776\",\"type\":\"HIVE\","
						+ "\"data.unit\":\"1day\",\"data.time.zone\":\"\",\"config\":{\"sourceType\":\"default\","
						+ "\"data.time.aggregateData\":false,\"instance\":\"Quantum\",\"cfsProfile\":null,\"database\""
						+ ":\"default\",\"table.name\":\"lte_msisdn_leakage_daily_part_day\",\"where\":\"\"}}],\"name\""
						+ ":\"source\"}],\"name\":\"Test_clone_Anomaly_11_01\",\"description\":\"\",\"organization\":\"\","
						+ "\"owner\":\"data_steward\",\"clone\":true,\"dq.type\":\"ANOMALY\",\"projectId\":8252,"
						+ "\"evaluate.rule\":{\"rules\":[{\"out\":[{\"type\":\"metric\",\"name\":\"lte_duration\","
						+ "\"flatten\":\"map\"}],\"rule\":\"anomaly_median\",\"dq.type\":\"ANOMALY\",\"dsl.type\""
						+ ":\"df-ops\",\"out.dataframe.name\":\"lte_duration\",\"details\":{\"groupByList\":[\"day\","
						+ "\"market\"],\"contributorLevels\":\"market\",\"contributorsList\":[{\"dimension\":\"protocol\","
						+ "\"dimensionAlias\":\"protocol\",\"metric\":\"min(lte_duration)\",\"percentageContribution\""
						+ ":true,\"sort\":\"DESC\",\"metricAlias\":\"min_of_lte_duration\",\"considerDrillDown\""
						+ ":false,\"drillDown\":[],\"level\":0,\"metricPercentage\":\"sum(lte_duration)\"}]"
						+ ",\"contributorsCount\":10,\"adGroupByList\":[\"day\",\"market\"],\"startDate\":"
						+ "\"\",\"filterRowLevelExpr\":\"\",\"metrics\":[],\"metricList\":[],\"medianColumnList\""
						+ ":[],\"list\":\"min(lte_duration) as lte_duration\",\"derived\":false,\"derivedList\""
						+ ":\" as null\",\"medianColumn\":\"lte_duration\",\"considerUpperLimit\":true,"
						+ "\"considerLowerLimit\":true,\"strictness\":\"strict\",\"timeInfo\":{\"type\":\"day_\",\"value\""
						+ ":\"\",\"skipLatestPartition\":false}}}]},\"editInfo\":\"{\\\"dsType\\\":\\\"hive\\\","
						+ "\\\"dataSource\\\":\\\"hive\\\",\\\"schema\\\":\\\"default\\\",\\\"table\\\":"
						+ "\\\"lte_msisdn_leakage_daily_part_day\\\",\\\"process\\\":\\\"BATCH\\\",\\\"config\\\""
						+ ":{\\\"sourceType\\\":\\\"default\\\",\\\"data.time.aggregateData\\\":false,\\\"instance\\\""
						+ ":\\\"Quantum\\\",\\\"cfsProfile\\\":null,\\\"database\\\":\\\"default\\\",\\\"table.name\\\""
						+ ":\\\"lte_msisdn_leakage_daily_part_day\\\",\\\"where\\\":\\\"\\\"},\\\"partitionConfig\\\""
						+ ":{\\\"where\\\":\\\"\\\",\\\"timezone\\\":\\\"\\\",\\\"num\\\":1,\\\"timetype\\\""
						+ ":\\\"day\\\",\\\"needpath\\\":false,\\\"path\\\":\\\"\\\",\\\"aggregateData\\\":false},\\\"skipLatestPartition\\\":false,\\\"timeType\\\":\\\"\\\",\\\"timeValue\\\":\\\"\\\",\\\"analyzeList\\\":[{\\\"name\\\":\\\"market\\\",\\\"anomaly\\\":true}],\\\"influencerList\\\":[],\\\"columnList\\\":[{\\\"name\\\":\\\"day\\\",\\\"type\\\":\\\"string\\\"},{\\\"name\\\":\\\"lte_duration\\\",\\\"type\\\":\\\"string\\\"},{\\\"name\\\":\\\"lte_payload\\\",\\\"type\\\":\\\"string\\\"},{\\\"name\\\":\\\"market\\\",\\\"type\\\":\\\"string\\\"},{\\\"name\\\":\\\"nlte_duration\\\",\\\"type\\\":\\\"string\\\"},{\\\"name\\\":\\\"nlte_payload\\\",\\\"type\\\":\\\"string\\\"},{\\\"name\\\":\\\"node\\\",\\\"type\\\":\\\"string\\\"},{\\\"name\\\":\\\"protocol\\\",\\\"type\\\":\\\"string\\\"}],\\\"xAxisAnomaly\\\":true,\\\"xAxis\\\":\\\"day\\\",\\\"XAxisUnit\\\":\\\"day\\\",\\\"startDate\\\":\\\"\\\",\\\"limit\\\":\\\"Both\\\",\\\"strictness\\\":\\\"strict\\\",\\\"derivedColumn\\\":\\\"column\\\",\\\"derivedColumnName\\\":null,\\\"columnName\\\":\\\"lte_duration\\\",\\\"columnAgg\\\":\\\"min\\\",\\\"derivedExpression\\\":\\\"\\\",\\\"filterQuery\\\":{\\\"condition\\\":\\\"and\\\",\\\"rules\\\":[]},\\\"contributorsList\\\":[{\\\"dimension\\\":\\\"protocol\\\",\\\"dimensionAlias\\\":\\\"protocol\\\",\\\"metric\\\":\\\"min(lte_duration)\\\",\\\"percentageContribution\\\":true,\\\"sort\\\":\\\"DESC\\\",\\\"metricAlias\\\":\\\"min_of_lte_duration\\\",\\\"considerDrillDown\\\":false,\\\"drillDown\\\":[],\\\"level\\\":0,\\\"metricPercentage\\\":\\\"sum(lte_duration)\\\"}],\\\"contributorsCount\\\":10}\",\"editable\":true}")
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
