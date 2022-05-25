package com.cd.testing.integrationtest;

import com.cd.testing.TestingApplication;
import com.cd.testing.request.EmployeeRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(classes = {TestingApplication.class})
@AutoConfigureMockMvc
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
@TestPropertySource("/application.properties")
class EmployeeIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${application.props}")
    private String value;

    @Value("${server.port}")
    private String server;

    @Test
    void addEmployeeIT() throws Exception{

        EmployeeRequest employeeRequest = new EmployeeRequest();
        employeeRequest.setEmployeeName("Iyyappan");
        employeeRequest.setAge(24);

        String employee = objectMapper.writeValueAsString(employeeRequest);

        mockMvc.perform(MockMvcRequestBuilders.post("/addEmployee").contentType(MediaType.APPLICATION_JSON_VALUE).content(employee))

                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.employeeName", Matchers.is("Iyyappan")));


    }


    @Test
    @DatabaseSetup(value = "/datasets/employee.xml", type = DatabaseOperation.CLEAN_INSERT)
    void getEmployeeIT() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/getEmployee").queryParam("id","100"))

                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.employeeName", Matchers.is(value)))
                        .andExpect(MockMvcResultMatchers.header().string("name","app-server"));

        System.out.println(value);
        System.out.println(server);

    }




}
