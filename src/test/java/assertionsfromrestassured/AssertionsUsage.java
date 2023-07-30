package assertionsfromrestassured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AssertionsUsage {
	

	@Test
	public void getAllPostamnWorkspaces()
	{
		RestAssured.baseURI="https://api.getpostman.com";
		
		 Response response=given().log().all().header("x-api-key","PMAK-64b6a8fb0f3f590031b65735-64d63ac2f88fe9d9064ea97728c227a34a")
		.when().get("/workspaces").then().assertThat().statusCode(200).contentType(ContentType.JSON).header("Connection","keep-alive").body("workspaces[0].name", equalTo("DAP_Reengineering"))
		.body("workspaces[1].name", equalTo("LearningAPIS"))
	     .body("workspaces[0].visibility", equalTo("personal"),"workspaces[1].visibility",equalTo("team"),"workspaces[2]", hasEntry("type", "team"))
	     .body("workspaces[1]",hasKey("id"),"workspaces[1].name", equalTo("LearningAPIS")) 
	     .body("workspaces.name", hasItem("LearningAPIS"))  //To check specific iteam contains/present
	     .body("workspaces[0].visibility", equalTo("personal"))
		 .log().all().extract().response();
		 String stringResponse=response.asPrettyString();
		 System.out.println("response is:"+stringResponse);
		
	}
}
