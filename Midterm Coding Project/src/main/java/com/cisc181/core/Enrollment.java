package com.cisc181.core;

import java.util.UUID;

public class Enrollment {

	private UUID SectionID;
	private UUID StudentID;
	private UUID EnrollmentID;
	private double Grade;
	
	private Enrollment() {}
	
	public Enrollment(UUID StudentID, UUID SectionID) {
		this();
		this.StudentID = StudentID;
		this.SectionID = SectionID;
		this.EnrollmentID = UUID.randomUUID();
	}

	public UUID getSectionID() {
		return this.SectionID;
	}

	public void setSectionID(UUID sectionID) {
		this.SectionID = sectionID;
	}

	public UUID getStudentID() {
		return this.StudentID;
	}

	public void setStudentID(UUID studentID) {
		this.StudentID = studentID;
	}

	public UUID getEnrollmentID() {
		return this.EnrollmentID;
	}

	public void setEnrollmentID(UUID enrollmentID) {
		this.EnrollmentID = enrollmentID;
	}

	public double getGrade() {
		return this.Grade;
	}

	public void setGrade(double grade) {
		this.Grade = grade;
	}
	
	
	
}