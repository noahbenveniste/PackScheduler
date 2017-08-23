package edu.ncsu.csc216.pack_scheduler.user;
/**
 * Class for a student object
 * @author Sarah Heckman
 * @author Daniel Mills <demills>
 * @author Noah Benveniste <nnbenven>
 * @author Kevin Hildner <kwhildne>
 */
public class Student {
	
	/** Fields */
	
	/** The student's first name */
	private String firstName;
	/** The student's last name */
	private String lastName;
	/** The student's id */
	private String id;
	/** The student's email */
	private String email;
	/** The student's password */
	private String password;
	/** The maximum number of credits that the student can enroll in */
	private int maxCredits;
	
	/** Class Constants */
	
	/** The minimum number of credits to enroll in */
	public static final int MIN_CREDITS = 3;
	/** The maximum number of credits to enroll in */
	public static final int MAX_CREDITS = 18;

	/**
	 * Constructor for student object
	 * @param firstName The student's first name
	 * @param lastName The student's last name
	 * @param id The student's id
	 * @param email The student's email
	 * @param hashPW The student's password
	 * @param maxCredits The max number of credits that the student can take
	 */
	public Student(String firstName, String lastName, String id, String email, String hashPW, int maxCredits) {
		//Set the fields by calling setter methods to enforce class invariants
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setId(id);
		this.setEmail(email);
		this.setPassword(hashPW);
		this.setMaxCredits(maxCredits);
	}
	
	/**
	 * Constructor with default max credit value
	 * @param firstName The student's first name
	 * @param lastName The student's last name
	 * @param id The student's id
	 * @param email The student's email
	 * @param hashPW The student's password
	 */
	public Student(String firstName, String lastName, String id, String email, String hashPW) {
		this(firstName, lastName, id, email, hashPW, MAX_CREDITS);
	}
	
	/**
	 * Returns the the student's email
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the student's email
	 * @param email the email to set
	 * @throws IllegalArgumentException for null or empty string input, if the email does not contain
	 * the "@" or "." characters, or if the final instance of the "." character comes before the "@" 
	 * character
	 */
	public void setEmail(String email) {
		if (email == null) {
			throw new IllegalArgumentException("Invalid email");
		}
		if (email.equals("")) {
			throw new IllegalArgumentException("Invalid email");
		}
		if (!email.contains("@")) {
			throw new IllegalArgumentException("Invalid email");
		}
		if (!email.contains(".")) {
			throw new IllegalArgumentException("Invalid email");
		}
		if (email.indexOf("@") > email.lastIndexOf(".")) {
			throw new IllegalArgumentException("Invalid email");
		}
		this.email = email;
	}

	/**
	 * Gets the student's password
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the student's password
	 * @param password the password to set
	 * @throws IllegalArgumentException for null or empty string input
	 */
	public void setPassword(String password) {
		if (password == null) {
			throw new IllegalArgumentException("Invalid password");
		}
		if (password.equals("")) {
			throw new IllegalArgumentException("Invalid password");
		}
		this.password = password;
	}

	/**
	 * Gets the max number of credits the student can take
	 * @return the maxCredits
	 */
	public int getMaxCredits() {
		return maxCredits;
	}

	/**
	 * Sets the max number of credits the student can take
	 * @param maxCredits the maxCredits to set
	 * @throws IllegalArgumentException for inputs less than 3 or greater than 18
	 */
	public void setMaxCredits(int maxCredits) {
		if (maxCredits < MIN_CREDITS || maxCredits > MAX_CREDITS) {
			throw new IllegalArgumentException("Invalid max credits");
		}
		this.maxCredits = maxCredits;
	}
	
	/**
	 * Gets the student's first name
	 * @return the student's first name
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
	/**
	 * Sets the student's first name
	 * @param firstName the firstName to set
	 * @throws IllegalArgumentException for null or empty string input
	 */
	public void setFirstName(String firstName) {
		if (firstName == null) {
			throw new IllegalArgumentException("Invalid first name");
		}
		if (firstName.equals("")) {
			throw new IllegalArgumentException("Invalid first name");
		}
		this.firstName = firstName;
	}

	/**
	 * Gets the student's last name
	 * @return the student's last name
	 */
	public String getLastName() {
		return this.lastName;
	}
	
	/**
	 * Sets the student's last name
	 * @param lastName the lastName to set
	 * @throws IllegalArgumentException for null or empty string input
	 */
	public void setLastName(String lastName) {
		if (lastName == null) {
			throw new IllegalArgumentException("Invalid last name");
		}
		if (lastName.equals("")) {
			throw new IllegalArgumentException("Invalid last name");
		}
		this.lastName = lastName;
	}

	/**
	 * Gets the student's id
	 * @return the student's id
	 */
	public String getId() {
		return this.id;
	}
	
	/**
	 * Sets the student's id
	 * @param id the id to set
	 * @throws IllegalArgumentException for null or empty string input
	 */
	private void setId(String id) {
		if (id == null) {
			throw new IllegalArgumentException("Invalid id");
		}
		if (id.equals("")) {
			throw new IllegalArgumentException("Invalid id");
		}
		this.id = id;
	}

	/**
	 * Generates a hashCode for Student using all fields.
	 * @return hashCode for Student
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + maxCredits;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	/**
	 * Compares a given object to this object for equality over all fields.
	 * @param obj The object to compare
	 * @return true if the objects are the same over all fields
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (maxCredits != other.maxCredits)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	/**
	 * Creates a string representation of the student object's data
	 * @return the student info represented as a string
	 */
	@Override
	public String toString() {
		return this.getFirstName() + "," + this.getLastName() + "," + this.getId() + "," 
			+ this.getEmail() + "," + this.getPassword() + "," + this.getMaxCredits();
	}
	
}
