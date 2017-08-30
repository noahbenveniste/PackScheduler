package edu.ncsu.csc216.pack_scheduler.user;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Used to test the Student class
 * @author Noah Benveniste
 * @author Daniel Mills
 * @author Kevin Hildner
 */
//adfdsafdsa
public class StudentTest {

	/** Valid first name */
	private static final String FIRST_NAME = "first";
	/** Valid last name */
	private static final String LAST_NAME = "last";
	/** Valid id */
	private static final String ID = "id";
	/** Valid email */
	private static final String EMAIL = "email@ncsu.edu";
	/** Valid password */
	private static final String HASHED_PASSWORD = "hashedpassword";
	/** Valid credits */
	private static final int CREDITS = 10;
	/** Max number of credits, used by constructor without int param as default value */
	private static final int MAX_CREDITS = 18;
	
	/**
	 * Testing constructor that has credits as an additional parameter
	 */
	@Test
	public void testStudentStringStringStringStringStringInt() {
		//Test that student object is not created when the first name is null
		Student s = null; //Initialize a student reference to null
		try {
		    s = new Student(null, LAST_NAME, ID, EMAIL, HASHED_PASSWORD, CREDITS);
		    //Note that for testing purposes, the password doesn't need to be hashedpassword
		    fail(); //If we reach this point a Student was constructed when it shouldn't have been!
		} catch (IllegalArgumentException e) {
		    //We should get here if the expected IllegalArgumentException is thrown, but that's not enough
		    //for the test.  We also need to make sure that the reference s is still null!
		    assertNull(s);
		}
		
		//Test that student object is not created when the first name is an empty string
		s = null; //Initialize a student reference to null
		try {
		    s = new Student("", LAST_NAME, ID, EMAIL, HASHED_PASSWORD, CREDITS);
		    fail(); //If we reach this point a Student was constructed when it shouldn't have been!
		} catch (IllegalArgumentException e) {
		    //We should get here if the expected IllegalArgumentException is thrown, but that's not enough
		    //for the test.  We also need to make sure that the reference s is still null!
		    assertNull(s);
		}
		
		//Test for valid student object construction
		s = new Student(FIRST_NAME, LAST_NAME, ID, EMAIL, HASHED_PASSWORD, CREDITS);
		try {
			assertEquals(FIRST_NAME, s.getFirstName());
			assertEquals(LAST_NAME, s.getLastName());
			assertEquals(ID, s.getId());
			assertEquals(EMAIL, s.getEmail());
			assertEquals(HASHED_PASSWORD, s.getPassword());
			assertEquals(CREDITS, s.getMaxCredits());
		} catch (IllegalArgumentException e){
			fail();
		}
	}

	/**
	 * Testing constructor that does not have credits as a parameter
	 */
	@Test
	public void testStudentStringStringStringStringString() {
		//Test for valid student object construction
		Student s = new Student(FIRST_NAME, LAST_NAME, ID, EMAIL, HASHED_PASSWORD);
		try {
			assertEquals(FIRST_NAME, s.getFirstName());
			assertEquals(LAST_NAME, s.getLastName());
			assertEquals(ID, s.getId());
			assertEquals(EMAIL, s.getEmail());
			assertEquals(HASHED_PASSWORD, s.getPassword());
			assertEquals(MAX_CREDITS, s.getMaxCredits());
		} catch (IllegalArgumentException e){
			fail();
		}
	}

