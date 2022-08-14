
public class SecondHighestNumber {

	public static void main(String[] args) {
	int arr[]= {100,14, 46, 47, 94, 94, 52, 86, 36, 94, 89};
	int largest=0;
	int secondLargest=0;
	
	for(int i=0;i<arr.length;i++) {
		
		if(arr[i] >largest) {
			secondLargest=largest;
			largest=arr[i];
			
		}
		else if(arr[i] > secondLargest) {
			secondLargest=arr[i];
		}
	
	}
	System.out.println("Largest number in the array is:: "+largest);
	System.out.println("Second Largest number in the array is:: "+secondLargest);

	}

}
