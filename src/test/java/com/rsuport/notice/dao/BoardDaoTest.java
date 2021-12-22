package com.rsuport.notice.dao;

import com.rsuport.notice.domain.Board;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

/**
 * 공지 사항 dao test
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BoardDaoTest {
    private final BoardDao boardDao;
    private Logger logger = LoggerFactory.getLogger(BoardDaoTest.class);

    @Autowired
    public BoardDaoTest(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    /**
     * findAll 과 save test
     */
    @Test
    public void findAllorSaveTest() {
        Board b1 = new Board();
        b1.setTitle("제목1");
        b1.setContent("내용1");
        Board b2 = new Board();
        b2.setTitle("제목2");
        b2.setContent("내용2");

        //when
        this.boardDao.save(b1);
        this.boardDao.save(b2);
        List<Board> boards = this.boardDao.findAll();

        //then
        Assertions.assertEquals(boards.size(), 2);
    }

    /**
     * findByBoardId 테스트
     */
    @Test
    public void findByBoardIdTest(){
        Board b1 = new Board();
        b1.setTitle("제목1");
        b1.setContent("내용1");
        //when
        Board inserted = this.boardDao.save(b1);
        logger.warn(inserted.toString());
        Board finded = this.boardDao.findByBoardId(inserted.getBoardId());

        //then
        Assertions.assertEquals("제목1", finded.getTitle());
    }
}
