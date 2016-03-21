package com.cisc181.core;

public class PersonException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Person p;
	
	//private Deck d;

	public PersonException(Person p) {
		super();
		this.p = p;
	}

	public Person getP() {
		return p;
	}
}
