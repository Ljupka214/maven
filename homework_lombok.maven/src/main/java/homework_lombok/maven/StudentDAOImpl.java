package homework_lombok.maven;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;



public class StudentDAOImpl implements StudentDAO {
	
	    private DB db;
		
		@Override
		public Student findById(Integer id) {
			Student result = null;
			if (id == null) {
				return null;
			}

			for (int i = 0; i < db.getStudents().size(); i++) {
				Student student = db.getStudents().get(i);
				if (student.getId() == id) {
					return student;

				}
			}	
				return result;

		}

		@Override
		public List<Student> findAll() {
			return db.getStudents();
		}

		@Override
		public int insert(Student student) {
			if (student == null) {
				return 0;
			}
			boolean inserted = db.getStudents().add(student);
			if (inserted) {
			return	db.getStudents().get(db.getStudents().size()-1).getId();
			}
			return 0;
	}



		@Override
		public int deleteById(Integer id) {
			// TODO Auto-generated method stub
			return 0;
		}


		@Override
		public int update(Student student) {
			// TODO Auto-generated method stub
			return 0;
		}

}
