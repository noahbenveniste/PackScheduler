package edu.ncsu.csc216.pack_scheduler.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.ncsu.csc216.pack_scheduler.user.Student;

/**
 * A class providing static IO methods for reading and writing Student records
 *   from and to a file, respectively.
 *   
 * @author demills
 * @author Sarah Heckman
 */
public class StudentRecordIO {

	/**
	 * Given a filename of Student records, reads the file and returns the valid
	 *   Student records in an ArrayList.
	 *   
	 * @param filename the file to read records from
	 * @return an ArrayList of Student records read from file
	 * @throws FileNotFoundException if the given file cannot be found or accessed
	 */
	public static ArrayList<Student> readStudentRecords(String filename) throws FileNotFoundException {
		Scanner fileReader = new Scanner(new FileInputStream(filename));
		ArrayList<Student> students = new ArrayList<Student>();
		while (fileReader.hasNextLine()) {
			try {
				Student student = processStudent(fileReader.nextLine());
				boolean duplicate = false;
				for (int i = 0; i < students.size(); i++) {
					Student s = students.get(i);
					if (student.getFirstName().equals(s.getFirstName()) &&
							student.getLastName().equals(s.getLastName())) {
						//it's a duplicate
						duplicate = true;
					}
				}
				if (!duplicate) {
					students.add(student);
				}
			} catch (IllegalArgumentException e) {
				//skip the line
			}
		}
		fileReader.close();
		return students;
	}
	
	/**
	 * Given a filename and an ArrayList of Students, writes the Student records 
	 *   to the file as a comma-separated sequence of Strings in the format:
	 *   "firstName,lastName,id,email,password,maxCredits"
	 *   
	 * @param filename the file to write Student records to 
	 * @param studentDirectory an ArrayList of Students to write to file
	 * @throws IOException if the file cannot be created
	 */
	public static void writeStudentRecords(String filename, ArrayList<Student> studentDirectory) throws IOException {
		PrintStream fileWriter = new PrintStream(new File(filename));

		for (int i = 0; i < studentDirectory.size(); i++) {
			fileWriter.println(studentDirectory.get(i).toString());
		}

		fileWriter.close();
	}
	
	/**
	 * Private helper method for readCourseRecords. 
	 * Given a line of comma-separated values, reads in the values, creates a Student
	 *   object and returns it.
	 * If the values cannot be read in, an IllegalArgumentException is thrown.
	 * 
	 * @param line a sequence of comma-separated values representing a Student
	 * @return Student read in from the given line
	 * @throws IllegalArgumentException if a Student cannot be read from the line
	 */
	private static Student processStudent(String line) {
		if (line == null || line.equals("")) {
			throw new IllegalArgumentException();
		}

		Scanner readLine = new Scanner(line);
		readLine.useDelimiter(",");

		String firstName;
		String lastName; 
		String id;
		String email;
		String password;
		int maxCredits;

		try {
			firstName = readLine.next();
			lastName = readLine.next();
			id = readLine.next();
			email = readLine.next();
			password = readLine.next();
			maxCredits = readLine.nextInt();
			readLine.close();
			return new Student(firstName, lastName, id, email, password, maxCredits);
		} catch (NoSuchElementException e) {
			readLine.close();
			throw new IllegalArgumentException();
		}
	}
}