package com.financomp.demo;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Import the above-defined classes 
// to use the properties of those 
// classes 
import com.financomp.demo.Store;
import com.financomp.demo.Employee;
import com.financomp.demo.Storeemp;
import com.financomp.demo.CustomUriBuilder;

// Creating the REST controller 
@RestController
@RequestMapping(path = "/employees")
public class Employeecontroller {

    @Autowired
    private Storeemp employeeDao;

    // Implementing a GET method
    // to get the list of all
    // the employees
    @GetMapping(path = "/", produces = "application/json")

    public Store getEmployees() {

        return employeeDao
                .getAllEmployees();
    }

    // Create a POST method
    // to add an employee
    // to the list
    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")

    public ResponseEntity<Object> addEmployee(
            @RequestBody Employee employee) {

        // Creating an ID of an employee
        // from the number of employees
        Integer id = employeeDao
                .getAllEmployees()
                .getEmployeeList()
                .size()
                + 1;

        employee.setId(id);

        employeeDao
                .addEmployee(employee);

        URI location = CustomUriBuilder
                .fromBaseUrl(null)
                .path("/{id}")
                .buildAndExpand(
                        employee.getId())
                .toUri();

        return ResponseEntity
                .created(location)
                .build();
    }
}
