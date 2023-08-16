package serializationAndDeserailization;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import pojo.Data;
import pojo.GetUserDetailsResponseBody;
import pojo.Support;

public class GetUserDetails {
	
	@Test
	public void getUserDetails() {
		RestAssured.baseURI = "https://reqres.in";
		GetUserDetailsResponseBody response = given().log().all().when().get("/api/users?page=2").then().log().all()
				.extract().response().as(GetUserDetailsResponseBody.class);
		
		System.out.println(response.getTotal_pages());
		
		System.out.println("First anme from all the array elemnts are:");

		for(Data data:response.getData())
		{
			System.out.println(data.getFirst_name());
		}
		
		System.out.println("Text is:"+response.getSupport().getText());
		System.out.println("Url is:"+response.getSupport().getUrl());
		

	}

}
