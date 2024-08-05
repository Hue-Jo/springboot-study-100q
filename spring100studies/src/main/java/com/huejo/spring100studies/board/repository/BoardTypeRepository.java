package com.huejo.spring100studies.board.repository;

import com.huejo.spring100studies.board.entity.BoardType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardTypeRepository extends JpaRepository<BoardType, Long> {

    BoardType findByBoardName(String name);
}
