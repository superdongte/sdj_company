package sdj_product.dto;

public class Department {
	private String deptno;
	private String deptname;
	private int floor;
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getDeptno() {
		return deptno;
	}
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	
	public Department(String deptno, String deptname, int floor) {
		this.deptno = deptno;
		this.deptname = deptname;
		this.floor = floor;
	}
	
	public Department(String deptno) {
		this.deptno = deptno;
	}
//	@Override
//	public String toString() {
//		return String.format("department [deptno=%s, deptname=%s, floor=%s]", deptno, deptname, floor);
//	}
	@Override
	public String toString() {
		return String.format("%s(%s층)", deptname, floor);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deptno == null) ? 0 : deptno.hashCode());
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
		Department other = (Department) obj;
		if (deptno == null) {
			if (other.deptno != null)
				return false;
		} else if (!deptno.equals(other.deptno))
			return false;
		return true;
	}
	
		
}
