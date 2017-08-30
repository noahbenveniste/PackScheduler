package edu.ncsu.csc216.pack_scheduler.io;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Test;

import edu.ncsu.csc216.pack_scheduler.user.Student;

public class StudentRecordIOTest {
	public static final String VALID_STUDENTS = "test-files/student_records.txt";
	public static final String INVALID_STUDENTS = "test-files/invalid_student_records.txt";
	public static final String VALID_STUDENTS_WITH_BLANK = "test-files/student_records_with_blank_line.txt";
	public static final String ROOT_OWNED_FILE = "test-files/owned_by_root.txt";

	@Test
	public void testReadStudentRecord() {
		ArrayList<Student> s = new ArrayList<Student>();
		s = null;

		// Tests passing an empty string filename.
		try {
			s = StudentRecordIO.readStudentRecords("");
			fail();
		} catch (FileNotFoundException e) {
			assertNull(s);
		}

		// Tests passing a null filename.
		try {
			s = StudentRecordIO.readStudentRecords(null);
			fail();
		} catch (FileNotFoundException e) {
			assertNull(s);
		}

		// Tests reading an inaccessible file.
		try {
			s = StudentRecordIO.readStudentRecords(ROOT_OWNED_FILE);
			fail();
		} catch (FileNotFoundException e) {
			assertNull(s);
		}

		// Tests reading a non-existent file.
		try {
			s = StudentRecordIO.readStudentRecords("non_existent_file.txt");
			fail();
		} catch (FileNotFoundException e) {
			assertNull(s);
		}

		// Tests reading an empty line inserted between non-empty lines.
		// The empty line should be skipped, but this allows the conditional
		//   for "
		try {
			ArrayList<Student> valid = StudentRecordIO.readStudentRecords(VALID_STUDENTS);
			s = StudentRecordIO.readStudentRecords(VALID_STUDENTS_WITH_BLANK);
			assertEquals(valid.size(), s.size());
			assertEquals(s.get(0), valid.get(0));
			assertEquals(s.get(s.size() - 1), valid.get(valid.size() - 1));
		} catch (FileNotFoundException e) {
			fail();
		}
	}

	@Test
	public void testWriteStudentRecord() {
		// TODO
		assertTrue(true);
	}
}