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

public class DepartmentDaoImpl implements DepartmentDao{

	@Override
	public List<Department> selectDepartmentByAll() {
		List<Department> list = new ArrayList<>();
		String sql = "select deptno,deptname,floor from department";
		try(Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			LogUtil.prnLog(pstmt);
				while (rs.next()) {
					list.add(getDepartment(rs));
				}
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
		return list;
	}

	private Department getDepartment(ResultSet rs) throws SQLException {
		String deptno = rs.getString("deptno");
		String deptname = rs.getString("deptname");
		int floor = rs.getInt("floor");
		return new Department(deptno,deptname,floor);
	}

	@Override
	public int insertDepartment(Department department) throws SQLException {
		LogUtil.prnLog("insertDepartment");
		String sql = "insert into Department values(?,?,?)";
		int rowAffected = 0;
		try(Connection conn = ConnectionProvider.getConnection();PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, department.getDeptno());
			pstmt.setString(2, department.getDeptname());
			pstmt.setInt(3, department.getFloor());
			rowAffected = pstmt.executeUpdate();
		}
		return rowAffected;
	}

	@Override
	public int deleteDepartment(Department department) throws SQLException {
		LogUtil.prnLog("deleteDepartment()");
		String sql = "delete from Department where deptno=?";
		int rowAffected = 0;
		try(Connection conn = ConnectionProvider.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, department.getDeptno());
			LogUtil.prnLog(pstmt);
			rowAffected = pstmt.executeUpdate();
		}
		return rowAffected;
	}

	@Override
	public int updateDepartment(Department department) throws SQLException {
		LogUtil.prnLog("updateDepartment()");
		String sql = "update Department set deptname=? ,floor=? where deptno=?";
		int rowAffected = 0;
		try(Connection conn = ConnectionProvider.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(3, department.getDeptno());
			pstmt.setString(1, department.getDeptname());
			pstmt.setInt(2, department.getFloor());
			rowAffected = pstmt.executeUpdate();
		}
		return rowAffected;
	}

	@Override
	public Department selectDepartmentByNo(Department department) throws SQLException {
		LogUtil.prnLog("updateDepartment()");
		Department dept = null;
		String sql = "select deptno, deptname , floor from department where deptno=?";
		
		try(Connection conn = ConnectionProvider.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, department.getDeptno());
			LogUtil.prnLog(pstmt);
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					dept = getDepartment(rs);
				}
			}
		}	
		return dept;
	}

	
}
