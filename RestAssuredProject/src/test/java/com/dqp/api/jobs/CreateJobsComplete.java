package com.dqp.api.jobs;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class CreateJobsComplete {
	
	
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
	
	@Test(priority = 0, enabled = false)   //Default project workspace
	void createCompletenessJob() { //Open URL with/w/o connecting VPN
			
			RestAssured.given().contentType("application/json")
				.body("{\"job.name\":\"TEST_E2E_Completeness\",\"job.type\":\"batch\",\"measure.id\":211496,\"dq.type\""
						+ ":\"COMPLETENESS\",\"measure.name\":\"TEST_E2E_Completeness\",\"projectId\":3,\"cron.expression\""
						+ ":\"0 */5 * ? * *\",\"cron.time.zone\":\"GMT+5:30\",\"owner\":\"data_steward\",\"data.segments\""
						+ ":[{\"data.connector.name\":\"source_1610426653360\",\"as.baseline\":true,\"segment.range\""
						+ ":{\"begin\":\"-500day\",\"length\":\"10day\"}}],\"runCount\":0}")
					.post(RestAssured.baseURI + "/api/v1/jobs").then().log().all();
				
		}
	
	@Test(priority = 1, enabled = false)   //Default project workspace
	void editCompletenessJob() { //Open URL with/w/o connecting VPN
			
			RestAssured.given().contentType("application/json")
				.body("{\"id\":211534,\"createdDate\":1610427755303,\"modifiedDate\":null,\"projectId\":3,\"reprocess\""
						+ ":false,\"owner\":\"data_steward\",\"sensitivity\":null,\"sensitivityDeviation\":null,\"measure\""
						+ ":{\"measure.type\":\"griffin\",\"id\":211496,\"createdDate\":1610426652491,\"modifiedDate\""
						+ ":null,\"name\":\"TEST_E2E_Completeness\",\"jobId\":null,\"projectId\":3,\"owner\""
						+ ":\"data_steward\",\"description\":\"\",\"organization\":\"\",\"editable\":true,\"editInfo\""
						+ ":\"{\\\"dsType\\\":\\\"hive\\\",\\\"dataSource\\\":\\\"hive\\\",\\\"schema\\\":\\\"default\\\","
						+ "\\\"table\\\":\\\"lte_msisdn_leakage_daily_part_day\\\",\\\"process\\\":\\\"BATCH\\\","
						+ "\\\"config\\\":{\\\"sourceType\\\":\\\"default\\\",\\\"data.time.aggregateData\\\""
						+ ":false,\\\"instance\\\":\\\"Quantum\\\",\\\"cfsProfile\\\":null,\\\"database\\\""
						+ ":\\\"default\\\",\\\"table.name\\\":\\\"lte_msisdn_leakage_daily_part_day\\\","
						+ "\\\"additional.filter\\\":\\\"\\\",\\\"where\\\":\\\"dt=#YYYYMMDD#\\\"},\\\"partitionConfig\\\":{\\\"where\\\":\\\"dt=#YYYYMMDD#\\\",\\\"timezone\\\":\\\"\\\",\\\"num\\\":1,\\\"timetype\\\":\\\"day\\\",\\\"needpath\\\":false,\\\"path\\\":\\\"\\\",\\\"aggregateData\\\":false,\\\"filepath\\\":\\\"\\\",\\\"org\\\":1,\\\"additional.filter\\\":\\\"\\\"},\\\"aggregateBy\\\":\\\"\\\",\\\"advancedRules\\\":[],\\\"totalRows\\\":[{\\\"data\\\":[{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"day\\\",\\\"type\\\":\\\"string\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"lte_duration\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"lte_payload\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"market\\\",\\\"type\\\":\\\"string\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"nlte_duration\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"nlte_payload\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"node\\\",\\\"type\\\":\\\"string\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"protocol\\\",\\\"type\\\":\\\"string\\\"}],\\\"selectedItems\\\":[\\\"lte_duration\\\",\\\"nlte_duration\\\"]}],\\\"columnList\\\":[{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"day\\\",\\\"type\\\":\\\"string\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"lte_duration\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"lte_payload\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"market\\\",\\\"type\\\":\\\"string\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"nlte_duration\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"nlte_payload\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"node\\\",\\\"type\\\":\\\"string\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"protocol\\\",\\\"type\\\":\\\"string\\\"}],\\\"aggregatorOption\\\":[{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"day\\\",\\\"type\\\":\\\"string\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"lte_payload\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"market\\\",\\\"type\\\":\\\"string\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":true,\\\"name\\\":\\\"nlte_payload\\\",\\\"type\\\":\\\"double\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"node\\\",\\\"type\\\":\\\"string\\\"},{\\\"selectedRules\\\":[],\\\"comment\\\":null,\\\"isNum\\\":false,\\\"name\\\":\\\"protocol\\\",\\\"type\\\":\\\"string\\\"}]}\",\"deleted\":false,\"deletedBy\":null,\"deletedDate\":null,\"jobInstanceId\":null,\"deviationCalc\":null,\"offenderJobConfig\":null,\"active\":false,\"dq.type\":\"COMPLETENESS\",\"sinks\":[\"ELASTICSEARCH\",\"HDFS\",\"MYSQL\"],\"process.type\":\"BATCH\",\"rule.description\":{\"details\":[{\"infos\":\"IS NOT NULL\",\"keys\":[\"lte_duration__nlte_duration_null_check\"],\"name\":\"lte_duration,nlte_duration\"}]},\"data.sources\":[{\"id\":211499,\"createdDate\":1610426652492,\"modifiedDate\":null,\"name\":\"source\",\"connectors\":[{\"id\":211500,\"createdDate\":1610426652492,\"modifiedDate\":null,\"name\":\"source_1610426653360\",\"type\":\"HIVE\",\"version\":null,\"predicates\":[],\"data.unit\":\"1day\",\"data.time.zone\":\"\",\"config\":{\"sourceType\":\"default\",\"data.time.aggregateData\":false,\"instance\":\"Quantum\",\"cfsProfile\":null,\"database\":\"default\",\"table.name\":\"lte_msisdn_leakage_daily_part_day\",\"additional.filter\":\"\",\"where\":\"dt=#YYYYMMDD#\"}}],\"baseline\":false}],\"evaluate.rule\":{\"id\":211497,\"createdDate\":1610426652492,\"modifiedDate\":null,\"rules\":[{\"id\":211498,\"createdDate\":1610426652492,\"modifiedDate\":null,\"rule\":\"select sum(total_count) as total_count, sum(complete_count) as complete_count, if(sum(total_count)=0,0,(sum(complete_count)/sum(total_count))*100) as complete_percentage,sum(incomplete_count) as incomplete_count, if(sum(total_count)=0,0,(sum(incomplete_count)/sum(total_count))*100) as incomplete_percentage from (select count(*) as total_count, 0 as complete_count,count(*)-0 as incomplete_count from source UNION ALL select 0 as total_count,count(*) as complete_count,0-count(*) as incomplete_count from source where lte_duration IS NOT NULL OR nlte_duration IS NOT NULL)\",\"dsl.type\":\"spark-sql\",\"dq.type\":\"COMPLETENESS\",\"out.dataframe.name\":\"lte_duration__nlte_duration_null_check\",\"details\":{},\"out\":[{\"type\":\"metric\",\"name\":\"lte_duration__nlte_duration_null_check\",\"flatten\":\"map\"}]}]}},\"modifiedBy\":\"data_steward\",\"deletedBy\":null,\"deletedDate\":null,\"measureConfig\":\"default.lte_msisdn_leakage_daily_part_day\",\"sourcePartitionInfo\":{},\"targetPartitionInfo\":{},\"previousFireTime\":null,\"parentJob\":null,\"offenderJobExists\":false,\"runCount\":0,\"hasAggregation\":false,\"jobType\":\"batch\",\"measureId\":211496,\"measureName\":\"TEST_E2E_Completeness\",\"dqType\":\"COMPLETENESS\",\"jobName\":\"TEST_E2E_Completeness\",\"metricName\":\"TEST_E2E_Completeness\",\"quartzName\":\"TEST_E2E_Completeness_1610427755307\",\"quartzGroup\":\"BA\",\"cronExpression\":\"0 */1 * ? * *\",\"jobState\":{\"jobName\":\"TEST_E2E_Completeness_1610427755307\",\"triggerState\":\"WAITING\",\"nextFireTime\":1610427780000,\"previousFireTime\":null,\"toStop\":true,\"toStart\":false,\"state\":\"NORMAL\"},\"cronTimeZone\":\"GMT+5:30\",\"predicateConfig\":null,\"dataSegments\":[{\"id\":211535,\"createdDate\":1610427755303,\"modifiedDate\":null,\"data.connector.name\":\"source_1610426653360\",\"as.baseline\":true,\"segment.range\":{\"id\":211536,\"createdDate\":1610427755303,\"modifiedDate\":null,\"begin\":\"-590day\",\"length\":\"20day\"}}],\"showDetail\":false,\"job.name\":\"TEST_E2E_Completeness\",\"job.type\":\"batch\",\"measure.id\":211496,\"cron.expression\":\"0 */5 * ? * *\",\"cron.time.zone\":\"GMT+5:30\",\"measure.name\":\"TEST_E2E_Completeness\",\"metric.name\":\"TEST_E2E_Completeness\",\"quartz.group\":\"BA\",\"quartz.name\":\"TEST_E2E_Completeness_1610427755307\",\"job.state\":{\"jobName\":\"TEST_E2E_Completeness_1610427755307\",\"triggerState\":\"WAITING\",\"nextFireTime\":1610427780000,\"previousFireTime\":null,\"toStop\":true,\"toStart\":false,\"state\":\"NORMAL\"},\"predicate.config\":null,\"dq.type\":\"COMPLETENESS\",\"data.segments\":[{\"data.connector.name\":\"source_1610426653360\",\"as.baseline\":true,\"segment.range\":{\"begin\":\"-610day\",\"length\":\"20day\"}}]}")
					.put(RestAssured.baseURI + "/api/v1/jobs").then().log().all();
				
		}
	
	
	@Test(priority = 1 , enabled = false) 
	void delete() {   //208957,206576,208968
		when().
			delete(RestAssured.baseURI + "/api/v1/jobs/211534").   //add ID of created job to delete record
		then().
		statusCode(204).log().all();
		
	}
	
}
