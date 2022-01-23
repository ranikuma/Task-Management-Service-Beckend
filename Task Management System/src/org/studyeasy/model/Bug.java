package org.studyeasy.model;

public class Bug<B> extends Task<B> {
	private Severity severity;

	public Bug(String title, String creator, String assignee, B status, String due_date, String type, String sprint,
			Severity severity) {
		super(title, creator, assignee, status, due_date, type, sprint);
		this.severity = severity;
		System.out.println("[BUG] " + severity);
		System.out.println("\n\n");
	}

	@Override
	public String toString() {
		return "Bug [severity=" + severity + "]";
	}

}
