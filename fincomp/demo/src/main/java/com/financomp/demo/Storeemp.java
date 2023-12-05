package com.financomp.demo;

import org.springframework.stereotype.Repository;

// Importing the employees class to 
// use the defined properties 
// in this class 

@Repository

// Class to create a list
// of employees
public class Storeemp {

    private static Store list = new Store();

    // This static block is executed
    // before executing the main
    // block
    static {

        // Creating a few employees
        // and adding them to the list
        list.getEmployeeList().add(
                new Employee(
                        1,
                        "Arun",
                        "Kumar",
                        "Arunkumar@gmail.com"));

        list.getEmployeeList().add(
                new Employee(
                        2, "goku",
                        "Kakarot",
                        "abc@gmail.com"));

        list.getEmployeeList().add(
                new Employee(
                        3, "vegeta",
                        "prince",
                        "asdjf@gmail.com"));

    }

    // Method to return the list
    public Store getAllEmployees() {

        return list;
    }

    // Method to add an employee
    // to the employees list
    public void addEmployee(Employee employee) {
        list.getEmployeeList()
                .add(employee);

    }
}
