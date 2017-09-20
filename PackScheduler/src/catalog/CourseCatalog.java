/**
 * 
 */
package catalog;

import java.util.ArrayList;

import edu.ncsu.csc216.collections.list.SortedList;
import edu.ncsu.csc216.pack_scheduler.course.Course;

/**
 * @author Kevin Hildner
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
}
