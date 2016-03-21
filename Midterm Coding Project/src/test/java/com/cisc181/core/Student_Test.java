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

	public static Date newDate(int year, int month, int day){
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

		Student s1 = new Student("Bob", null, "Trite", newDate(1998, 1, 11), eMajor.CHEM, "Anywhere",
				"(312)-555-2355", "email1@email.com");
		Student s2 = new Student("Bob", null, "Otherbob", newDate(1998, 1, 11), eMajor.PHYSICS, "Anywhere",
				"(312)-555-2355", "email1@email.com");
		Student s3 = new Student("Bob", null, "Meow", newDate(1998, 1, 11), eMajor.NURSING, "Anywhere",
				"(312)-555-2355", "email1@email.com");
		Student s4 = new Student("Bob", null, "Tom", newDate(1998, 1, 11), eMajor.CHEM, "Anywhere",
				"(312)-555-2355", "email1@email.com");
		Student s5 = new Student("Bob", null, "Nob", newDate(1998, 1, 11), eMajor.BUSINESS, "Anywhere",
				"(312)-555-2355", "email1@email.com");
		Student s6 = new Student("Bob", null, "Com", newDate(1998, 1, 11), eMajor.CHEM, "Anywhere",
				"(312)-555-2355", "email1@email.com");
		Student s7 = new Student("Bob", null, "Pop", newDate(1998, 1, 11), eMajor.NURSING, "Anywhere",
				"(312)-555-2355", "email1@email.com");
		Student s8 = new Student("Bob", null, "Crackle", newDate(1998, 1, 11), eMajor.PHYSICS, "Anywhere",
				"(312)-555-2355", "email1@email.com");
		Student s9 = new Student("Bob", null, "Snap", newDate(1998, 1, 11), eMajor.BUSINESS, "Anywhere",
				"(312)-555-2355", "email1@email.com");
		Student s10 = new Student("Bob", null, "Jerk", newDate(1998, 1, 11), eMajor.CHEM, "Anywhere",
				"(312)-555-2355", "email1@email.com");

		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		studentList.add(s5);
		studentList.add(s6);
		studentList.add(s7);
		studentList.add(s8);
		studentList.add(s9);
		studentList.add(s10);
		
		
		for (Section section : sectionList){
			for (Student student : studentList){
				enrollmentList.add(new Enrollment(student.getStudentID(), section.getSectionID()));
			}
		}
	}
	
	public long GPAcalc(UUID studentID){
		long gpa = 0;
		for(Enrollment enrollment : enrollmentList){
			if(enrollment.getStudentID() == studentID){
				if(enrollment.getGrade() > 89){
					gpa += 4.0;
				} else if(enrollment.getGrade() > 79){
					gpa += 3.0;
				} else if(enrollment.getGrade() > 69){
					gpa += 2.0;
				}else if(enrollment.getGrade() > 59){
					gpa += 1.0;
				}else{
					gpa += 0.0;
				}
			}
		}
		long avgGPA = gpa / sectionList.size();
		return avgGPA;
	}

	public long CourseAvg(UUID sectionID) {
		long courseAvg = 0;
		for(Enrollment e : enrollmentList){
			if(e.getSectionID() == sectionID){
				courseAvg += e.getGrade();
			}
		}
		long avgCourseGrd = courseAvg / 10;
		avgCourseGrd *= 100;
		avgCourseGrd /= 100;
		return avgCourseGrd;
	}{

	
	
	for(Enrollment enr : enrollmentList) {
		if(enr.getStudentID() == studentList.get(0).getStudentID() || enr.getStudentID() == studentList.get(1).getStudentID()) {
				enr.setGrade(100.0);
		}else if(enr.getStudentID() == studentList.get(2).getStudentID() || enr.getStudentID() == studentList.get(3).getStudentID()) {
				enr.setGrade(90.0);
		}else if(enr.getStudentID() == studentList.get(4).getStudentID() || enr.getStudentID() == studentList.get(5).getStudentID()) {
				enr.setGrade(80.0);
		}else if(enr.getStudentID() == studentList.get(6).getStudentID() || enr.getStudentID() == studentList.get(7).getStudentID()) {
				enr.setGrade(75.0);
		}else if(enr.getStudentID() == studentList.get(8).getStudentID() || enr.getStudentID() == studentList.get(9).getStudentID()) {
				enr.setGrade(60.0);
		}else{
			if(enr.getSectionID() == sectionList.get(0).getSectionID()) {
				enr.setGrade(50);
		}}}
	}
	
	
	@Test
	public void testGPAaverage(){
		assertEquals(GPAcalc(enrollmentList.get(0).getStudentID()), 4);
		assertEquals(GPAcalc(enrollmentList.get(1).getStudentID()), 4);
		assertEquals(GPAcalc(enrollmentList.get(2).getStudentID()), 4);
		assertEquals(GPAcalc(enrollmentList.get(3).getStudentID()), 4);
		assertEquals(GPAcalc(enrollmentList.get(4).getStudentID()), 3);
		assertEquals(GPAcalc(enrollmentList.get(5).getStudentID()), 3);
		assertEquals(GPAcalc(enrollmentList.get(6).getStudentID()), 2);
		assertEquals(GPAcalc(enrollmentList.get(7).getStudentID()), 2);
		assertEquals(GPAcalc(enrollmentList.get(8).getStudentID()), 1);
		assertEquals(GPAcalc(enrollmentList.get(9).getStudentID()), 1);
		//fall physics avg
		assertEquals(CourseAvg(enrollmentList.get(0).getSectionID()), 81);
		//fall nursing avg
		assertEquals(CourseAvg(enrollmentList.get(11).getSectionID()), 81);
		//fall chem avg
		assertEquals(CourseAvg(enrollmentList.get(21).getSectionID()), 81);
		//spring phys avg
		assertEquals(CourseAvg(enrollmentList.get(0).getSectionID()), 81);
		//spring nursing avg
		assertEquals(CourseAvg(enrollmentList.get(11).getSectionID()), 81);
		//spring chem avg
		assertEquals(CourseAvg(enrollmentList.get(21).getSectionID()), 81);
	}


	@Test
	public void testMajorChange() {
		assertTrue(studentList.get(0).getMajor() == eMajor.CHEM);
		studentList.get(0).setMajor(eMajor.PHYSICS);
		assertTrue(studentList.get(0).getMajor() == eMajor.PHYSICS);
	}

}