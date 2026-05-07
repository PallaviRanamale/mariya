import java.rmi.Naming;
import java.rmi.RemoteException;

public class AddClient {

    public static void main(String[] args) throws Exception {
        
        String url = "rmi://localhost/AddServer";

        AddIntf intf = (AddIntf) Naming.lookup(url);

        // int a = Integer.parseInt(args[0]);


        String a = args[0];
        // String b = args[1];

        int res = intf.add(a);

        System.out.println("Result : "+res);
    }
}