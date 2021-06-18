package com.roytuts.java.coding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Pangram {

	public static void main(String[] args) {

		final List<String> list = Arrays.asList("pack my box with five dozen liquor jugs", "this is not a pangram",
				"Waltz, bad nymph, for quick jigs vex.", "Glib jocks quiz nymph to vex dwarf",
				"Sphinx of black quartz, judge my vow", "How vexingly quick daft zebras jump!",
				"The five boxing wizards jump quickly", "Jackdaws love my big sphinx of quartz",
				"Pack my box with five dozen liquor jugs");

		String result = isPangram(list);
		System.out.println(result);

		result = isPangram2(list);
		System.out.println(result);

		result = isPangram3(list);
		System.out.println(result);

		result = isPangram4(list);
		System.out.println(result);

		result = isPangram5(list);
		System.out.println(result);

	}

	public static String isPangram(List<String> pangram) {

		final StringBuilder result = new StringBuilder();

		for (String str : pangram) {
			// Set<Integer> chars = new HashSet<>();
			if (str.length() > 25
					&& str.toLowerCase().chars().filter(i -> i >= 'a' && i <= 'z').distinct().count() == 26) {
				// if(str.length() > 25 && str.toLowerCase().chars().filter(i -> i >= 'a' && i
				// <= 'z').filter(chars::add).filter(i -> chars.size() ==
				// 26).findAny().isPresent()) {
				result.append("1");
			} else {
				result.append("0");
			}
		}

		return result.toString();
	}

	public static String isPangram2(List<String> pangram) {
		final StringBuilder result = new StringBuilder();

		for (String str : pangram) {
			if (IntStream.range('a', 'z' + 1).allMatch(c -> str.toLowerCase().indexOf(c) >= 0)) {
				result.append("1");
			} else {
				result.append("0");
			}
		}

		return result.toString();
	}

	public static String isPangram3(List<String> pangram) {
		final StringBuilder result = new StringBuilder();

		for (String str : pangram) {
			int cnt = 0;
			boolean found = false;
			Set<Integer> alphabet = new HashSet<>(26);

			for (char c : str.toLowerCase().toCharArray()) {
				int n = c - 'a';
				if (n >= 0 && n < 26) {
					if (alphabet.add(n)) {
						cnt += 1;
						if (cnt == 26) {
							found = true;
							break;
						}
					}
				}
			}

			if (found) {
				result.append("1");
			} else {
				result.append("0");
			}
		}

		return result.toString();
	}

	public static String isPangram4(List<String> pangram) {
		final StringBuilder result = new StringBuilder();

		for (String str : pangram) {
			str = str.replaceAll("[^a-zA-Z]", "");
			str = str.toLowerCase();
			str = str.replaceAll("(.)(?=.*\\1)", "");
			if (str.length() == 26) {
				result.append("1");
			} else {
				result.append("0");
			}
		}

		return result.toString();
	}

	public static String isPangram5(List<String> pangram) {
		final StringBuilder result = new StringBuilder();

		for (String str : pangram) {
			boolean found = true;
			for (char c = 'a'; c <= 'z'; ++c) {
				if (!str.toLowerCase().contains(String.valueOf(c))) {
					found = false;
					break;
				}
			}

			if (found) {
				result.append("1");
			} else {
				result.append("0");
			}
		}

		return result.toString();
	}

}
