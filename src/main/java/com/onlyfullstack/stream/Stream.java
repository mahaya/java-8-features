package com.onlyfullstack.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.onlyfullstack.bean.Student;
import com.onlyfullstack.util.JavaInputFixture;

public class Stream {
	
	private static final String MAHAYA = "Mahaya";

	public static void main(String[] args) {
		List<Student> students = JavaInputFixture.createList();
		
		filter(students);
		mapAndCollect(students);
		peek(students);
	}

	private static void mapAndCollect(List<Student> students) {
		System.out.println("######## Executing mapAndCollect() : ######## ");
		// get the age of Student whose name is Mahaya
		int age = students.stream()
						  .filter(student -> MAHAYA.equals(student.getName()))
						  .map(Student::getAge)
						  .findAny()
						  .orElse(0);
		System.out.printf("*** Age of %s is %d\n",MAHAYA, age);
		
		Set<String> names = students.stream()
									.map(Student::getName) // this will convert the Student Stream into String Stream by 
															// applying the getName()
									.collect(Collectors.toSet());
		
		System.out.printf("*** All the names from the list is %s\n",names);
		
		Set<String> courses = students.stream()
									  .map(Student::getCourses)
									  .flatMap(Arrays::stream)
									  .collect(Collectors.toSet());
		
		System.out.printf("*** All the courses from the list is %s\n",courses);
		System.out.println("######## Ending the execution of mapAndCollect() ######## ");
		
	}

	private static void filter(List<Student> students) {
		System.out.println("######## Executing filter() :######## ");
		// Print all the students who lives in Pune
		System.out.println("*** Students who lives in NY *** ");
		students.stream()
				.filter(student -> "NY".equals(student.getCity()))
				.forEach(System.out::println);
		
		// Find the student whose name is Mahaya and return null if not found
		System.out.println("*** Students whos name is Mahaya *** ");
		Student stud = students.stream()
				.filter(student -> MAHAYA.equals(student.getName()))
				.findAny()
				.orElse(null); // it will return null if filter does find any object matching the criteria 
		
		System.out.println(stud);
		
		// Java converts the above piece of code into below lines by adding a Annonymus class of Predicate interface 
		Student stud2 = students.stream()
				.filter( new Predicate<Student>() {
					public boolean test(Student student) {
						return MAHAYA.equals(student.getName());
					}}
				)
				.findAny()
				.orElse(null); // it will return null if filter does find any object matching the criteria 
		
		System.out.println(stud2);
		
		System.out.println("######## Ending the execution of filter() ######## ");
	}
	
	private static void peek(List<Student> students) {
		System.out.println("######## Executing peek() :######## ");
		students.stream()
				.peek(stud -> {System.out.println("Processing Student Name : "+ stud.getName());})
				.filter(student -> "TX".equals(student.getCity()))
				.peek(stud -> { System.out.println("Filtered Student Name :" + stud.getName());})
				.forEach(System.out::println);
		System.out.println("######## Ending the execution of peek() ######## ");
	}
}
