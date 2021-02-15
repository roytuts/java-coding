package com.roytuts.minimum.moves.segregate.even.odd;

import java.util.Arrays;

public class EvenOddArrayElementsApp {

	public static void main(String[] args) {
		int[] arr = new int[] { 13, 10, 21, 20 };

		int minMoves = minMovesToEvenFollowedByOdd(arr);

		System.out.println("Minimum moves to segregate even followed by odd elements: " + minMoves);

		arr = new int[] { 5, 8, 5, 11, 4, 6 };

		minMoves = minMovesToEvenFollowedByOdd(arr);

		System.out.println("Minimum moves to segregate even followed by odd elements: " + minMoves);
	}

	private static int minMovesToEvenFollowedByOdd(int[] arr) {
		int moves = 0;
		int totalLength = arr.length;

		for (int i = 0; i < totalLength / 2; i++) {
			if (arr[i] % 2 != 0) {
				for (int j = totalLength / 2; j < totalLength; j++) {
					if (arr[j] % 2 == 0) {
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;

						moves++;

						break;
					} else {
						continue;
					}
				}
			} else {
				continue;
			}
		}

		System.out.println("Array elements after moving: " + Arrays.toString(arr));

		return moves;
	}

}
