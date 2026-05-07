import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AddImpl extends UnicastRemoteObject implements AddIntf{

        public AddImpl() throws RemoteException
        {
            super();
        }

        public int add(String a)
        {
            String str = a.toLowerCase();
            
            int cnt = 0;
            for(int i=0;i<str.length();i++)
            {
                if(str.charAt(i)== 'a'||str.charAt(i)== 'e'||str.charAt(i)== 'i'||str.charAt(i)== 'o'||str.charAt(i)== 'u')
                {
                    cnt++;
                }
            }

            return cnt;
        }
}