	/**
	 * Testing setter for email field
	 */
	@Test
	public void testSetEmail() {
		//Initialize a valid student 
		Student s = new Student(FIRST_NAME, LAST_NAME, ID, EMAIL, HASHED_PASSWORD);
		assertEquals(FIRST_NAME, s.getFirstName());
		assertEquals(LAST_NAME, s.getLastName());
		assertEquals(ID, s.getId());
		assertEquals(EMAIL, s.getEmail());
		assertEquals(HASHED_PASSWORD, s.getPassword());
		assertEquals(MAX_CREDITS, s.getMaxCredits());
		
		//Testing that setting the email field to null throws an exception and doesn't change anything
		try {
			s.setEmail(null);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(FIRST_NAME, s.getFirstName());
			assertEquals(LAST_NAME, s.getLastName());
			assertEquals(ID, s.getId());
			assertEquals(EMAIL, s.getEmail());
			assertEquals(HASHED_PASSWORD, s.getPassword());
			assertEquals(MAX_CREDITS, s.getMaxCredits());
		}
		
		//Testing that setting the email field to an empty string throws an exception and doesn't change anything
		try {
			s.setEmail("");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(FIRST_NAME, s.getFirstName());
			assertEquals(LAST_NAME, s.getLastName());
			assertEquals(ID, s.getId());
			assertEquals(EMAIL, s.getEmail());
			assertEquals(HASHED_PASSWORD, s.getPassword());
			assertEquals(MAX_CREDITS, s.getMaxCredits());
		}
		
		//Testing that setting an email without an '@' character throws an exception and doesn't change anything
		try {
			s.setEmail("invalidEmail.ncsu.edu");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(FIRST_NAME, s.getFirstName());
			assertEquals(LAST_NAME, s.getLastName());
			assertEquals(ID, s.getId());
			assertEquals(EMAIL, s.getEmail());
			assertEquals(HASHED_PASSWORD, s.getPassword());
			assertEquals(MAX_CREDITS, s.getMaxCredits());
		}
		
		//Testing that setting an email without an '.' character throws an exception and doesn't change anything
		try {
			s.setEmail("invalidEmail@ncsuedu");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(FIRST_NAME, s.getFirstName());
			assertEquals(LAST_NAME, s.getLastName());
			assertEquals(ID, s.getId());
			assertEquals(EMAIL, s.getEmail());
			assertEquals(HASHED_PASSWORD, s.getPassword());
			assertEquals(MAX_CREDITS, s.getMaxCredits());
		}
		
		//Testing that setting an email where the last '.' comes before the '@' character throws an exception and doesn't change anything
		try {
			s.setEmail("invalid.Email@ncsuedu");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(FIRST_NAME, s.getFirstName());
			assertEquals(LAST_NAME, s.getLastName());
			assertEquals(ID, s.getId());
			assertEquals(EMAIL, s.getEmail());
			assertEquals(HASHED_PASSWORD, s.getPassword());
			assertEquals(MAX_CREDITS, s.getMaxCredits());
		}
		
		//Valid email set containing only one '.' characters
		s.setEmail("validEmail@ncsu.edu");
		assertEquals(FIRST_NAME, s.getFirstName());
		assertEquals(LAST_NAME, s.getLastName());
		assertEquals(ID, s.getId());
		assertEquals("validEmail@ncsu.edu", s.getEmail());
		assertEquals(HASHED_PASSWORD, s.getPassword());
		assertEquals(MAX_CREDITS, s.getMaxCredits());
		
		//Valid email set containing multiple '.' characters
		s.setEmail("valid.Email@ncsu.edu");
		assertEquals(FIRST_NAME, s.getFirstName());
		assertEquals(LAST_NAME, s.getLastName());
		assertEquals(ID, s.getId());
		assertEquals("valid.Email@ncsu.edu", s.getEmail());
		assertEquals(HASHED_PASSWORD, s.getPassword());
		assertEquals(MAX_CREDITS, s.getMaxCredits());
	}

	/**
	 * Testing setter for password field
	 */
	@Test
	public void testSetPassword() {
		fail("Not yet implemented");
	}

	/**
	 * Testing setter for credits field
	 */
	@Test
	public void testSetMaxCredits() {
		fail("Not yet implemented");
	}

	/**
	 * Testing setter for firstName field
	 */
	@Test
	public void testSetFirstName() {
		//Initialize a valid student 
		Student s = new Student(FIRST_NAME, LAST_NAME, ID, EMAIL, HASHED_PASSWORD);
		assertEquals(FIRST_NAME, s.getFirstName());
		assertEquals(LAST_NAME, s.getLastName());
		assertEquals(ID, s.getId());
		assertEquals(EMAIL, s.getEmail());
		assertEquals(HASHED_PASSWORD, s.getPassword());
		assertEquals(MAX_CREDITS, s.getMaxCredits());
		
		//Test that setting the first name to null throws an exception and doesn't change anything
		try {
			s.setFirstName(null);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(FIRST_NAME, s.getFirstName());
			assertEquals(LAST_NAME, s.getLastName());
			assertEquals(ID, s.getId());
			assertEquals(EMAIL, s.getEmail());
			assertEquals(HASHED_PASSWORD, s.getPassword());
			assertEquals(MAX_CREDITS, s.getMaxCredits());
		}
		
		//Test that setting the first name to an empty string throws an exception and doesn't change anything
		try {
			s.setFirstName("");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(FIRST_NAME, s.getFirstName());
			assertEquals(LAST_NAME, s.getLastName());
			assertEquals(ID, s.getId());
			assertEquals(EMAIL, s.getEmail());
			assertEquals(HASHED_PASSWORD, s.getPassword());
			assertEquals(MAX_CREDITS, s.getMaxCredits()); 
		}
		
		//Valid first name set
		s.setFirstName("foo");
		assertEquals("foo", s.getFirstName());
		assertEquals(LAST_NAME, s.getLastName());
		assertEquals(ID, s.getId());
		assertEquals(EMAIL, s.getEmail());
		assertEquals(HASHED_PASSWORD, s.getPassword());
		assertEquals(MAX_CREDITS, s.getMaxCredits());
	}

