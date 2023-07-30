package pathAndQueryparam;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class EchoGetRequestForMultipleQueryParams {
	
	
	@Test
	public void getEchoParam()
	{
		
		HashMap<String, String> qp = new HashMap<String, String>();
		
		qp.put("foo1", "bar1");
		qp.put("foo2", "bar2");
		qp.put("foo3", "bar3");
		qp.put("foo4", "bar4");


		RestAssured.baseURI = "https://postman-echo.com";
		
		given()
		
		.queryParams(qp)
		
//		.queryParams("foo1","bar1", "foo2", "bar2")    //To pass query params in sequence.
		
		.header("x-api-key", "PMAK-64c51655bec46e002a654757-37a9270636fa3b68a00be70498702691c3")
		
		.log().all()
		.when()
		
		.get("/get")
		
		.then()
		
		.log().all();
	
	
		
		
		
	}

}
