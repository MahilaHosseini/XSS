import java.util.List;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class HTMLParser {
    static InetAddress[] inetAddresses;
    static String site2, site;
    static boolean ip = false;

    public final static void main(String[] args) throws Exception {

        site = args[0];
        site2 = site.substring(site.indexOf(":") + 3);
        //  System.out.println(site2);

        try {
            inetAddresses = InetAddress.getAllByName(site2);
        } catch (UnknownHostException e) {
            // System.out.println("no ip address");
            ip = true;

        }


        for (InetAddress ina : inetAddresses)
            System.out.println(ina);
        System.out.println("done");

        List<String> links = extractLinks(site);
        for (String link : links) {
            System.out.println(link);
        }
    }

    public static List<String> extractLinks(String url) throws Exception {
        final ArrayList<String> result = new ArrayList<String>();

        Document doc = Jsoup.connect(url).get();

        Elements links = doc.select("a[href]");

        /*if provided url is not ip address then all the associated ip addresses will be checked to see if the
         * link is for the site itself or is redirect to another site*/

        if (!ip) {
            for (Element link : links) {
                for (InetAddress ina : inetAddresses) {
                    if (link.toString().contains(ina.toString()) || link.toString().contains(site2)) {
                        result.add(link.attr("abs:href"));
                        break;
                    }
                }
            }
        }

        /*i fthe provided url is an ip itself then it will only check for it */
        else {
            String l;
            for (Element link : links) {
                l = link.attr("abs:href");
                if (l.contains(site2))
                    result.add(l);

            }
        }

        return result;
    }


}


