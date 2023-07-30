package basiccalls;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import junit.framework.Assert;

public class GetUserDetails {
	@Test
	public void getUserDetails() {
		RestAssured.baseURI = "https://reqres.in";
		Response response = given().log().all().when().get("/api/users?page=2").then()
				.log().all().assertThat().statusCode(200)
				.body("$", hasKey("page"))  //to check perticular key is pesent
				.body("data[0]", hasEntry("first_name", "Michael"))   //to check perticulra value is present along with key
				.body("$", hasEntry("per_page", 6))
				.body("data[0].avatar", equalTo("https://reqres.in/img/faces/7-image.jpg"))
				.body("page", equalTo(2))
				.extract().response();
		String stringResponse = response.asPrettyString();
		System.out.println(stringResponse);
		int statusCode = response.statusCode();
		System.out.println("Status code is:" + statusCode);
		Assert.assertEquals(200, statusCode);
		long reqTime = response.getTime();
		System.out.println(reqTime);
	}
}
