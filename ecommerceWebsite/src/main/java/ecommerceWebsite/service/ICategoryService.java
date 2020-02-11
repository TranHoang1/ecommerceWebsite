package ecommerceWebsite.service;

import java.util.List;

import ecommerceWebsite.model.CategoryModel;

public interface ICategoryService {
	List<CategoryModel> getAll();

	CategoryModel save(CategoryModel model);

	CategoryModel findByid(long id);

}
