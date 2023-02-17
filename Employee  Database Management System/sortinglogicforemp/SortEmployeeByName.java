package com.sortinglogicforemp;

import java.util.Comparator;

import com.jspiders.Employee;


	public class SortEmployeeByName implements Comparator <Employee>
	{@Override
		 public int compare( Employee a,Employee b)
		 {
			 return (a.getName().compareTo(b.getName()));

}
}