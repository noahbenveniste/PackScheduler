/**
 * 
 */
package edu.ncsu.csc216.pack_scheduler.catalog;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Noah Benveniste
 * @author Daniel Mills
 * @author Kevin Hildner
 *
 */
public class CourseCatalogTest {
	
	/** Valid course records */
	private final String validTestFile = "test-files/course_records.txt";
	/** Invalid course records */
	private final String invalidTestFile = "test-files/invalid_course_records.txt";
	/** Course name */
	private static final String NAME = "CSC216";
	/** Course title */
	private static final String TITLE = "Programming Concepts - Java";
	/** Course section */
	private static final String SECTION = "001";
	/** Course credits */
	private static final int CREDITS = 4;
	/** Course instructor id */
	private static final String INSTRUCTOR_ID = "sesmith5";
	/** Course meeting days */
	private static final String MEETING_DAYS = "MW";
	/** Course start time */
	private static final int START_TIME = 1330;
	/** Course end time */
	private static final int END_TIME = 1445;
	
	/**
	 * Tests the construction of a course catalog 
	 */
	@Test
	public void testCourseCatalog() {
		//Test that the StudentDirectory is initialized to an empty list
		CourseCatalog catalog = new CourseCatalog();
		assertFalse(catalog.removeCourseFromCatalog(NAME, SECTION));
		assertEquals(0, catalog.getCourseCatalog().length);
	}
	
	/**
	 * Tests loading in a course catalog from a list of courses in a text file.
	 */
	@Test
	public void testLoadCourseCatalog() {
		//Test that invalid test files are ignored
		CourseCatalog badCatalog = new CourseCatalog();
		badCatalog.loadCoursesFromFile(invalidTestFile);
		assertEquals(0, badCatalog.getCourseCatalog().length);
		
		//Load in a course catalog from a valid test file
		CourseCatalog catalog = new CourseCatalog();
		catalog.loadCoursesFromFile(validTestFile);
		assertEquals(8, catalog.getCourseCatalog().length);
		
		//Test file that doesn't exist
		try {
			badCatalog.loadCoursesFromFile("Nonexistant File");
			fail("Loaded file that doesn't exist");
		} catch(IllegalArgumentException e) {
			assertEquals(0, badCatalog.getCourseCatalog().length);
		}
	}
	
	/**
	 * Tests that calling newCourseCatalog() on a populated CourseCatalog resets it to empty
	 */
	@Test
	public void testNewCourseCatalog() {
		//Load in a course catalog from a valid test file
		CourseCatalog catalog = new CourseCatalog();
		catalog.loadCoursesFromFile(validTestFile);
		assertEquals(8, catalog.getCourseCatalog().length);
		
		//Check that calling the method resets the catalog
		catalog.newCourseCatalog();
		assertEquals(0, catalog.getCourseCatalog().length);
	}
	
	/**
	 * Tests adding a course to a catalog
	 */
	@Test
	public void testAddCourseToCatalog() {
		
	}
	
	/**
	 * Tests removing a course from a catalog
	 */
	@Test
	public void testRemoveCourseFromCatalog() {
		
	}
	
	/**
	 * Tests getting a course from a catalog
	 */
	@Test
	public void testGetCourseFromCatalog() {
		
	}
	
	/**
	 * Tests getting a course catalog
	 */
	@Test
	public void testGetCourseCatalog() {
		
	}
	
	/**
	 * Tests saving a course catalog
	 */
	@Test
	public void testSaveCourseCatalog() {
		
	}
}
