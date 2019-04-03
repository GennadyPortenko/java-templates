import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PropertyFilesReader {
  public static void main(String... args{
     try (
             InputStreamReader reader = new BufferedReader(new InputStreamReader("application.properties"));
         ) {
     }
  }
}
