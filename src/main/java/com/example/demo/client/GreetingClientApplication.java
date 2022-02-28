package com.example.demo.client;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
public class GreetingClientApplication {
	
	@Value("${greeting.server.url}")
	String url;
	
	public static void main(String[] args) {
		SpringApplication.run(GreetingClientApplication.class, args);
		try {
			System.out.println("Greeting client stared : "+InetAddress.getLocalHost());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/greet")
	public String sayHello() throws UnknownHostException, InterruptedException{
		System.out.println("Request received at client "+InetAddress.getLocalHost());
		RestTemplate rt = new RestTemplate();
		String g = rt.getForObject(url, String.class);
		return g;
	}

}
