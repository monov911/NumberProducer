package com.example.numberProducer;

import com.example.numberProducer.sender.RandomNumberSender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootApplication
public class NumberProducerApplication {


	public static void main(String[] args) throws URISyntaxException, IOException {
		SpringApplication.run(NumberProducerApplication.class, args);
		RandomNumberSender randomNumberSender = new RandomNumberSender();
		randomNumberSender.execute();

	}

}
