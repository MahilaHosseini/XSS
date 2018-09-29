import java.util.List;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTMLParser {


    public final static void main(String[] args) throws Exception{

        String site = args[0];
        //System.out.println();
        List<String> links = extractLinks(site);
        for (String link : links) {
            System.out.println(link);
        }
    }

    public static List<String>extractLinks(String url) throws Exception {
        final ArrayList<String> result = new ArrayList<String>();

        Document doc = Jsoup.connect(url).get();

        Elements links = doc.select("a[href]");

        for (Element link : links) {
            result.add(link.attr("abs:href"));
        }

        return result;
    }




}


