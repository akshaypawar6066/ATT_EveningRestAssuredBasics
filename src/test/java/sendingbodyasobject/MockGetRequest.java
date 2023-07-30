package sendingbodyasobject;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

public class MockGetRequest {
	
	
	@Test
	public void getResponse()
	{
		RestAssured.baseURI = "https://eb3a2103-4b32-4c3a-a58e-a83488263791.mock.pstmn.io";
		
		given().log().all()
		
		.header("x-mock-response-code", "200")
		
		.when()
		
		.get("/attGetCall")
		
		.then()
		
		.log().all();
		
	}

}
