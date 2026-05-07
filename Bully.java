import java.util.Arrays;
import java.util.Scanner;

public class Bully 
{
    static int processes[];
    static boolean active[];

    
    public static void bully(int initiator)
    {
        boolean higherExist = false;

        System.out.println("Process "+processes[initiator]+" starts election...");

        for(int i=0;i<processes.length;i++)
        {
            if(processes[initiator] < processes[i] && active[i])
            {
                System.out.println("Process "+processes[initiator]+" -> Election ->"+processes[i]);
                System.out.println("Process "+processes[i]+" -> OK -> "+processes[initiator]);

                higherExist = true;

                 bully(i);
                 return;

            }

           
        }

        if(!higherExist)
        {
             //leader
        System.out.println("Process "+processes[initiator]+" now becomes leader..");

            for(int i=0;i<processes.length;i++)
            {
                if(processes[i]!=processes[initiator] && active[i])
                {
                    System.out.println("Process "+processes[initiator]+" -> Coordinator ->"+processes[i]);
                }

            }
        }

       

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter No. of Processes:");
        int n = sc.nextInt();

        processes = new int[n];
        active = new boolean[n];

        System.out.println("Enter no of Processes : ");

        for(int i=0;i<n;i++)
        {
            System.out.println("Process ID : ");
            processes[i] = sc.nextInt();
            active[i] = true;
        }

        System.out.println("Array : "+Arrays.toString(processes));

        System.out.println("Enter idx to Inactive Process : ");
        int idx = sc.nextInt();
        active[idx] = false;

        System.out.println("Process "+processes[idx]+" is now Inactive");

        System.out.println("Enter initiator from (0 to "+ (n-1)+ ")");
        int initiator = sc.nextInt();

        if(!active[initiator])
        {
            System.out.println(processes[initiator]+"is inactive so it can't start election...");

            return;
        }

        bully(initiator);



    }
    
}
