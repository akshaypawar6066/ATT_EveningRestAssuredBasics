package sendingbodyasobject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class MockPostRequestAccounting {
	
	@Test
	public void addNewAccount()
	{
		
		//Creating Accounting HashMaps
		HashMap<String, Object> accountingHashMap1=new HashMap<String, Object>();
		accountingHashMap1.put("firstName", "John");
		accountingHashMap1.put("lastName", "Doe");
		accountingHashMap1.put("age", 23);
		
		HashMap<String, Object> accountingHashMap2=new HashMap<String, Object>();
		accountingHashMap2.put("firstName", "Mary");
		accountingHashMap2.put("lastName", "Smith");
		accountingHashMap2.put("age", 32);
		
		//Creating accounting array
		List<HashMap<String, Object> > accountingArray=new ArrayList<HashMap<String, Object>>();
		accountingArray.add(accountingHashMap1);
		accountingArray.add(accountingHashMap2);
		
		
		//Creating Sales HashMaps
		HashMap<String, Object> salesHm1=new HashMap<String, Object>();
		salesHm1.put("firstName", "Sally");
		salesHm1.put("lastName", "Green");
		salesHm1.put("age", 27);
		
		HashMap<String, Object> salesHm2=new HashMap<String, Object>();
		salesHm2.put("firstName", "Jim");
		salesHm2.put("lastName", "Galley");
		salesHm2.put("age", 32);
		
		//Creating sales list
		List<HashMap<String, Object>> salesArray=new ArrayList<HashMap<String, Object>>();
		salesArray.add(salesHm1);
		salesArray.add(salesHm2);
		
		//Creating main Body Object
		HashMap<String, Object> mainBody=new HashMap<String, Object>();
		mainBody.put("accounting", accountingArray);
		mainBody.put("sales", salesArray);
		
		RestAssured.baseURI="https://eb3a2103-4b32-4c3a-a58e-a83488263791.mock.pstmn.io";
		given().log().all().header("Content-Type","application/json").header("x-mock-match-request-body","true")
		.body(mainBody).when().post("/complexPostCall_Accounting").then().log().all();
		
	}

}
