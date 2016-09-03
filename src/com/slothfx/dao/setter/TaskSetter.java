package com.slothfx.dao.setter;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.slothfx.core.Task;

public class TaskSetter implements ISetter {

	private Task task;
	
	@Override
	public boolean init(ResultSet set) throws SQLException {
		if(!set.next())
			return false;

		if(task == null)
			task = new Task();
		
		task.setId(set.getInt(1));
		task.setName(set.getString(2));

		return true;
	}

	public Task getTask() {
		return task;
	}
	
	public void setTask(Task Task){
		this.task = Task;
	}

}
