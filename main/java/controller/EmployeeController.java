package controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


import model.Employee;
import repository.EmployeeRepository;

@Controller
public class EmployeeController {
	@Autowired
	  EmployeeRepository employeeRepository;
	
	@GetMapping("/employees")
	public   ResponseEntity<List<Employee>>getAllEmployees(@RequestParam(required = false) String eid) {
		try {
		    List<Employee> employees = new ArrayList<Employee>();

		    if (eid == null)
		      employeeRepository.findAll().forEach(employees::add);
		    
		    
		    if (employees.isEmpty()) {
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }

		    return new ResponseEntity<>(employees, HttpStatus.OK);
		  } catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	  }

	  @GetMapping("/employees/{eid}")
	  public  ResponseEntity<Employee>  getEmployeelById(@PathVariable("eid") String eid) {
		return null;
	    
	  }

	  @PostMapping("/employees")
	  public  ResponseEntity createEmployee(@RequestBody Employee employee) {
		  try {
			    Employee _employee = employeeRepository.save(new Employee(employee.getEid(), employee.getEname(), employee.getEphone()));
			    return new ResponseEntity<>(_employee, HttpStatus.CREATED);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
		
	  }
	  
	  
}
