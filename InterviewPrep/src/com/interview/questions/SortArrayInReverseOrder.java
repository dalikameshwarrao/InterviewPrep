package com.interview.questions;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SortArrayInReverseOrder {

	public static void main(String[] args) {
		  int a[] = { 3, 6, 32, 1, 8, 5, 31, 22 };

		  List<Integer> newArra = Arrays.stream(a).boxed().sorted().collect(Collectors.toList());

		  List<Integer> reverseArra = Arrays.stream(a).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		  System.out.println(reverseArra);

		  Arrays.sort(a);
		  System.out.println(Arrays.toString(a));
		  
		  List<String> list1 = Arrays.asList("abc", "def", "xyz", "mno", "pqr", 
				  "def", "xyz", "stu");
				  Set<String> set1=new LinkedHashSet<>();
				  list1.stream().filter(s->set1.add(s)).forEach(System.out::println);
		 }

	
}
