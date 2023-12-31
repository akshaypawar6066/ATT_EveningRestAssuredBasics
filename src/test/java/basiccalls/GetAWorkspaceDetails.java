package basiccalls;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAWorkspaceDetails {
	
	@Test
	public void getAWorkspaceDeatils()
	{
		RestAssured.baseURI="https://api.getpostman.com";
		
		 Response response=given().log().all().header("x-api-key","PMAK-64c51655bec46e002a654757-37a9270636fa3b68a00be70498702691c3")
		.when().get("/workspaces/3f005e12-8aa1-4571-bf51-24b0801912c8").then().log().all().extract().response();
		 String stringResponse=response.asPrettyString();
		 System.out.println("response is:"+stringResponse);
		
	}
}
