package com.bayo.controllertesting.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.HttpStatus.OK;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GoodbyeAcceptanceTest {

	@LocalServerPort
	int randomServerPort;

	private RestTemplate restTemplate;
	private String url;

	@BeforeEach
	void setUp() {
		restTemplate = new RestTemplate();
		url = "http://localhost:" + randomServerPort + "/goodbye";
	}

	@Test
	void shouldGetDefaultGoodbyeMessage() throws Exception {
		ResponseEntity responseEntity = restTemplate.getForEntity( url, String.class );
		assertEquals(OK, responseEntity.getStatusCode());
		assertEquals("Goodbye friend!", responseEntity.getBody());
	}

}
