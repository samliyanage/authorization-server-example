package com.sblsoft.auth.server.authserver;

import com.sblsoft.auth.server.authserver.entity.Account;
import com.sblsoft.auth.server.authserver.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class AuthServerApplication {

	@Bean
	CommandLineRunner demo(AccountRepository accountRepository){
		return args ->
				Stream.of("samliyanage,password", "admin,admin", "test,pwd")
				.map(tpl -> tpl.split(","))
				.forEach(tpl-> accountRepository.save(new Account(tpl[0], tpl[1], true)));

	}

	public static void main(String[] args) {
		SpringApplication.run(AuthServerApplication.class, args);
	}
}
