package com.jspiders;  
import java.util.Scanner;
import com.customexception.InvalidChoiceException;

public class SolutionEmp 
{
	public static void main(String[] args) 
	{ 
		EmployeeManagementSystem  emp= new EmployeeManagementSystemImpl();
		Scanner sc= new Scanner(System.in);

		System.out.println("Welcome to Employee Database Project");
		System.out.println("-------------------");

    while(true)
    {
		System.out.println("1.Add Employee\n2.Display Employee\n3.Display All Employees\n4.Remove Employee ");
		System.out.println("5.RemoveAll Employees\n6.Update Employee\n7.Count Employees\n8. Sort Employees");
		System.out.println("9.Exit");
		System.out.println("%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("Enter Choice ");
	
		int choice = sc.nextInt();

		switch(choice)
		{
		case 1: emp.addEmployee(); break;
		
		case 2: emp.displayEmployee(); break;
		
		case 3: emp.displayAllEmployees(); break;
		
		case 4: emp.removeEmployee(); break;
		
		case 5: emp.removeAllEmployees(); break;
		
		case 6: emp.updateEmployee();  break;
		
		case 7: emp.countEmployees(); break;
		
		case 8:emp.sortEmployees(); break;
		
		case 9:  System.out.println("Thank you");
			System.exit(0);

		default:
			 try
			 {
				 throw new InvalidChoiceException("Invalid Choice ,Please choose correct choice");
				 
			 }
			 catch(InvalidChoiceException e)
			 {
				 System.out.println(e.getMessage());
			 }
			 System.out.println("$$$$$$$$$$$$$$$");
			 
		}	 
		System.out.println("============");
    }		

	}

}
