package miscelleneous;

public class FindSpan {

	static int []findSpan(int arr[]){
		int n= arr.length;
		int[] span = new int[n];
		int currentSpan =0;
		int i,j;
		for( j= n-1;j>=0;j--){
			currentSpan =1;
			for(i=j-1;i>=0;i--){
				if(arr[i]<arr[j]){
					currentSpan++;
				}
				else 
				break;
			}
			span[j]=currentSpan;
		}
		return span;
	}
	
	public static void main(String args[]) {
		int arr[]={6,3,4,5,2};
		for(int i:findSpan(arr)) {
			System.out.print(i);
		}
	}
}

