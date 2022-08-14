
public class Student5 {
	int id;
	String name;
	int age;
	Student5(int r,String n)
	{
		id=r;
		name = n;

	}
	Student5(int r, String n, int a)
	{
		id=r;
		name=n;
		age=a;

	}
	void display1(){

		System.out.println(id+" "+name+" "+age);
	} 
	void display(){

		System.out.println(id+" "+name);
	} 


	public static void main(String[] args) {
		Student5 s5 = new Student5(5,"bhargav");
		Student5 s6 = new Student5(6,"AJ",23);
		s5.display();
		s6.display1();

	}

}
