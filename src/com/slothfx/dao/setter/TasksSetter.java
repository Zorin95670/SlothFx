package com.slothfx.dao.setter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.slothfx.core.Task;

public class TasksSetter implements ISetter {

	private List<Task> tasks;

	public List<Task> getTasks() {
		return tasks;
	}

	@Override
	public boolean init(ResultSet set) throws SQLException {
		TaskSetter setter = new TaskSetter();

		while (setter.init(set)) {
			tasks.add(setter.getTask());
			setter.setTask(new Task());
		}

		return true;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public TasksSetter(List<Task> tasks) {
		this.tasks = tasks;
	}

}
