package ecommerceWebsite.DAO;

import java.util.List;

import ecommerceWebsite.model.CategoryModel;

public interface ICategoryDAO {
	List<CategoryModel> findAll();

	Long addData(CategoryModel model);

	CategoryModel finByid(long id);
}
