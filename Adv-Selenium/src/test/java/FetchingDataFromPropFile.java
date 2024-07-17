import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FetchingDataFromPropFile {

	public static void main(String[] args) throws IOException {
		
		//1. Create FileInputStream Object
		FileInputStream fis = new FileInputStream("./src/test/resources/prop.properties");

		//2. Create property file object
		Properties p = new Properties();
		
		//3.Load File
		p.load(fis);
		
		//4. Fetch the data
		System.out.println(p.getProperty("url"));
		System.out.println(p.getProperty("uname"));
		System.out.println(p.getProperty("password"));
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
	//	String Url = p.getProperty("url");
	//	driver.get(Url);
	//OR
		driver.get(p.getProperty("url"));
	}

}
