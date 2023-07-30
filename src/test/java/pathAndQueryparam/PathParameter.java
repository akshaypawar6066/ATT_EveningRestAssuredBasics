package pathAndQueryparam;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PathParameter {
	

	@Test
	public void getUserDetails()
	{
		RestAssured.baseURI = "https://reqres.in";
		
							given()
							
							.pathParam("pathparameter","2")
		
							.when()
		
							.get("/api/users/{pathparameter}")
		
							.then()
							
							.log().all()
		
							.extract()
		
							.response();
	}
		

}
