import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class Statistics {

	public static void findMostCommonWords(String text) throws FileNotFoundException {

		HashMap<String, Integer> wordMap = new HashMap<String, Integer>();

		String[] words = text.replaceAll("[^a-zA-Z]", " ").toLowerCase().split(" ");
		for (String word : words) {
			if (!word.isEmpty()) {
				Integer wordCount = wordMap.get(word);
				if (wordCount == null) {
					wordMap.put(word, 1);
				} else {
					wordMap.put(word, wordCount + 1);
				}
			}
		}

		Set<Entry<String, Integer>> entrySet = wordMap.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(entrySet);
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
				return (e2.getValue().compareTo(e1.getValue()));
			}
		});

		System.out.println("\nHere are the 10 most common words in the text: ");
		for (int i = 0; i < 10; i++) {
			System.out.println((i + 1) + ")Word: " + list.get(i).getKey() + " - " + list.get(i).getValue() + " times.");
		}
	}
}
