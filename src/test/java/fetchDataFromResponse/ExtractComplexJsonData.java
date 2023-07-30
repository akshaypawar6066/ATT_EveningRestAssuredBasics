package fetchDataFromResponse;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

public class ExtractComplexJsonData {

	@Test
	public void getUserDetails() {
		RestAssured.baseURI = "https://reqres.in";
		Response response = given().log().all().when().get("/api/users?page=2").then().log().all().extract().response();
		String stringResponse = response.asPrettyString();
		System.out.println("Response is:" + stringResponse);
		int statusCode = response.statusCode();
		System.out.println("Statuc code is:" + statusCode);
		JsonPath js = response.jsonPath();
		String firstUserId = js.getString("data[0].id");
		System.out.println("First user id:" + firstUserId);
		String firstUserEmailId = js.getString("data[0].email");
		System.out.println("First user email id:" + firstUserEmailId);
		String url = js.getString("support.url");
		System.out.println("Url is:" + url);
		int pages=js.getInt("total_pages");
		System.out.println("No of pages are:"+pages);
		
	  // int dataSize=js.getList("data").size();
	  int dataSize=js.getInt("data.size()");
	  System.out.println("Total nof elemnts present in array are:"+dataSize);
	 System.out.println("First name of all the users are:");
	for(int i=0;i<dataSize;i++)
	{
		System.out.println(js.getString("data["+i+"].first_name"));
	}
	
	String expectedEmail="george.edwards@reqres.in";
	for(int i=0;i<dataSize;i++)
	{
		String actualEmail=js.getString("data["+i+"].email");
		if(actualEmail.equals(expectedEmail))
		{
			System.out.println("Lat name of expected user is:"+js.getString("data["+i+"].last_name"));
		}
	}
	}	

}
