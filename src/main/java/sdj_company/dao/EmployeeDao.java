package sdj_company.dao;

import java.sql.SQLException;
import java.util.List;

import sdj_product.dto.Employee;

public interface EmployeeDao{
	List<Employee> selectDepartmentByAll();
	int insertDepartment(Employee employee) throws SQLException;
	
	int deleteDepartment(Employee employee) throws SQLException;
	int updateDepartment(Employee employee) throws SQLException;
	Employee selectDepartmentByNo(Employee employee) throws SQLException;
}
