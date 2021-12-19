package com.rsuport.notice.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReadBoardDto {
    private String title;
    private String content;
    private LocalDateTime generateTime;
    private Long views;
    private String author;
}
//- 제목, 내용, 등록일시, 조회수, 작성자