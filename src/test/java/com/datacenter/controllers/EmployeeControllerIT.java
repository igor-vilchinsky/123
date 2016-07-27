package com.datacenter.controllers;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.datacenter.DataCenterApp;
import com.datacenter.model.Employee;
import com.datacenter.services.EmployeeService;

import io.restassured.RestAssured;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DataCenterApp.class)
@WebAppConfiguration
@WebIntegrationTest({ "server.port=0", "management.port=0" })
@IntegrationTest("server.port:0")
public class EmployeeControllerIT {

    @Autowired
    private EmployeeService employeeService;

    private Employee employee;

    @Value("${local.server.port}") // 6
    int port;

    @Before
    public void setup() throws Exception {
        employee = new Employee("tName", 10000.0);
        employeeService.saveEmployee(employee);

        RestAssured.port = port;

    }

    @Test
    public void returnEmployeeById() {

        given().standaloneSetup(new EmployeeController()).when().get("/employee/" + employee.getIdemployee()).then()
                .statusCode(200).body("name", equalTo("sad")).body("salary", equalTo(10000.0));

    }

}
