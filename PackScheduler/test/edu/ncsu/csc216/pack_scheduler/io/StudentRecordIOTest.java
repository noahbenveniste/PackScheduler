package edu.ncsu.csc216.pack_scheduler.io;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import edu.ncsu.csc216.collections.list.SortedList;
import java.util.Scanner;
import org.junit.Test;
import edu.ncsu.csc216.pack_scheduler.user.Student;

/**
 * Tests the static helper class, StudentRecordIO.
 * @author demills
 */
public class StudentRecordIOTest {
	// Input files.
	/** Relative path to file containing multiple valid Student records */
	public static final String STUDENT_RECORDS = "test-files/student_records.txt";
	/** Relative path to file containing multiple valid Student records, with a blank line inserted between two non-blank lines */
	public static final String STUDENT_RECORDS_WITH_BLANK = "test-files/student_records_with_blank_line.txt";
	/** Relative path to file containing several invalid Student records */
	public static final String INVALID_STUDENT_RECORDS = "test-files/invalid_student_records.txt";
	/** Relative path to file containing valid Student records with several duplicates mixed in */
	public static final String DUPLICATE_STUDENT_RECORDS = "test-files/duplicate_student_records.txt";
	
	// Expected output files.
	/** Relative path to file containing Student records identical to STUDENT_RECORDS file */
	public static final String EXPECTED_FULL_STUDENT_RECORDS = "test-files/expected_full_student_records.txt";
	/** Relative path to file containing a single Student record for Zahir King */
	public static final String EXPECTED_STUDENT_RECORDS = "test-files/expected_student_records.txt";

	/**
	 * Tests readStudentRecords() method of StudentRecordIO.
	 * See StudentRecordIO.readStudentRecords()'s Javadoc for description
	 *   of functionality being tested and in-line comments of testReadStudentRecords()
	 *   for specific details of testing.
	 */
	@Test
	public void testReadStudentRecords() {
		// A SortedList of Students that holds the output of 
		//   the readStudentRecords() methods. 
		SortedList<Student> actualStudents = new SortedList<Student>();
		actualStudents = null;

		// Tests passing an empty string filename.
		try {
			actualStudents = StudentRecordIO.readStudentRecords("");
			fail();
		} catch (FileNotFoundException e) {
			assertNull(actualStudents);
		}

		// Tests passing a null filename.
		try {
			actualStudents = StudentRecordIO.readStudentRecords(null);
			fail();
		} catch (FileNotFoundException e) {
			assertNull(actualStudents);
		}

		// Tests reading a non-existent file.
		try {
			actualStudents = StudentRecordIO.readStudentRecords("non_existent_file.txt");
			fail();
		} catch (FileNotFoundException e) {
			assertNull(actualStudents);
		}

		// Tests reading an empty line inserted between non-empty lines.
		// No exceptions should be thrown.
		try {
			SortedList<Student> expected = StudentRecordIO.readStudentRecords(EXPECTED_FULL_STUDENT_RECORDS);
			actualStudents = StudentRecordIO.readStudentRecords(STUDENT_RECORDS_WITH_BLANK);

			assertEquals(expected.size(), actualStudents.size());
			// Compares each Student in the two SortedLists, expected and actualStudents. 
			// Since VALID_STUDENTS_WITH_BLANK has the same records as VALID_STUDENTS, 
			// except for a single blank line inserted, the two should produce identical 
			// lists of Students.
			for (int i = 0; i < expected.size(); i++) {
				// assertEquals will use the overridden equals() method of 
				//   Student, not of Object.
				assertEquals(expected.get(i), actualStudents.get(i));
			}
		} catch (Exception e) {
			fail();
		}
		
		// Tests reading a file with invalid entries, either duplicates or invalid 
		//   Student entries. A record is invalid if StudentRecordIO.processStudent()
		//   cannot read in valid tokens or a Student object cannot be created from 
		//   validly read in tokens. The invalid entries should be omitted with
		//   no exceptions thrown.
		actualStudents = null;
		try {
			actualStudents = StudentRecordIO.readStudentRecords(INVALID_STUDENT_RECORDS);
			assertNotNull(actualStudents);
			assertEquals(0, actualStudents.size()); 
		} catch (Exception e) {
			fail();
		}
		
		// Tests reading a file with duplicate Student records, which are 
		//   identified by equal, e
		actualStudents = null;
		try {
			actualStudents = StudentRecordIO.readStudentRecords(DUPLICATE_STUDENT_RECORDS);
			assertNotNull(actualStudents);
			assertEquals(2, actualStudents.size());
		} catch (Exception e) {
			fail();
		}
		
		// Tests reading a normal, valid file of Student records.
		actualStudents = null;
		try {
			actualStudents = StudentRecordIO.readStudentRecords(DUPLICATE_STUDENT_RECORDS);
			assertNotNull(actualStudents);
			assertEquals(2, actualStudents.size());
		} catch (Exception e) {
			fail();
		}
		
		// Creates a StudentRecordIO instance and does nothing with it.
		// Without this addition, JaCoCo reports that StudentRecordIO doesn't
		//   have 100% condition and statement coverage, listing the only 
		//   uncovered code as the class header (public class StudentRecordIO { )
		// Although it makes no sense to instantiate a class containing only static
		//   methods, the code below is to account a flaw in the JaCoCo tool, so our
		//   group can receive full extra credit points for attaining 100% coverage.
		StudentRecordIO s = new StudentRecordIO();
		assertTrue(s instanceof StudentRecordIO);
	}

