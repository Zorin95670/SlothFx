package com.slothfx.dao.setter;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.slothfx.core.data.Tag;


public class TagSetter implements ISetter {

	private Tag tag;
	
	@Override
	public boolean init(ResultSet set) throws SQLException {
		if(!set.next())
			return false;

		if(tag == null)
			tag = new Tag();
		
		tag.setId(set.getInt(1));
		tag.setName(set.getString(2));

		return true;
	}

	public Tag getTag() {
		return tag;
	}
	
	public void setTag(Tag tag){
		this.tag = tag;
	}

}
