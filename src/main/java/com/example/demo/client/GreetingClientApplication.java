package com.example.demo.client;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class GreetingClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreetingClientApplication.class, args);
	}
	
	@GetMapping("/hello")
	public String sayHello() throws UnknownHostException, InterruptedException{
		Thread.sleep(5000l);
		System.out.println("Request processed successfully at server "+InetAddress.getLocalHost());
		return "Hello @ "+InetAddress.getLocalHost();
	}

}
