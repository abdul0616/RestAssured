package resting;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class TestingApi {
	
	@Test 
	
	public void testone() {
		Response response = get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.getStatusCode());
	}
	
	@Test
	public void test2Get() {
		
		baseURI = "https://reqres.in/api";
		given().get("/users?page=2").then().
		body("data[4].first_name",equalTo("George"));
	}
	@Test
	
	public void test3Post() {
		
		baseURI = "https://reqres.in/api";
		Map<String, Object> map = new HashMap<String,Object>();
		
		map.put("name", "Akosua Mapuka");
		map.put("Job", "dancer");
		System.out.println(map);
		
		
		JSONObject request = new JSONObject();
		request.put("name", "Akosua Mapuka");
		request.put("Job", "dancer");
		
		given().body(request.toJSONString()).when().post("/user").then().statusCode(201).log().all();		
		
		System.out.println(request);
	
		
	}
	@Test
	public void test4PutAndPatch() {
		
		baseURI = "https://reqres.in/api";
//		Map<String, Object> map = new HashMap<String,Object>();
//		
//		map.put("name", "Akosua Mapuka");
//		map.put("Job", "dancer");
//		System.out.println(map);
		
		
		JSONObject request = new JSONObject();
		request.put("name", "Akos Mapuka");
		request.put("Job", "dancer");
		
		given().body(request.toJSONString()).when().put("/users/2").then().statusCode(200).log().all();		
		
		
	}
	
	@Test
	public void testDelete() {
		
		baseURI = "https://reqres.in/api";
//		Map<String, Object> map = new HashMap<String,Object>();
//		
//		map.put("name", "Akosua Mapuka");
//		map.put("Job", "dancer");
//		System.out.println(map);
//		
//		
//		JSONObject request = new JSONObject();
//		request.put("name", "Akos Mapuka");
//		request.put("Job", "dancer");
		
		given().when().delete("/users/2").then().statusCode(204).log().all();		
		
		
	}
	

}
