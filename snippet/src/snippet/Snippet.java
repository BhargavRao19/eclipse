package snippet;

public class Snippet {
	public static void main(String... args) {
//int[] nums = {1,2,3,4,5,6,};
//System.out.println(nums[1]+nums[3]);
  String s = new String("bhargav");
  String s1 = new String("bhargav");
  s1=s+"Anna";  
  s=s.concat(" rao");
  //s=s1+"bhargav";
  System.out.println(s);
  System.out.println(s1);
  StringBuffer ab= new StringBuffer("rahul");
  System.out.println(ab);
  ab= new StringBuffer("aa");
  ab=ab.append("bb");
  System.out.println(ab);
  
		


	}
}

