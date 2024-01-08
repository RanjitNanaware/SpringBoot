package com.jsp.springboot_employee_pejm16.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsp.springboot_employee_pejm16.dto.Employee;
import com.jsp.springboot_employee_pejm16.service.EmployeeService;
import com.jsp.springboot_employee_pejm16.util.ResponseStructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private EmployeeService employeeService;

    private Employee testEmployee;

    @BeforeEach
    public void setUp() {
        // Create a sample Employee object for testing
        testEmployee = new Employee();
//        testEmployee.setId(1L);
        testEmployee.setName("John Doe");
//        testEmployee.setDepartment("HR");
    }

    @Test
    public void testSaveEmployee() throws Exception {
        // Convert the testEmployee object to JSON
        String jsonEmployee = objectMapper.writeValueAsString(testEmployee);

        // Mock the behavior of the service method
        Mockito.when(employeeService.saveEmployee(Mockito.any(Employee.class)))
               .thenReturn(ResponseEntity.status(HttpStatus.CREATED).body(new ResponseStructure<Employee>()));

        // Perform the POST request and validate the response
        mockMvc.perform(MockMvcRequestBuilders.post("/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonEmployee))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.name").value("John Doe"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.department").value("HR"));
    }
}