	/**
	 * Tests writeStudentRecords() method of StudentRecordIO.
   	 * See StudentRecordIO.writeStudentRecords()'s Javadoc for description
	 *   of functionality being tested and in-line comments of testWriteStudentRecords()
	 *   for specific details of testing.
	 */
	@Test
	public void testWriteStudentRecords() {
		// Tests passing a null filename. File class should throw an IOException.
		SortedList<Student> studentDirectory = new SortedList<Student>();
		try {
			StudentRecordIO.writeStudentRecords(null, studentDirectory);
			fail();
		} catch(IOException e) {
			// Do nothing
		}
			
		// Tests passing an empty string filename. IOException should be thrown.
		try {
			StudentRecordIO.writeStudentRecords("", studentDirectory);
			fail();
		} catch(IOException e) {
			// Do nothing. 
		}
		
		// Tests passing a filename the Student shouldn't have access to.
		try {
			StudentRecordIO.writeStudentRecords("/test_file.txt", studentDirectory);
			fail();
		} catch (IOException e) {
			// Do nothing
		}

		// Tests passing an empty SortedList of Students. File should be created, but containing no records.
		try {
			StudentRecordIO.writeStudentRecords("test-files/blank_file.txt", studentDirectory);
		} catch (Exception e) {
			// Checks for existence of output file.
			File f = new File("test-files/blank_file.txt");
			assertTrue(f.exists());

			// Checks that the file has 0 lines.
			// NOTE: I referenced a StackOverflow response to find out how to count lines in a file.
			//    link: https://stackoverflow.com/questions/1277880/how-can-i-get-the-count-of-line-in-a-file-in-an-efficient-way
			//    username for response: Augustin
			Path p = Paths.get("test-files/blank_file.txt");
			try {
				assertEquals(0, Files.lines(p).count());
			} catch(Exception e_0) {
				fail();
			}
		}
		
		// Tests writing multiple Student records to a file. 
		Scanner actualReader = null;
		Scanner expectedReader = null;
		try {
			// Reads in a SortedList of 10 valid Student records. 
			studentDirectory = StudentRecordIO.readStudentRecords(STUDENT_RECORDS);
			StudentRecordIO.writeStudentRecords("test-files/actual_student_records.txt", studentDirectory);
			// Checks that output file was created.
			File outputFile = new File("test-files/actual_student_records.txt");
			assertTrue(outputFile.exists());

			actualReader = new Scanner(outputFile);
			expectedReader = new Scanner(new FileInputStream(new File(EXPECTED_FULL_STUDENT_RECORDS)));
			
			// Reads through all lines in "expected_full_student_records.txt". For each line in this file,
			//   checks that the actual output file also has a line. If it doesn't, the test fails, as the two files
			//   should have an equal number of lines. If the output file does have another line, this line is compared
			//   for equality with the next line in the expected output file.
			while (expectedReader.hasNextLine()) {
				if (!actualReader.hasNextLine()) {
					fail("Actual output file has less lines than expected.");
				} 
				assertEquals(expectedReader.nextLine(), actualReader.nextLine());
			}
			// Checks that "actual_student_records.txt" doesn't have additional records after
			//   all lines in "expected_full_student_records.txt" have been matched.
			assertFalse(actualReader.hasNext());
		} catch (Exception e) {
			fail();
		} finally {
			if (actualReader != null) {
				actualReader.close();
			}
			if (expectedReader != null) {
				expectedReader.close();
			}
		}
	}
}