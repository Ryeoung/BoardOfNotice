package com.rsuport.notice.service;

import com.rsuport.notice.dao.BoardDao;
import com.rsuport.notice.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BoardService {
    private final BoardDao boardDao;

    @Autowired
    public BoardService(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    /**
     * @return List<Board>
     * 모든 게시물 객체 반환
     */
    public List<Board> findAllBoard() {
        return this.boardDao.findAll();
    }
    /**
     * @param board 삽입할 공지사항 객체
     * @return Board 삽입된 공지사향 객체
     *
     * 공지사항 객체 삽입 하기
     */
    public Board insertBoard(Board board) {
        board.setGenerateTime(LocalDateTime.now());
        return this.boardDao.save(board);
    }

    /**
     * @param boardId 공지사항 게시물 아이디
     * @param board 수정 할 게시물 객체
     * @return Board 수정한 게시물 객체
     *
     * 공지사항 수정하기
     */
    public Board updateBoard(Long boardId , Board board) {
        Board finded = this.boardDao.findByBoardId(boardId);
        if(finded == null) {
            return null;
        }
       return this.boardDao.save(finded);
    }

    /**
     * @param boardId 삭제할 공지사항 아이디
     * @return Boolean
     *  공지사항 삭제 하기
     */
    public Boolean deleteBoard(Long boardId) {
        Board finded = this.boardDao.findByBoardId(boardId);
        if(finded == null) {
            return false;
        }

        this.boardDao.delete(finded);
        return true;
    }
}
