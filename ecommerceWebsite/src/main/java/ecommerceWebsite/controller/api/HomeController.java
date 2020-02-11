package ecommerceWebsite.controller.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import ecommerceWebsite.controller.utils.HttpUtils;
import ecommerceWebsite.model.CategoryModel;
import ecommerceWebsite.service.ICategoryService;

@WebServlet(urlPatterns = { "/api-categoryTest" })
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private ICategoryService iCategoryService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");

		CategoryModel model = HttpUtils.of(request.getReader()).tomodel(CategoryModel.class);
		model = iCategoryService.save(model);
		System.out.println(model);
		mapper.writeValue(response.getOutputStream(), model);
	}

}
