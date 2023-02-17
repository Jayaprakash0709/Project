package com.sortinglogicforemp;

import java.util.Comparator;
import com.jspiders.Employee;


	public class SortEmployeeBySalary implements Comparator <Employee>
	{@Override
		 public int compare( Employee a,Employee b)
		 {
			 return (a.getSalary().compareTo(b.getSalary()));
		 }

}
