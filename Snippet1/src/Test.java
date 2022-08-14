import java.util.Arrays;

public class Test {
public static void main(String[] args)
{
  Object[ ] arr = new String[3];
    arr[0] = "A";
    arr[1] = "B";
    arr[2] = "20";
   System.out.println(Arrays.toString(arr));
   System.out.println(new int[]{1, 2, 3}.length); // It will display 3.
   }
}