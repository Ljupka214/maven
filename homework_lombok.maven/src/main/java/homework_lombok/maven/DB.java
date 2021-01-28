package homework_lombok.maven;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class DB {

		
    private List<Student> students;
	 public DB(ArrayList<Student> pom) {
		 
		 this.students=pom;
		 
	 };

	
	}


