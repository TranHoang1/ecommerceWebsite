package ecommerceWebsite.DAO;

import java.util.List;

import ecommerceWebsite.Mapper.IRowMapper;

public interface GenaricDAO<T> {
	List<T> query(String sql, IRowMapper<T> mapper, Object... paramaters);

	Long insert(String sql, Object... paramaters);

	void update(String sql, Object... paramaters);

}
