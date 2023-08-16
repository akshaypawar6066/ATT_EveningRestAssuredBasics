package spotifyAPIs;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class ChangePlaylistDetails {
	
	@Test
	public void updatePlaylist()
	{
		HashMap<String, String> headers=new HashMap<String, String>();
		headers.put("Authorization", "Bearer BQA_-SafQMppoE5byilH4gBKJ7XlW-07jkKE-XytHEzt4bNRr7Dc1pZVUFqRFGQEprNo8tBBx-NpHAQ4QK9LTZoxUaG1-WPNbWzD3TZeH3EgFPHVVKhrWJN8AWmNEpAlYofEllpv9IrTRUxETwcmssvJNz77as0pj_6ZEjwgA-UHGSVQMGeRuUa9Tgo9ZmRNNiyYrvsHpHU6boZFkGAr3zgdtE3rTKCS5I-jsUojEvMBxBYZkhDf-odfA8MXI3NWdC3UY5h0ktgLofGI");
		headers.put("Content-Type", "application/json");
		RestAssured.baseURI="https://api.spotify.com/v1";
		 given().log().all()
		 .headers(headers)
		 .body("{\r\n"
		 		+ "    \"name\": \"AkshayPawar EveningMashup\",\r\n"
		 		+ "    \"description\": \"EvevningMashup by Akshay Pawar\",\r\n"
		 		+ "    \"public\": false\r\n"
		 		+ "}")
		  .when().put("/playlists/4p99UUacbX5xGZf3EgESj1").then().log().all();
	}

}
