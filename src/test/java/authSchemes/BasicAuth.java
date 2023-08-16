package authSchemes;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class BasicAuth {

	@Test
	public void executeGetECho()
	{
		RestAssured.baseURI="https://postman-echo.com";
		given().log().all()
		//.auth().basic("postman", "password")
		.header("Authorization", "Basic cG9zdG1hbjpwYXNzd29yZA==")
		.when().get("/basic-auth").then().log().all();
		
	}
}
