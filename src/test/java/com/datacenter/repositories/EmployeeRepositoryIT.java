package com.datacenter.repositories;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.datacenter.DataCenterApp;
import com.datacenter.model.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DataCenterApp.class)
@Transactional
public class EmployeeRepositoryIT {

    @Autowired
    private EmployeeRepository repository;

    @Test
    public void testCreateUser() {
        Employee employee = new Employee("Tester", 10000.0);

        assertNull(employee.getIdemployee());

        employee = repository.save(employee);

        assertNotNull(employee.getIdemployee());
        assertTrue(employee.getIdemployee() > 0);
    }

}
