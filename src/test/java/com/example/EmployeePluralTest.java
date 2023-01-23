package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.shouldHaveThrown;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.doThrow;

class EmployeePluralTest {
    BankService bankService = Mockito.mock(BankService.class);
    EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    EmployeePlural employees = new EmployeePlural(employeeRepository, bankService);
    Employee harald;
    @BeforeEach
    void init(){
        Employee gunnar = new Employee("1", 300);
        Employee sven = new Employee("2", 310);
        harald = new Employee("3", 200);
        Employee kim = new Employee("4", 400);
        employeeRepository.save(gunnar);
        employeeRepository.save(sven);
        employeeRepository.save(harald);
        employeeRepository.save(kim);
    }
    @Test
    void payEmployees() {
        assertThat(employees.payEmployees()).isEqualTo(4);
    }
    @Test
    void payEmployeesException(){
        harald.setPaid(true);
        doThrow(RuntimeException.class).when(bankService).pay(harald.getId(), harald.getSalary());
        employees.payEmployees();
        assertFalse(harald.isPaid());
    }
}