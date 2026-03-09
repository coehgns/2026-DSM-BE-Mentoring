package org.example.dsm.domain.board.domain.repository;

import org.example.dsm.domain.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
