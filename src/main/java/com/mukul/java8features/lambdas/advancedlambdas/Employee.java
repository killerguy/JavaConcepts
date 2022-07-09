package com.mukul.java8features.lambdas.advancedlambdas;

/**
 * Class to demonstrate the usage of constructor references
 */
public class Employee {

	public Employee(int id) {
		// Logic for creating an employee with an id
	}

	public Employee(int id, String name) {
		// Logic for creating an employee with an id and name.
	}

	interface EmployeeById {
		public Employee create(int id);
	}

	interface EmployeeByName {
		public Employee create(int id, String employee);
	}
	
	public void normalLambdaExpressions(){
		// Lambda invoking the first constructor - no const refs
		EmployeeById empLambda = id -> new Employee(id);

		// Lambda invoking the second constructor - no const refs
		EmployeeByName empNameLambda = 
		  (id, name) -> new Employee(id, name);
	}
	
	/**
	 * Lambdas with constructor references
	 */
	public void constructorReferencedLambdas(){
		// Both have the same constructor reference

		// Constructor reference invocation for first constructor
		EmployeeById empLambdaConstRef = Employee::new;
		// Constructor reference invocation for second constructor
		EmployeeByName empNameLambdaConstRef = Employee::new;

	}
}
