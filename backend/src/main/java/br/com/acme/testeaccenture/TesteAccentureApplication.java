package br.com.acme.testeaccenture;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.acme.testeaccenture.model.Task;
import br.com.acme.testeaccenture.repository.TaskRepository;
import br.com.acme.testeaccenture.service.TaskService;

@SpringBootApplication
public class TesteAccentureApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteAccentureApplication.class, args);
	}
	
	   @Bean
	    CommandLineRunner init(TaskRepository taskRepository) {
	        return args -> {
	        	Task task =  new Task();
	        	task.setCompleted(false);
	        	task.setDescription("Qualquer tarefa");
	        	taskRepository.save(task);
	        	task =  new Task();
	        	task.setDescription("tarefa 2");
	        	taskRepository.save(task);
	        };
	    }

}
