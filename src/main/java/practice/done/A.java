package practice.done;

class A {
	public final void testMethod() {
		System.out.println("invoke A");
	}
}
class B extends A {
	/**
	 * uncomment this method will give compile time error as final is being used above
	 */
//	public final void testMethod() {
//		System.out.println("invoke B");
//	}
}
class Main {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        	A a = new B();
		a.testMethod();
    }
}