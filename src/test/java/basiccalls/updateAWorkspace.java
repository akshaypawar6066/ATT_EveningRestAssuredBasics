package basiccalls;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class updateAWorkspace {
	
	@Test
	public void updateAWorkspace() 
	{
      RestAssured.baseURI="https://api.getpostman.com";
      Response response= given().log().all().header("x-api-key","PMAK-64c51655bec46e002a654757-37a9270636fa3b68a00be70498702691c3")
      .body("{\r\n"
      		+ "    \"workspace\": {\r\n"
      		+ "        \"name\": \"ManualWorkspaceupdatedInRestAssured\",\r\n"
      		+ "        \"type\": \"personel\",\r\n"
      		+ "        \"description\": \"updatedWorkspaceFromTeamTopersonelInRestAssured\"\r\n"
      		+ "    }\r\n"
      		+ "}").when().put("/workspaces/ad0bab94-e28d-447d-a3d7-8c6f0f7ea536").then().log().all().extract().response();
      String responseString=response.asPrettyString();
      System.out.println("Response is:"+responseString);
	}

}
