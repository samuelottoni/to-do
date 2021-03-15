package br.com.acme.testeaccenture.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.acme.testeaccenture.model.Task;

public interface TaskRepository extends  CrudRepository<Task,Integer>{
 
	List<Task>findAllByOrderByIdAsc();
}
