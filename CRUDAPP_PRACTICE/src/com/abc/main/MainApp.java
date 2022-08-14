package com.abc.main;

import java.util.Scanner;

import com.abc.controller.IStudentController;
import com.abc.factory.StudentControllerFactory;
import com.abc.pojo.Student;

public class MainApp {

	public static void main(String[] args) {
	Scanner scanner = null;
	String name,age,address =null;
	
		while(true) {
			System.out.println("Welcome to my Application");
			System.out.println("1.CREATE");
			System.out.println("2.READ");
			System.out.println("3.UPDATE");
			System.out.println("4.DELETE");
			System.out.println("Please enter your choice...");
			scanner = new Scanner(System.in);
			int option = scanner.nextInt();
			switch(option) {
			case 1:
				System.out.println("Enter the name::");
				name=scanner.next();
				System.out.println("Enter the age::");
				age=scanner.next();
				System.out.println("Enter the address::");
				address=scanner.next();
				
				//Sending the data to the controller using POJO
				Student student = new Student();
				student.setSname(name);
				student.setSage(Integer.parseInt(age));
				student.setSaddress(address);
				
				//Pure abstraction(hiding the internal logic just exposing the service name)
				IStudentController studentController = StudentControllerFactory.getController();
				String status = studentController.save(student);
				System.out.println(status);
				
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			default:
				System.out.println("Invalid choice please try again");
				scanner.close();
			}
			
		}
		

	}

}
