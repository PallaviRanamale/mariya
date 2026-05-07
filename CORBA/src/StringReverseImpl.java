import StringReverseApp.StringReversePOA;
import java.lang.StringBuilder;
public class StringReverseImpl extends StringReversePOA
{
   public String reverse(String str)
    {
        return new StringBuilder(str).reverse().toString();
    }
    
}
