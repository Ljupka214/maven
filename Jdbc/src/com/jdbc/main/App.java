package com.jdbc.main;

import com.jdbc.dao.StudentDAO;
import com.jdbc.dao.StudentDAOImpl;
import com.jdbc.model.Student;

public class App {

	public static void main(String[] args) {
		StudentDAO studentDAO = new StudentDAOImpl();
		System.out.println(studentDAO.findAll());
		
		studentDAO.insert(new Student("Ѓоре", "Ѓорев"));
		System.out.println(studentDAO.findById(3));

		System.out.println(studentDAO.deleteById(3));
		
		System.out.println(studentDAO.update(new Student(8, "Перо", "Ѓорев")));
		System.out.println(studentDAO.findAll());

		
	}

}
