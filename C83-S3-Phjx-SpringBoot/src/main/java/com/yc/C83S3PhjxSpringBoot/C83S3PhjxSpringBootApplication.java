package com.yc.C83S3PhjxSpringBoot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yc.C83S3PhjxSpringBoot.dao")
public class C83S3PhjxSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(C83S3PhjxSpringBootApplication.class, args);
	}

}
