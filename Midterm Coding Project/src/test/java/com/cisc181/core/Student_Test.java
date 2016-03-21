package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test {

	static ArrayList<Student> studentList = new ArrayList<Student>();
	static ArrayList<Course> courseList = new ArrayList<Course>();
	static ArrayList<Semester> semesterList = new ArrayList<Semester>();
	static ArrayList<Section> sectionList = new ArrayList<Section>();
	static ArrayList<Enrollment> enrollmentList = new ArrayList<Enrollment>();

	public static Date newDate(int year, int month, int day) {
		Calendar date = Calendar.getInstance();
		date.set(year, month - 1, day);
		return date.getTime();
	}

	@BeforeClass
	public static void setup() throws PersonException {
		Course Physics = new Course("Physics", 100, eMajor.PHYSICS);
		Course Nursing = new Course("Nursing", 100, eMajor.NURSING);
		Course Chemistry = new Course("Chemistry", 100, eMajor.CHEM);
		courseList.add(Physics);
		courseList.add(Nursing);
		courseList.add(Chemistry);

		Semester spring = new Semester(newDate(2015, 2, 5), newDate(2015, 5, 29));
		Semester fall = new Semester(newDate(2015, 8, 29), newDate(2015, 12, 18));
		semesterList.add(spring);
		semesterList.add(fall);

		Section fPhys100 = new Section(Physics.getCourseID(), fall.getSemesterID(), 100);
		Section fNurs100 = new Section(Nursing.getCourseID(), fall.getSemesterID(), 101);
		Section fChem100 = new Section(Chemistry.getCourseID(), fall.getSemesterID(), 102);
		Section sPhys100 = new Section(Physics.getCourseID(), spring.getSemesterID(), 100);
		Section sNurs100 = new Section(Nursing.getCourseID(), spring.getSemesterID(), 101);
		Section sChem100 = new Section(Chemistry.getCourseID(), spring.getSemesterID(), 102);
		sectionList.add(fPhys100);
		sectionList.add(fNurs100);
		sectionList.add(fChem100);
		sectionList.add(sPhys100);
		sectionList.add(sNurs100);
		sectionList.add(sChem100);

		Student s1 = new Student("Bob", null, "Noob", newDate(1998, 1, 11), eMajor.CHEM, "Anywhere",
				"(312)-555-2355", "email1@email.com");

		studentList.add(s1);

		for (Section section : sectionList) {
			for (Student student : studentList) {
				enrollmentList.add(new Enrollment(student.getStudentID(), section.getSectionID()));
			}
		}
	}


	@Test
	public void testMajorChange() {
		assertTrue(studentList.get(0).getMajor() == eMajor.CHEM);
		studentList.get(0).setMajor(eMajor.PHYSICS);
		assertTrue(studentList.get(0).getMajor() == eMajor.PHYSICS);
	}

}