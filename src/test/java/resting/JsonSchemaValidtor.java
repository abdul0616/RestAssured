package resting;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.*;


import org.testng.annotations.Test;

public class JsonSchemaValidtor {
	
	
	@Test
	public void validateSchema() {
		
//		baseURI = "http://localhost:3000";
		
		given().get("https://reqres.in/api/users?page=2").then().assertThat().body(matchesJsonSchemaInClasspath("Schema.json"));
		
		
		
 
		
	
	}

}
