package hibernateFirstAssign;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import studentDao.StudentDao;

public class Main {

	static StudentDao studentDao;
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("springHibernate.cfg.xml");

		printMainMenu();

		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();

		studentDao = context.getBean("studentDao",StudentDao.class);
		
		while(!"Q".equals(input)) {
			
			if("A".equals(input)) {
				addNewStudent(scanner);
			
			}else if("G".equals(input)) {
				System.out.println("To Get student please enter student id:");
				studentDao.getStudent(scanner);
			}else if("D".equals(input)) {
				studentDao.deleteStudent(scanner);
			}else if("U".equals(input)) {
				studentDao.updateStudent(scanner);
			}
			
			printMainMenu();
			input = scanner.nextLine();
			
		}
		
		System.out.println("Goodbye!");
		

	}




	private static void printMainMenu() {
		System.out.println("Welcome to hibernate School, To add a student Enter 'A' ");
		System.out.println("Welcome to hibernate School, To Get a student Enter 'G' ");
		System.out.println("Welcome to hibernate School, To Delete a student Enter 'D' ");
		System.out.println("Welcome to hibernate School, To Update a student Enter 'U' ");
		System.out.println("Welcome to hibernate School, To Quit Enter 'Q' ");

	}



	private static void addNewStudent(Scanner scanner) {
		System.out.println("To Add a new Student, please enter Student Info");
		
		String firstname = getStringInfo("Please Input Student FirstName", scanner);
		String lastname = getStringInfo("Please Input Student lastname", scanner);
		String street = getStringInfo("Please Input Student Street address", scanner);
		String state = getStringInfo("Please Input Student State", scanner);
		String zipCode = getStringInfo("Please Input Zip code", scanner);
		String email = getStringInfo("Please Input  Email", scanner);

		Address address = new Address(street, state, zipCode);
		Student student = new Student(firstname, lastname, address, email);
		
		studentDao.saveStudent(student);
	}
	
	
	private static String getStringInfo(String msg, Scanner scanner) {
		System.out.print(msg + ": ");
		return scanner.nextLine();
	}


}
