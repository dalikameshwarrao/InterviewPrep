package com.interview.ajayrathodquestions;

import java.util.Arrays;
import java.util.stream.Collectors;

public class AlphanumericFilterExample {

	public static void main(String[] args) {
		String str = "a1b2c3d4e5f6g7h8i9j0";
		char[] arr = str.toCharArray();
		System.out.println("Original array: " + Arrays.toString(arr));
		int[] nums = new String(arr)
		.chars()
		.filter(Character::isDigit)
		.map(Character::getNumericValue)
		.toArray();
		System.out.println("Numbers only: " + Arrays.toString(nums));
		
        int[] charArray = {'a', '1', 'b', '2', 'c', '3', 'd', '4'};

        // Filter out numeric characters using Stream API
        String numbers = Arrays.stream(charArray)
                .filter(Character::isDigit)
                .mapToObj(Character::toString)
                .collect(Collectors.joining());

        System.out.println("Numbers from the char array: " + numbers);

		
	}
	
}
