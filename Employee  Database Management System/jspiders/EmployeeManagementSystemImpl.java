package com.jspiders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.customexception.InvalidChoiceException;
import com.customexception.EmployeeNotFoundException;
import com.sortinglogicforemp.SortEmployeeByAge;
import com.sortinglogicforemp.SortEmployeeByEmpId;
import com.sortinglogicforemp.SortEmployeeBySalary;
import com.sortinglogicforemp.SortEmployeeByName;


/**  
 * 
 * @author JAYAPRAKASH
 * @since   2022
 * 
 * We are  adding   implementation for 8 Abstract methods EmployeeManagementSystem
 */



public class EmployeeManagementSystemImpl implements EmployeeManagementSystem 
{

	Map<String,Employee> db= new LinkedHashMap<String,Employee>();
	Scanner sc=new Scanner(System.in); 


	@Override
	public void  addEmployee() 
	{  
	System.out.println("Enter the name: ");
	String name=sc.next();
	System.out.println("Enter the age: ");
	int age= sc.nextInt();
	System.out.println("Enter the salary: ");
	Double salary=sc.nextDouble();

	Employee s= new Employee(name,age,salary);
	db.put(s.getEmpId(),s);																	
	System.out.println("Employee Record  Inserted Successfully");
	System.out.println("Your Employee Id is "+s.getEmpId());
	}


	@Override
	public void displayEmployee()
	{
		System.out.println("Enter the Emp ID  to Display: ");
		String id=sc.next();

		id.toUpperCase();
		if(db.containsKey(id))
		{
			// System.out.println(db.get(id));  optional  (or)  below format

			Employee obj=db.get(id);
			System.out.println("EmpId: "+obj.getEmpId());
			System.out.println("Name: "+obj.getName());
			System.out.println("Age: "+obj.getAge());
			System.out.println("Salary: "+obj.getSalary());
		}
		else
			try
		{
				throw new EmployeeNotFoundException ("Given Employee Record is not Available to Display");
		}
		catch(Exception e) 
		{
			System.out.println(e.getMessage());
		}

	}
	@Override
	public void displayAllEmployees()
	{
		Set <String> keys=db. keySet();
		System.out.println("Employee Records are as Follows: ");
		System.out.println("---------------------------");
		if(db.size()!=0)
		{
			for(String key:keys)
			{
				System.out.println(db.get(key));    // printing reference variable	
			}
		}
		else	
		{  try
		{
			throw new EmployeeNotFoundException ("Employee Record not Available to Display");
		}
		catch(Exception e) 
		{
			System.out.println(e.getMessage());
		}
		}			

	}
	@Override
	public void removeEmployee()
	{
		System.out.println("Enter the Employee Id: ");
		String id= sc.next().toUpperCase();

		//  or	id.toUpperCase();

		if (db.containsKey(id))
		{   
			db.remove(id);
			System.out.println("Employee Record are Deleted Successfully");
		}
		else
		{
			try
			{
				throw new  EmployeeNotFoundException("Employee Records are Not Found");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}

		}






	}
	@Override
	public void removeAllEmployees()
	{
		System.out.println(db.size()+" Employee Records are Available");
		db.clear();
		System.out.println("Employees Records are  Deleted Successfully");

	}
	@Override
	public void updateEmployee()
	{
		System.out.println("Enter the Employee Id: ");
		String id= sc.next().toUpperCase();
		if(db.containsKey(id))
		{
			Employee std=db.get(id);
			System.out.println("1.Update Name\n2.Update Age\n3.Update Salary");
			System.out.println("Enter Choice: ");
			int choice=sc.nextInt();
			switch (choice)
			{
			case 1: System.out.println("Enter Name: ");
			String name=sc.next();
			std.setName(name); 			 // std.setName(sc.next());
			System.out.println("Name Updated Successfully");
			break;

			case 2:	 System.out.println("Enter Age: ");
			int age=sc.nextInt();
			std.setAge(age);
			System.out.println("Age Updated Successfully");
			break;

			case 3:	 System.out.println("Enter Salary ");
			Double salary=sc.nextDouble();
			std.setSalary(salary);
			System.out.println("Salary Updated Successfully");
			break;	

			default:
				try
				{
					throw new InvalidChoiceException("Invalid Choice");
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}

			}
		}		
		else {
			try
			{
				throw new  EmployeeNotFoundException("Employee Records are Not Found");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}

		}	
	}
	@Override
	public void countEmployees()
	{
		System.out.println(" Total Employees are "+ db.size());
	}
	@Override
	public void sortEmployees()
	{

		/**
		 * Converting   Map into Set
		 * keys  are Employee Id and datatype is String
		 */

		Set <String> set= db.keySet();    //  JSP101    JSP102
		/**
		 *  Achieving Upcasting between List & ArrayList
		 *  list can store Employee objects.
		 */

		List<Employee> l= new ArrayList<Employee>();

		for(String key:set)
		{
			l.add(db.get(key));   // Adding Employee objects  from Map to List .
		}

		System.out.println("1.SortEmployeeByID\n2.SortEmployeeByName\n3.SortEmployeeByAge\n4.SortEmployeeBySalary");
		int choice = sc.nextInt();

		switch(choice)
		{
		case 1: Collections.sort(l,new SortEmployeeByEmpId()); 
		display(l);
		System.out.println("----------");
		break;

		case 2: Collections.sort(l,new SortEmployeeByName());
		display(l);
		System.out.println("----------");
		break;

		case 3: Collections.sort(l, new SortEmployeeByAge());   
		display(l);
		System.out.println("----------");
		break;


		case 4:Collections.sort(l, new SortEmployeeBySalary());  
		display(l);
		System.out.println("----------");
		break;

		default : 
			try
			{
				throw new InvalidChoiceException("Invalid choice,Please choose coorect choice");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	private static void display(List<Employee> l)
	{		for(Employee s:l)
	{
		System.out.println(s);
	}
	}
}

