package aa;
class A{
	public static void m1() {
		System.out.println("I'm from A class");
	}
}
class B extends A{
public static void m1() {
	System.out.println("I'm from B class");
	}
}
public class Hey {

	public static void main(String[] args) {
		B b = new B();
		b.m1();
		
		A ab = new B();
		ab.m1();
	}

}
