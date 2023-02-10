package com.jpasupport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan({"any package can mention here", "com.in28minutes.springboot.basics.springbootin10steps","com.in28minutes.springboot.somethingelse"})
public class JpaHelperApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaHelperApplication.class, args);
	}

}
