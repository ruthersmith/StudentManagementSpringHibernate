package hibernateFirstAssign;

import java.io.Serializable;
import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * java bean properties: id, firstname,lastname,Address,email. you may have to
	 * create address java bean which is depedent java bean.
	 */
	
	@Id @GeneratedValue
	private int id;
	
	private String firstname;
	private String lastname;
	private Address address;
	private String email;
	
	
	
	public Student() {/* required empty constructor */}
	
	public Student(int id) {
		this.id = id;
	}

	public Student(String firstname, String lastname, Address address, String email) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.email = email;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "first name: " + this.firstname + " Last Name: " + this.lastname+ 
				" Address " + this.address.toString() + " email "+ this.email;
	}

	public void handleUpdate(Scanner scanner) {
		this.printMenu();
		String choice = scanner.nextLine();
		
		if("F".equals(choice)) {
			this.firstname = getStringInfo("Enter new First name", scanner);
			
		}else if("L".equals(choice)) {
			this.lastname = getStringInfo("Enter new last name", scanner);
			
		}else if("A".equals(choice)) {
			this.address.handleUpdate(scanner);
			
		}else if("E".equals(choice)) {
			this.email = getStringInfo("Enter new email", scanner);
		}
	}

	private void printMenu() {
		System.out.println("To Change Firstname enter 'F'");
		System.out.println("To Change Lasrname enter 'L'");
		System.out.println("To Change Address enter 'A'");
		System.out.println("To Change Email enter 'E'");

	}
	
	private  String getStringInfo(String msg, Scanner scanner) {
		System.out.print(msg + ": ");
		return scanner.nextLine();
	}
	
}
