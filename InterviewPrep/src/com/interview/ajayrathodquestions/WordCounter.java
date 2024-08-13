package com.interview.ajayrathodquestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class WordCounter {
	
	public static void main(String[] args) {
	String str = "Hello world hello java world";
	Map<String, Integer> wordCounts = new HashMap<>();
	// Split the string into words
	String[] words = str.split(" ");
	// Count the occurrence of each word
	for (String word : words) {
	if (!wordCounts.containsKey(word)) {
	wordCounts.put(word, 1);
	} else {
	int count = wordCounts.get(word);
	wordCounts.put(word, count + 1);
	}
	}
	// Print the occurrence of each word
	for (String word : wordCounts.keySet()) {
	System.out.println(word + ": " + wordCounts.get(word));
	}
	
    Map<String, Long> wordOccurrences = Arrays.stream(words)
            .collect(Collectors.groupingBy(word -> word.toLowerCase(), Collectors.counting()));
    System.out.println(wordOccurrences);
	}

}
