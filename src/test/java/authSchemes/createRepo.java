package authSchemes;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class createRepo {
	
	@Test
	public void createRepository() {
		RestAssured.baseURI = "https://api.github.com";

		given().log().all().header("Accept", "application/vnd.github+json")
				.header("Authorization", "Bearer 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")
				.header("X-GitHub-Api-Version", "2022-11-28")
				.body("{\r\n"
						+ "  \"name\": \"Demo-World\",\r\n"
						+ "  \"description\": \"This is your first repository_Demo\",\r\n"
						+ "  \"homepage\": \"https://github.com\",\r\n"
						+ "  \"private\": false,\r\n"
						+ "  \"has_issues\": true,\r\n"
						+ "  \"has_projects\": true,\r\n"
						+ "  \"has_wiki\": true\r\n"
						+ "}").
				when().post("/user/repos").then().log().all();

	}

}
