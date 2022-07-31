package com.modern.process;

import com.modern.process.config.xml.SampleAdder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:springAop-applicationContext.xml")
public class DemoApplication implements CommandLineRunner {

	@Autowired
	SampleAdder sampleAdder;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(sampleAdder.add(1,3));
	}
}
