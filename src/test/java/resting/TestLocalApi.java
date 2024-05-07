package resting;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class TestLocalApi {
	
	@Test

	public void get() {
		
		baseURI = "http://localhost:3000";
		
		given().when().get("/subjects").then().statusCode(200).log().all();		
	}
	
	
	@Test

	public void post() {
		
		baseURI = "http://localhost:3000";
		
		JSONObject data = new JSONObject();
	data.put("firstname", "Harrison");
		data.put("lastname", "Afful");
		data.put("subjectId", 2);
		
		given().body(data.toJSONString()).when().post("/users").then().statusCode(201).log().all();
	}
	
	
//	@Test
//
//	public void getAgain() {
//		
//		baseURI = "http://localhost:3000";
//		
//		given().when().get("/users").then().statusCode(200).log().all();		
//	}
//	
	
//	@Test
//
//	public void put() {
//		
//		baseURI = "http://localhost:3000";
//		
//		JSONObject data = new JSONObject();
//		data.put("firstname", "Sulley");
//		data.put("lastname", "Muntari");
//		data.put("subjectId", 1);
//		
//		given().body(data.toJSONString()).when().put("/users/").then().statusCode(200).log().all();
//	}
	

//	@Test
//	public void patch() {
//		
//		baseURI = "http://localhost:3000";
//		
//		JSONObject data = new JSONObject();
//		
//		data.put("lastname", "Ali Muntari");
//		
//		
//		given().body(data.toJSONString()).when().patch("/users/bb34").then().statusCode(200).log().all();
//	}
	
	
//	@Test
//
//	public void delete() {
//		
//		baseURI = "http://localhost:3000";
//		
//	
//		
//		
//		given().when().delete("/users/bb34").then().statusCode(200).log().all();
//	}
	
	
	@Test
	public void addsubject() {
		
		baseURI = "http://localhost:3000";
		
		JSONObject data = new JSONObject();
		data.put("name", "Selenium");
		data.put("subjectId", "3");
		
	
		given().body(data.toJSONString()).when().post("/subjects").then().log().all();
		
//		given().when().delete("/users/bb34").then().statusCode(200).log().all();
	}
}
