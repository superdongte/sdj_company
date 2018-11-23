package sdj_company.service;

import java.sql.SQLException;
import java.util.List;

import sdj_company.dao.TitleDao;
import sdj_company.dao.TitleDaoImpl;
import sdj_product.dto.Title;



public class TitleUiService {
private TitleDao dao;
	
	public TitleUiService() {
		dao = new TitleDaoImpl();
	}
	public List<Title> selectTitleAll(){
		return dao.selectTitleByAll();
	}
	public int registerTitle(Title title) throws SQLException{
		return dao.insertTitle(title);
	}
	public String nextTno() {
		return dao.nextTno();
	}
	public int unRegisterTitle(Title tept) throws SQLException{
		return dao.deleteTitle(tept);
	}
	public int UpdateTitle(Title tept) throws SQLException {
		return dao.updateTitle(tept);
	}
}
