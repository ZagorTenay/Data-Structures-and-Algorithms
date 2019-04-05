import java.io.File;

public class Test {
	public static void main(String[] args) {

		Btree myBtree;

		try {
			myBtree = new Btree();

			myBtree.Bulk_Insert(new File("sdata.txt"));
			System.out.println("search 3935245592,jtqfwphtfv,iadcptmxie");
			Student st = myBtree.search(Btree.mRootNode, new Student(Long.parseLong("3935245592"), "", ""));
			if (st != null)
				System.out.println("found " + st.number + "" + st.name + "" + st.surname);
			else
				System.out.println("Not found");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}