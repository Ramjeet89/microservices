package com.employee.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class ConsumerControllerClient {

	/*
	 * @Autowired private DiscoveryClient discoveryClient;
	 */

	public void getEmployee() throws RestClientException, IOException {

		/*
		 * List<ServiceInstance> instances =
		 * discoveryClient.getInstances("employee-producer"); ServiceInstance
		 * serviceInstance = instances.get(0);
		 */
		String baseUrl = "http://localhost:8081/employee";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(response.getBody());
	}

	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		return new HttpEntity<>(headers);
	}
}
