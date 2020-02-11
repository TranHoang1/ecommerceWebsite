package ecommerceWebsite.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import ecommerceWebsite.model.CategoryModel;

public class CategoryMapper implements IRowMapper<CategoryModel> {

	@Override
	public CategoryModel rowMapper(ResultSet rs) {
		try {
			CategoryModel model = new CategoryModel();
			model.setId(rs.getLong("id"));
			model.setName(rs.getString("name"));
			model.setCode(rs.getString("code"));
			return model;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
