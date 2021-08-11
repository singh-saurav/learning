package com.maersk.democlient;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class DemoClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoClientApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return $ -> {
			long end = 0;
			WebClient webClient = WebClient.create("http://localhost:8080/ping");
			ExecutorService executor = Executors.newFixedThreadPool(600);
			OffsetDateTime start = OffsetDateTime.now();
			IntStream.range(1, 601).forEach(i -> {
				executor.submit(() -> {
					String response = webClient.get().retrieve().bodyToMono(String.class).block();
					System.out.println(i + ":: Received response " + response);
				});
			});
			executor.shutdown();
			while (!executor.isTerminated()) {
				end = Duration.between(start, OffsetDateTime.now()).toSeconds();
			}
			System.out.println("Time Taken To Complete :: " + end + " secs");
		};
	}

}
