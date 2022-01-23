package org.studyeasy.model;

import java.util.List;

public class Story<S> extends Task<S> {
	private List<Subtrack<S>> subtracks;
	private String storySummary;
	public Story(String title, String creator, String assignee, S status, String due_date, String type, String sprint, List<Subtrack<S>> subtracks, String storySummary) {
		super(title, creator, assignee, status, due_date, type, sprint);
		this.subtracks = subtracks;
		this.storySummary = storySummary;
		System.out.println("[STORY] "+subtracks);
		System.out.println("[STORY] "+storySummary);
		System.out.println("\n\n");
	}
	public List<Subtrack<S>> getSubtracks(){
		return subtracks;
	}
	@Override
	public String toString() {
		return "Story [subtracks=" + subtracks + ", storySummary=" + storySummary + "]";
	}
	
	
}
