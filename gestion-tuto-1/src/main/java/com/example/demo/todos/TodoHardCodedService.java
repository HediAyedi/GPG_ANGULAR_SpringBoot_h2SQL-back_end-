package com.example.demo.todos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class TodoHardCodedService {
	private static List<Todo> todos = new ArrayList();
	private static long idCounter = 0;
	
	
	static {
		todos.add(new Todo(++idCounter,"in28","learn to dance",new Date(),false));
		todos.add(new Todo(++idCounter,"in28","learn to sleep",new Date(),false));
		todos.add(new Todo(++idCounter,"in28","learn to eat",new Date(),false));
		todos.add(new Todo(++idCounter,"in28","learn to angular",new Date(),false));
		todos.add(new Todo(++idCounter,"in28","learn to angular2",new Date(),false));


		
	}
	public List<Todo> findAll(){
		return todos;
	}
	public Todo deleteById(long id) {
		Todo todo = findById(id);
		if(todo==null) return null;
		if(todos.remove(todo)) {
		return todo;
		}
		return null;
	}
	
	public Todo save(Todo todo) {
		if (todo.getId()==-1  ||todo.getId()==0) {
			todo.setId(++idCounter);
			todos.add(todo);
		}else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
	
	
	Todo findById(long id) {
		// TODO Auto-generated method stub
		for(Todo todo:todos) {
			if(todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
}
