package hibernateFirstAssign;

import java.util.Scanner;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	private String name;
	private String State;
	private String zipCode;
	
	public Address() { /* required empty constructor */}
	
	
	
	public Address(String name, String state, String zipCode) {
		super();
		this.name = name;
		State = state;
		this.zipCode = zipCode;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	@Override
	public String toString() {
		return this.name + ", " + this.State + ", " + this.zipCode;
	}



	public void handleUpdate(Scanner scanner) {
		this.printMenu();
		String choice  = scanner.nextLine();
		
		if("A".equals(choice)) {
			this.name = getStringInfo("Enter new street name", scanner);
		}else if("s".equals(choice)) {
			this.name = getStringInfo("Enter new state", scanner);
		}else if("z".equals(choice)) {
			this.name = getStringInfo("Enter new Zip code", scanner);
		}
	}



	private void printMenu() {
		System.out.println("To Change street address enter 'A'");
		System.out.println("To Change state enter 'S'");
		System.out.println("To Zip Code enter 'Z'");
	}
	
	private  String getStringInfo(String msg, Scanner scanner) {
		System.out.print(msg + ": ");
		return scanner.nextLine();
	}
}
