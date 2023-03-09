package week2_3_3;

import java.util.ArrayList;

public class ListEmployee {
	ArrayList<Employee> list;

	public ListEmployee() {
		this.list = new ArrayList<Employee>();
	}

	public boolean addEmp(Employee newEmp) {
		if (list.contains(newEmp)) {
			return false;
		} else {
			list.add(newEmp);
			return true;
		}
	}

	public boolean deleteIndex(int index) {
		if (index >= 0 && index < list.size() - 1) {
			list.remove(index);
			return true;
		} else {
			return false;
		}
	}

	public boolean updateEmp(String id, String lastName, String firstName, String gender, int age, double salary) {
		Employee tempEmp = new Employee(id, lastName, firstName, age, gender, salary);
		if(list.contains(tempEmp)) {
			tempEmp.setId(id);
			tempEmp.setLastName(lastName);
			tempEmp.setFirstName(firstName);
			tempEmp.setGender(gender);
			tempEmp.setAge(age);
			tempEmp.setSalary(salary);
			return true;
		}
		else {
			return false;
		}
	}
	
	public int findEmp(String id) {
		return list.indexOf(new Employee(id, "", "", 0, "", 0));
	}
	
}
