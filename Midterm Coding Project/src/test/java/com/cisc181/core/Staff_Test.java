package com.cisc181.core;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.text.ParseException;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

public class Staff_Test {

	static ArrayList<Staff> staffList = new ArrayList<Staff>();

	public static Date makeDate(int year, int month, int day) {
		Calendar date = Calendar.getInstance();
		date.set(year, month - 1, day);
		return date.getTime();
	}

	@BeforeClass
	public static void setup() throws PersonException {
		staffList.add(new Staff("Bob", null, "Joe", makeDate(1990, 6, 5), "33 Street", "(111)-555-1111",
				"email@email.com", "TR 1-2 PM", 1, 10000, makeDate(2010, 7, 1), eTitle.MR));
		staffList.add(new Staff("Blob", null, "Joe", makeDate(1990, 6, 5), "33 Street", "(111)-555-1111",
				"email@email.com", "TR 1-2 PM", 1, 10000, makeDate(2010, 7, 1), eTitle.MR));
		staffList.add(new Staff("Bob", null, "Joe", makeDate(1990, 6, 5), "33 Street", "(111)-555-1111",
				"email@email.com", "TR 1-2 PM", 1, 10000, makeDate(2010, 7, 1), eTitle.MS));
		staffList.add(new Staff("Bob", null, "Joe", makeDate(1990, 6, 5), "33 Street", "(111)-555-1111",
				"email@email.com", "TR 1-2 PM", 1, 10000, makeDate(2010, 7, 1), eTitle.MRS));
		staffList.add(new Staff("Bob", null, "Joe", makeDate(1990, 6, 5), "33 Street", "(111)-555-1111",
				"email@email.com", "TR 1-2 PM", 1, 10000, makeDate(2010, 7, 1), eTitle.MRS));

	}

	@Test
	public void SalaryAverage(){
		int sum = 0;
		for (Staff staff : staffList) {
			sum += staff.getSalary();
		}
		int average = sum / staffList.size();
		assertEquals(average, 10000);
	}

	@Test
	public final void testDOBException() throws PersonException {
		boolean expectException = false;
		boolean actualException = false;
		Staff staff = new Staff("Bob", null, "Joe", makeDate(3000, 6, 5), "33 Street", "(111)-555-1111",
				"email@email.com", "TR 1-2 PM", 1, 10000, makeDate(2010, 7, 1), eTitle.MR);
		assertEquals(expectException, actualException);
	}

	@Test(expected = PersonException.class)
	public final void testPhoneNumberException() throws PersonException {
		Staff staff = new Staff("Bob", null, "Joe", makeDate(1990, 6, 5), "33 Street", "(5555)-555-1111",
				"email@email.com", "TR 1-2 PM", 1, 10000, makeDate(2010, 7, 1), eTitle.MR);	
	}
}