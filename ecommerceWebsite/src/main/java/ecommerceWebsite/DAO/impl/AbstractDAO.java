package ecommerceWebsite.DAO.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.lang.ObjectUtils.Null;

import ecommerceWebsite.DAO.GenaricDAO;
import ecommerceWebsite.Mapper.IRowMapper;

public class AbstractDAO<T> implements GenaricDAO<T> {
	ResourceBundle bundle = ResourceBundle.getBundle("db");

	public Connection getConnect() {
		try {
			Class.forName(bundle.getString("driver"));
			String url = bundle.getString("url");
			String user = bundle.getString("username");
			String password = bundle.getString("password");
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}

	private void setParamater(PreparedStatement statement, Object... paramater) {
		try {
			for (int i = 0; i < paramater.length; i++) {
				Object parameter = paramater[i];
				int index = i + 1;
				if (parameter instanceof Long) {
					statement.setLong(index, (Long) parameter);
				} else if (parameter instanceof String) {
					statement.setString(index, (String) parameter);
				} else if (parameter instanceof Integer) {
					statement.setInt(index, (Integer) parameter);
				} else if (parameter instanceof Null) {
					statement.setNull(index, Types.VARCHAR);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<T> query(String sql, IRowMapper<T> mapper, Object... paramaters) {
		List<T> lists = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			connection = getConnect();
			statement = connection.prepareStatement(sql);
			setParamater(statement, paramaters);
			rs = statement.executeQuery();
			while (rs.next()) {
				lists.add(mapper.rowMapper(rs));
			}
			return lists;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				} else if (statement != null) {
					statement.close();
				} else if (rs != null) {
					rs.close();
				}
			} catch (Exception e2) {
				e2.getMessage();
			}
		}
		return null;
	}

	@Override
	public Long insert(String sql, Object... paramaters) {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			Long id = null;
			connection = getConnect();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParamater(statement, paramaters);
			statement.executeUpdate();
			rs = statement.getGeneratedKeys();
			while (rs.next()) {
				id = rs.getLong(1);
			}
			connection.commit();
			return id;
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					return null;
				}
			}
			return null;
		}finally {
			try {
				if (connection != null) {
					connection.close();
				} else if (statement != null) {
					statement.close();
				} else if (rs != null) {
					rs.close();
				}
			} catch (Exception e2) {
				e2.getMessage();
			}
		}
	}

	@Override
	public void update(String sql, Object... paramaters) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = getConnect();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			setParamater(statement, paramaters);
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {

			try {
				if (connection != null) {
					connection.close();
				} else if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
