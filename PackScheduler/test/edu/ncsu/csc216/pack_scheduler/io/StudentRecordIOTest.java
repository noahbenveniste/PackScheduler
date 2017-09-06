package edu.ncsu.csc216.pack_scheduler.io;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Test;

import edu.ncsu.csc216.pack_scheduler.user.Student;

public class StudentRecordIOTest {
	public static final String INPUT_VALID_STUDENTS = "test-files/student_records.txt";
	public static final String INPUT_INVALID_STUDENTS = "test-files/invalid_student_records.txt";
	public static final String INPUT_VALID_STUDENTS_WITH_BLANK = "test-files/student_records_with_blank_line.txt";
	public static final String INPUT_DUPLICATE_STUDENTS = "test-files/duplicate_student_records.txt";
	public static final String EXPECTED_VALID_STUDENTS = "test-files/expected_full_student_records.txt";
	public static final String EXPECTED_INVALID_STUDENTS = "test-files/expected_student_records.txt";

	/**
	 * Tests StudentRecordIO.readStudentRecords();
	 */
	@Test
	public void testReadStudentRecords() {
		ArrayList<Student> actual = new ArrayList<Student>();
		actual = null;

		// Tests passing an empty string filename.
		try {
			actual = StudentRecordIO.readStudentRecords("");
			fail();
		} catch (FileNotFoundException e) {
			assertNull(actual);
		}

		// Tests passing a null filename.
		try {
			actual = StudentRecordIO.readStudentRecords(null);
			fail();
		} catch (FileNotFoundException e) {
			assertNull(actual);
		}

		// Tests reading a non-existent file.
		try {
			actual = StudentRecordIO.readStudentRecords("non_existent_file.txt");
			fail();
		} catch (FileNotFoundException e) {
			assertNull(actual);
		}

		// Tests reading an empty line inserted between non-empty lines.
		// No exceptions should be thrown.
		try {
			ArrayList<Student> expected = StudentRecordIO.readStudentRecords(EXPECTED_VALID_STUDENTS);
			actual = StudentRecordIO.readStudentRecords(INPUT_VALID_STUDENTS_WITH_BLANK);

			assertEquals(expected.size(), actual.size());
			// Compares each Student in the two ArrayListactual. Since VALID_STUDENTS_WITH_BLANK
			//   has the same records as VALID_STUDENTS, except for a single blank line 
			//   inserted, the two should produce identical lists of Students.
			for (int i = 0; i < expected.size(); i++) {
				// assertEquals will use the overridden equals() method of 
				//   Student, not of Object.
				assertEquals(expected.get(i), actual.get(i));
			}
		} catch (Exception e) {
			fail();
		}
		
		// Tests reading a file with invalid entries, either duplicates or invalid 
		//   Student entries. A record is invalid if StudentRecordIO.processStudent()
		//   cannot read in valid tokens or a Student object cannot be created from 
		//   validly read in tokens. The invalid entries should be omitted with
		//   no exceptions thrown.
		actual = null;
		try {
			actual = StudentRecordIO.readStudentRecords(INPUT_INVALID_STUDENTS);
			assertNotNull(actual);
			assertEquals(0, actual.size()); 
		} catch (Exception e) {
			fail();
		}
		
		// Tests reading a file with duplicate Student records, which are 
		//   identified by equal, e
		actual = null;
		try {
			actual = StudentRecordIO.readStudentRecords(INPUT_DUPLICATE_STUDENTS);
			assertNotNull(actual);
			assertEquals(2, actual.size());
		} catch (Exception e) {
			fail();
		}
	}

	/**
	 *
	 */
	@Test
	public void testWriteStudentRecords() {
		
	}
}