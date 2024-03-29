package com.pmn.gmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class GmtApplication {
	@PostConstruct
	private void setTime() {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
	}
	public static void main(String[] args) {
		SpringApplication.run(GmtApplication.class, args);
	}


}
