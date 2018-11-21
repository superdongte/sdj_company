package sdj_product.dto;

public class Employee { 
	private String empno;
	private String empname;
	private Title title;
	private int salary;
	private String gender;
	private String dept;
	private String ipsa; 
	private Department dno;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	/*get and setter*/
	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
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

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getIpsa() {
		return ipsa;
	}

	public void setIpsa(String ipsa) {
		this.ipsa = ipsa;
	}

	public Department getDno() {
		return dno;
	}

	public void setDno(Department dno) {
		this.dno = dno;
	}
	/*using field*/
	public Employee(String empno, String empname, Title title, int salary, String gender, String dept, String ipsa,
			Department dno) {
		this.empno = empno;
		this.empname = empname;
		this.title = title;
		this.salary = salary;
		this.gender = gender;
		this.dept = dept;
		this.ipsa = ipsa;
		this.dno = dno;
	}

	public Employee(Title title) {
		this.title = title;
	}

	public Employee(Department dno) {
		this.dno = dno;
	}
	/*toString*/
	@Override
	public String toString() {
		return String.format(
				"Employee [empno=%s, empname=%s, title=%s, salary=%s, gender=%s, dept=%s, ipsa=%s, dno=%s]", empno,
				empname, title, salary, gender, dept, ipsa, dno);
	}
	
}
