package sdj_company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





import sdj_company.ConnectionProvider;
import sdj_company.LogUtil;
import sdj_product.dto.Department;
import sdj_product.dto.Employee;
import sdj_product.dto.Title;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public List<Employee> selectEmployeeByAll() {
		List<Employee> list = new ArrayList<>();
		String sql = "{call total()}";
		try(Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			LogUtil.prnLog(pstmt);
				while(rs.next()) {
					list.add(getEmployeeDetail(rs));
				}
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
		return list;
	}

	private Employee getEmployeeDetail(ResultSet rs) throws SQLException {
		String empno = rs.getString("empno");
		String empname = rs.getString("empname");
		Title title = new Title(rs.getString("title"),rs.getString("tname"));
		int salary = rs.getInt("salary");
		String gender = rs.getString("gender");
		String ipsa = rs.getString("ipsa");
		Department dno = new Department(rs.getString("dno"),rs.getString("deptname"),rs.getInt("floor"));

		return new Employee(empno,empname,title,salary,gender,ipsa,dno);
	}
	@Override
	public int insertEmployee(Employee employee) throws SQLException {
		LogUtil.prnLog("insertEmployee");
		String sql = "insert into Employee values(?,?,?,?,?,?,?)";
		int rowAffected = 0;
		try(Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, employee.getEmpno());
				pstmt.setString(2, employee.getEmpname());
				pstmt.setString(3, employee.getTitle().getTno());
				pstmt.setInt(4, employee.getSalary());
				pstmt.setString(5, employee.getGender());
				pstmt.setString(7, employee.getDno().getDeptno());
				pstmt.setString(6, employee.getIpsa());
				
				rowAffected = pstmt.executeUpdate();
		}
		return rowAffected;
	}

	@Override
	public int deleteEmployee(Employee employee) throws SQLException {
		LogUtil.prnLog("deleteEmployee()");
		String sql = "delete from Employee where empno=?";
		int rowAffected = 0;
		try(Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);){
				pstmt.setString(1, employee.getEmpno());
				LogUtil.prnLog(pstmt);
				rowAffected = pstmt.executeUpdate();
		}
		return  rowAffected;
	}
	@Override
	public int updateEmployee(Employee employee) throws SQLException {
		LogUtil.prnLog("updateEmployee()");
		String sql = "update Employee set empname=?, title=?, salary=?, gender=?, ipsa=?, dno=? where empno=?";
		int rowAffected = 0;
		try(Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);){
				pstmt.setString(1, employee.getEmpname());
				pstmt.setString(2, employee.getTitle().getTno());
				pstmt.setInt(3, employee.getSalary());
				pstmt.setString(4, employee.getGender());
				pstmt.setString(5, employee.getIpsa());
				pstmt.setString(6, employee.getDno().getDeptno());
				pstmt.setString(7, employee.getEmpno());
				LogUtil.prnLog(pstmt);
				rowAffected = pstmt.executeUpdate();
		}
		return rowAffected;
	}

	@Override
	public Employee selectEmployeeByNo(Employee employee) throws SQLException {
		LogUtil.prnLog("selectEmployeeByNo()");
		Employee dept = null;
		String sql = "select empno, empname, title, salary, gender,ipsa,dno from  employee where empno=?";
		try(Connection conn = ConnectionProvider.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, employee.getEmpno());
			LogUtil.prnLog(pstmt);
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					dept = getEmployee(rs);
				}
			}
		}	
		return dept;
	}

	private Employee getEmployee(ResultSet rs) throws SQLException {
		String empno = rs.getString("empno");
		String empname = rs.getString("empname");
		Title title = new Title(rs.getString("title"));
		int salary = rs.getInt("salary");
		String gender = rs.getString("gender");
		String ipsa = rs.getString("ipsa");
		Department dno = new Department(rs.getString("dno"));

		return new Employee(empno,empname,title,salary,gender,ipsa,dno);
	}

}
