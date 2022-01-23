package org.studyeasy.model;

public class Subtrack<B> {
	String title;
	trackStatus status;
	Task<B> task;
	public Subtrack(String title, trackStatus status, Task<B> task) {
		super();
		this.title = title;
		this.status = status;
		this.task = task;
		System.out.println("[SUBTRACK] "+title);
		System.out.println("[SUBTRACK] "+status);
		System.out.println("[SUBTRACK] "+task);
		System.out.println("\n\n");
	}
	public void updateStatus(trackStatus status) {
		this.status = status;
	}
	public String getTitle() {
		return title;
	}
}
