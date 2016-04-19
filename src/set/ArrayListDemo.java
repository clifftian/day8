package set;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {
	public static void main(String args[]) {
		List<String> list = new ArrayList<String>();
		list.add("luojiahui");
		list.add("luojiafeng");

		// ����1
		Iterator it1 = list.iterator();
		while (it1.hasNext()) {
			System.out.println(it1.next());
		}

		// ����2
		for (Iterator it2 = list.iterator(); it2.hasNext();) {
			System.out.println(it2.next());
		}

		// ����3
		for (String tmp : list) {
			System.out.println(tmp);
		}

		// ����4
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}
}