package com.game.controller;

import java.net.URL;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SortControllerTest {

	@LocalServerPort
    private int port;
	
	@Autowired
    private TestRestTemplate restTemplate;
	
	
	@Test
	public void sortGames() throws Exception {
		ResponseEntity<String> response = restTemplate.getForEntity(
				new URL("http://localhost:" + port + "/sortgames").toString(), String.class);
		Assertions.assertEquals(response.getStatusCodeValue(), 200);
	}
	
	@Test
	public void displayInputFile() throws Exception {
		ResponseEntity<String> response = restTemplate.getForEntity(
				new URL("http://localhost:" + port + "/displayinput").toString(), String.class);
		Assertions.assertEquals(response.getStatusCodeValue(), 200);
	}
	
}
