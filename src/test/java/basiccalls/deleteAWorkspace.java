package basiccalls;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class deleteAWorkspace {
	@Test
	public void deleteAWorkspace() {
		RestAssured.baseURI = "https://api.getpostman.com";

		Response response = given().log().all()
				.header("x-api-key", "PMAK-64c51655bec46e002a654757-37a9270636fa3b68a00be70498702691c3").when()
				.delete("/workspaces/ad0bab94-e28d-447d-a3d7-8c6f0f7ea536").then().log().all().extract().response();
		String stringResponse = response.asPrettyString();
		System.out.println("Response is:" + stringResponse);
	}

}
