package src.main.sorts;

import java.util.Arrays;

public class QuickSort {
	
	public void quicksort(int[] arr, int low, int high){
		if( arr == null)
			return;
		if(low >= high || arr.length == 1 || high - low < 1)
			return;
		//pick a random pivot in the middle
		int middle = (low + high)/2;
		int pivot = arr[middle];
		int i = low, j = high;
		
		while(i <= j){
			while(arr[i] < pivot)
				i++;
			while(arr[j] > pivot)
				j--;
			if(i <= j){
				//swap them now
				//the loop can run until i and j are on the same position
				//then we have to come out
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j--;
				i++;
			}
		}
		//now i crossed j
		//so i is on the right side of the pivot and j on the left
		if(low < j)
			quicksort(arr, low, j);
		if(i < high)
			quicksort(arr, i, high);
	}
	
	public static void main(String[] args){
		int[] arr = {10, 99, 7, 2, 1, 5, 29, 1000, 999, 3};
		new QuickSort().quicksort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

}
