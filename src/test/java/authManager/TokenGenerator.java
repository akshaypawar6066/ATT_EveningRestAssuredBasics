package authManager;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class TokenGenerator {

	public static String renewToken() {
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("grant_type", "refresh_token");
		param.put("refresh_token",
				"AQAnwpF4WAt8BunMJHfYOzwLR2mZkB1NI4QhMhVJVxhqYolX1Pgv_0Y9oUqJgJpdd89G0a27PCziFUJZ9fT4Q7PscMg5G8Y0Pu_43ECBiDtENmidwn1ndHLIDZkH08rYeWY");
		param.put("client_id", "7d6dbf5f9a064863b07d96a641533693");
		param.put("client_secret", "855b9bf1b09d41b1b8a7fb5042c40e4a");

		RestAssured.baseURI = "https://accounts.spotify.com";

		Response response = given().log().all().contentType(ContentType.URLENC)

				.formParams(param)

				.when().post("/api/token")

				.then().log().all()

				.extract().response();
		
		if(response.getStatusCode()!=200)
		{
			throw new RuntimeException("Failed to generate the access token");
		}

		return response.jsonPath().getString("access_token");

	}

}
