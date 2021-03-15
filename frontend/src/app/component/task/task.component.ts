import { Component, OnInit } from '@angular/core';
import { ConfirmationService, MessageService } from 'primeng/api';
import {Task}         from './../../model/task';
import {TaskService} from './../../service/task.service'

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {
  taskDialog:boolean;
  task: Task;
  selectedProducts: Task[];

  submitted: boolean;
  tasks: Task[] = [];
  constructor(private taskService: TaskService,private messageService: MessageService, 
    private confirmationService: ConfirmationService) { }

  ngOnInit(): void {
    this.listTask();
  }
  openNew() {
    this.task = new Task();
    this.submitted = false;
    this.taskDialog = true;
  }
  listTask(){
    this.taskService.getTasks().then(x => this.tasks = x);  
  }
  editTask(task: Task) {
    this.task = {...task};
    this.taskDialog = true;
  }
  hideDialog() {
    this.taskDialog = false;
    this.submitted = false;
  }
  saveTask() {
    this.submitted = true;

    if (this.task.description.trim()) {
        if (this.task.id) {
          this.taskService.editTask(this.task,this.task.id);
        }
        else {
          this.taskService.addTask(this.task);
        }
        
        this.listTask();
        this.task = new Task();
        this.taskDialog = false;
       
    }
  }

  deleteTask(task: Task){
    console.log(task);
    this.task = {...task};
    this.taskService.deleteTask(this.task.id);
    this.task = new Task();
    this.messageService.add({severity:'success', summary: 'Successful', detail: 'Product Deleted', life: 3000});
    this.listTask();
  }
  
  onCompletedCheckChange(task: Task){
    console.log(task);
    this.task = {...task};  
    this.taskService.editTask(this.task,this.task.id);


  }

  }

  


