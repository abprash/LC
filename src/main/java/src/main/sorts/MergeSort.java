package src.main.sorts;

import java.util.Arrays;

public class MergeSort {

	static int[] helper = new int[10];
	
	public void mergeSort(int[] arr, int low, int high){
		//low should definitely be lesser than high
		//else its already sorted
		if(low < high){
		int middle = (low + high)/2;
		mergeSort(arr, low, middle);
		mergeSort(arr, middle+1, high);
		merge(arr, low, middle, high);
		}
	}
	
	
	public void merge(int[] arr, int low, int middle, int high){
		//copy it to the helper array
		//helper = new int[high];
		for(int i=low; i<=high; i++){
			helper[i] = arr[i];
		}
		
		//next start copying back to the original array
		int i = low, j = (high+low)/2;
		j = middle + 1;
		int k = low;
		//we are going till the end of the array anyway so <= is used
		while(i <= middle && j <= high){
			if(helper[i] < helper[j]){
				arr[k] = helper[i];
				i++;
			}
			else{
				arr[k] = helper[j];
				j++;
			}
			k++;
		}
		//copy the remaining elements into arr
		//some elements may be left out
		while(i <= middle){
			arr[k] = helper[i];
			i++;
			k++;
		}
		while(j <= high){
			arr[k] = helper[j];
			j++;
			k++;
		}
	}

	public static void main(String[] args){
		int[] arr = new int[]{10,9,8,7,6,5,4,3,2,1};
		new MergeSort().mergeSort(arr,0,9);
		System.out.println(Arrays.toString(arr));
	}
}
