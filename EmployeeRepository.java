package repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import model.Employee;


public interface EmployeeRepository extends MongoRepository<Employee, String> {
	List<Employee>findAll();
}
