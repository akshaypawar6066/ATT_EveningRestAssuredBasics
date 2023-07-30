package basiccalls;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class createWorkspace {
	
	@Test
	public void createAWorkspace()
	{
		RestAssured.baseURI="https://api.getpostman.com";
		
		Response response=given().log().all().header("x-api-key","PMAK-64c51655bec46e002a654757-37a9270636fa3b68a00be70498702691c3")
		.body("{\r\n"
				+ "    \"workspace\": {\r\n"
				+ "        \"name\": \"Automated_Team Workspace_ATT_Evevning_RestAssured\",\r\n"
				+ "        \"type\": \"personal\",\r\n"
				+ "        \"description\": \"This is a Personel workspace craeted using RestAssured code.\"\r\n"
				+ "    }\r\n"
				+ "}").when().post("/workspaces").then().log().all().extract().response();
		String stringResponse=response.asPrettyString();
		System.out.println("Response is:"+stringResponse);
	}

}
