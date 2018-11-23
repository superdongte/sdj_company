package sdj_company.dao;

import java.sql.SQLException;
import java.util.List;

import sdj_product.dto.Department;

public interface DepartmentDao {
	List<Department> selectDepartmentByAll();
	int insertDepartment(Department department) throws SQLException;
	
	int deleteDepartment(Department department) throws SQLException;
	int updateDepartment(Department department) throws SQLException;
	Department selectDepartmentByNo(Department department) throws SQLException;
	String nextDeptNo();

}
