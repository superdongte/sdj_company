package sdj_company.dao;

import java.sql.SQLException;
import java.util.List;

import sdj_product.dto.Title;

public interface TitleDao {
	List<Title> selectDepartmentByAll();
	int insertDepartment(Title title) throws SQLException;
	
	int deleteDepartment(Title title) throws SQLException;
	int updateDepartment(Title title) throws SQLException;
	Title selectDepartmentByNo(Title title) throws SQLException;
}
