package com.modern.process;

import com.modern.process.model.Account;
import com.modern.process.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private final AccountRepository accountRepository;

	public DemoApplication(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		accountRepository.save(new Account("user", new BigDecimal(1000)));
		accountRepository.save(new Account("admin", new BigDecimal(1000)));

	}
}
