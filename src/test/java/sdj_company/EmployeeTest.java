package sdj_company;

import java.sql.SQLException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import sdj_company.dao.EmployeeDao;
import sdj_company.dao.EmployeeDaoImpl;
import sdj_product.dto.Department;
import sdj_product.dto.Employee;
import sdj_product.dto.Title;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeTest {
	static EmployeeDao dao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println();
		LogUtil.prnLog("Start EmployeeTest");
		dao = new EmployeeDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println();
		LogUtil.prnLog("End EmployeeTest");
		dao = null;
	}

	@Before
	public void setUp() throws Exception {
		System.out.println();
	}

	@Test
	public void test01SelectEmployeeByAll() {
		List<Employee> lists = dao.selectEmployeeByAll();
		LogUtil.prnLog(lists.toString());
		Assert.assertNotNull(lists);
		System.out.println(lists);
	}
	@Test
	public void test02insertEmployee() {
		try {
			Employee newEmployee = new Employee("ED1810","너회장", new Title("T006"), 50000000,"남자", "2018-10-21",new Department("D005"));
			int rowAffected = dao.insertEmployee(newEmployee);
			LogUtil.prnLog(String.format("rowAffected %d",rowAffected));
			Assert.assertEquals(1, rowAffected);
		}catch(SQLException e) {
			if(e.getErrorCode() == 1062) {
				LogUtil.prnLog("해당 인원 존재함");
			}else {
				LogUtil.prnLog(e);
			}
		}
	}
	@Test
	public void test05DeleteEmployee() {
		try {
			Employee delEmployee = new Employee();
			delEmployee.setEmpno("ED1810");
			int rowAffectied = dao.deleteEmployee(delEmployee);
			LogUtil.prnLog(String.format("rowAffected %d", rowAffectied));
			Assert.assertEquals(1, rowAffectied);
		}catch(SQLException e) {
			if(e.getErrorCode() == 1451) {
				LogUtil.prnLog("해당 인원 존재함");
			}else {
				LogUtil.prnLog(e);
			}
		}
	}
	@Test
	public void test03UpdateEmployee(){
		try {
			Employee updateEmp = new Employee("ED1810","건달", new Title("T007"),5000000,"여자","2018-12-01",new Department("D005"));
			int rowAffected = dao.updateEmployee(updateEmp);
			LogUtil.prnLog(String.format("rowAffected %d", rowAffected));
			Assert.assertEquals(1, rowAffected);
		}catch(SQLException e) {
			LogUtil.prnLog(e);
		}
	}
	@Test
	public void test04SelectEmployee() {
		try {
			Employee selEmp = new Employee();
			selEmp.setEmpno("E017001");
			Employee employee = dao.selectEmployeeByNo(selEmp);
			LogUtil.prnLog(String.format("%s - %s",employee.getClass().getSimpleName(),employee));
			Assert.assertNotNull(employee);
		}catch(SQLException e) {
			LogUtil.prnLog(e);
		}
	}
}//end of class
