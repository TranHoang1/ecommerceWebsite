package ecommerceWebsite.model;

public class ProductModel extends AbstractModel<ProductModel> {

	private String productName;
	private String productThumbnail;
	private Double price;
	private String pro_description;
	private Long category_id;


	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductThumbnail() {
		return productThumbnail;
	}

	public void setProductThumbnail(String productThumbnail) {
		this.productThumbnail = productThumbnail;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPro_description() {
		return pro_description;
	}

	public void setPro_description(String pro_description) {
		this.pro_description = pro_description;
	}

	public Long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}

}
