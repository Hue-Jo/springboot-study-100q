package com.huejo.spring100studies.board.repository;

import com.huejo.spring100studies.board.entity.Board;
import com.huejo.spring100studies.board.entity.BoardType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {


    long countByBoardType(BoardType boardType);
}
