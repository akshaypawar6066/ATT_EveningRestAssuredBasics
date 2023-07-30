package pathAndQueryparam;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class QueryParameters {
	
	@Test
	public void getUserDetails()
	{
		RestAssured.baseURI = "https://reqres.in";
		
							given()
							
							.queryParam("page", "2")          //don't know query params will go in this sequence or not.
							                                 //To pass multiple query params we can use queryParams() method as well.
							
							.queryParam("line", "6")
							
							.log().all()
		
							.when()
		
							.get("/api/users")
		
							.then()
							
							.log().all()
		
							.extract()
		
							.response();
		
	}
		

}
