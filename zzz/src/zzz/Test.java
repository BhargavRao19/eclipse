package zzz;
class Animal {
	
}
class Monkey extends Animal
{
	
}
public class Test {
	public void methodOne(Animal a) {
		System.out.println("animal version");
	}
public void methodOne(Monkey m) {
	System.out.println("monkey version");
}
	public static void main(String[] args) {
		Test t = new Test();
		Animal a = new Animal();
		t.methodOne(a);
		Monkey m = new Monkey();
		t.methodOne(m);
		
		
		Animal a1 = new Monkey();
		t.methodOne(a1);
		t.methodOne(null);
		t.methodOne(new Monkey());
		t.methodOne(new Animal());
		

	}

}
