package pers.frame4j.test;

public class Bubble {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 6, 4};
		
		for (int i = 0; i < arr.length -1; i++) {
			for (int j = 0; j < arr.length - i -1; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		System.out.println(arr[0]+"==="+arr[4]);
	}
}
