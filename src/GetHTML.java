import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class GetHTML {



    public static void main(String[] args) throws Exception {

        GetHTML http = new GetHTML();

        System.out.println("Testing 1 - Send Http GET request");
        http.sendGet();

    }

    // HTTP GET request
    private void sendGet() throws Exception {

        String url = "http://www.google.com";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");


        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));

        StringBuilder response ;

        String line;
        response = new StringBuilder();
        while ((line = in.readLine()) != null) {
            response.append(line);
            response.append(System.lineSeparator());
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }
}
