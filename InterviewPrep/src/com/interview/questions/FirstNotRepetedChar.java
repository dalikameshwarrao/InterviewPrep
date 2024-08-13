package com.interview.questions;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNotRepetedChar {

	public static void main(String[] args) {
		  String input = "ava Stream API is very good concept";

		  char firstNotRepetedChar = input.chars().mapToObj(x -> Character.toUpperCase((char) x))//converting the object format
		    .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))// find duplicate freq in linkedHashMap
		    .entrySet().stream().filter(x -> x.getValue() == 1L).map(x -> x.getKey()).findFirst().get();//filtering the freq which is not first time

		  System.out.println("First non repeated char  : " + firstNotRepetedChar);
		  
	        int[] numbers = { 10, 20, 30, 40, 50 };

	        // Rearrange the array in the specified order
	        int[] rearrangedNumbers = new int[numbers.length];
	        for (int i = 0; i < numbers.length; i++) {
	            rearrangedNumbers[i] = numbers[(i + 1) % numbers.length];
	            System.out.println((i + 1) % numbers.length);
	        }

	        // Print the rearranged array
	        Arrays.stream(rearrangedNumbers).forEach(System.out::println);


		 }
	
	

	
}
