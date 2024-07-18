package com.huejo.spring100studies.user.repository;

import com.huejo.spring100studies.user.entity.UserLoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoginHistoryRepository extends JpaRepository<UserLoginHistory, Long> {
}
