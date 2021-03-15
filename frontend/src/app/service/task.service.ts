import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Task}         from './../model/task'

@Injectable({
  providedIn: 'root'
})
export class TaskService {
   BASE_URL:string = 'http://localhost:8080/'
  constructor(private http: HttpClient) {}

  getTasks() {    
    return this.http.get<Task[]>(this.BASE_URL + 'task').toPromise().then(res => <Task[]>res);    
  }
  addTask(payload:Task) {    
    return this.http.post<Task>(this.BASE_URL + 'task',payload).toPromise().then(res => <Task>res);    
  }
  editTask(payload:Task, id:number) {    
    return this.http.put<Task>(this.BASE_URL + 'task/' + id,payload).toPromise().then(res => <Task>res);    
  }
  deleteTask(id:number) {    
    return this.http.delete<Task>(this.BASE_URL + 'task/' + id).toPromise().then(res => <Task>res);    
  }
  

}
