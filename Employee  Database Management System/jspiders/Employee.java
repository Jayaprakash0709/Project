package com.jspiders;

public class Employee {
	
	 private String empid;
	  private String name;
	  private int age;
	  private Double salary;
	  
	  static int count=101;
	 public  Employee(String name,int age, Double salary)
	 {
		 this.empid="JSP"+count++;
		 this.age=age;
		 this.name=name;
		 this.salary=salary;
	 }
	 public String  getEmpId()
	 {
		 return empid;
	 }
	 
	public void setAge(int age)
	{ 
		this.age=age;	
	}
	 public  int getAge()
	 {
		 return age;
	 }
	 public void setName(String name)
	 {
		 this.name=name;
	 }
	 public String  getName()
	 {
		 return name;
	 }
	  public void setSalary(Double salary)
	  {
		  this.salary=salary;
	  }
	  public Double getSalary()
	  {
		  return salary;
	  }
	@Override
	public String toString() {
		System.out.println("********************");
		return " empid=" + empid + "\n name=" + name + "\n age=" + age + "\n salary=" + salary;
	}
	 
	}



