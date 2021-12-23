package com.rsuport.notice.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table(name = "board")

public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long boardId;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "views")
    private Long views;

    @Column(name = "author")
    private String author;

    @OneToMany(mappedBy = "board")
    Set<BoardFile> boardFiles = new HashSet<>();

    @Column(name = "generate_time")
    private LocalDateTime generateTime;

    @Column(name = "start_data_time")
    private LocalDateTime startDataTime;

    @Column(name = "fin_data_time")
    private LocalDateTime finDataTime;

}
