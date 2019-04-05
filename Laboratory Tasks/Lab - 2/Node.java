public class Node {
	public int mNumKeys = 0;
	public Node[] mChildNodes = new Node[2 * Btree.T];
	public boolean mIsLeafNode;
	public Student[] student = new Student[2 * Btree.T - 1];
	public int pageNumber = 0;

	public Node() {
		for (int i = 0; i < student.length; i++) {
			student[i] = new Student(0, null, null);
		}
		for (int i = 0; i < mChildNodes.length; i++) {
			mChildNodes[i] = null;
		}
		mIsLeafNode = true;
	}
}