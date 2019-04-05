import java.util.ArrayList;

public class AVLTree {

	private AVLTreeNode root;
	private long sum;
	private int sumSmaller;

	public void insert(int key) {

		AVLTreeNode newNode = new AVLTreeNode(key);
		insertAVL(this.root, newNode);
	}

	public void insertAVL(AVLTreeNode root, AVLTreeNode newNode) {
		
		if (root == null) {
			this.root = newNode;
		} 
		else {

			if (newNode.key < root.key) {
				
				if (root.left == null) {
					root.left = newNode;
					newNode.parent = root;

					recursiveBalance(root);
				} 
				else {
					insertAVL(root.left, newNode);
				}

			} else if (newNode.key > root.key) {
				
				if (root.right == null) {
					root.right = newNode;
					newNode.parent = root;

					recursiveBalance(root);
				} 
				else {
					insertAVL(root.right, newNode);
				}
			}
		}
	}

	public void recursiveBalance(AVLTreeNode currentNode) {

		setBalance(currentNode);
		int balance = currentNode.balance;

		if (balance == 2) {

			if (height(currentNode.left.left) >= height(currentNode.left.right)) {
				currentNode = rotateRight(currentNode);
			} else {
				currentNode = doubleRotateLeftRight(currentNode);
			}
		} else if (balance == -2) {
			if (height(currentNode.right.right) >= height(currentNode.right.left)) {
				currentNode = rotateLeft(currentNode);
			} else {
				currentNode = doubleRotateRightLeft(currentNode);
			}
		}

		// we did not reach the root yet
		if (currentNode.parent != null) {
			recursiveBalance(currentNode.parent);
		} else {
			this.root = currentNode;
		}
	}

	public AVLTreeNode rotateLeft(AVLTreeNode k1) { // right > left

		AVLTreeNode k2 = k1.right;
		k2.parent = k1.parent;
		k1.right = k2.left;

		if (k1.right != null) {
			k1.right.parent = k1;
		}
		
		k2.left = k1;
		k1.parent = k2;

		if (k2.parent != null) {
			
			if (k2.parent.right == k1) {
				k2.parent.right = k2;
			} 
			else if (k2.parent.left == k1) {
				k2.parent.left = k2;
			}
			
		}

		setBalance(k1);
		setBalance(k2);

		return k2;
	}

	public AVLTreeNode rotateRight(AVLTreeNode k1) { // left > right

		AVLTreeNode k2 = k1.left;
		k2.parent = k1.parent;
		k1.left = k2.right;

		if (k1.left != null) {
			k1.left.parent = k1;
		}
		
		k2.right = k1;
		k1.parent = k2;

		if (k2.parent != null) {
			
			if (k2.parent.right == k1) {
				k2.parent.right = k2;
			} 
			else if (k2.parent.left == k1) {
				k2.parent.left = k2;
			}
			
		}

		setBalance(k1);
		setBalance(k2);

		return k2;
	}

	public AVLTreeNode doubleRotateLeftRight(AVLTreeNode node) {
		node.left = rotateLeft(node.left);
		return rotateRight(node);
	}

	public AVLTreeNode doubleRotateRightLeft(AVLTreeNode node) {
		node.right = rotateRight(node.right);
		return rotateLeft(node);
	}

	public int height(AVLTreeNode currentNode) {
		if (currentNode == null) {
			return -1;
		}
		if (currentNode.left == null && currentNode.right == null) {
			return 0;
		} else if (currentNode.left == null) {
			return 1 + height(currentNode.right);
		} else if (currentNode.right == null) {
			return 1 + height(currentNode.left);
		} else {
			return 1 + maximum(height(currentNode.left), height(currentNode.right));
		}
	}

	public int maximum(int height1, int height2) {
		if (height1 >= height2) {
			return height1;
		} else {
			return height2;
		}
	}

	public void setBalance(AVLTreeNode node) { // left - right
		node.balance = height(node.left) - height(node.right);
	}
	
	public void print(){
		inorderForPrint(this.root);
	}
	
	public void inorderForPrint(AVLTreeNode node) { // printing from smallest to biggest
		if (node != null) {
			inorderForPrint(node.left);
			System.out.println(node.key);
			inorderForPrint(node.right);
		}
	}

	public long getSum() { 
		sum = 0;
		return calculateSum(this.root);
	}
	
	public long calculateSum(AVLTreeNode node) { // Summation all nodes with inorder treversal 
		if (node != null) {
			sum += node.key;
			calculateSum(node.left);
			calculateSum(node.right);
		}
		
		return sum;
	}
	
	public void sumOfSmallerItems(int limit, AVLTreeNode root){
		if (root != null) {			
			sumOfSmallerItems(limit, root.left);
			
			if(root.key < limit)
				sumSmaller += root.key;
			
			sumOfSmallerItems(limit, root.right);
		}
	}
	
	public int getSumSmaller(int limit){ // we get limit and add items acording to it
		sumSmaller = 0;
		sumOfSmallerItems(limit, root);
		return sumSmaller;		
	}
	
	public int getMax(){ // right
		AVLTreeNode temp = root;
		
		while(temp.right != null){
			temp = temp.right;
		}
		
		return temp.key;		
	}

	public int getMin() { // left
		AVLTreeNode temp = root;

		while (temp.left != null) {
			temp = temp.left;
		}

		return temp.key;
	}

}
