package fetchDataFromResponse;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class FetchDataFromReadyMadeJson {

	@Test
	public void fetchDataFromReadyMadeJson() {
		String jsonBody = "{\r\n" + "    \"dashboard\": {\r\n" + "        \"purchaseAmount\": 1162,\r\n"
				+ "        \"website\": \"rahulshettyacademy.com\"\r\n" + "    },\r\n" + "    \"courses\": [\r\n"
				+ "        {\r\n" + "            \"title\": \"Selenium Python\",\r\n" + "            \"price\": 50,\r\n"
				+ "            \"copies\": 6\r\n" + "        },\r\n" + "        {\r\n"
				+ "            \"title\": \"Cypress\",\r\n" + "            \"price\": 40,\r\n"
				+ "            \"copies\": 4\r\n" + "        },\r\n" + "        {\r\n"
				+ "            \"title\": \"RPA\",\r\n" + "            \"price\": 45,\r\n"
				+ "            \"copies\": 10\r\n" + "        },\r\n" + "                {\r\n"
				+ "            \"title\": \"Appium\",\r\n" + "            \"price\": 36,\r\n"
				+ "            \"copies\": 7\r\n" + "        }\r\n" + "    ]\r\n" + "}";
		JsonPath js = new JsonPath(jsonBody);
		String website = js.getString("dashboard.website");
		System.out.println("Website is:" + website);

		// No of courses returned by API
		int noOfCourses = js.getInt("courses.size()");
		System.out.println("No of courses are:" + noOfCourses);
		// Purchase Amount
		System.out.println("Purchase Amount is:" + js.getString("dashboard.purchaseAmount"));
		// Title of the first cource
		System.out.println("Title of the first course is:" + js.getString("courses[0].title"));

		// Print all course titles and their respective prices
		int size = js.getList("courses").size();
		System.out.println("all course titles and their respective prices are:");
		for (int i = 0; i < size; i++) {
			System.out.print(js.getString("courses[" + i + "].title")+" ");
			System.out.println(js.getInt("courses[" + i + "].price"));
		}
		
		//print no of copies sold by RPA cource
			for(int i=0;i<size;i++)
			{
				if(js.getString("courses["+i+"].title").equals("RPA"))
				{
					System.out.println("No of copis sold by RPA course are:"+js.getInt("courses["+i+"].copies"));
				}
			}
			int purchaseAmount=js.getInt("dashboard.purchaseAmount");
		   int totalPrice=0;
			for(int i=0;i<size;i++)
			{
				int copies=js.getInt("courses["+i+"].copies");
				int price=js.getInt("courses["+i+"].price");
				totalPrice=totalPrice+(price*copies);
			}
			System.out.println("Total price is:"+totalPrice);
			if(purchaseAmount==totalPrice)
			{
				System.out.println("Total amount and purchase price are matches:");
			}
		}

	}

