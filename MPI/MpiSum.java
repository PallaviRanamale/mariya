// command to run in windows :
// command to compile : javac -cp ".;C:\mpj-v0_44\lib\mpj.jar" sum.java
// command to run : C:\mpj-v0_44\bin\mpjrun.bat -np 5 sum
//commands to run in linux :
// command to compile : javac -cp ".:/home/ubuntu/mpj-v0_44/lib/mpj.jar" sum.java
// command to run : /home/ubuntu/mpj-v0_44/bin/mpjrun.sh -np 5 sum

import java.util.Random;

import mpi.*;
public class MpiSum {
    
   public static void main(String[] args) {
        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        int n = size;
        int data[] = new int[n];
        int recv[] = new int[1];

        if(rank==0)
        {
            System.out.print("Root Initializing Array : ");
            Random r = new Random();
            for(int i=0;i<n;i++)
            {
                data[i] = r.nextInt(100);

                System.out.print(data[i]+" ");
            }
            System.out.println();
        }

        MPI.COMM_WORLD.Scatter(data,0,1,MPI.INT,recv,0,1,MPI.INT,0);

        int localSum = recv[0];

        for(int i=0;i<n;i++)
        {
            if(rank == i)
            {
                System.out.println("Process "+rank+ " received "+localSum);
            }

            MPI.COMM_WORLD.Barrier();
        }

        int sum[] = new int[1];

        MPI.COMM_WORLD.Scan(new int[]{localSum},0,sum,0,1,MPI.INT,MPI.SUM);

       
            for(int i=0;i<n;i++)
            {
                 if(rank == i)
        {
                System.out.println("Process "+i+" Intermediate Sum : "+sum[0]);
            }

            MPI.COMM_WORLD.Barrier();
            
        }


        MPI.Finalize();
   }
    
}
