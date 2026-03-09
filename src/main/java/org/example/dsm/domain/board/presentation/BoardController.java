package org.example.dsm.domain.board.presentation;

import lombok.RequiredArgsConstructor;
import org.example.dsm.domain.board.presentation.dto.request.BoardRequest;
import org.example.dsm.domain.board.presentation.dto.response.BoardResponse;
import org.example.dsm.domain.board.service.BoardService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public void createBoard(@RequestBody BoardRequest request) {
        boardService.createBoard(request);
    }

    @PatchMapping("/{board-id}")
    public void updateBoard(@PathVariable("board-id") Long boardId, @RequestBody BoardRequest request) {
        boardService.updateBoard(boardId, request);
    }

    @GetMapping
    public List<BoardResponse> queryBoardList() {
        return boardService.queryBoardList();
    }

    @GetMapping("/{board-id}")
    public BoardResponse queryBoardDetail(@PathVariable("board-id") Long boardId) {
        return boardService.queryBoardDetail(boardId);
    }

    @DeleteMapping("/{board-id}")
    public void deleteBoard(@PathVariable("board-id") Long boardId) {
        boardService.deleteBoard(boardId);
    }
}
