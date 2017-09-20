/**
 * 
 */
package catalog;

import java.io.FileNotFoundException;

import edu.ncsu.csc216.collections.list.SortedList;
import edu.ncsu.csc216.pack_scheduler.course.Course;
import edu.ncsu.csc216.pack_scheduler.io.CourseRecordIO;
import edu.ncsu.csc216.pack_scheduler.course.ConflictException;

/**
 * @author Kevin Hildner
 * @author Noah Benveniste
 *
 */
public class CourseCatalog {

	/** The course catalog */
	private SortedList<Course> catalog;
	
	/**
	 * Constructs a blank CourseCatalog
	 */
	
	
	/**
	 * Creates a new catalog
	 */
	public void newCourseCatalog() {
		this.catalog = new SortedList<Course>();
	}
	
	/**
	 * 
	 */
	public void loadCoursesFromFile(String fileName) {
		try {
			catalog = CourseRecordIO.readCourseRecords(fileName);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Unable to read file " + fileName);
		}
	}
	
	/**
	 * 
	 */
	public boolean removeCourseFromCatalog(String name, String section) {
		for (int i = 0; i < catalog.size(); i++) {
			Course c = catalog.get(i);
			if ((c.getName().equals(name)) && (c.getSection().equals(section))) {
				catalog.remove(i);
				return true;
			}
		}
		//Return false if the course is not in the catalog
		return false;
	}
	
	/**
	 * 
	 */
	public Course getCourseFromCatalog(String name, String section) {
		for (int i = 0; i < catalog.size(); i++) {
			Course c = catalog.get(i);
			if ((c.getName().equals(name)) && (c.getSection().equals(section))) {
				return c;
			}
		}
		//Return null if the course is not in the catalog
		return null;
	}
	
	/**
	 *
	 */
	public String[][] getCourseCatalog() {
		//Initialize the string array
		String[][] courseCatalog = new String[catalog.size()][3];
		//Loop through the course catalog getting the required fields and adding them
		//to the relevant cells in the string array
		for (int i = 0; i < catalog.size(); i++) {
			Course c = catalog.get(i);
			courseCatalog[i][0] = c.getName();
			courseCatalog[i][1] = c.getSection();
			courseCatalog[i][2] = c.getTitle();
		}
		return courseCatalog;
	}
}
