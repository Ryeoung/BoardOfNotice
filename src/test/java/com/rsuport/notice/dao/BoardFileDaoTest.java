package com.rsuport.notice.dao;

import com.rsuport.notice.domain.Board;
import com.rsuport.notice.domain.BoardFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

/**
 * BoardFileDao Test
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BoardFileDaoTest {
    private final BoardFileDao boardFileDao;
    private final BoardDao boardDao;
    @Autowired
    public BoardFileDaoTest(BoardFileDao boardFileDao, BoardDao boardDao) {
        this.boardFileDao = boardFileDao;
        this.boardDao = boardDao;
    }

    /**
     * save와 findAll 테스트
     */
    @Test
    public void saveAndFindAllTest() {
        Board board = new Board();
        board.setTitle("공지 사항 제목 1");
        board.setContent("공지 사항 내용 1");
        Board inserted = boardDao.save(board);

        BoardFile bf1 = new BoardFile();
        bf1.setFileName("공지 사항 첨부 파일 1");
        bf1.setBoard(inserted);
        BoardFile bf2 = new BoardFile();
        bf2.setFileName("공지 사항 첨부 파일 2");
        bf2.setBoard(inserted);

        //when
        this.boardFileDao.save(bf1);
        this.boardFileDao.save(bf2);

        List<BoardFile> boardFiles = this.boardFileDao.findAll();

        //then
        Assertions.assertEquals(boardFiles.size(), 2);

    }
}
