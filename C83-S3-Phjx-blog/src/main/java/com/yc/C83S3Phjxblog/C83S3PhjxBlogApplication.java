package com.yc.C83S3Phjxblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yc.C83S3Phjxblog.dao")
public class C83S3PhjxBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(C83S3PhjxBlogApplication.class, args);
	}

}
