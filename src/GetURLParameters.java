
import java.io.IOException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;


public class GetURLParameters {
    private  static int i,j;
     static String sub;
    public static String sendGet(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

       i= response.toString().indexOf("form action") +12;
       j= response.toString().indexOf(" ",i);
       // System.out.println("i is: "+i);
       // System.out.println("j is:" +j);
        sub = response.toString().substring(i , j);
       // System.out.println(sub);
        return sub;
    }
//    public static void main(String[] args) throws Exception {
//        sendGet("http://192.168.56.102/peruggia/index.php?action=comment&pic_id=1");
//    }

}
