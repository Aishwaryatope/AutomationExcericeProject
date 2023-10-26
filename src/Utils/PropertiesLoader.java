package Utils;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {

	 public static String loadProperty(String propertyName) throws IOException {

	        InputStream inputStream = new FileInputStream("C:\\Users\\Ajit Tamboli\\eclipse-workspace\\Selenium\\src\\test\\resources\\testData\\Configurationproperty");
	        Properties properties = new Properties();
	        properties.load(inputStream);
	        return properties.getProperty(propertyName);
	
}
}