package ecommerceWebsite.model;

import java.sql.Timestamp;

public abstract class AbstractModel<T> {

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getCreatedDay() {
		return createdDay;
	}

	public void setCreatedDay(Timestamp createdDay) {
		this.createdDay = createdDay;
	}

	public Timestamp getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	private Timestamp createdDay;
	private Timestamp modifieddate;
	private String createdBy;
	private String modifiedBy;

}
