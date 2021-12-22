package com.rsuport.notice.dao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BoardFileDaoTest {
    private final BoardFileDao boardFileDao;

    public BoardFileDaoTest(BoardFileDao boardFileDao) {
        this.boardFileDao = boardFileDao;
    }

    @Test
    public void saveTest() {
        
    }
}
