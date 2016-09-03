package com.slothfx.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.slothfx.core.Application;

public class Request {

	private String dataBase;
	private String query;

	public boolean init(Application application, String fileName) {
		if (fileName.contains("internal")) {
			this.setDataBase("internal");
		} else {
			this.setDataBase("external");
		}

		File file = new File(application.getPath("sql") + fileName.replace(".", File.separator).concat(".sql"));

		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));

			StringBuilder sb = new StringBuilder();
			while (reader.ready()) {
				sb.append(reader.readLine());
			}
			reader.close();
			this.setQuery(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	public String getDataBase() {
		return dataBase;
	}

	public void setDataBase(String dataBase) {
		this.dataBase = dataBase;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
}
