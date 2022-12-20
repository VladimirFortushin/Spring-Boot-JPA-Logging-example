package com.example.demo1;

import com.example.demo1.models.Person;
import com.example.demo1.repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}
	final Logger logger = LoggerFactory.getLogger(Demo1Application.class);
	@Bean
	public CommandLineRunner demo(PersonRepository personRepository){
		return x -> {
			personRepository.save(new Person("Vladimir", 29));
			personRepository.save(new Person("Ekatik", 26));
			personRepository.save(new Person("Olga", 49));


			logger.info("Person found with findAll():");
			logger.info("-----------------------");
			for(Person person : personRepository.findAll()){
				logger.info(person.toString());
			}
			logger.info("");

			Person person = personRepository.findById(1L);
			logger.info("Person found with findById(1L):");
			logger.info("-----------------------");
			logger.info(person.toString());
			logger.info("");


			logger.info("Person found with findByName(\"Ekatik\"):");
			logger.info("-----------------------");
			personRepository.findByName("Ekatik").forEach(ekatik -> logger.info(ekatik.toString()));

			logger.info("");



		};

	}
}
