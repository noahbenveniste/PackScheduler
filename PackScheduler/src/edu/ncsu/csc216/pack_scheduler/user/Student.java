package edu.ncsu.csc216.pack_scheduler.user;
/**
 * 
 * @author Daniel Mills <demills>
 * @author Noah Benveniste <nnbenven>
 * @author Kevin Hildner <kwhildne>
 */
public class Student {
	private String firstName;
	private String lastName;
	private String id;
	private String email;
	private String password;
	private int maxCredits;
	
	public static final int MIN_CREDITS = 3;
	public static final int MAX_CREDITS = 18;

	public Student(String firstName, String lastName, String id, String email, String hashPW, int maxCredits) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setId(id);
		this.setEmail(email);
		this.setPassword(hashPW);
		this.setMaxCredits(maxCredits);
	}
	
	public Student(String firstName, String lastName, String id, String email, String hashPW) {
		this(firstName, lastName, id, email, hashPW, MAX_CREDITS);
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		if (email == null) {
			throw new IllegalArgumentException();
		}
		if (email.equals("")) {
			throw new IllegalArgumentException();
		}
		if (!email.contains("@")) {
			throw new IllegalArgumentException();
		}
		if (!email.contains(".")) {
			throw new IllegalArgumentException();
		}
		if (email.indexOf("@") > email.lastIndexOf(".")) {
			throw new IllegalArgumentException();
		}
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		if (password == null) {
			throw new IllegalArgumentException();
		}
		if (password.equals("")) {
			throw new IllegalArgumentException();
		}
		this.password = password;
	}

	/**
	 * @return the maxCredits
	 */
	public int getMaxCredits() {
		return maxCredits;
	}

	/**
	 * @param maxCredits the maxCredits to set
	 */
	public void setMaxCredits(int maxCredits) {
		if (maxCredits < MIN_CREDITS || maxCredits > MAX_CREDITS) {
			throw new IllegalArgumentException();
		}
		this.maxCredits = maxCredits;
	}
	
	public String getFirstName() {
		// TODO Auto-generated method stub
		return this.firstName;
	}
	
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		if (firstName == null) {
			throw new IllegalArgumentException();
		}
		if (firstName.equals("")) {
			throw new IllegalArgumentException();
		}
		this.firstName = firstName;
	}

	public String getLastName() {
		// TODO Auto-generated method stub
		return this.lastName;
	}
	
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		if (lastName == null) {
			throw new IllegalArgumentException();
		}
		if (lastName.equals("")) {
			throw new IllegalArgumentException();
		}
		this.lastName = lastName;
	}

	public String getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
	/**
	 * @param id the id to set
	 */
	private void setId(String id) {
		if (id == null) {
			throw new IllegalArgumentException();
		}
		if (id.equals("")) {
			throw new IllegalArgumentException();
		}
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
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

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getFirstName() + "," + this.getLastName() + "," + this.getId() + "," 
			+ this.getEmail() + "," + this.getPassword() +"," + this.getMaxCredits();
	}
	
	

}
