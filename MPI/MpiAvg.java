import java.util.Random;
import mpi.*;
public class MpiAvg 
{
    public static void main(String[] args) 
    {
        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        int n = size*2;
        int data[] = new int[n];
        int recv[] = new int[2];
        
        if(rank==0)
        {
            Random r = new Random();
            System.out.print("Root Initializing Array : ");

            for(int i=0;i<n;i++)
            {
                data[i] = r.nextInt(100);

                System.out.print(data[i]+" ");
            }
            System.out.println();
        }

        MPI.COMM_WORLD.Scatter(data,0,2,MPI.INT,recv,0,2,MPI.INT,0);

        double localAvg = (recv[0]+recv[1])/2.0;

        for(int i=0;i<size;i++)
        {
            if(rank==i)
            {
                System.out.println("Process "+rank+" received "+localAvg);
            }
            MPI.COMM_WORLD.Barrier();
        }

        double total[] = new double[size];

        MPI.COMM_WORLD.Gather(new double[]{localAvg},0,1,MPI.DOUBLE,total,0,1,MPI.DOUBLE,0);

        if(rank==0)
        {
            double sum=0;

            for(int i=0;i<size;i++)
            {
                sum+=total[i];
            }

            double finalAvg = sum/size;

            System.out.println("Final Avg : "+finalAvg);
        }

        MPI.Finalize();
        
    }
    
}
