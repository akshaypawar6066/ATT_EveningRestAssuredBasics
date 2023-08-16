package spotifyAPIs;

import org.testng.annotations.Test;

import com.spotify.pojo.CreatePlaylistRequest;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CreatePlaylistWithPojoClass {

	@Test
	public void createPlayListWithPojo() {
		CreatePlaylistRequest reqBody = new CreatePlaylistRequest();
		reqBody.setName("Baba Chamatkar Playsist usuing Pojo Class");
		reqBody.setDescription("These are Baba Chamatkar Songs created using PoJO Class");
		reqBody.setPublic(true);

		RestAssured.baseURI = "https://api.spotify.com/v1";

		CreatePlaylistRequest res = given().log().all().header("Authorization",
				"Bearer BQDwQQ9HJXeuKVdMLfHznsDtPGzH9_-meOhs1fpTd_X1qb5xvGwNfUIFmjFshS4s5IaBbqPR7onGRSFr0yuEtZk7WQux9i9lQ5q5I5hL13NzPZh71BZnzlEvT8jrOO80N2oqGOMkDaw_hqrn8lQdAPYbC0OmNSH3zL9LZaSn2t5_uH3qJMO_JgSsIi5baX16DSSury_KGj63ekf71mwxTO0P7idoCnThee9x3-Ds7lY7SOQeC3AMwVXbFDB0tU5CwnvejaeY4-qNSP1O")
				
				.header("Content-Type", "application/json").body(reqBody).when()
				
				.post("/users/31n64s22erzad25vftps2ywsj64i/playlists").then().log().all()
				
				.assertThat().body("name", equalTo("Baba Chamatkar Playsist usuing Pojo Class")).statusCode(201)
				
				.extract().response()
				
				.as(CreatePlaylistRequest.class);
	}
}