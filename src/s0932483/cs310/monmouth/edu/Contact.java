/**
 * Richard Kanson
 * Nov 22, 2016
 * ContactList
 */
package s0932483.cs310.monmouth.edu;

import java.util.Comparator;

public class Contact {

	int id;
	String firstName;
	String lastName;
	String number;

	public Contact() {

	}

	public Contact(int id, String firstName, String lastName, String number) {
		setID(id);
		setFirst(firstName);
		setLast(lastName);
		setNumber(number);
	}

	public void setID(int id) {
		this.id = id;
	}

	public void setFirst(String firstName) {
		this.firstName = firstName;
	}

	public void setLast(String lastName) {
		this.lastName = lastName;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getID() {
		return id;
	}

	public String getFirst() {
		return firstName;
	}

	public String getLast() {
		return lastName;
	}

	public String getNumber() {
		return number;
	}

	public static Comparator<Contact> ContactNameComparator = new Comparator<Contact>() {

		@Override
		public int compare(Contact c1, Contact c2) {
			String cName1 = c1.getFirst().toUpperCase();
			String cName2 = c2.getFirst().toUpperCase();
			return cName1.compareTo(cName2);
		}
	};

}
