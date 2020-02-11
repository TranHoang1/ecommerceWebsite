package ecommerceWebsite.Mapper;

import java.sql.ResultSet;

public interface IRowMapper<T> {
	T rowMapper(ResultSet rs);
}
