package com.springboot.webdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebDataApplication {

	public static void main(String[] args) {
		//WebCrawler.crawl();
		WebCrawler.jsonMapper();
		SpringApplication.run(WebDataApplication.class, args);

	}

}
