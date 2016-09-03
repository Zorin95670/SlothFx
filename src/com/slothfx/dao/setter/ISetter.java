package com.slothfx.dao.setter;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ISetter {

	public boolean init(ResultSet set) throws SQLException;
}