	/**
	 * Testing setter for lastName field
	 */
	@Test
	public void testSetLastName() {
		//Initialize a valid student 
		Student s = new Student(FIRST_NAME, LAST_NAME, ID, EMAIL, HASHED_PASSWORD);
		assertEquals(FIRST_NAME, s.getFirstName());
		assertEquals(LAST_NAME, s.getLastName());
		assertEquals(ID, s.getId());
		assertEquals(EMAIL, s.getEmail());
		assertEquals(HASHED_PASSWORD, s.getPassword());
		assertEquals(MAX_CREDITS, s.getMaxCredits());
		
		//Test that setting the first name to null throws an exception and doesn't change anything
		try {
			s.setLastName(null);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(FIRST_NAME, s.getFirstName());
			assertEquals(LAST_NAME, s.getLastName());
			assertEquals(ID, s.getId());
			assertEquals(EMAIL, s.getEmail());
			assertEquals(HASHED_PASSWORD, s.getPassword());
			assertEquals(MAX_CREDITS, s.getMaxCredits());
		}
		
		//Test that setting the first name to an empty string throws an exception and doesn't change anything
		try {
			s.setLastName("");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(FIRST_NAME, s.getFirstName());
			assertEquals(LAST_NAME, s.getLastName());
			assertEquals(ID, s.getId());
			assertEquals(EMAIL, s.getEmail());
			assertEquals(HASHED_PASSWORD, s.getPassword());
			assertEquals(MAX_CREDITS, s.getMaxCredits());
		}
		
		//Valid first name set
		s.setLastName("bar");
		assertEquals(FIRST_NAME, s.getFirstName());
		assertEquals("bar", s.getLastName());
		assertEquals(ID, s.getId());
		assertEquals(EMAIL, s.getEmail());
		assertEquals(HASHED_PASSWORD, s.getPassword());
		assertEquals(MAX_CREDITS, s.getMaxCredits());
	}

	/**
	 * Testing equals method
	 */
	@Test
	public void testEqualsObject() {
		Student s1 = new Student(FIRST_NAME, LAST_NAME, ID, EMAIL, HASHED_PASSWORD);
		Student s2 = new Student(FIRST_NAME, LAST_NAME, ID, EMAIL, HASHED_PASSWORD);
		Student s3 = new Student("Foo", "Bar", "foobar", "foobar@ncsu.edu", "drowssap");
		
		//Test that two objects with different state are unequal
		assertFalse(s2.equals(s3));
		
		//Test that two objects with the same state are equal
		assertTrue(s1.equals(s2));
	}
	
	/**
	 * Testing hashCode method
	 */
	@Test
	public void testHashCode() {
		Student s1 = new Student(FIRST_NAME, LAST_NAME, ID, EMAIL, HASHED_PASSWORD);
		Student s2 = new Student(FIRST_NAME, LAST_NAME, ID, EMAIL, HASHED_PASSWORD);
		Student s3 = new Student("Foo", "Bar", "foobar", "foobar@ncsu.edu", "drowssap");
		
		//Test that two unequal objects have different hash code
		assertNotEquals(s2.hashCode(), s3.hashCode());
		
		//Test that two equal objects have the same hash code
		assertEquals(s1.hashCode(), s2.hashCode());
	}
	
	/**
	 * Testing toString method
	 */
	@Test
	public void testToString() {
		//Test toString for object constructed with credits param
		Student s1 = new Student(FIRST_NAME, LAST_NAME, ID, EMAIL, HASHED_PASSWORD, CREDITS);
		String str1 = "first,last,id,email@ncsu.edu,hashedpassword,10";
		assertEquals(s1.toString(), str1);
		
		//Test toString for object constructed without credits param
		Student s2 = new Student(FIRST_NAME, LAST_NAME, ID, EMAIL, HASHED_PASSWORD);
		String str2 = "first,last,id,email@ncsu.edu,hashedpassword,18";
		assertEquals(s2.toString(), str2);
	}
}