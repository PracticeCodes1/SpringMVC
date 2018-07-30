package com.cg.demo.data;

public class EmployeeDetails {

	@Override
	public String toString() {
		return "EmployeeDetails [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", deptId=" + deptId + ", deptName=" + deptName + "]";
	}
	private int employeeId;
	private String firstName;
	private String lastName;
	private int deptId;
	private String deptName;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public EmployeeDetails() {
		super();
		
	}
	
}
