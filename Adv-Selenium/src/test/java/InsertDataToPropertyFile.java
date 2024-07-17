import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class InsertDataToPropertyFile {

	public static void main(String[] args) throws IOException {
	
		Properties p = new Properties();
		p.setProperty("url", "https://demowebshop.tricentis.com/");
		p.setProperty("username", "Chandana");
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/prop1.properties");
		p.store(fos, "prop1");
		System.out.println("Property file1 created");
		
	
	}

}
