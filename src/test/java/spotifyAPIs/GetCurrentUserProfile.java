package spotifyAPIs;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetCurrentUserProfile {
	String userId=null;
	
	@Test
	public void getCurrentUserProfile()
	{
		RestAssured.baseURI="https://api.spotify.com/v1";
		
		Response response=given().log().all().header("Authorization", "Bearer BQBK0L8TYdNP5SXFeJfRfS7mpRHbPfZqw1nFhgwfS2cqi5UgFz2raZY-oQHHUXC4lIya6v9TN7p06UGfQmRbwEHTfH5LJrtMA6IkIXo3QAJzr4r3OILp9fNcdjCGsDOV3MHP8V1sgAqJcvmNprHGdg59sve4s86IJvxasw1f5B3LrKjrkRt31_1S5gZJuWxShOTADFE5bwvuh1J3s-YSjcS6FiXftHOY3aAEaQYeUkMcRwicZqT9yJr0VnbLVIKsPivWcaiCM_x50xQp")
		.when().get("/me").then().log().all().extract().response();
		JsonPath js=response.jsonPath();
		userId=js.getString("id");
		
	}
	
	

}
