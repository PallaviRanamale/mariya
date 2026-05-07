import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TokenRing {

     int myId;
     int nextPort;
     int totalNodes;
     ServerSocket serverSocket;

     public TokenRing(int myId,int totalNodes) throws Exception
     {
        this.myId = myId;
        this.totalNodes = totalNodes;
        int myPort= 6000+myId;
        nextPort = 6000+ ((myId+1)%totalNodes);

        serverSocket = new ServerSocket(myPort);

        System.out.println("Node Starts on port "+myPort);
     }

     public void run() throws Exception
     {
        while(true)
        {
            Socket in = serverSocket.accept();
            DataInputStream dis = new DataInputStream(in.getInputStream());
            int token = dis.readInt();
            in.close();

            System.out.println(" Node "+myId+ " receiving token "+token);
            System.out.println("Node "+myId+ " Entering into CS...");
            Thread.sleep(300);
            System.out.println("Node "+myId+ "Leaving CS...");

            Thread.sleep(200);
            passToken(token);
        }
     }


     public void passToken(int token) throws Exception
     {
        for(int i=0;i<totalNodes;i++)
        {
            try
            {
                Socket s = new Socket("localhost",nextPort);
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                dos.writeInt(token);
                s.close();

                System.out.println("Node "+myId+" passes token to "+ (myId+1)%totalNodes);
                return;
            }
            catch(Exception e)
            {
                Thread.sleep(500);
            }
        }
        
     }


    public static void main(String[] args) throws Exception
    {
        int nodeId = Integer.parseInt(args[0]);
        int totalNodes = Integer.parseInt(args[1]);

        TokenRing node = new TokenRing(nodeId, totalNodes);

        if(nodeId == 0)
        {
            Thread.sleep(2000);

            System.out.println("Node 0 initiating a Toke...");

            node.passToken(1);
        }

        node.run();
        
    }

}