package com.abc.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.abc.controller.IStudentController;
import com.abc.factory.StudentControllerFactory;
import com.abc.pojo.Student;

public class MainApp {

	public static void main(String[] args) {
		Scanner scanner = null;
		String name,age,address,id = null;
		String status =null;
		IStudentController studentController=null;
		Student stdRecord = null;
		BufferedReader br = null;
		InputStreamReader isr = null;

		while(true) {
			System.out.println("Welcome to our Application");
			System.out.println("1. CREATE");
			System.out.println("2. READ");
			System.out.println("3. UPDATE");
			System.out.println("4. DELETE");
			System.out.print("Please enter your choice:");
			scanner = new Scanner(System.in);
			int option = scanner.nextInt();
			

			switch(option) {
			case 1: 
				
				//Collecting the inputs
				System.out.print("Enter the name::");
				name = scanner.next();
				System.out.print("Enter the age::");
				age = scanner.next();
				System.out.print("Enter the address::");
				address = scanner.next();

				//Sending the data to the controller using POJO
				Student student = new Student();
				student.setSname(name);
				student.setSage(Integer.parseInt(age));
				student.setSaddress(address);


				//Pure Abstraction(hiding the internal just exposing the service name)
				studentController = StudentControllerFactory.getController();
				status = studentController.save(student);
				System.out.println(status);

				break;
				
			case 2:
				
				//Collecting the inputs
				System.out.println("Enter the id::");
				id=scanner.next();
				//Pure Abstraction(hiding the internal just exposing the service name)
				studentController = StudentControllerFactory.getController();
				//Invoking the controller to get the service
				stdRecord = studentController.getById(Integer.parseInt(id));
				if(stdRecord !=null) 
					System.out.println(stdRecord);
				else 
					System.out.println("Record not available for the given id:: "+id);

				break;
				
			case 3:
				
				System.out.print("Enter the id:: ");
				id = scanner.next();

				// Pure Abstraction(hiding the internal just exposing the service name)
				studentController = StudentControllerFactory.getController();

				// Invoking the controller to get the service
				stdRecord = studentController.getById(Integer.parseInt(id));

				if (stdRecord != null)  {
                    try {
					//Collecting the input for updating the record
					System.out.print("CurrentName is :: " + stdRecord.getSname() + ",  Enter the newName : ");
					br = new BufferedReader(new InputStreamReader(System.in));
					String newName = br.readLine();
					
					System.out.print("CurrentAddress is :: " + stdRecord.getSaddress() + ",  Enter the newAddress: ");
					
					br = new BufferedReader(new InputStreamReader(System.in));
					String newAddress = br.readLine();

					System.out.print("CurrentAge is :: " + stdRecord.getSage() + ",  Enter the newAge: ");
					//String newAge = scanner.next();
					br = new BufferedReader(new InputStreamReader(System.in));
					String newAge = br.readLine();

					// Sending the updated POJO object details for Controller
					Student newStudent = new Student();


					//Setting SID value to the POJO object
					newStudent.setSid(stdRecord.getSid());

					// Perform validation based on the input provided by the user for name
					if (newName.equals("") || newName == null) {
						newStudent.setSname(stdRecord.getSname());
					} else {
						newStudent.setSname(newName);
					}

					// Perform validation based on the input provided by the user for age
					if (newAge.equals("") || newAge == null) {
						newStudent.setSage(stdRecord.getSage());
					} else {
						newStudent.setSage(Integer.parseInt(newAge));
					}

					// Perform validation based on the input provided by the user for address
					if (newAddress.equals("") || newAddress == null) {
						newStudent.setSaddress(stdRecord.getSaddress());
					} else {
						newStudent.setSaddress(newAddress);
					}

					System.out.println(newStudent);
					status = studentController.updateById(newStudent);
					System.out.println(status);
				}catch(IOException ie) {
					ie.printStackTrace();
				}
				}

				else
					System.out.println("Record not available for the updation " + id);

				break;
			case 4: 
				//Collecting the inputs
				System.out.println("Enter the id::");
				id=scanner.next();
				//Pure Abstraction(hiding the internal just exposing the service name)
				studentController = StudentControllerFactory.getController();

				//Invoking the controller to get the service
				status = studentController.deleteById(Integer.parseInt(id));
				System.out.println(status);
				break;

			default:
				System.out.print("Thanks for using the application");
				System.exit(0);
			}
		}

	}

}
