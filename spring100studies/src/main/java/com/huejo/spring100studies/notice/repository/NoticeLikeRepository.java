package com.huejo.spring100studies.notice.repository;

import com.huejo.spring100studies.notice.entity.Notice;
import com.huejo.spring100studies.notice.entity.NoticeLike;
import com.huejo.spring100studies.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface NoticeLikeRepository extends JpaRepository<NoticeLike, Long> {

    List<NoticeLike> findByUser(User user);

}
