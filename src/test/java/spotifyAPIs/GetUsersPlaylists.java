package spotifyAPIs;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GetUsersPlaylists {
	RequestSpecification req;
	ResponseSpecification res;
	
	@BeforeClass
	public void reqAndResBuilder()
	{
		RequestSpecBuilder requestSpecBuilder=new RequestSpecBuilder();
		
	 req=	requestSpecBuilder.setBaseUri("https://api.spotify.com/v1").setContentType(ContentType.JSON)
		.addHeader("Authorization", "Bearer BQBK0L8TYdNP5SXFeJfRfS7mpRHbPfZqw1nFhgwfS2cqi5UgFz2raZY-oQHHUXC4lIya6v9TN7p06UGfQmRbwEHTfH5LJrtMA6IkIXo3QAJzr4r3OILp9fNcdjCGsDOV3MHP8V1sgAqJcvmNprHGdg59sve4s86IJvxasw1f5B3LrKjrkRt31_1S5gZJuWxShOTADFE5bwvuh1J3s-YSjcS6FiXftHOY3aAEaQYeUkMcRwicZqT9yJr0VnbLVIKsPivWcaiCM_x50xQp")
		.log(LogDetail.ALL).build();
	
	ResponseSpecBuilder responseSpecBuilder=new ResponseSpecBuilder();
	
	 res=responseSpecBuilder.expectContentType(ContentType.JSON).log(LogDetail.ALL).build();
	
	
	}
	
	@Test
	public void getUsersPlaylists()
	{
		given().spec(req).pathParam("UserId", "31n64s22erzad25vftps2ywsj64i")
		.when().get("/users/{UserId}/playlists").then().spec(res);
	}

}
