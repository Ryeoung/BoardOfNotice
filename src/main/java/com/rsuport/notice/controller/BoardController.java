package com.rsuport.notice.controller;

import com.rsuport.notice.domain.Board;
import com.rsuport.notice.dto.ReadBoardDto;
import com.rsuport.notice.response.ResponseMessage;
import com.rsuport.notice.service.BoardService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class BoardController {
    private final BoardService boardService;
    private final ModelMapper modelMapper;

    @Autowired
    public BoardController(BoardService boardService, ModelMapper modelMapper) {
        this.boardService = boardService;
        this.modelMapper = modelMapper;
    }

    /**
     * @return  ResponseEntity<ResponseMessage>
     *    모든 게시물 데이터(ReadBoardDto)를 응답
     */
    @GetMapping("/boards")
    public ResponseEntity<ResponseMessage> getAllBoards() {
        List<Board> boards = this.boardService.findAllBoard();
        List<ReadBoardDto> readBoardDtos = boards.stream()
                .map(board -> this.convertTReadBoardDto(board))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK)
                .body(ResponseMessage.success(readBoardDtos));
    }

    @PutMapping("/boards/{boardId}")
    public ResponseEntity<ResponseMessage> updateBoard(@PathVariable Long boardId,
                                                       @RequestBody Board board) {
        Board updatedBoard = this.boardService.updateBoard(boardId, board);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseMessage.success());

    }

    @DeleteMapping("/boards/{boardId}")
    public ResponseEntity<ResponseMessage> deleteBoard(@PathVariable Long boardId){
        boolean isDelete = this.boardService.deleteBoard(boardId);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseMessage.success());
    }


    private ReadBoardDto convertTReadBoardDto(Board board) {
        ReadBoardDto dto = modelMapper.map(board, ReadBoardDto.class);
        return dto;
    }

}
