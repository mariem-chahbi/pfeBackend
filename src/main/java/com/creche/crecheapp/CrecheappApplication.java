package com.creche.crecheapp;

import com.creche.crecheapp.typefile.service.FileStorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class CrecheappApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CrecheappApplication.class, args);
	}
	@Resource
	FileStorageService storageService;
	@Override
	public void run(String... args) throws Exception {
		storageService.init();

	}
}
