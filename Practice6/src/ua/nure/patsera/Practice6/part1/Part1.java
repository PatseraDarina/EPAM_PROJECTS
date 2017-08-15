package ua.nure.patsera.Practice6.part1;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Part1 {
	Word newWord;
	WordContainer wordContainer = new WordContainer();

	public Part1() {

	}

	private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {
		List<Map.Entry<String, Integer>> list =
				new LinkedList<>(unsortMap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
				@Override
				public int compare(Map.Entry<String, Integer> o1,
						Map.Entry<String, Integer> o2) {
			return o1.getValue().compareTo(o2.getValue());
			}
		});

		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}

	StringBuilder readWords() {
		StringBuilder result = new StringBuilder();
		String[] words = {};
		String inputText = "";
		Scanner in = new Scanner(System.in, "Cp1251");
		while (in.hasNext()) {
				inputText = in.nextLine();
	}
		words = inputText.split("\\s");
		for (String s : words) {
			wordContainer.add(s);
		}

		for (Map.Entry<String, Integer> entry : sortByValue(wordContainer.wordsList).entrySet()) {
			result.append(entry.getKey()).append(":").append(entry.getValue()).append("\n");
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new Part1().readWords());
	}
}
