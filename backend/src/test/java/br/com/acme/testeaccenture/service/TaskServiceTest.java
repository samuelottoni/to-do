package br.com.acme.testeaccenture.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.acme.testeaccenture.model.dto.TaskDTO;

@SpringBootTest
public class TaskServiceTest {
	
	@Autowired
	private TaskService taskService;
	
	@Test
	void saveTest() throws Exception {
		TaskDTO taskDTO =  new TaskDTO();
		taskDTO.setCompleted(false);
		taskDTO.setDescription("tarefaTeste");    	
    	assertEquals("tarefaTeste", taskService.save(taskDTO).getDescription());
		
	}
	@Test
	void editTest() throws Exception {
		TaskDTO taskDTO =  new TaskDTO();
		taskDTO.setCompleted(false);
		taskDTO.setDescription("tarefaTeste");     
		int id = taskService.save(taskDTO).getId();
		taskDTO.setCompleted(true);		
    	assertEquals(true, taskService.edit(taskDTO,id).isCompleted());
		
	}
	@Test
	void editTestNullID() throws Exception {
		TaskDTO taskDTO =  new TaskDTO();
		taskDTO.setCompleted(false);
		taskDTO.setDescription("tarefaTeste"); 
		taskDTO.setCompleted(true);		
    	assertEquals("tarefaTeste", taskService.edit(taskDTO,0).getDescription());
		
	}
	@Test
	void deleteTest() throws Exception {
		TaskDTO taskDTO =  new TaskDTO();
		taskDTO.setCompleted(false);
		taskDTO.setDescription("tarefaTeste");     
		int id = taskService.save(taskDTO).getId();
		assertDoesNotThrow(() -> taskService.delete(id));
		
	}
	
	

}
