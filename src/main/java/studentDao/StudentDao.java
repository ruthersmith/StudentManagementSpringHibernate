package studentDao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hibernateFirstAssign.Student;

@Repository
public class StudentDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public  void saveStudent(Student student) {
		Session session =  getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(student);
		transaction.commit();
		System.out.println("student saved succesfully");
		session.close();
	}
	
	public  Student getStudent(Scanner scanner) {
		
		Session session =  getSessionFactory().openSession();
		session.beginTransaction();
		
		int id = Integer.parseInt(scanner.nextLine());
		Student student = null;
		student = (Student) session.get(Student.class, id);
		System.out.println(student);
		session.close();
		return student;
	}
	

	public  void deleteStudent(Scanner scanner) {
		System.out.println("To Get Delete please enter student id:");
		
		Session session =  getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		int id = Integer.parseInt(scanner.nextLine());
		session.delete(new Student(id));
		transaction.commit();
		System.out.println("student with id " + id + " deleted");
	}
	
	public  void updateStudent(Scanner scanner) {
		System.out.println("To Get Update please enter student id:");
		Student student = getStudent(scanner);
		
		Session session =  getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		student.handleUpdate(scanner);
		session.update(student);
		transaction.commit();
		System.out.println("student updated successfully");
	}

	
	
}
