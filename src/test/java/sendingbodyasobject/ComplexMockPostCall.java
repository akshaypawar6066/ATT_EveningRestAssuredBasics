package sendingbodyasobject;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class ComplexMockPostCall {

	@Test
	public void postCall() {

//		creating body of the request

		HashMap<String, String> hm1 = new HashMap<String, String>();

		hm1.put("id", "1000");
		hm1.put("type", "grains");

		HashMap<String, String> hm2 = new HashMap<String, String>();

		hm2.put("id", "1001");
		hm2.put("type", "beverages");

		HashMap<String, String> hm3 = new HashMap<String, String>();
		hm3.put("id", "1002");
		hm3.put("type", "chocolates");

		List<HashMap<String, String>> jsonObject = new ArrayList<HashMap<String, String>>();

		jsonObject.add(hm1);
		jsonObject.add(hm2);
		jsonObject.add(hm3);

		RestAssured.baseURI = "https://eb3a2103-4b32-4c3a-a58e-a83488263791.mock.pstmn.io";

		given().log().all()

				.header("x-mock-match-request-body", "true")

				.header("Content-Type", "application/json")

				.body(jsonObject)

				.when()

				.post("/attPostCall")

				.then()

				.log().all();

	}

}
