package com.interview.questions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPIImprovementsExample {
	
	public static void main(String[] args) {
		// Example 1: takeWhile
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9,
		10);
		List<Integer> lessThanFive = numbers.stream()
		.takeWhile(n -> n < 5)
		.collect(Collectors.toList());
		System.out.println("Numbers less than 5: " + lessThanFive);
		// Example 2: dropWhile
		List<Integer> greaterThanThree = numbers.stream()
		.dropWhile(n -> n <= 3).toList();
		System.out.println("Numbers greater than 3: " +
		greaterThanThree);
		// Example 3: ofNullable
		List<String> names = Arrays.asList("Alice", "Bob", null,
		"Charlie", null, "David");
		List<String> nonNullNames = names.stream()
		.flatMap(name ->
		StreamAPIImprovementsExample.nullSafeStream(name))
		.collect(Collectors.toList());
		System.out.println("Non-null names: " + nonNullNames);
		}
		// Helper method to create a stream from a potentially null value
		private static <T> java.util.stream.Stream<T> nullSafeStream(T
		value) {
		return value == null ? java.util.stream.Stream.empty() :
		java.util.stream.Stream.of(value);
		}

}
