package com.rsuport.notice.dao;

import com.rsuport.notice.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 공지사항 게시판 Dao
 */
public interface BoardDao extends JpaRepository<Board, Long> {
    /**
     * @param boardId 공지사항 게시물 아이디
     * @return Board
     */
    Board findByBoardId(Long boardId);
}
