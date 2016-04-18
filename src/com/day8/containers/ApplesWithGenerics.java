package com.day8.containers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Apple{
	private static long counter=0;
	private int id=0;
	public Apple(int i){
		id=i;
	}
	public int getId(){
		return id;
	}
}

public class ApplesWithGenerics {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("Beijing", "Beijing");
		hm.put("Shandong", "Jinan");
		System.out.println(hm.toString());	
		System.out.println(hm);	
		
		for (String prov : hm.keySet()){
			System.out.println(hm.get(prov));	
		}
		
		/*Integer[] ar = {111,222,333,444};
		
		List <Integer> list1 = new ArrayList<Integer>();
		list1 = Arrays.asList(ar);
		System.out.println(list1.toString());
		System.out.println("----");
		for (int i=0; i<list1.size(); i++){
			System.out.println(list1.get(i));
		}
		
		
		List <Apple> apples = new ArrayList<Apple>();
		
		for (int i=0; i<3; i++){
			apples.add(new Apple(i));
		}
		
		for (Apple a : apples){
			System.out.println(((Apple)a).getId());
		}
		
		Set<Apple> appleSets = new HashSet<Apple>();
		for (int i=5; i<8; i++){
			appleSets.add(new Apple(i));
		}
		for (Apple a : appleSets){
			System.out.println(a.getId());
		}*/

	}

}
