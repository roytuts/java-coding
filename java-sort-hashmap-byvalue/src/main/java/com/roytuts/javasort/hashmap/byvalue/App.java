package com.roytuts.javasort.hashmap.byvalue;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class App {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();

		map.put(1, "c");
		map.put(2, "b");
		map.put(3, "a");
		map.put(4, "hi");
		map.put(5, "Hi");
		map.put(6, "hello");
		map.put(7, "Hello");

		List<Entry<Integer, String>> list = new LinkedList<>(map.entrySet());

		Collections.sort(list, (l1, l2) -> l1.getValue().compareToIgnoreCase(l2.getValue()));

		Map<Integer, String> sortedMap = new LinkedHashMap<>();

		for (Entry<Integer, String> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		for (Entry<Integer, String> entry : sortedMap.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

}
