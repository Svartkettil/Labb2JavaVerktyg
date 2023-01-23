package com.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    List<Employee> listEmployee = new ArrayList<>();
    @Override
    public List<Employee> findAll() {
        return listEmployee;
    }

    @Override
    public Employee save(Employee e) {
        listEmployee.add(e);
        return e;
    }
}
