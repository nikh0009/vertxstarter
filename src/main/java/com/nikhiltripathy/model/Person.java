package com.nikhiltripathy.model;

public class Person {
	static  String name;
	static  String age;
	static  String country;
	
	public Person(String name, String age, String country ) {
		this.name = name;
		this.age = age;
		this.country = country;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(String age) {
		this.age = age;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAge() {
		return age;
	}
	
	public String getCountry() {
		return country;
	}

 }
