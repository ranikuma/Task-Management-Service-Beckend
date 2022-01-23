package org.studyeasy.service;

//import java.io.StreamCorruptedException;
//import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//import javax.swing.Spring;

import org.studyeasy.model.Bug;
import org.studyeasy.model.Feature;
import org.studyeasy.model.Impact;
import org.studyeasy.model.Severity;
import org.studyeasy.model.Sprint;
import org.studyeasy.model.Story;
import org.studyeasy.model.Subtrack;
import org.studyeasy.model.Task;
import org.studyeasy.model.TaskType;
import org.studyeasy.model.trackStatus;
//import org.studyeasy.service.TaskPlannerService.FeatureTypeTaskStatus;

public class TaskPlannerService {
	String sprint;

	public static enum FeatureTypeTaskStatus implements TaskType {
		Open, InProgress, Testing, Deployed;
	}

	public static enum BugTypeTaskStatus implements TaskType {
		Open, InProgress, Fixed;
	}

	public static enum StoryTypeTaskStatus implements TaskType {
		Open, InProgress, Completed;
	}

	public TaskPlannerService() {
		// Create Task

	}

	// Create Subtrack
	public Subtrack<StoryTypeTaskStatus> createSubtrack(String title, trackStatus status,
			Task<StoryTypeTaskStatus> task) {
		return new Subtrack<StoryTypeTaskStatus>(title, status, task);
	}

	// Create Tasks of any type
	public Feature<? extends TaskType> createTaskService(String title, String creator, String assignee,
			FeatureTypeTaskStatus status, String due_date, String type, String sprint, String featureSummary,
			Impact impact) {
		return new Feature<FeatureTypeTaskStatus>(title, creator, assignee, status, due_date, type, sprint,
				featureSummary, impact);
	}

	public Bug<? extends TaskType> createTaskService(String title, String creator, String assignee,
			BugTypeTaskStatus status, String due_date, String type, String sprint, Severity severity) {
		return new Bug<BugTypeTaskStatus>(title, creator, assignee, status, due_date, type, sprint, severity);
	}

	public Story<? extends TaskType> createTaskService(String title, String creator, String assignee,
			StoryTypeTaskStatus status, String due_date, String type, String sprint,
			List<Subtrack<StoryTypeTaskStatus>> subtracks, String storySummary) {
		return new Story<StoryTypeTaskStatus>(title, creator, assignee, status, due_date, type, sprint, subtracks,
				storySummary);
	}

	// Change the status of task
	public void updateStatusServiceForFeatureType(Task<TaskType> task, TaskType status) {
		task.updateStatus(status);
	}

	// Change the status of subtrack
	public void updateStatusServiceForSubtrack(Subtrack<? extends TaskType> subtrack, trackStatus status) {
		subtrack.updateStatus(status);
	}

	// Change the asignee of tasks
	public void updateStatusServiceForFeatureType(Task<TaskType> task, String assignee) {
		task.updateAssignee(assignee);
	}

	@SuppressWarnings("unchecked")
	public void displayTaskOfAssignedUser(List<Task<? extends TaskType>> tasks, String user, String type) {
		Iterator<Task<? extends TaskType>> iterator = tasks.iterator();
		System.out.println("User=>" + user);
		System.out.println("type=>" + type);
		while (iterator.hasNext()) {
			Task<? extends TaskType> task = iterator.next();
			if (task.getAssignee().equals(user) && task.getType().equals(type)) {
				System.out.println("\tTask Type=>" + task.getType());
				System.out.println("\tTask Title=>" + task.getTitle());
				System.out.println("\tSprint=>" + task.getSprint());
				if (task instanceof Story) {
					System.out.println("\tSubtrack");
					Iterator<Subtrack<StoryTypeTaskStatus>> iterator1 = ((Story<StoryTypeTaskStatus>) task)
							.getSubtracks().iterator();
					while (iterator1.hasNext())
						System.out.println(iterator1.next().getTitle());
				}
			}
		}

	}

	// Sprint
	public void createSprint(String sprintName) {
		this.sprint = sprintName;
	}

	public void addTaskFromSprint(String sprint, Task<TaskType> task) {
		task.setSprint(sprint);
	}

	public void removeTaskFromSprint(Sprint<TaskType> sprint, Task<TaskType> task) {
		task.setSprint(null);
	}

	public void displayTasksInSprint(List<Task<? extends TaskType>> tasks, String sprint) {
		Iterator<Task<? extends TaskType>> iterator = tasks.iterator();
		List<String> onTrackTasks = new ArrayList<String>();
		List<String> dueTask = new ArrayList<String>();
		System.out.println("Sprint title=>" + sprint);
		while (iterator.hasNext()) {
			Task<? extends TaskType> task = iterator.next();
			if (task.getSprint() == null)
				continue;
			if (!(task.getSprint().equals(sprint)))
				continue;
			SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date curDate = new java.util.Date();
			java.util.Date taskDueDate = null;
			try {
				curDate = dateFormater.parse(dateFormater.format(curDate));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				taskDueDate = dateFormater.parse(task.getDueDate());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if ((curDate.compareTo(taskDueDate) > 0) && (task.getStatus() == FeatureTypeTaskStatus.Open
					|| task.getStatus() == FeatureTypeTaskStatus.InProgress
					|| task.getStatus() == FeatureTypeTaskStatus.Testing || task.getStatus() == BugTypeTaskStatus.Open
					|| task.getStatus() == BugTypeTaskStatus.InProgress || task.getStatus() == StoryTypeTaskStatus.Open
					|| task.getStatus() == StoryTypeTaskStatus.InProgress)) {
				dueTask.add(task.getTitle());
			} else {
				onTrackTasks.add(task.getTitle());
			}
		}
		System.out.println("On Track Tasks");
		for (String str : onTrackTasks) {
			System.out.println("\t" + str);
		}
		System.out.println("Delayed Tasks");
		for (String str : dueTask) {
			System.out.println("\t" + str);
		}
	}

}
