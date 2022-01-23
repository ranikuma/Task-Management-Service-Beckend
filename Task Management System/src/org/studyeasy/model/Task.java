package org.studyeasy.model;

public abstract class Task<T> {
	protected String title;
	protected String creator;
	protected String assignee;
	protected T status;
	protected String dueDate;
	protected String type;
	protected String sprint;

	public Task() {
		sprint = null;
	}

	public Task(String title, String creator, String assignee, T status, String due_date, String type, String sprint) {
		super();
		this.title = title;
		this.creator = creator;
		this.assignee = assignee;
		this.status = status;
		this.dueDate = due_date;
		this.type = type;
		this.sprint = sprint;
		System.out.println("[TASK] " + title);
		System.out.println("[TASK] " + creator);
		System.out.println("[TASK] " + assignee);
		System.out.println("[TASK] " + status);
		System.out.println("[TASK] " + due_date);
	}

	public void updateStatus(T status) {
		this.status = status;
	}

	public void updateAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getAssignee() {
		return this.assignee;
	}

	public String getTitle() {
		return title;
	}

	public String getType() {
		return type;
	}

	public T getStatus() {
		return status;
	}

	public String getSprint() {
		return sprint;
	}

	public void setSprint(String sprint) {
		this.sprint = sprint;
	}

	public String getDueDate() {
		return dueDate;
	}
}
