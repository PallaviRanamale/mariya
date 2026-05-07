import StringReverseApp.*;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.*;

public class StringReverseServer 
{
    public static void main(String[] args) throws Exception {
        
        ORB orb = ORB.init(args,null);

        POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
        rootpoa.the_POAManager().activate();

        StringReverseImpl impl = new StringReverseImpl();

        org.omg.CORBA.Object cobj = rootpoa.servant_to_reference(impl);
        StringReverse str = StringReverseHelper.narrow(cobj);

        org.omg.CORBA.Object name = orb.resolve_initial_references("NameService");
        NamingContextExt nc = NamingContextExtHelper.narrow(name);

        nc.rebind(nc.to_name("ReverseString"),str);

        System.out.println("Server is Ready...");

        orb.run();
    }
    
}
