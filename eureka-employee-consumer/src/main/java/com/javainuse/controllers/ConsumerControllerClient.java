package com.javainuse.controllers;

import java.io.IOException;

import com.javainuse.model.Employee;
import com.javainuse.services.RemoteCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestClientException;

@Controller
public class ConsumerControllerClient {

//	@Autowired
//	private LoadBalancerClient loadBalancer;

	@Autowired
	private RemoteCallService loadBalancer;
	
	public void getEmployee() throws RestClientException, IOException {
		
//		ServiceInstance serviceInstance = loadBalancer.choose("employee-producer");
//
//		System.out.println(serviceInstance.getUri());
//
//		String baseUrl = serviceInstance.getUri().toString();
//
//		baseUrl = baseUrl + "/employee";
//
//		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<String> response = null;
//		try {
//			response = restTemplate.exchange(baseUrl,
//					HttpMethod.GET, getHeaders(), String.class);
//		} catch (Exception ex) {
//			System.out.println(ex);
//		}
//
//		System.out.println(response.getBody());
		try {
			Employee emp = loadBalancer.getData();
			System.out.println(emp.getEmpId());
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

//	private static HttpEntity<?> getHeaders() throws IOException {
//		HttpHeaders headers = new HttpHeaders();
//		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
//		return new HttpEntity<>(headers);
//	}
}