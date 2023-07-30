package basiccalls;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;import io.restassured.specification.FilterableResponseSpecification;
import junit.framework.Assert;

public class FetchDataOfHeaders {
	@Test
	public void getUserDetails() {
		RestAssured.baseURI = "https://reqres.in";
		Response response = given().log().all().when().get("/api/users?page=2").then().extract().response();
//		System.out.println(response.getStatusCode());
//		System.out.println(response.getStatusLine());
//		System.out.println(response.getBody().asString());
//		System.out.println(response.getTime());
		//System.out.println("Header value is:"+response.getHeader("Content-Type"));	  ///TO get value of perticular header
		
		//To ge the values of all the headers
		System.out.println("Header values is:"+response.getHeader("Content-Type"));
		System.out.println("Haeders:"+response.getHeaders());
	}
}
