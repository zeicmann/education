package main;

public class Sort {
	
	public int[] insertionSort(int arr[]){
		
		for (int i = 1; i<arr.length; i++){
			int temp = arr[i];
			int j = i-1;
			while (j>=0 && arr[j]>temp){
				arr[j+1]=arr[j];
				j-=1;
			}
			arr[j+1]=temp;
		}
		
		return arr;
	}
	
	public int[] bubbleSort(int arr[]){
		
		for (int i = 1; i<arr.length; i++){
			for (int j = i-1; j>=0; j--){
				if (arr[j+1]<arr[j]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}
	
	public int[] selectionSort(int arr[]){
		
		for (int i = 0; i<arr.length-1; i++){
			int indMin = i;
			for (int j = i+1; j<arr.length; j++){
				if (arr[j]<arr[indMin]){
				indMin = j;
			}
			}
			
			if (indMin!=i){
				int temp = arr[indMin];
				arr[indMin] = arr[i];
				arr[i] = temp;
			}
			
		}
		
		return arr;
	}
}
