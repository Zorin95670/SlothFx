package com.slothfx.dao.setter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.slothfx.core.data.Tag;


public class TagsSetter implements ISetter {

	private List<Tag> tags;

	public List<Tag> getTags() {
		return tags;
	}

	@Override
	public boolean init(ResultSet set) throws SQLException {
		TagSetter setter = new TagSetter();

		while (setter.init(set)) {
			tags.add(setter.getTag());
			setter.setTag(new Tag());
		}

		return true;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public TagsSetter(List<Tag> tags) {
		this.tags = tags;
	}

}
