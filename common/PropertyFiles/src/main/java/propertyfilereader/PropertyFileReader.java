package propertyfilereader;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileReader {
  Properties readProperties(String propertyFile) {
     try (
           InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertyFile);
         ) {
         if (inputStream == null) {
             throw new FileNotFoundException("Can't read property file '" + propertyFile + "'");
         }
         Properties props = new Properties();
         props.load(inputStream);
         return props;
     } catch (Exception e) { }
     return null;
  }
  public static void main(String... args) {
    PropertyFileReader propertyFileReader = new PropertyFileReader();
    Properties props = propertyFileReader.readProperties("application.properties");
    if ( props == null ) {
        System.out.println("Unable to get properties");
        return;
    }
    System.out.println(props.getProperty("app_name"));
  }
}
