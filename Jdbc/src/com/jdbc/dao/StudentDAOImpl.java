package com.jdbc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.jdbc.db.DB;
import com.jdbc.model.Student;

/*
  create table students (
    id serial primary key,
    first_name varchar(50) not null,
    last_name varchar(100) not null
  );
 */

public class StudentDAOImpl implements StudentDAO {
	private static final String SQL_SELECT = "SELECT id, first_name, last_name FROM students WHERE id = ?";
	private static final String SQL_SELECT_ALL = "SELECT id, first_name, last_name FROM students";
	private static final String SQL_INSERT = "INSERT INTO students (first_name, last_name) VALUES (?, ?)";
	private static final String SQL_DELETE = "DELETE FROM students WHERE ID = ?";
	private static final String SQL_UPDATE = "UPDATE students set first_name = ?, last_name = ? WHERE id = ?";

	@Override
	public Student findById(Integer id) {
		if (id == null) {
			return null;
		}

		Student result = null;
		try (DB db = new DB(); PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				result = new Student(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Student> findAll() {
		List<Student> result = new LinkedList<>();
		try (DB db = new DB();
				Statement s = db.getConnection().createStatement();
				ResultSet rs = s.executeQuery(SQL_SELECT_ALL);) {

			while (rs.next()) {
				result.add(new Student(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insert(Student student) {
		if (student == null) {
			return 0;
		}

		int affected = 0;

		try (DB db = new DB(); PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT);) {
			ps.setString(1, student.getFirstName());
			ps.setString(2, student.getLastName());
			affected = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return affected;
	}

	@Override
	public int deleteById(Integer id) {
		if (id == null) {
			return 0;
		}

		int affected = 0;
		try (DB db = new DB(); PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE);) {
			ps.setInt(1, id);
			affected = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return affected;
	}

	@Override
	public int update(Student student) {
		if (student == null) {
			return 0;
		}

		int affected = 0;
		try (DB db = new DB(); PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE);) {
			ps.setString(1, student.getFirstName());
			ps.setString(2, student.getLastName());
			ps.setInt(3, student.getId());

			affected = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return affected;
	}

}
