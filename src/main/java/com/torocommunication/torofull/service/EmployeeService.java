package com.torocommunication.torofull.service;

import com.torocommunication.torofull.entities.Employee;
import com.torocommunication.torofull.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {




        @Autowired
        private EmployeeRepository employeeRepository;

        public List<Employee> getAllEmployees() {
            return employeeRepository.findAll();
        }

        public Employee getEmployeeById(Long id) {
            return employeeRepository.findById(id).orElseThrow(null);
        }

        public Employee addEmployee(Employee employee) {
            return employeeRepository.save(employee);
        }

        public Employee updateEmployee(Long id, Employee employeeDetails) {
            Employee employee = getEmployeeById(id);

            employee.setName(employeeDetails.getName());
            employee.setAddress(employeeDetails.getAddress());
            employee.setAge(employeeDetails.getAge());


            return employeeRepository.save(employee);
        }

        public void deleteEmployee(Long id) {
            Employee employee = getEmployeeById(id);
            employeeRepository.delete(employee);
        }


    public Employee createEmployee(Employee employee) {
           Employee employee1= employeeRepository.save(employee);

           return  employee1;
    }
}
