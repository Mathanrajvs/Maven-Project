package com.junit.training;

import java.util.Arrays;
import java.util.List;

public class User {
public String greetUser(String username) {
	return "Hello"+username;
	//return null;
}
public List<String> showCourses(){
	List<String> course=Arrays.asList("C","C++","Java","Python","RasberPy");
	return course;
}
public int product(int valueone,int valuetwo) {
	return valueone*valuetwo;
}

}
