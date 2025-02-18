package com.yedam.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.BoardVO;

/*
 * 추가,수정,삭제,조회
 * Create, Read, Update, Delete
 */
public class BoardDAO extends DAO {
	// 조회
	public List<BoardVO> selectBoard() {
		List<BoardVO> brdList = new ArrayList<>();
		String qry = "select * from tbl_board " //
			+ "order by board_no";
		// 조회 결과
		try {
			psmt = getConnect().prepareStatement(qry);
			rs = psmt.executeQuery();	
			ResultSet rs = psmt.executeQuery();
			
			while (rs.next()) {
			BoardVO brd = new BoardVO();
			brd.setBoardNo(rs.getInt("board_no"));
			brd.setTitle(rs.getString("title"));
			brd.setContent(rs.getString("content"));
			brd.setWriter(rs.getString("writer"));
			brd.setWriteDate(rs.getDate("write_date"));
			brd.setViewCnt(rs.getInt("view_cnt"));
			
			brdList.add(brd);
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return brdList;
	}

	// 추가.
	public boolean insertBoard(BoardVO board) {

		return false;
	}

	// 수정.
	public boolean updateBoard(BoardVO board) {

		return false;
	}

	// 삭제.
	public boolean deleteBoard(BoardVO board) {

		return false;
	}

}
