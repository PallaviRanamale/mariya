import java.rmi.*;
public interface AddIntf extends Remote
{
    int add(String a) throws RemoteException;
}