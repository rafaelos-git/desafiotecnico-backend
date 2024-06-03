package br.com.sicredi.desafio_rafael;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DesafioRafaelApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioRafaelApplication.class, args);
	}

}
