package com.sortinglogicforemp;

import com.jspiders.Employee;

import java.util.Comparator;

	public class SortEmployeeByEmpId implements Comparator <Employee>
	{@Override
		 public int compare( Employee a,Employee b)
		 {
			 return (a.getEmpId().compareTo(b.getEmpId()));
		 }

}
