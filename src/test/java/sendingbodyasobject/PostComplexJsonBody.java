package sendingbodyasobject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
public class PostComplexJsonBody {
	
	
	//Creating the complex json body as per the requirement.
	@Test
	public void sendingComplexJsonAsBody()
	{
		RestAssured.baseURI="https://eb3a2103-4b32-4c3a-a58e-a83488263791.mock.pstmn.io";
		
		//defining the inner most array which is the value of Id element.
		List<Integer> arrayOfId= new ArrayList<Integer>();
		arrayOfId.add(5);
		arrayOfId.add(9);
		
		//creation of batter HashMaps.
		HashMap<String, Object> batterHm1=new HashMap<String, Object>();
		batterHm1.put("id", "1001");
		batterHm1.put("type", "Regular");
		
		HashMap<String, Object> batterHm2=new HashMap<String, Object>();
		batterHm2.put("id", arrayOfId );
		batterHm2.put("type", "Chocolate");
		
		
	//Defining the array of batter
		List<HashMap<String, Object>> batterArray=new ArrayList<HashMap<String, Object>>();
		batterArray.add(batterHm1);
		batterArray.add(batterHm2);
		
		//Defining the Batters HashMap
		HashMap<String, List<HashMap<String, Object>>> battersHashMap=new HashMap<String, List<HashMap<String, Object>>>();
		battersHashMap.put("batter", batterArray);
		
		//Creation of toppings HashMaps
		HashMap<String, String> toppingsHm1=new HashMap<String, String>();
		toppingsHm1.put("id", "5001");
		toppingsHm1.put("type", "None");
		
		HashMap<String, String> toppingsHm2=new HashMap<String, String>();
		toppingsHm2.put("id", "5002");
		toppingsHm2.put("type", "Glazed");
		
		
		HashMap<String, String> toppingsHm3=new HashMap<String, String>();
		toppingsHm3.put("id", "5005");
		toppingsHm3.put("type", "Sugar");
		
		//Creation of topping Array
		List<HashMap<String, String>> toppingArray=new ArrayList<HashMap<String, String>>();
		toppingArray.add(toppingsHm1);
		toppingArray.add(toppingsHm2);
		toppingArray.add(toppingsHm3);
		
		HashMap<String, Object> jsonBody=new HashMap<String, Object>();
		jsonBody.put("ppu", 0.55);
		jsonBody.put("batters", battersHashMap);
		jsonBody.put("name", "Cake");
		jsonBody.put("id", "0001");
		jsonBody.put("type", "donut");
		jsonBody.put("topping", toppingArray);
		
		given().log().all().header("x-mock-match-request-body","true").header("Content-Type","application/json")
		.body(jsonBody).when().post("/complexPostCall")
		.then().log().all();
		
		

		
		
		
		
	}

}
