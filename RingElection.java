import java.util.Scanner;
import java.util.Arrays;

public class RingElection 
{
   public static int processes[];
   public static boolean active[];

    public static void Ring(int initiator)
    {
        System.out.println(processes[initiator]+" Initiating Election...");

        int candidate = processes[initiator];
        int next = (initiator+1)%processes.length;

        while (next != initiator) 
        {
            if(!active[next])
            {
                next = (next+1)%processes.length;
                continue;
            }
            System.out.println(candidate+" -> Election -> "+processes[next]);

            if(processes[next]>candidate)
            {
                candidate = processes[next];

            }

            next = (next+1)%processes.length;
            
        }

        System.out.println(candidate+ "again back to "+ processes[initiator]);

        System.out.println(candidate +" becomes a Coordinator");

        //Broadcast
        for(int i=0;i<processes.length;i++)
        {
            if(processes[i] != candidate && active[i])
            {
                System.out.println(candidate+" -> coordinator -> "+processes[i]);
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter No. of Processes : ");
        int n = sc.nextInt();

         processes = new int[n];
         active = new boolean[n];

        System.out.println("Enter Process IDs");
        for(int i=0;i<n;i++)
        {
            System.out.println("Process Id : ");         
            processes[i] =  sc.nextInt();
            active[i] = true;
        }

        System.out.println("Array :"+ Arrays.toString(processes));

        active[n-1] = false;
        System.out.println("Process "+ processes[n-1] +" is now Inactive");

        System.out.print("Enyter Initiator Idx :");
        int initiator = sc.nextInt();

        Ring(initiator);

    }
    
}
