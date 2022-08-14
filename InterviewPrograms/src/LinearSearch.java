
public class LinearSearch {

	public static void main(String[] args) {
	int a[] = {10,20,40,50,60};
    int ele_search=100;
    boolean flag=false;
    for(int i=0;i<a.length;i++)
    {
    	if(ele_search==a[i]) {
    		System.out.println("element found "+i);
    	    flag=true;
    	    break;
    }
	}
    if(flag==false)
        System.out.println("element not found");

}
}