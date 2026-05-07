import java.rmi.Naming;
import java.rmi.RemoteException;

public class AddServer {

    public static void main(String[] args) throws Exception {

            AddImpl impl = new AddImpl();

            Naming.rebind("AddServer", impl);

            System.out.println("Server is Start...");   
        
    }
}