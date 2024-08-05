package com.huejo.spring100studies.board.service;

import com.huejo.spring100studies.board.entity.BoardType;
import com.huejo.spring100studies.board.model.BoardTypeInput;
import com.huejo.spring100studies.board.model.ServiceResult;

public interface BoardService {

//    BoardType getByName(String boardName);
    ServiceResult addBoard(BoardTypeInput boardTypeInput);

    ServiceResult updateBoard(long id, BoardTypeInput boardTypeInput);

    ServiceResult deleteBoard(Long id);
}
