package org.example.dsm.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.example.dsm.domain.board.domain.Board;
import org.example.dsm.domain.board.domain.repository.BoardRepository;
import org.example.dsm.domain.board.presentation.dto.request.BoardRequest;
import org.example.dsm.domain.board.presentation.dto.response.BoardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;

    public void createBoard(BoardRequest request) {
        Board board = new Board(request.getTitle(), request.getContent());
        boardRepository.save(board);
    }

    public void updateBoard(Long id, BoardRequest request) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "board not found"));
        board.updateBoard(request.getTitle(), request.getContent());
    }

    public BoardResponse queryBoardDetail(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "board not found."));
        return new BoardResponse(board.getId(), board.getTitle(), board.getContent());
    }

    public List<BoardResponse> queryBoardList() {
        List<Board> boards = boardRepository.findAll();
        List<BoardResponse> boardResponseList = new ArrayList<>();

        for (Board board : boards) {
            BoardResponse boardResponse =
                    new BoardResponse(board.getId(), board.getTitle(), board.getContent());

            boardResponseList.add(boardResponse);
        }

        return boardResponseList;
    }

    public void deleteBoard(Long id) {
        Board board = boardRepository.findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "board not found"));
        boardRepository.delete(board);
    }
}
