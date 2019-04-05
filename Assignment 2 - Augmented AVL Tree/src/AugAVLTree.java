import java.util.ArrayList;

public class AugAVLTree {
	private AugAVLTreeNode root;
	private long sumForUpdate = 0;
	private long sum;
	private int sumSmaller;

	public void insert(int key) {

		AugAVLTreeNode newNode = new AugAVLTreeNode(key);
		insertAVL(this.root, newNode);
	}

	public void insertAVL(AugAVLTreeNode root, AugAVLTreeNode newNode) {
		boolean isInserted = false;
		
		if (root == null) {
			this.root = newNode;
			isInserted = true;
		} 
		else {

			if (newNode.key < root.key) {
				
				if (root.left == null) {
					root.left = newNode;
					newNode.parent = root;
					isInserted = true;
					recursiveBalance(root);
				} 
				else {
					insertAVL(root.left, newNode);
				}

			} else if (newNode.key > root.key) {
				
				if (root.right == null) {
					root.right = newNode;
					newNode.parent = root;
					isInserted = true;
					recursiveBalance(root);
				} 
				else {
					insertAVL(root.right, newNode);
				}

			}
		}
		
		if(isInserted == true){ // all nodes are updated on every insertion
			sumForUpdate = 0;
			update(this.root);
		}
		
	}
	
	public void update(AugAVLTreeNode node){ // updating for augmented values of all nodes
		if (node != null) {		
			update(node.left);		
			node.totalOfSmaller = sumForUpdate;
			sumForUpdate += node.key;
			update(node.right);
		}
		
	}

	public void recursiveBalance(AugAVLTreeNode currentNode) {

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

	public AugAVLTreeNode rotateLeft(AugAVLTreeNode k1) { // right > left

		AugAVLTreeNode k2 = k1.right;
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

	public AugAVLTreeNode rotateRight(AugAVLTreeNode k1) { // left > right

		AugAVLTreeNode k2 = k1.left;
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

	public AugAVLTreeNode doubleRotateLeftRight(AugAVLTreeNode node) {
		node.left = rotateLeft(node.left);
		return rotateRight(node);
	}

	public AugAVLTreeNode doubleRotateRightLeft(AugAVLTreeNode node) {
		node.right = rotateRight(node.right);
		return rotateLeft(node);
	}

	public int height(AugAVLTreeNode currentNode) {
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

	public void setBalance(AugAVLTreeNode node) { // left - right
		node.balance = height(node.left) - height(node.right);
	}

	public void print() {
		inorderForPrint(this.root);
	}
	
	public void inorderForPrint(AugAVLTreeNode node) { // printing from smallest to biggest
		if (node != null) {		
			inorderForPrint(node.left);
			System.out.println(node.key);
			inorderForPrint(node.right);
		}
	}
	
	public void sumOfSmallerItems(int limit, AugAVLTreeNode root){
		if (root != null) {
			sumOfSmallerItems(limit, root.left);
			
			if(root.key < limit) // we add items with references to limit
				sumSmaller += root.key;
			
			sumOfSmallerItems(limit, root.right);
		}
	}
	
	public int getSumSmaller(int limit){
		sumSmaller = 0;
		sumOfSmallerItems(limit, root);
		return sumSmaller;		
	}
	
	public int getMax(){ // right
		AugAVLTreeNode temp = root;
		
		while(temp.right != null){
			temp = temp.right;
		}
		
		return temp.key;		
	}

	public int getMin() { // left
		AugAVLTreeNode temp = root;

		while (temp.left != null) {
			temp = temp.left;
		}

		return temp.key;
	}
	
	public long getSum(){	// Firstly we find biggest node and we add its augmented and key.
		
		sum = 0;
		AugAVLTreeNode temp = root;
		
		while(temp.right != null){
			temp = temp.right;
		}
		
		sum = temp.key + temp.totalOfSmaller;
		
		return sum;
		
	}

	
}
