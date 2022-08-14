class ChangeIt
{
	static void dolt(int[] z)
	{
		z=null;
	}
}
public class Testit {

	public static void main(String[] args) {
		int[] myArray = {1,2,3,4,5,6};
		//ChangeIt ab = new ChangeIt();
		//ab.dolt(myArray);
		ChangeIt.dolt(myArray);
		for(int j=0;j<=myArray.length-1;j++)
			System.out.println(myArray[j]+" ");

	}

}
