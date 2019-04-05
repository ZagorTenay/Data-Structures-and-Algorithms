
public class AugAVLTreeNode {
	public AugAVLTreeNode left;
	public AugAVLTreeNode right;
	public AugAVLTreeNode parent;
	public long totalOfSmaller;
	public int key;
	public int balance;

	public AugAVLTreeNode(int key) {
		left = right = parent = null;
		balance = 0;
		totalOfSmaller = 0;
		this.key = key;
	}

}
