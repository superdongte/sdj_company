package sdj_company;

import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import sdj_company.LogUtil;
import sdj_company.dao.DepartmentDao;
import sdj_company.dao.DepartmentDaoImpl;
import sdj_product.dto.Department;

public class DepartmentTest {
	static DepartmentDao dao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println();
		LogUtil.prnLog("Start DepartmentDaoTest");
		dao = new DepartmentDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println();
		LogUtil.prnLog("End ProductDaoTest");
		dao = null;
	}

	@Before
	public void setUp() throws Exception {
		System.out.println();
	}
	
	@Test
	public void selectDepartmentByAll() {
		
		List<Department> lists = dao.selectDepartmentByAll();
		LogUtil.prnLog(lists.toString());
		Assert.assertNotNull(lists);
		System.out.println(lists);
	}
	@Test
	public void test02InsertDepartment() {
		try {
			Department newDept = new Department("D006","잡아부",8);
			int rowAffected = dao.insertDepartment(newDept);
			LogUtil.prnLog(String.format("rowAffected %d", rowAffected));
			Assert.assertEquals(1, rowAffected);
		} catch (SQLException e) {
			if (e.getErrorCode() == 1062) {
				LogUtil.prnLog("해당 부서 존재함");
			} else {
				LogUtil.prnLog(e);
			}
		}
	}
	/*@Test
	public void test04DeleteDepartment() {
		try {
			Department delDept = new Department();
			delDept.setDeptno("D006");
			int rowAffected = dao.deleteDepartment(delDept);
			LogUtil.prnLog(String.format("rowAffected %d", rowAffected));
			Assert.assertEquals(1, rowAffected);
		} catch (SQLException e) {
			if (e.getErrorCode() == 1451) {
				LogUtil.prnLog("해당 음식 존재한다.");
			} else {
				LogUtil.prnLog(e);
			}
		}
	}*/
	@Test
	public void test03UpdateDepartment() {
		try {
			Department updateDept = new Department("D006", "건달부",8);
			int rowAffected = dao.updateDepartment(updateDept);
			LogUtil.prnLog(String.format("rowAffected %d", rowAffected));
			Assert.assertEquals(1, rowAffected);
		} catch (SQLException e) {
			LogUtil.prnLog(e);
		}
	}
	@Test
	public void test05SelectDepartmentByNo() {
		try {
			Department selDept = new Department();
			selDept.setDeptno("D003");
			Department department = dao.selectDepartmentByNo(selDept);
			LogUtil.prnLog(String.format("%s - %s", department.getClass().getSimpleName(), department));
			Assert.assertNotNull(department);
		} catch (SQLException e) {
			LogUtil.prnLog(e);
		}
	}
	
}
