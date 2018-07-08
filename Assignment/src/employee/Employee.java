package employee;

public class Employee {
	
	
	int sl;
	String name;
	String designation;
	String department;
	String userId;
	
	
	
	/*public Employee(int sl, String name, String designation, String department,
			String userId) {
		super();
		this.sl = sl;
		this.name = name;
		this.designation = designation;
		this.department = department;
		this.userId = userId;
	}*/
	public int getSl() {
		return sl;
	}
	public void setSl(int sl) {
		this.sl = sl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
/*	@Override
	public String toString() {
		return "Employee [sl=" + sl + ", name=" + name + ", designation="
				+ designation + ", department=" + department + ", userId="
				+ userId + "]";
	}*/
	
	
}
