package com.lineardatastructure;

public class BubbleSort {

	public static void main(String[] args) {
		
		int[] arr = {13,94,47,28,48,23,53,45,3,543,53};
		int i,j,temp;
		for(i=0;i<arr.length;i++) {
			for(j=0;j<arr.length-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		for(i=0;i<arr.length;i++)
			System.out.println(arr[i]);

	}

}
