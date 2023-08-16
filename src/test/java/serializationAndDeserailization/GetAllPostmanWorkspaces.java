package serializationAndDeserailization;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import pojo.GetWorkPlacesResponseBody;
import pojo.Workspaces;


public class GetAllPostmanWorkspaces {

	
	@Test
	public void getAllPostamnWorkspaces()
	{
		RestAssured.baseURI="https://api.getpostman.com";
		
		 GetWorkPlacesResponseBody response=given().log().all().header("x-api-key","PMAK-64c51655bec46e002a654757-37a9270636fa3b68a00be70498702691c3")
		.when().get("/workspaces").then().log().all().extract().response().as(GetWorkPlacesResponseBody.class);
		 List<Workspaces> workspaces=response.getWorkspaces();
		 
		
	}
}
