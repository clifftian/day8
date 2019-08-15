package com.day8.poly;

class A {
	void aa() {
		System.out.println("A里的");
	}
}

class B extends A {
	void aa() {
		System.out.println("B里的");
	}
}

class C extends A {
	void aa() {
		System.out.println("C里的");
	}
}

public class ClassForName {
	public static void main(String[] args) {
		ClassForName t = new ClassForName();
		t.show("com.day8.poly.C");
	}

	void show(String name) {
		try {
			A show = (A) Class.forName(name).newInstance();
			show.aa();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}