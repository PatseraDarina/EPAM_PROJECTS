package ua.nure.patsera.Practice6.part1;

import java.util.HashMap;
import java.util.Map;

public class WordContainer {

	Map<String, Integer> wordsList = new HashMap<>();
	public WordContainer() {

	}

	void add(String word) {
		if (!wordsList.containsKey(word)) {
			Word w = new Word(word, 1);
			wordsList.put(w.getWord(), 1);
		} else {
			wordsList.replace(word, wordsList.get(word), wordsList.get(word) + 1);
		}
	}
}
