package testData;

public class BodyCreator {

	public static String getBodyToCreateUser() {
		String body = "{\r\n" + "  \"id\": 0,\r\n" + "  \"username\": \"userone\",\r\n"
				+ "  \"firstName\": \"userfirstname\",\r\n" + "  \"lastName\": \"userlastname\",\r\n"
				+ "  \"email\": \"user.user@att.com\",\r\n" + "  \"password\": \"Test@1234\",\r\n"
				+ "  \"phone\": \"9876543223\",\r\n" + "  \"userStatus\": 0\r\n" + "}";

		return body;
	}

	public static String getLoginBody() {
		return "{\r\n" + "    \"userEmail\": \"akshaypawar8369@gmail.com\",\r\n"
				+ "    \"userPassword\": \"Akshay@6066\"\r\n" + "}";
	}
	
	public static String getBodyToaddProduct(String productId)
	{
		return "{\r\n"
				+ "    \"orders\": [\r\n"
				+ "        {\r\n"
				+ "            \"country\": \"India\",\r\n"
				+ "            \"productOrderedId\": \""+productId+"\"\r\n"
				+ "        }\r\n"
				+ "    ]\r\n"
				+ "}";
	}

}
