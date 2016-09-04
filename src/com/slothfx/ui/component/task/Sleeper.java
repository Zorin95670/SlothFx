package com.slothfx.ui.component.task;

import javafx.concurrent.Task;

public class Sleeper extends Task<Void> {

	long timeOut;
	
	public Sleeper(long timeOut) {
		this.timeOut = timeOut;
	}
	
	@Override
	protected Void call() throws Exception {
		try {
			Thread.sleep(timeOut);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
