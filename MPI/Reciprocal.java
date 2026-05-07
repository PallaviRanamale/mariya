import mpi.*;

public class Reciprocal 
{
    public static void main(String[] args) {
        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        int n = size;
        int data[] = new int[n];
        int recv[] = new int[1];

        if(rank == 0)
        {
            System.out.print("Root Initialize Array : ");

            for(int i =0;i<n;i++)
            {
                data[i] = i+1;
                
                System.out.print(data[i]+" ");
            }
            System.out.println();
        }


        MPI.COMM_WORLD.Scatter(data,0,1,MPI.INT,recv,0,1,MPI.INT,0);

        double localRec = 1.0/recv[0];

        for(int i=0;i<n;i++)
        {
            if(rank == i)
            {
                System.out.println("Process "+rank+" received local reciprocal "+localRec);
            }
            
            MPI.COMM_WORLD.Barrier();
        }

        double Total[] = new double[n];

        MPI.COMM_WORLD.Gather(new double[]{localRec},0,1,MPI.DOUBLE,Total,0,1,MPI.DOUBLE,0);

        
         if(rank ==0)
        {
            double sum=0;
            for(int i=0;i<n;i++)
            {
                sum += Total[i];
            }

            double finalReci = sum/size;

        
                System.out.println("Final Recirpocal : "+finalReci);
        }
        


        MPI.Finalize();

    }     

    
}
