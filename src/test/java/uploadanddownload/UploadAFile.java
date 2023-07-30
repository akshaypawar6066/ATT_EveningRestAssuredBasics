package uploadanddownload;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.io.File;

public class UploadAFile {
	
	
	@Test
	public void uploadFile()
	{
		File file = new File("C:\\Users\\Admin\\OneDrive\\Desktop\\June_Eve_Batch_Mock_Result_02_July.xlsx");
		
		RestAssured.baseURI = "https://the-internet.herokuapp.com";
		
		given().log().all()
		
		.multiPart("file",file)
		
		.when()
		
		.post("/upload")
		
		.then()
		
		.log().all();
		
		
		
	}

}
