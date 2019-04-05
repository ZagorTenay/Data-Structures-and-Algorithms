public class Max_Heap {
    int Array[];
    int heap_size;

    private int Parent(int i) {
        return i / 2 - (i % 2 == 0 ? 1 : 0);
    }

    private int Left(int i) {
        return 2 * i + 1;
    }

    private int Right(int i) {
        return 2 * i + 2;
    }

    public Max_Heap(int[] Array) {
        heap_size = 0;
        this.Array = Array;

    }

    private void Max_Heapify(int i)// Maintaining the heap property
    {
        int largest;
        int left = Left(i);
        int right = Right(i);
        largest = Parent(i);
        if (left <= heap_size - 1 && Array[left] > Array[i])
            largest = left;
        else
            largest = i;
        if (right <= heap_size - 1 && Array[right] > Array[largest])
            largest = right;
        if (largest != i) {
            int temp = Array[i];
            Array[i] = Array[largest];
            Array[largest] = temp;
            Max_Heapify(largest);
        }

    }

    private void Build_Max_Heap() {
        heap_size = Array.length;
        for (int i = Array.length / 2; i >= 0; i--)
            Max_Heapify(i);
    }

    public void HeapSort() {
        int temp;
        Build_Max_Heap();
        for (int i = Array.length - 1; i >= 1; i--) {
            temp = Array[0];
            Array[0] = Array[i];
            Array[i] = temp;
            heap_size = heap_size - 1;
            Max_Heapify(0);
        }
    }

    public void List_All_Elemets() {
        for (int i = 0; i < Array.length; i++) {
            System.out.print(Array[i] + " ");
        }
        System.out.println();
    }

}
