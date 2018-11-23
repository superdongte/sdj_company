package sdj_company.dao;

import java.sql.SQLException;
import java.util.List;

import sdj_product.dto.Employee;

public interface EmployeeDao{
	List<Employee> selectEmployeeByAll();
	int insertEmployee(Employee employee) throws SQLException;
	
	int deleteEmployee(Employee employee) throws SQLException;
	int updateEmployee(Employee employee) throws SQLException;
	Employee selectEmployeeByNo(Employee employee) throws SQLException;
	String nextEmpNo();
}
