package sendingbodyasobject;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class SendingBodyAsObject {
	
	@Test
	public void createWorkspace()
	{
		
		HashMap<String, String> innerMap = new HashMap<String, String>();
		
		innerMap.put("name", "Jsonobject");
		innerMap.put("type", "personal");
		innerMap.put("description", "Creating a workspace using body as object");
	
		HashMap<String, HashMap<String, String>> mainBody = new HashMap<String, HashMap<String,String>>();
		
		mainBody.put("workspace", innerMap);
		
		
		
RestAssured.baseURI = "https://api.getpostman.com";
		
		Response response = given()
		
		.body(mainBody)
		
		.header("x-api-key", "PMAK-64bfdf62e2502b002a2be44b-2a59f729f441780f5fc0db41ffe5b970f9")
		
		.log().all()
		
		.when()
		
		.post("/workspaces")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
		
		
	
	}

}
