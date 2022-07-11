package com.task2.task2.Controller;

import java.util.Arrays;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.task2.task2.vo.Employee;
import com.task2.task2.vo.EmployeeDto;


@RestController
@RequestMapping(value="task2")
public class Task2Controller {
	private static final String url = "http://localhost:8080/taskCont/getByName?name=";
		
	RestTemplate restTemplate = new RestTemplate();
	
	@GetMapping("getByName")
	public EmployeeDto getByName(@RequestParam String name) {
		
		//Employee emp = restTemplate.getForObject(url+name, Employee.class);
		ParameterizedTypeReference<Employee> typeRef = new ParameterizedTypeReference<Employee>() {};
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Employee> entity = new HttpEntity<Employee>(headers);

		Employee emp = restTemplate.exchange(url+name, HttpMethod.GET, entity, Employee.class).getBody(); 
		
		  EmployeeDto empDto = new EmployeeDto();
		  
		  empDto.setFullName(emp.getFirstName()+" "+emp.getLastName());
		  empDto.setAge(emp.getAge());
		  empDto.setAddress(emp.getAddressLine1()+", "+emp.getAddressLine2()+
		  ", "+emp.getCity()+", "+emp.getState()+", "+emp.getCountry()+", "+emp.
		  getPincode());
		 
		
		return empDto;
	}
}
