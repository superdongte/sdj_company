package sdj_company.dao;

import java.sql.SQLException;
import java.util.List;

import sdj_product.dto.Title;

public interface TitleDao {
	List<Title> selectTitleByAll();
	int insertTitle(Title title) throws SQLException;
	
	int deleteTitle(Title title) throws SQLException;
	int updateTitle(Title title) throws SQLException;
	Title selectTitleByNo(Title title) throws SQLException;
	String nextTno();
}
