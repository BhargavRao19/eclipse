
public class DebuggingExample2 {

	public static void main(String[] args) {
		String s1 = new String("Kramer");
		s1.concat("Jerry Sienfeld");
		String s2 = new String("Elaine Benez");
        String s3 =s1;
        StringBuffer sb = new StringBuffer("Mutable");
       
        sb.append("String class");
		String [] arr = new String[4];
		arr[0]= s1;
		arr[1]= s2; 
		System.out.println(arr[0]);
		System.out.println(arr[1]);


	}

}
