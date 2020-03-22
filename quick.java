import java.util.Arrays;

//best/avg----nlog(n)
//worst-------O(n^2)
//space------O(log n)
public class quick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {9,6,5,0,8,2,4,7};
		int n=8;

	    System.out.println(System.getProperty("java.runtime.version"));
		sort(a, 0, n-1); 
		System.out.println("\n\n"+Arrays.toString(a));
		

	}
	static int partition(int arr[],int low, int high) 
    { 
		  int pivot = arr[high];  
          int i = (low-1);
        for ( int j=low; j<high; j++) 
        { 
            if (arr[j] < pivot) 
            { 
                i++; 
  
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
  
  
    static void sort(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            int pi = partition(arr, low, high); 
  
            sort(arr, low, pi-1); 
            sort(arr, pi+1, high); 
        } 
    } 


}
