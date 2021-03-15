package br.com.acme.testeaccenture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.acme.testeaccenture.model.Task;
import br.com.acme.testeaccenture.model.dto.TaskDTO;
import br.com.acme.testeaccenture.service.TaskService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/task")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@GetMapping
	public ResponseEntity<List<Task>> findAll() {

		return ResponseEntity.ok(taskService.findAll());
	}

	@PostMapping
	public void saveTask(@RequestBody TaskDTO task) {
		taskService.save(task);
	}
	@PutMapping("/{id}")
	public void editTask(@RequestBody TaskDTO task,@PathVariable int id) {
		taskService.edit(task,id);
	}

	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable int id) {
		taskService.delete(id);
	}
}
