package ecommerceWebsite.DAO.impl;

import java.util.List;

import ecommerceWebsite.DAO.ICategoryDAO;
import ecommerceWebsite.Mapper.CategoryMapper;
import ecommerceWebsite.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {

	@Override
	public List<CategoryModel> findAll() {
		String sql = "SELECT * FROM category";
		return query(sql, new CategoryMapper());
	}

	@Override
	public Long addData(CategoryModel model) {
		StringBuilder sql =new StringBuilder( "INSERT INTO category(name,code) ");
		sql.append("VALUES(?,?)");
		return insert(sql.toString(), model.getName(), model.getCode());
	}

	@Override
	public CategoryModel finByid(long id) {
		String sql = "SELECT * FROM category WHERE id = ?";
		List<CategoryModel> listResult = query(sql, new CategoryMapper(), id);
		return listResult.isEmpty() ? null : listResult.get(0);
	}

}
