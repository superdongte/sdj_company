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

import sdj_company.dao.TitleDao;
import sdj_company.dao.TitleDaoImpl;
import sdj_product.dto.Title;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TitleTest {
	
	static TitleDao tao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println();
		LogUtil.prnLog("Start Title");
		tao = new TitleDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println();
		LogUtil.prnLog("End TitleDaoTest");
		tao = null;
	}

	@Before
	public void setUp() throws Exception {
		System.out.println();
	}

	@Test
	public void test01selectTitleByAll() {
		
		List<Title> lists = tao.selectTitleByAll();
		LogUtil.prnLog(lists.toString());
		Assert.assertNotNull(lists);
		System.out.println(lists);
	}
	@Test
	public void test02InsertTitle() {
		try {
			Title newTitle = new Title("T000","인싸");
			int rowAffected = tao.insertTitle(newTitle);
			LogUtil.prnLog(String.format("rowAffected %d", rowAffected));
			Assert.assertEquals(1, rowAffected);
		}catch(SQLException e) {
			if(e.getErrorCode() == 1062) {
				LogUtil.prnLog("해당 작위 존재함");
			}else {
				LogUtil.prnLog(e);
			}
		}
	}
	@Test
	public void test05DeleteTitle() {
		try {
			Title delTitle = new Title();
			delTitle.setTno("T000");
			int rowAffected = tao.deleteTitle(delTitle);
			LogUtil.prnLog(String.format("rowAffected %d", rowAffected));
			Assert.assertEquals(1, rowAffected);
		}catch(SQLException e) {
			if(e.getErrorCode() == 1451) {
				LogUtil.prnLog("해당 작위가 존재함");
			}else {
				LogUtil.prnLog(e);
			}
		}
	}
	@Test
	public void test03UpdateDepartment() {
		try {
			Title updateTitle = new Title("T000","아싸");
			int rowAffected = tao.updateTitle(updateTitle);
			LogUtil.prnLog(String.format("rowAffected %d", rowAffected));
			Assert.assertEquals(1, rowAffected);
		}catch(SQLException e) {
			LogUtil.prnLog(e);
		}
	}
	@Test
	public void test04SelectTitle() {
		try {
			Title selTitle = new Title();
			selTitle.setTno("T001");
			Title title = tao.selectTitleByNo(selTitle);
			LogUtil.prnLog(String.format("%s - %s",title.getClass().getSimpleName(),title));
			Assert.assertNotNull(title);
		}catch(SQLException e) {
			LogUtil.prnLog(e);
		}
	}



}//end of Class
