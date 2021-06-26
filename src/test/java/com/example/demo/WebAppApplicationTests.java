package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.controller.HomeController;

@SpringBootTest
class WebAppApplicationTests {
	
	@Autowired
	private HomeController home;

	@Test
	void contextLoads() {
		assertThat(home).isNotNull();	
	}

}
