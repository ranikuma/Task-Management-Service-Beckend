package org.studyeasy.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sprint<S> {
	private List<Task<S>> tasks;

	public Sprint() {
		super();
		this.tasks = new ArrayList<Task<S>>();
	}

	public void addTask(Task<S> task) {
		// TODO Auto-generated method stub
		tasks.add(task);
	}
	public void removeTask(Task<S> task) {
		tasks.remove(task);
	}

	public void displayTasks() {
		// TODO Auto-generated method stub
		Iterator<Task<S>> iterator = tasks.iterator();
		while(iterator.hasNext()) {
			Task<S> task = iterator.next();
			System.out.println("title:  "+task.getTitle()+"\nStatus delayed or on Track: "+task.getStatus());
		}
	}
	
}
