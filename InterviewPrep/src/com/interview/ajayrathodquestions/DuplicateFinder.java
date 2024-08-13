package com.interview.ajayrathodquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DuplicateFinder {

	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, 1, 2, 4, 5};
		List<String> names = Arrays.asList("John", "Alice", "Bob", "John", "Jane");
        char[] charArray = {'a', 'b', 'c', 'a', 'd', 'b', 'e', 'c'};

		List<Integer> list = Arrays.stream(arr)
		.boxed()
		.collect(Collectors.toList());
		
		list.stream()
		.filter(i -> Collections.frequency(list, i) > 1)
		.distinct()
		.forEach(System.out::println);
	
	
    

    List<String> duplicates = names.stream()
            .collect(Collectors.groupingBy(s -> s))
            .entrySet()
            .stream()
            .filter(entry -> entry.getValue().size() > 1)
            .map(entry -> entry.getKey())
            .collect(Collectors.toList());
    
    System.out.println("Duplicate names: " + duplicates);
    
names.stream()
	.filter(i -> Collections.frequency(names, i) > 1)
	.distinct()
	.forEach(System.out::println);

// Convert char array to a list of Characters

// Convert char array to List<Character>
List<Character> charList = new ArrayList<>();
for (char c : charArray) {
    charList.add(c);
}


// Filter out duplicate characters
List<Character> duplicatesChar = charList.stream()
        .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
        .entrySet()
        .stream()
        .filter(entry -> entry.getValue() > 1)
        .map(entry -> entry.getKey())
        .collect(Collectors.toList());

System.out.println("Duplicates in the character array: " + duplicatesChar);

	}
              	
}
