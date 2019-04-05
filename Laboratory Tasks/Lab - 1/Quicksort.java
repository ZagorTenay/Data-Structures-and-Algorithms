public class Quicksort {

    public void Quicksort(int[] A, int p, int r)
    {
        if(p<r)
        {
            int q = Partition(A,p,r);
            Quicksort(A, p, q - 1);
            Quicksort(A, q + 1, r);
        }
    }

    private int Partition(int[] A, int p, int r)
    {
        int pivot = A[r];
        int i = p - 1;
        for (int j = p; j<= r-1; j++ )
        {
            if(A[j] <= pivot)
            {
                i = i + 1;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }	
        }
        int temp = A[r];
        A[r] = A[i + 1];
        A[i + 1] = temp;
        
        return i+1;
    }

    public void List_All_Elemets(int[] A)
    {
        for(int i=0;i<A.length;i++)
        {
            System.out.print(A[i]+" ");
        }
        System.out.println();
    }
}
