package org.studyeasy.model;

public class Feature<F> extends Task<F>{
	private String featureSummary;
	private Impact impact;
//	private F type;
	public Feature(String title, String creator, String assignee, F status, String due_date, String type, String sprint, String featureSummary, Impact impact) {
		super(title, creator, assignee, status, due_date, type, sprint);
		this.featureSummary = featureSummary;
		this.impact = impact;
		System.out.println("[FEATURE] "+featureSummary);
		System.out.println("[FEATURE]"+impact);
		System.out.println("\n\n");
	}
	@Override
	public String toString() {
		return "Feature [featureSummary=" + featureSummary + ", impact=" + impact + "]";
	}
	
	
	
	
}
