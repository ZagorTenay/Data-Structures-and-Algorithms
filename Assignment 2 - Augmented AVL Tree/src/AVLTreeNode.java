
public class AVLTreeNode {
	public AVLTreeNode left;
	public AVLTreeNode right;
	public AVLTreeNode parent;
	public int key;
	public int balance;

	public AVLTreeNode(int key) {
		left = right = parent = null;
		balance = 0;
		this.key = key;
	}

}
