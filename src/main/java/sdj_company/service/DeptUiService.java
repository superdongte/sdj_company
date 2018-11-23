package sdj_company.service;

import java.sql.SQLException;
import java.util.List;

import sdj_company.dao.DepartmentDao;
import sdj_company.dao.DepartmentDaoImpl;
import sdj_product.dto.Department;

public class DeptUiService {
	private DepartmentDao dao;
	
	public DeptUiService() {
		dao = new DepartmentDaoImpl();
	}
	public List<Department> selectDeptAll(){
		return dao.selectDepartmentByAll();
	}
	public int registerDepartment(Department department) throws SQLException{
		return dao.insertDepartment(department);
	}
	public String nextDeptno() {
		return dao.nextDeptNo();
	}
}//end of class
