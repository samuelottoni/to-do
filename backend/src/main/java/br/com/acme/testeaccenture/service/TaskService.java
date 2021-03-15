package br.com.acme.testeaccenture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.acme.testeaccenture.model.Task;
import br.com.acme.testeaccenture.model.dto.TaskDTO;
import br.com.acme.testeaccenture.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	public List<Task> findAll() {

		return taskRepository.findAllByOrderByIdAsc();
	}

	public Task save(TaskDTO taskDTO) {
		Task task = new Task();
		task.setDescription(taskDTO.getDescription());
		task.setCompleted(taskDTO.isCompleted());
				
		return taskRepository.save(task);

	}

	public Task edit(TaskDTO taskDTO, int id) {
		return taskRepository.findById(id).map(x -> {
			x.setDescription(taskDTO.getDescription());
			x.setCompleted(taskDTO.isCompleted());
			return taskRepository.save(x);
		}).orElseGet(() -> this.save(taskDTO));

	}

	public void delete(int id) {
		taskRepository.deleteById(id);
	}

}
