import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Btree {
	public static Node mRootNode;
	public final static int T = 2;

	public Btree() throws Exception {
		mRootNode = new Node();
		mRootNode.mIsLeafNode = true;
	}

	public void Bulk_Insert(File file) throws NumberFormatException, Exception {
		FileReader frdr = new FileReader(file);
		BufferedReader br = new BufferedReader(frdr);
		String str;
		String[] informs = {};

		while ((str = br.readLine()) != null) {
			informs = str.split(",");
			Insert(new Student(Long.parseLong(informs[0]), informs[1], informs[2]));
		}
	}

	public void Insert(Student s) throws Exception {
		Node rootNode = mRootNode;

		if (rootNode.mNumKeys == (2 * T - 1)) {
			Node newRootNode = new Node();
			mRootNode = newRootNode;
			newRootNode.mIsLeafNode = false;
			mRootNode.mChildNodes[0] = rootNode;

			splitChildNode(newRootNode, 0, rootNode);
			insertIntoNonFullNode(rootNode, s);
		} else {
			insertIntoNonFullNode(rootNode, s);
		}
	}

	void splitChildNode(Node parentNode, int i, Node node) throws Exception {
		Node newNode = new Node();
		newNode.mIsLeafNode = node.mIsLeafNode;
		newNode.mNumKeys = T - 1;
		for (int j = 0; j < T - 1; j++) {
			newNode.student[j] = node.student[j + T];
		}
		if (!node.mIsLeafNode) {
			for (int j = 0; j < T + 1; j++) {
				newNode.mChildNodes[j] = node.mChildNodes[j + T - 1];
			}
			for (int j = T; j <= node.mNumKeys; j++) {
				node.mChildNodes[j] = null;
			}
		}
		node.mNumKeys = T - 1;
		for (int j = parentNode.mNumKeys; j >= i + 1; j--) {
			parentNode.mChildNodes[j + 1] = parentNode.mChildNodes[j];
		}
		parentNode.mChildNodes[i + 1] = newNode;
		for (int j = parentNode.mNumKeys - 1; j >= i; j--) {
			parentNode.student[j + 1] = parentNode.student[j];
		}
		parentNode.student[i] = node.student[T - 1];
		parentNode.mNumKeys++;
	}

	void insertIntoNonFullNode(Node node, Student stu) throws Exception {
		int i = node.mNumKeys - 1;
		if (node.mIsLeafNode) {
			while (i >= 0 && stu.number < node.student[i].number) {
				node.student[i + 1] = node.student[i];
				i--;
			}
			i++;
			node.student[i] = stu;
			node.mNumKeys++;
		} else {
			while (i >= 0 && stu.number < node.student[i].number) {
				i--;
			}
			i++;
			if (node.mChildNodes[i] != null) {
				Node child = node.mChildNodes[i];
				if (child != null) {
					if (child.mNumKeys == (2 * T - 1)) {
						splitChildNode(node, i, child);
						if (stu.number > node.student[i].number) {
							i++;
						}
					}
					insertIntoNonFullNode(node.mChildNodes[i], stu);
				}
			}
		}
	}

	public Student search(Node node, Student stu) {
		int i = 0;
		while (i < node.mNumKeys && stu.number > node.student[i].number) {
			i++;
		}
		if (i < node.mNumKeys && stu.number == node.student[i].number) {
			return node.student[i];
		}
		if (node.mIsLeafNode) {
			return null;
		} else {
			Node child;
			try {
				if (node.mChildNodes[i] != null) {
					child = node.mChildNodes[i];
					if (child != null)
						return search(child, stu);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}