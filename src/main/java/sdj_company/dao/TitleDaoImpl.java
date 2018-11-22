package sdj_company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sdj_company.ConnectionProvider;
import sdj_company.LogUtil;
import sdj_product.dto.Title;

public class TitleDaoImpl implements TitleDao {

	@Override
	public List<Title> selectTitleByAll() {
		List<Title> list = new ArrayList<>();
		String sql = "select tno, tname from Title";
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			LogUtil.prnLog(pstmt);
			while (rs.next()) {
				list.add(getTitle(rs));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return list;
	}

	private Title getTitle(ResultSet rs) throws SQLException {
		String tno = rs.getString("tno");
		String tname = rs.getString("tname");
		return new Title(tno, tname);
	}

	@Override
	public int insertTitle(Title title) throws SQLException {
		LogUtil.prnLog("insert Title");
		String sql = "insert into Title values(?,?)";
		int rowAffected = 0;
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, title.getTno());
			pstmt.setString(2, title.getTname());
			rowAffected = pstmt.executeUpdate();
		}
		return rowAffected;
	}

	@Override
	public int deleteTitle(Title title) throws SQLException {
		LogUtil.prnLog("deleteTitle()");
		String sql = "delete from title where tno=? ";
		int rowAffected = 0;
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, title.getTno());
			LogUtil.prnLog(pstmt);
			rowAffected = pstmt.executeUpdate();
		}
		return rowAffected;
	}

	@Override
	public int updateTitle(Title title) throws SQLException {
		LogUtil.prnLog("updateTitle()");
		String sql = "update Title set tname=? where tno=?";
		int rowAffected = 0;
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, title.getTname());
			pstmt.setString(2, title.getTno());
			LogUtil.prnLog(pstmt);
			rowAffected = pstmt.executeUpdate();
		}
		return rowAffected;
	}

	@Override
	public Title selectTitleByNo(Title title) throws SQLException {
		LogUtil.prnLog("updateTitle()");
		Title tept = null;
		String sql = "select tno,tname from title where tno=?";

		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, title.getTno());
			LogUtil.prnLog(pstmt);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					tept = getTitle(rs);
				}
			}

		}
		return tept;
	}

}
