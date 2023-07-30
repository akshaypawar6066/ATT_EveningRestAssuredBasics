package eCommerseAPIS;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import testData.BodyCreator;

public class eCommerseAPIs {
	String accessToken;
	String userId;
	String productId;
	String orderId;
	
	
	// Login to Application
	@Test(priority = 1)
	public void loginToApplication() {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		Response response=given().log().all()
		.contentType(ContentType.JSON)
		.body(BodyCreator.getLoginBody())
		.when().post("/api/ecom/auth/login")
		.then().log().all().extract().response();
		
		JsonPath js=response.jsonPath();
		accessToken=js.getString("token");
		userId=js.getString("userId");	

	}
	
	
	//Add Product
   @Test(priority = 2)
	public void addProduct()
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		File imagePath=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\shaker.png");
		
		System.out.println("Image Path is:"+imagePath);
		
		Response response=given().log().all()
				.header("Authorization",accessToken)
				.param("productName", "AppleLaptop").param("productAddedBy", userId)
				.param("productCategory", "Electronics").param("productSubCategory", "Laptops")
				.param("productPrice", "200000").param("productDescription", "Apple BestLaptop 8GB RAM")
				.param("productFor", "All").multiPart("productImage",imagePath)
				.when().post("/api/ecom/product/add-product").then().log().all().extract().response();
		
		JsonPath js=response.jsonPath();
	    productId=js.getString("productId");		
	}
   
   //Create order 
   @Test(priority = 3)
   public void placeOrder()
   {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		Response response=given().log().all().header("Authorization",accessToken)
				.header("Content-Type","application/json")
		.body(BodyCreator.getBodyToaddProduct(productId))
		.when().post("/api/ecom/order/create-order").then().log().all().extract().response();
		JsonPath js=response.jsonPath();
	    orderId=js.getString("orders[0]");
   }
	
   //GetOrderDetails
   @Test(priority = 4)
   public void getOrderDetails()
   {
	   RestAssured.baseURI = "https://rahulshettyacademy.com";
	   
	   Response response= given().log().all()
	   .header("Authorization",accessToken).header("Content-Type","application/json")
	   .queryParam("id", orderId)
	   .when().get("/api/ecom/order/get-orders-details").then()
	   .log().all().extract().response();
   }
	
   //DeleteProduct
   @Test(priority = 5)
   public void deleteProduct()
   {
	   RestAssured.baseURI = "https://rahulshettyacademy.com";
	   
	    Response response= given().log().all()
	   .header("Authorization",accessToken).header("Content-Type","application/json")
	   .pathParam("productId", productId).when().delete("/api/ecom/product/delete-product/{productId}").then().log().all().extract().response();
       
	   JsonPath js=response.jsonPath();
	   String deletedMessage=js.getString("message");
	   System.out.println("After product deleted message is:"+deletedMessage);
   }

}
