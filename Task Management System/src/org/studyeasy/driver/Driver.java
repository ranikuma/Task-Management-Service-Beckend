package org.studyeasy.driver;

import java.util.ArrayList;
import java.util.List;
import org.studyeasy.model.*;
import org.studyeasy.service.TaskPlannerService;
import org.studyeasy.service.TaskPlannerService.StoryTypeTaskStatus;

public class Driver {

	@SuppressWarnings({ "unchecked", "unused" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TaskPlannerService service = new TaskPlannerService();

		// Create a task of feature type
		Feature<? extends TaskType> dashBoardFeature = service.createTaskService("Create DashBoard", "Brad", "Peter",
				TaskPlannerService.FeatureTypeTaskStatus.Open, "2019-04-12", "Feature", null,
				"Create console for debugging", Impact.low);
		Bug<? extends TaskType> sqlBug = service.createTaskService("Fix mysql issue", "Ryan", "Ryan",
				TaskPlannerService.BugTypeTaskStatus.InProgress, "2019-04-14", "Bug", "Sprint-1", Severity.P0);
		Story<? extends TaskType> microServiceStory = service.createTaskService("Create a microservice", "Amy", "Ryan",
				TaskPlannerService.StoryTypeTaskStatus.Completed, "2019-03-12", "Story", "Sprint-1", null,
				"Add logging to the feature");
		Feature<? extends TaskType> consoleFeature = service.createTaskService("Setup console", "Ryan", "Ryan",
				TaskPlannerService.FeatureTypeTaskStatus.InProgress, "2019-04-14", "Feature", null,
				"Create console for debugging", Impact.high);
		Feature<? extends TaskType> apiFeature = service.createTaskService("Console api", "Ryan", "Ryan",
				TaskPlannerService.FeatureTypeTaskStatus.InProgress, "2019-04-14", "Feature", null,
				"Create api for console", Impact.high);

		Subtrack<TaskPlannerService.StoryTypeTaskStatus> deSubtrack = service.createSubtrack("Developement",
				trackStatus.Open, (Task<StoryTypeTaskStatus>) microServiceStory);
		Subtrack<TaskPlannerService.StoryTypeTaskStatus> deSubtrack1 = service.createSubtrack("Unit test",
				trackStatus.Open, (Task<StoryTypeTaskStatus>) microServiceStory);
		Subtrack<TaskPlannerService.StoryTypeTaskStatus> deSubtrack2 = service.createSubtrack("Integration Test",
				trackStatus.Open, (Task<StoryTypeTaskStatus>) microServiceStory);
		List<Task<? extends TaskType>> tasks = new ArrayList<Task<? extends TaskType>>();
		tasks.add(dashBoardFeature);
		tasks.add(sqlBug);
		tasks.add(microServiceStory);
		tasks.add(consoleFeature);
		tasks.add(apiFeature);

		service.displayTaskOfAssignedUser(tasks, "Ryan", "Feature");

		service.displayTasksInSprint(tasks, "Sprint-1");

	}

}
