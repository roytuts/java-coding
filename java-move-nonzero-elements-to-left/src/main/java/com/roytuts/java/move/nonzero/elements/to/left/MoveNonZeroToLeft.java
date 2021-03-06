package com.roytuts.java.move.nonzero.elements.to.left;

import java.util.Arrays;

public class MoveNonZeroToLeft {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 0, 2, 0, 0, 3, 4 };
		
		System.out.println(Arrays.toString(arr));
		
		moveNonZeroToLeft(arr);
	}

	public static void moveNonZeroToLeft(int[] arr) {
		int lastIndex = arr.length - 1;
		for (int index = 0; index < arr.length;) {
			if (index == lastIndex)
				break;
			if (arr[index] == 0) {
				// swap to last index
				int temp = arr[lastIndex];
				arr[lastIndex] = arr[index];
				arr[index] = temp;
				lastIndex--;
			} else {
				index++;
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}

}
