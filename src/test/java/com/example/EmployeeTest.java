package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    Employee employee;
    @BeforeEach
    void init(){
        employee = new Employee("1", 200);
    }

    @Test
    void setId() {
        employee.setId("2");
        assertThat(employee.getId()).isEqualTo("2");
    }

    @Test
    void setSalary() {
        employee.setSalary(300);
        assertThat(employee.getSalary()).isEqualTo(300);
    }

    @Test
    void isPaid() {
        assertFalse(employee.isPaid());
    }

    @Test
    void setPaidTrue() {
        employee.setPaid(true);
        assertTrue(employee.isPaid());
    }

    @Test
    void testToString() {
        assertThat("Employee [id=1, salary=200.0]").isEqualTo(employee.toString());
    }
}