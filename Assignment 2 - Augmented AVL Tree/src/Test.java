import java.util.ArrayList;
import java.util.Random;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rnd =new Random();
		ArrayList<Integer>	numbersToInsert = new ArrayList();
		long startTime;
		long endTime;
		int randnum;
		
		while(numbersToInsert.size() < 10001) {
			randnum=rnd.nextInt(600000);
			if(!numbersToInsert.contains(randnum)){
				numbersToInsert.add(randnum);
			}
		}
		AVLTree avl = new AVLTree();
		AugAVLTree aavl = new AugAVLTree();
		
		System.out.println("------ AVL-Tree ------");		
		startTime=System.nanoTime();
		for (int i = 0; i <numbersToInsert.size() ; i++) {
			avl.insert(numbersToInsert.get(i));
		
		}
		endTime=System.nanoTime();
		System.out.println("All items were inserted.");
		System.out.println("The time elapsed for the insertion of all items is " + (endTime-startTime) + " nanoseconds");
		System.out.println("The result of GETSUMSMALLER for the item with value 1000 is " + avl.getSumSmaller(1000));
		System.out.println("The maximum value of all items is " + avl.getMax());
		System.out.println("The minimum value of all items is " + avl.getMin());
		startTime=System.nanoTime();
		long avlsum = avl.getSum();
		endTime=System.nanoTime();
		System.out.println("The summation of all items is " + avlsum);
		System.out.println("The time elapsed for GETSUM is " + (endTime-startTime) + " nanoseconds");		
//		avl.print();
		
		System.out.println();
		
		System.out.println("------ Augmented AVL-Tree ------");		
		startTime=System.nanoTime();
		for (int i = 0; i <numbersToInsert.size() ; i++) {
			aavl.insert(numbersToInsert.get(i));
		
		}
		endTime=System.nanoTime();
		System.out.println("All items were inserted.");
		System.out.println("The time elapsed for the insertion of all items is " + (endTime-startTime) + " nanoseconds");
		System.out.println("The result of GETSUMSMALLER for the item with value 1000 is " + aavl.getSumSmaller(1000));
		System.out.println("The maximum value of all items is " + aavl.getMax());
		System.out.println("The minimum value of all items is " + aavl.getMin());
		startTime=System.nanoTime();
		long aavlsum = aavl.getSum();
		endTime=System.nanoTime();
		System.out.println("The summation of all items is " + aavlsum);
		System.out.println("The time elapsed for GETSUM is " + (endTime-startTime) + " nanoseconds");
//		aavl.print();
	
/*		
		AVLTree avl1 = new AVLTree();
		AugAVLTree aavl1 = new AugAVLTree();
		AVLTree avl2 = new AVLTree();
		AugAVLTree aavl2 = new AugAVLTree();
		AVLTree avl3 = new AVLTree();
		AugAVLTree aavl3 = new AugAVLTree();
		
		
		long sum = 0;
		
		startTime = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			avl1.insert(numbersToInsert.get(i));
		
		}
		endTime = System.nanoTime();
		System.out.println(endTime - startTime);
		startTime = System.nanoTime();
		sum = avl1.getSum();
		endTime = System.nanoTime();
		System.out.println(endTime - startTime);
		
		startTime=System.nanoTime();
		for (int i = 0; i < 10000 ; i++) {
			avl2.insert(numbersToInsert.get(i));
		
		}
		endTime=System.nanoTime();
		System.out.println(endTime - startTime);
		startTime = System.nanoTime();
		sum = avl2.getSum();
		endTime = System.nanoTime();
		System.out.println(endTime - startTime);		
			
		startTime=System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			avl3.insert(numbersToInsert.get(i));
		
		}
		endTime=System.nanoTime();
		System.out.println(endTime - startTime);
		startTime = System.nanoTime();
		sum = avl3.getSum();
		endTime = System.nanoTime();
		System.out.println(endTime - startTime);		
		
		startTime=System.nanoTime();
		for (int i = 0; i < 1000 ; i++) {
			aavl1.insert(numbersToInsert.get(i));
		
		}
		endTime=System.nanoTime();
		System.out.println(endTime - startTime);
		startTime = System.nanoTime();
		sum = aavl1.getSum();
		endTime = System.nanoTime();
		System.out.println(endTime - startTime);
		
		startTime=System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			aavl2.insert(numbersToInsert.get(i));
		
		}
		endTime=System.nanoTime();
		System.out.println(endTime - startTime);
		startTime = System.nanoTime();
		sum = aavl2.getSum();
		endTime = System.nanoTime();
		System.out.println(endTime - startTime);
		
		startTime=System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			aavl3.insert(numbersToInsert.get(i));
		
		}
		endTime=System.nanoTime();
		System.out.println(endTime - startTime);
		startTime = System.nanoTime();
		sum = aavl3.getSum();
		endTime = System.nanoTime();
		System.out.println(endTime - startTime);
*/
		
	}

}
