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

public class StudentRecordIO {

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
	
	public static void writeStudentRecords(String filename, ArrayList<Student> studentDirectory) throws IOException {
		PrintStream fileWriter = new PrintStream(new File(filename));

		for (int i = 0; i < studentDirectory.size(); i++) {
			fileWriter.println(studentDirectory.get(i).toString());
		}

		fileWriter.close();
	}
	
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