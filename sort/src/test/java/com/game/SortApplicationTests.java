package com.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.game.controller.SortController;


@SpringBootTest
class SortApplicationTests {
	
@Autowired
SortController sortController;


	@Test
	void contextLoads() {
		Assertions.assertNotNull(sortController);
	}

}
