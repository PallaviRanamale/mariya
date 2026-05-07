import StringReverseApp.*;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

public class StringReverseClinet 
{
    public static void main(String[] args) throws Exception {
        ORB orb = ORB.init(args,null);

        org.omg.CORBA.Object name = orb.resolve_initial_references("NameService");
        NamingContextExt nc = NamingContextExtHelper.narrow(name);

        StringReverse str = StringReverseHelper.narrow(nc.resolve_str("ReverseString"));

        String s = args[4];
        System.out.println("Reverse : "+str.reverse(s));
    }
    
}
