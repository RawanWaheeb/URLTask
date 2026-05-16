import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class URLTask {

    public static void main(String[] args) throws Exception {


        URL url = new URL("https://example.com");


        URLConnection connection = url.openConnection();

        System.out.println("Connected to website successfully!\n");


        System.out.println("--- HTTP HEADERS ---");

        for (int i = 1; ; i++) {

            String key = connection.getHeaderFieldKey(i);
            String value = connection.getHeaderField(i);

            if (key == null && value == null) break;

            System.out.println(key + " : " + value);
        }


        System.out.println("\n--- PAGE CONTENT ---\n");

        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(connection.getInputStream())
                );

        String line;

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        reader.close();
    }
}