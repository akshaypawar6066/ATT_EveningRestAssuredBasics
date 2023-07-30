package basiccalls;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getPostmanWorkspacesWithHeaders {
	@Test
	public void getAllPostamnWorkspacesWithHeaders()
	{
		RestAssured.baseURI="https://api.getpostman.com";
		
		 Response response=given().log().all().header("x-api-key","PMAK-64c51655bec46e002a654757-37a9270636fa3b68a00be70498702691c3")
		.when().head("/workspaces").then().log().all().extract().response();
		int statusCode=response.getStatusCode();
		System.out.println("Response is:"+response.asPrettyString());
		System.out.println("Status code is:"+statusCode);
		Assert.assertEquals(statusCode, 200);
		
	}

}
