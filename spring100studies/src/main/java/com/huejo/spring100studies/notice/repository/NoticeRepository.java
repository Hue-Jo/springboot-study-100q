package com.huejo.spring100studies.notice.repository;

import com.huejo.spring100studies.notice.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {

    //Optional로 싸주는 이유 = 없을 수도 있으니까

    Optional<List<Notice>> findByIdIn(List<Long> idList);

    // 제목 내용 동일, 등록시간이 체크시간보다 크다
    Optional<List<Notice>> findByTitleAndContentsAndRegisterDtIsGreaterThanEqual(String title, String contents, LocalDateTime registerDt);

    int countByTitleAndContentsAndRegisterDtIsGreaterThanEqual(String title, String contents, LocalDateTime registerDt);


}
