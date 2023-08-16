package uploadanddownload;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;



public class DownloaAFile {

	@Test
	public void downloadAFile() throws IOException {
		RestAssured.baseURI = "https://github.com";

		byte[] byteArray = given().log().all().when()
				.get("/akshaypawar6066/ATT_EveningRestAssuredBasics/raw/master/src/test/resources/CasualJeans.png")
				.then().log().all().extract().response().asByteArray();

		String path = "C:\\Users\\Admin\\OneDrive\\Documents\\downloadedFiles\\downloadedByCode.png";
		File downloadPath = new File(path);
		FileOutputStream fos = new FileOutputStream(downloadPath);
		fos.write(byteArray);
		fos.close();    //Need to close file once saved.(Mandatory). 

	}

}
