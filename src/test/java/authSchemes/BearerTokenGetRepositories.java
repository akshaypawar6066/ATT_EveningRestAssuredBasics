package authSchemes;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class BearerTokenGetRepositories {
	@Test
	public void getRepositories() {
		RestAssured.baseURI = "https://api.github.com";

		given().log().all().header("Accept", "application/vnd.github+json")
				.header("Authorization", "Bearer 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")
				.header("X-GitHub-Api-Version", "2022-11-28").when().get("/user/repos").then().log().all();

	}
}
