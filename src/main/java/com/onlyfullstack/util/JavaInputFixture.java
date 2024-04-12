package com.onlyfullstack.util;

import java.util.Arrays;
import java.util.List;

import com.onlyfullstack.bean.Student;

public class JavaInputFixture {
	
	public static List<Student> createList() {

		Student student1 = new Student("Mahaya", "NY", 26, new String[] {"Java","Spring","Hibernate"});
		Student student2 = new Student("Robert", "NY", 70, new String[] {".Net","HTML","CSS"});
		Student student3 = new Student("John", "TX", 21, new String[] {"Typescript","Angular 4"});
		Student student4 = new Student("Roman", "NY", 2, new String[] {"ReactJS","JavaScript","Fidler"});
		Student student5 = new Student("Randy", "TX", 17, new String[] {"Java","Spring Cloud","Spring Data"});
		Student student6 = new Student("Mahaya", "NY", 26, new String[] {"Java","Spring","Hibernate"});
		Student student7 = new Student("Robert", "NY", 70, new String[] {".Net","HTML","CSS"});
		Student student8 = new Student("John", "TX", 21, new String[] {"Typescript","Angular 4"});
		Student student9 = new Student("Roman", "NY", 2, new String[] {"ReactJS","JavaScript","Fidler"});
		Student student10 = new Student("Randy", "TX", 17, new String[] {"Java","Spring Cloud","Spring Data"});
		
		return Arrays.asList(new Student[] {student1, student2, student3, student4, student5});
	}

}
