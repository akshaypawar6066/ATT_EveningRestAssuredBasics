package basiccalls;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class GetAllPostmanWorkspaces {

	
	@Test
	public void getAllPostamnWorkspaces()
	{
		RestAssured.baseURI="https://api.getpostman.com";
		
		 Response response=given().log().all().header("x-api-key","PMAK-64c51655bec46e002a654757-37a9270636fa3b68a00be70498702691c3")
		.when().get("/workspaces").then().log().all().extract().response();
		 String stringResponse=response.asPrettyString();
		 System.out.println("response is:"+stringResponse);
		
	}
}
