package com.interview.questions;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateNumber {
	
	 public static void main(String[] args) {
		  int a[] = { 1, 4, 4,5, 2, 12, 34, 2, 11 };
		  System.out.println("Duplicate number by java 1.8 : " + findDuplicateNumberByJava1_8(a));
		 }
		 private static int findDuplicateNumberByJava1_8(int[] a) {
		  Map<Integer, Long> map = Arrays.stream(a).boxed()
		    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		  
		  System.out.println(map);

		  int duplicate = map.keySet().stream().filter(x -> map.get(x) > 1).findFirst().orElse(0);

		  // If there have more then one duplicate then used this
		 map.keySet().stream().filter(x -> map.get(x) > 1).forEach(System.out::println);
		  return duplicate;
		 }


}
