package com.cts.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cts.model.Employee;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class EmployeeController {
	
	private DataSource dataSource;
	
	public EmployeeController(DataSource dataSource) {
		this.dataSource = dataSource;
	}



	@GetMapping(value = "/batch/employee")
	public @ResponseBody List<Employee> listOfEmployees(){
		log.debug("EmployeeController : listOfEmployees invoked");
		List<Employee> list = new ArrayList<>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		List<Map<String,Object>> empRows = jdbcTemplate.queryForList("select * from Employee");
		
		for(Map<String,Object> e:empRows) {
			Employee emp = new Employee();
			emp.setEmployeeId(Long.valueOf(String.valueOf(e.get("employee_id"))));
			emp.setName(String.valueOf(e.get("name")));
			emp.setPhoneNumber(String.valueOf(e.get("phone_number")));
			emp.setManagerId(Long.valueOf(String.valueOf(e.get("manager_id"))));
		}
		
		return list;
	}
}
