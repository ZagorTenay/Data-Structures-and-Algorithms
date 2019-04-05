
public class Sort {
	public String strYour_name = "Özgür Hepsað";
	public long Your_number = 2014510043;

	public Sort() {
		
	}

	public String convertToBinary(int number) { 
		// We take our integer(int number) that we want to convert to unsigned 32-bit
			String binary = ""; // Firstly our string variable that we will conver is empty.
			int value = number;

			for (int j = 0; j < 32; j++) { // turn 32 times

				if (value == 1) // If last bit is 1 or 0, we control it first two else. They are prior conditions.
					binary = "1" + binary;
				else if (value == 0)
					binary = "0" + binary; // If last bit 0 and we have less than 32 bits, we will add the 0 s head of the string to fill it 32.
				else if (value % 2 == 1)
					binary = "1" + binary;
				else if (value % 2 == 0)
					binary = "0" + binary;

				value = value / 2; // Value is always devided to 2, because we take mode 2 of value. 
				}
		
		return binary; // Return 32-bit representation of number that we will use

	}
	
	// The parameters have to be like this " Sort sort = new Sort(); sort.Our_sort(numbers, 0, numbers.length - 1, 32); " for proper sort.
	public void Our_sort(int[] unsorted, int p, int q, int digit) {

		
		boolean control = false; // We will control that if j (boundary) is same with first location of q and it is biggest element or not.
		int bitNum = 32 - digit;
		int i = p, j = q; // We store temps of p and q, because we might use the first locations of them in recursion.

		while (i < j) { // if i and j would be equals, this mean we have to get out of this while. So, we should control other bit.
			// i and j can just be equals in my algorithm, i could not bigger than j. 
			String binaryp = convertToBinary(unsorted[i]); // We get our 32-representations with calling convertToBinary() function.
			String binaryq = convertToBinary(unsorted[j]); // Used two strings in order to compare two integers.
			
			if(Integer.parseInt(binaryp.substring(bitNum, bitNum + 1)) == 0 // In case of 0-0 in bit comparison, we increase i
					&& Integer.parseInt(binaryq.substring(bitNum, bitNum + 1)) == 0){
				i++;
			}
			else if(Integer.parseInt(binaryp.substring(bitNum, bitNum + 1)) == 1 // In case of 1-1 in bit comparison, we decrease j
					&& Integer.parseInt(binaryq.substring(bitNum, bitNum + 1)) == 1){
				j--;			}
			else if(Integer.parseInt(binaryp.substring(bitNum, bitNum + 1)) == 0 // In case of 0-1 in bit comparison, we increase i again
					&& Integer.parseInt(binaryq.substring(bitNum, bitNum + 1)) == 1){
				i++;
				control = true; // Last element might biggest if j is same with q.
			}
			else if(Integer.parseInt(binaryp.substring(bitNum, bitNum + 1)) == 1 // In case of 1-0 in bit comparison, we increase i
					&& Integer.parseInt(binaryq.substring(bitNum, bitNum + 1)) == 0){
				control = true; // Last element might biggest if j is same with q.
				
				int temp2 = unsorted[i]; // Swap the smaller and bigger numbers
				unsorted[i] = unsorted[j];
				unsorted[j] = temp2;
				
				i++;
			}		
		}
		
		if (bitNum < 31) { // If bitNum greater than 31, we have to prevent to enter the recursion.
			// Locations of temps of p and q will be controlled.
			if(q != j && i - 1 != p){ // If i is not at the head of array and j is not at the tail of the array, we can divide the array. We assume that j is the boundary.
				Our_sort(unsorted, j, q, digit - 1); // Right part of boundary. So, we will sort the array from boundary to first place of q.
				Our_sort(unsorted, p, i-1, digit - 1); // Left part of boundary. So, we will sort the array from first place of p to boundary.
			}
			else if(control == false && q == j){ // If j same with q and we don't know that elemet q of array is bigger (We can control that with boolean control),this means that boundary has been not created. So, we do not need to sort all of the array from p to q.
				Our_sort(unsorted, p, q, digit - 1); // We will send the array and increase the digit
			}
			else if(control == true && q == j &&  i - 1 != p){ // If j same with q and we know that elemet q of array is bigger (We can control that with boolean control), we do not need do send right part of boundary to recursion, because it has already sorted and one.
				Our_sort(unsorted, p, i - 1, digit - 1); //We will just send left part of j. So j is boundary.
			}
			else if(q != j && i - 1 == p){ // If i has moved one time and j has decreased, this means that p is the smallest element. 
				Our_sort(unsorted, j, q, digit - 1); // So, we do not need to send left side to recursion. It is just one element. We will send the right side.
			}			
			// We always decrease the digit in every recursion
		}

	}

}
