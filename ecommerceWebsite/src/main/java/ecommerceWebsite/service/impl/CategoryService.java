package ecommerceWebsite.service.impl;

import java.util.List;

import javax.inject.Inject;

import ecommerceWebsite.DAO.ICategoryDAO;
import ecommerceWebsite.model.CategoryModel;
import ecommerceWebsite.service.ICategoryService;

public class CategoryService implements ICategoryService {
	
	@Inject
	private ICategoryDAO iCategoryDAO;

	@Override
	public List<CategoryModel> getAll() {
		List<CategoryModel> models = iCategoryDAO.findAll();
		return models;
	}

	@Override
	public CategoryModel save(CategoryModel model) {
		Long id = iCategoryDAO.addData(model);
		return iCategoryDAO.finByid(id);
	}

	@Override
	public CategoryModel findByid(long id) {
		return iCategoryDAO.finByid(id);
	}
}
