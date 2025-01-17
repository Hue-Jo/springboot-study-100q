package com.huejo.spring100studies.board.service;

import com.huejo.spring100studies.board.entity.BoardType;
import com.huejo.spring100studies.board.model.BoardTypeInput;
import com.huejo.spring100studies.board.model.ServiceResult;
import com.huejo.spring100studies.board.repository.BoardRepository;
import com.huejo.spring100studies.board.repository.BoardTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardTypeRepository boardTypeRepository;
    private final BoardRepository boardRepository;

    @Override
    public ServiceResult addBoard(BoardTypeInput boardTypeInput) {

        BoardType boardType = boardTypeRepository.findByBoardName(boardTypeInput.getName());

        if (boardType != null && boardTypeInput.getName().equals(boardType.getBoardName())) {
            return ServiceResult.fail("이미 동일한 게시판이 동일합니다.");
        }

        BoardType addBoardType = BoardType.builder()
                .boardName(boardTypeInput.getName())
                .regDate(LocalDateTime.now())
                .build();
        boardTypeRepository.save(addBoardType);

        return ServiceResult.success();
    }

    @Override
    public ServiceResult updateBoard(long id, BoardTypeInput boardTypeInput) {

        Optional<BoardType> optionalBoardType = boardTypeRepository.findById(id);

        if (!optionalBoardType.isPresent()) {
            return ServiceResult.fail("수정할 게시판이 없습니다.");
        }

        BoardType boardType = optionalBoardType.get();
        if (boardType != null && boardTypeInput.getName().equals(boardType.getBoardName())) {
            return ServiceResult.fail("수정할 이름이 동일한 게시판명입니다.");
        }

        boardType.setBoardName(boardTypeInput.getName());
        boardType.setUpdateDate(LocalDateTime.now());
        boardTypeRepository.save(boardType);

        return ServiceResult.success();
    }

    @Override
    public ServiceResult deleteBoard(Long id) {

        Optional<BoardType> optionalBoardType = boardTypeRepository.findById(id);

        if (!optionalBoardType.isPresent()) {
            return ServiceResult.fail("삭제할 게시판이 없습니다.");
        }

        BoardType boardType = optionalBoardType.get();
        if (boardRepository.countByBoardType(boardType) > 0) {
            return ServiceResult.fail("삭제할 게시판 타입의 게시글이 존재합니다.");
        }

        boardTypeRepository.delete(boardType);
        return ServiceResult.success();
    }
}
