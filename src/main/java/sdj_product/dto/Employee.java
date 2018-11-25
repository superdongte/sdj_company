package sdj_product.dto;

import java.util.Date;

public class Employee { 
	private String empno;
	private String empname;
	private Title title;
	private int salary;
	private String gender;
	private Department dno;
	private Date ipsa;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return String.format("Employee [empno=%s, empname=%s, title=%s, salary=%s, gender=%s, dept=%s, ipsa=%s]", empno,
				empname, title, salary, gender, dno, ipsa);
	}

	public String getEmpno() {
		return empno;
	}
	
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	
	public Employee(String empNo) {
		this.empno = empNo;
	}
	
	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	
	public Department getDno() {
		return dno;
	}

	public void setDno(Department dno) {
		this.dno = dno;
	}

	public Date getIpsa() {
		return ipsa;
	}

	public void setIpsa(Date ipsa) {
		this.ipsa = ipsa;
	}

	public Employee(String empno, String empname, Title title, int salary, String gender, Date ipsa,
			Department dno) {
		this.empno = empno;
		this.empname = empname;
		this.title = title;
		this.salary = salary;
		this.gender = gender;
		this.ipsa = ipsa;
		this.dno = dno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empno == null) ? 0 : empno.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empno == null) {
			if (other.empno != null)
				return false;
		} else if (!empno.equals(other.empno))
			return false;
		return true;
	}
	
	
}//end of class
