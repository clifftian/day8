package com.day8.containers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class Charproducer {
	private String movieName;
	private char[] acm;
	private static int counter;

	public Charproducer(String str) {
		movieName = str;
		acm = movieName.toCharArray();
	}

	public char producer() {
		return acm[(counter++) % acm.length];
	}
}

public class FillTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Hello, this is Ray!";
		Charproducer chd = new Charproducer(str);
		List al = new ArrayList();
		List ll = new LinkedList();
		Set hs = new HashSet();
		Set ts = new TreeSet();
		Set ls = new LinkedHashSet();
		for (int i = 0; i < str.length(); i++) {
			char c = chd.producer();
			al.add(c);
			ll.add(c);
			hs.add(c);
			ts.add(c);
			ls.add(c);

			Iterator i1 = al.iterator();
			while (i1.hasNext()) {
				System.out.print(i1.next());
			}
			System.out.print("XXXX");
			System.out.println(al);
			System.out.println(ll);
			System.out.println(hs);
			System.out.println(ts);
			System.out.println(ls);
		}

	}
}
