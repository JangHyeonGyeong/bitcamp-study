package com.bitcamp.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@Controller
@EnableTransactionManagement

public class DemoApplication {

	public static void main(String[] args) {
		System.out.println(" 테스트 프로젝트!");
		SpringApplication.run(DemoApplication.class, args);
	}







	public static void main(String[] args) {
		System.out.println("비트캠프 프로젝트!");
		SpringApplication.run(App.class, args);
	}

	@GetMapping("/")
	public String welcome() {
		return "welcome";
	}

}
