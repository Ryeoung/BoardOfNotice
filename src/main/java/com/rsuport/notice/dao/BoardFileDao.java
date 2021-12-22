package com.rsuport.notice.dao;

import com.rsuport.notice.domain.BoardFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardFileDao extends JpaRepository<BoardFile, Long> {
}
