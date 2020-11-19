package com.kriscfoster.controllertesting.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.HttpStatus.OK;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WelcomeControllerAcceptanceTest {

    @LocalServerPort
    int randomServerPort;

    private RestTemplate restTemplate;
    private String url;

    @BeforeEach
    void setUp() {
        restTemplate = new RestTemplate();
        url = "http://localhost:" + randomServerPort + "/welcome";
    }

    @Test
    void shouldGetDefaultWelcomeMessage() throws Exception {
        ResponseEntity responseEntity = restTemplate.getForEntity(url, String.class);
        assertEquals(OK, responseEntity.getStatusCode());
        assertEquals("Welcome Stranger!", responseEntity.getBody());
    }

    @Test
    void shouldGetCustomWelcomeMessage() throws Exception {
        ResponseEntity responseEntity = restTemplate.getForEntity(url + "?name=John", String.class);
        assertEquals(OK, responseEntity.getStatusCode());
        assertEquals("Welcome John!", responseEntity.getBody());
    }
}
