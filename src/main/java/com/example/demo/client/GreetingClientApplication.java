package com.example.demo.client;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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
	
	String randomName;
	
	public static void main(String[] args) {
		SpringApplication.run(GreetingClientApplication.class, args);
		try {
			System.out.println("Greeting client stared : "+InetAddress.getLocalHost());
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/greet")
	public Map<String, String> sayHello() throws UnknownHostException, InterruptedException{
		System.out.println("Request received at client "+InetAddress.getLocalHost());
		RestTemplate rt = new RestTemplate();
		Map<String, String> map = new HashMap<>();
		String endPointUrl = url+"/greet";
		String g = rt.getForObject(endPointUrl, String.class);
		map.put("greetingMessage", g);
		if(randomName == null) 
		{
			randomName = names[new Random().nextInt(names.length - 1)];
		}
		System.out.println("Today's hero (greeting client) : "+randomName);
		return map;
	}
	
	String[] names = {"Subhas Chandra Bose", 
						"Bhagat Singh",
						"Sardar Vallabhbhai Patel",
						"Rani Lakshmibai",
						"Bal Gangadhar Tilak",
						"Lala Lajpat Rai",
						"Chandrashekhar Azad",
						"Mangal Pandey",
						"Madam Bhikaji Cama",
						"Kittur Chennamma",
						"Kamaladevi Chattopadhyay",
						"Shri Ram",
						"Shri Krishna",
						"Deveki Nandan"
					 };
}
