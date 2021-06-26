package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.example.models.Product;

@SpringBootTest
public class ProductServiceTest {
	
	   
	   @Test
	   public void pengPriceTest() throws  Exception {
		   Product peng1 = new Product(1);
		   assertThat(peng1.calPrice(20)).isEqualTo(175);   
	   }
	   
	   @Test
	   public void horsePriceTest() throws Exception{
		   Product horse = new Product(2);
		   assertThat(horse.calPrice(5)).isEqualTo(825);
	   }
	   
}
