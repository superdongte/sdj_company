package sdj_company.service;

import java.sql.SQLException;
import java.util.List;

import sdj_company.dao.DepartmentDao;
import sdj_company.dao.DepartmentDaoImpl;
import sdj_company.dao.EmployeeDao;
import sdj_company.dao.EmployeeDaoImpl;
import sdj_company.dao.TitleDao;
import sdj_company.dao.TitleDaoImpl;
import sdj_product.dto.Department;
import sdj_product.dto.Employee;
import sdj_product.dto.Title;

public class EmployeeUiService {
	private EmployeeDao Edao;
	private DepartmentDao Ddao;
	private TitleDao Tdao;
	
	public EmployeeUiService() {
		Edao = new EmployeeDaoImpl();
		Ddao = new DepartmentDaoImpl();
		Tdao = new TitleDaoImpl();		
	}
	public List<Employee> selectEmpAll(){
		return Edao.selectEmployeeByAll();
	}
	public int registerEmployee(Employee employee) throws SQLException{
		return Edao.insertEmployee(employee);
	}
	public String nextEmpNo() {
		return Edao.nextEmpNo();
	}
	public int unRegisterEmployee(Employee employee) throws SQLException {
		return Edao.deleteEmployee(employee);
	}
	public int UpdateEmployee(Employee employee) throws SQLException {
		return Edao.updateEmployee(employee);
	}
	public List<Title> selectTitleAll(){
		return Tdao.selectTitleByAll();
	}
	public List<Department> selectDeptAll(){
		return Ddao.selectDepartmentByAll();
	}
}
