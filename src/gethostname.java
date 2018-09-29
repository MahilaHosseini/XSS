
import java.net.InetAddress;
import java.net.UnknownHostException;

public class gethostname {

    public static void main(String a[]) {

        try {
            InetAddress host = InetAddress.getByName("216.58.204.100");
            System.out.println(host.getHostName());

            InetAddress[] inetAddresses = InetAddress.getAllByName(host.getHostName());
            for (InetAddress ina : inetAddresses)
                System.out.println("ip: "+ina);



        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
    }
}