package com.task1.task1.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.task1.task1.vo.Employee;

@RestController
@RequestMapping(value="taskCont")
public class TaskController1 {
	private Map<String, Employee> map = new HashMap<>();
	ObjectMapper mapper = new ObjectMapper();
	
	@GetMapping("getByName")
	public Employee getByName(@RequestParam String name) {
		String strJson = "{\"firstName\":\"Akshay\",\"lastName\":\"Kolla\",\"age\":\"26\",\"addressLine1\":\"Raghu road\",\"addressLine2\":\"RL Nagar\",\"state\":\"Andhrapradesh\",\"country\":\"India\",\"city\":\"Vijayawada\",\"pincode\":\"520013\"}";
		/*
		 * Employee emp = new Employee(); emp.setFirstName("Akshay");
		 * emp.setLastName("Kolla"); emp.setAge(26); emp.setAddressLine1("Raghu road");
		 * emp.setAddressLine2("RL Nagar"); emp.setCity("Vijayawada");
		 * emp.setState("Andhra pradesh"); emp.setCountry("India");
		 * emp.setPincode(520013);
		 * 
		 * map.put(emp.getFirstName(), emp);
		 * 
		 * Employee emp1 = new Employee(); emp1.setFirstName("Kishore");
		 * emp1.setLastName("Kadapa"); emp1.setAge(31);
		 * emp1.setAddressLine1("Venkachalam road");
		 * emp1.setAddressLine2("Shanti Nagar"); emp1.setCity("Hyderabad");
		 * emp1.setState("Telangana"); emp1.setCountry("India");
		 * emp1.setPincode(502285);
		 */
		
		try {
			Employee emp = mapper.readValue(strJson, Employee.class);
			System.out.println(emp.toString());
			map.put(emp.getFirstName(), emp);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} 

		return map.get(name);
	}
}
