package serializationAndDeserailization;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.CreateUserRequestBody;
import pojo.CreateUserResponseBody;

public class CreateUser {
	
	@Test	
	public void createUser()
	{
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		CreateUserRequestBody jsonBody=new CreateUserRequestBody();
		jsonBody.setId(1);
		jsonBody.setUsername("Akshay");
		jsonBody.setFirstName("TestUser_Serialization");
		jsonBody.setLastName("TestLastName_Serilization");
		jsonBody.setEmail("Test@321@gmail.com");
		jsonBody.setPassword("TestPassword");
		jsonBody.setPhone("6856495656");
		jsonBody.setUserStatus(100);
		
		CreateUserResponseBody response = given()
		
		.body(jsonBody)
		.header("Content-Type", "application/json")
		
		.log().all()
		
		.when()
		
		.post("/user")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response().as(CreateUserResponseBody.class);
		
		System.out.println(response.getCode());
		System.out.println(response.getType());
		System.out.println(response.getMessage());
		

	}


}
