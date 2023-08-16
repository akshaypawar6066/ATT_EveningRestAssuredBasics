package spotifyAPIs;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class CreatePlaylist {
	
	RequestSpecification reqSpecification;
	ResponseSpecification responseSpecification;
	@BeforeClass
	public void requestSpecBuilder()
	{
		RequestSpecBuilder requestSpecBuilder=new RequestSpecBuilder();
		
		 reqSpecification = requestSpecBuilder.setBaseUri("https://api.spotify.com/v1")
		.setContentType(ContentType.JSON).addHeader("Authorization", "Bearer BQBgjitB5uVQ4FvEgX_Zg_Sst4_e7AYxu8LI9_GG8yfHpRLnfy9HmbsoTyJG_e3mqpwdUOZA4YXxbObmgSOl4jKGPUNsYnSG-PPSFrkmNyM2pgAEAfadc1Piagm6Ut_M9V-EXYpTZKZ1rG-oZXzutHS3dKoYRfHK5NLSXFzPsbgwbDy3ifXQVtzt6ovpnhZ6rbh6tAkSdfEHhVlxfSTKA4qknFtm487JVdEKPVwQCP4QMpH8dK7fVwnPlEXth_c-38VGXyugLrSHrDRS")
		.log(LogDetail.ALL).build();
		
		ResponseSpecBuilder responseSpecBuilder=new ResponseSpecBuilder();
		
		 responseSpecification = responseSpecBuilder.expectContentType(ContentType.JSON).log(LogDetail.ALL).build();
		
	}
	@Test
	public void createPlaylist()
	{
		given().spec(reqSpecification)
		.body("{\r\n"
				+ "    \"name\": \"New Playlist generated using RestAssured_ATTEvening\",\r\n"
				+ "    \"description\": \"Neha Kakkar Mashup and DJ Songs\",\r\n"
				+ "    \"public\": false\r\n"
				+ "}")
		.when().post("/users/31n64s22erzad25vftps2ywsj64i/playlists")
		.then().spec(responseSpecification).assertThat().body("description", equalTo("Neha Kakkar Mashup and DJ Songs"));
		
	}

}
