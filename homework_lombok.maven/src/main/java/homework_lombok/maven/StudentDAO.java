package homework_lombok.maven;

import java.util.List;

	
	public interface StudentDAO
	{
		public Student findById(Integer id);
		public List<Student> findAll();
		public int insert(Student student);
		public int deleteById(Integer id);
		public int update(Student student);


}
