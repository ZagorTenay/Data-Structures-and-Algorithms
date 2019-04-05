public class Test 
{
	public static void main(String[] args) 
	{
		int[] Array1={11, 13, 2, 8, 40, 100, 5, 15, 35, 11, 2, 35, 40};
		int[] Array2={11, 13, 2, 8, 40, 100, 5, 15, 35, 11, 2, 35, 40};
		Max_Heap max_heap1=new Max_Heap(Array1);
		max_heap1.HeapSort();
		
		Quicksort quicksort1 = new Quicksort();
		quicksort1.Quicksort(Array2, 0, Array2.length - 1);
		
		max_heap1.List_All_Elemets();
		quicksort1.List_All_Elemets(Array2);
	}
}
