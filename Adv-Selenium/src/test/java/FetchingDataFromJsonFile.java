import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FetchingDataFromJsonFile {

	public static void main(String[] args) throws IOException 

	{
		//Create an objrct of a file
		File file = new File("./src/test/resources/JsonFile.json");
		
		//Create an object of an objectmapper
		ObjectMapper jsonData = new ObjectMapper();
		
		//
		JsonNode data = jsonData.readTree(file);
		
		System.out.println(data.get("url").asText());
		System.out.println(data.get("username").asText());
		System.out.println(data.get("password").asText());
		
		WebDriver driver = new EdgeDriver();
		String Url = data.get("url").asText();
		driver.get(Url);
		
		
		
	}

}
