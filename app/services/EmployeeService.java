package services;

import play.*;
import play.mvc.*;
import play.db.jpa.*;

import java.util.List;

import models.Employee;

public class EmployeeService {
    /**
     * Create an employee
     *
     * @param Employee data
     *
     * @return Employee
     */
    public static Employee create(Employee data) {
        return CoreServices.create(data);
    }

    /**
     * Update an employee
     *
     * @param Employee data
     *
     * @return Employee
     */
    public static Employee update(Employee data) {
        return CoreServices.update(data);
    }

    /**
     * Find an employee by id
     *
     * @param Integer id
     *
     * @return Employee
     */
    public static Employee find(Integer id) {
        return CoreServices.find(Employee.class,id);
    }

    /**
     * Delete an employee by id
     *
     * @param Integer id
     */
    public static Boolean delete(Integer id) {
        Employee employee = CoreServices.find(Employee.class,id);
        if (employee != null) {
            CoreServices.delete(Employee.class,id);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get all employees
     *
     * @return List<Employee>
     */
    public static List<Employee> all() {
        return CoreServices.all(Employee.class);
    }

    /**
     * Get the page of employees
     *
     * @param Integer page
     * @param Integer size
     *
     * @return List<Employee>
     */
    public static List<Employee> paginate(Integer page, Integer size) {
        return CoreServices.paginate(Employee.class,page, size);
    }

    /**
     * Get the number of total of employees
     *
     * @return Long
     */
    public static Long count() {
        return CoreServices.count(Employee.class);
    }
}