package specBuilders;

import static io.restassured.RestAssured.given;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ReqResSpecBuilder {
	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	String messagevalue;
	
	@BeforeClass
	public void initReqAndResponseSpec()
	{
//		common properties for request 
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
		
	
		requestSpecification=requestSpecBuilder.setBaseUri("https://petstore.swagger.io/v2").setContentType(ContentType.JSON).log(LogDetail.ALL).build();
		
//		common properties for Response
		
		ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
		
		responseSpecification=responseSpecBuilder.expectStatusCode(200).expectContentType(ContentType.JSON).log(LogDetail.ALL).build();
		
		
	}
	
	
	@Test(priority = 1)
	public void createAnUser()
	{		
		Response response = given()
				
				.spec(requestSpecification)
		
		.body("{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"username\": \"restassureduserlatest\",\r\n"
				+ "  \"firstName\": \"RestAssuredlatest\",\r\n"
				+ "  \"lastName\": \"User\",\r\n"
				+ "  \"email\": \"restassuredlatest.user@att.com\",\r\n"
				+ "  \"password\": \"Test@1234\",\r\n"
				+ "  \"phone\": \"9876543213\",\r\n"
				+ "  \"userStatus\": 0\r\n"
				+ "}")
				
		.when()
		
		.post("/user")
		
		.then()
		
		.spec(responseSpecification)
		
		.extract()
		
		.response();
		
		JsonPath jp = response.jsonPath();
		
		 messagevalue = jp.getString("message");
		
		System.out.println("Message value is "+messagevalue);
	}

	
	
	@Test(priority = 2)
	public void getUserDetails()
	{
		Response response = given()
				
		.spec(requestSpecification)
		
		.pathParam("createdUserName", "restassureduserlatest")
		
		.when()
		
		.get("/user/{createdUserName}")
		
		.then()
		
		.spec(responseSpecification)
		
		.extract()
		
		.response();
		
	JsonPath jp = response.jsonPath();
	
	String idvalue= jp.getString("id");
	
	System.out.println("ID value is : "+idvalue);
		
	Assert.assertEquals(idvalue, messagevalue);
		
	}

}
