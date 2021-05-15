package com.roytuts.java.josephus.problem;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JosephusProblem {

	public static void main(String[] args) {
		System.out.println("Non-Recursive");
		System.out.println("--------------------------------------");
		int winner = josephus(5, 3);
		System.out.println("winner is " + winner);
		winner = josephus(10, 3);
		System.out.println("winner is " + winner);
		winner = josephus(5, 2);
		System.out.println("winner is " + winner);
		winner = josephus(7, 3);
		System.out.println("winner is " + winner);
		
		System.out.println();
		System.out.println("Recursive");
		System.out.println("--------------------------------------");
		winner = josephusRecursive(5, 3);
		System.out.println("winner is " + winner);
		winner = josephusRecursive(10, 3);
		System.out.println("winner is " + winner);
		winner = josephusRecursive(5, 2);
		System.out.println("winner is " + winner);
		winner = josephusRecursive(7, 3);
		System.out.println("winner is " + winner);
	}

	public static int josephus(int noOfPeople, int remPosition) {
		int tempPos = remPosition - 1;
		int[] people = new int[noOfPeople];

		for (int i = 0; i < noOfPeople; i++) {
			people[i] = i + 1;
		}

		int iteration = noOfPeople - 1;

		List<Integer> list = IntStream.of(people).boxed().collect(Collectors.toList());

		while (iteration > 0) {
			list.remove(tempPos);
			tempPos += remPosition - 1;
			if (tempPos > list.size() - 1) {
				tempPos = tempPos % list.size();
			}
			iteration--;
		}

		return list.get(0);
	}

	public static int josephusRecursive(int n, int k) {
		if (n == 1) {
			return 1;
		} else {
			return (josephusRecursive(n - 1, k) + k - 1) % n + 1;
		}
	}

}
