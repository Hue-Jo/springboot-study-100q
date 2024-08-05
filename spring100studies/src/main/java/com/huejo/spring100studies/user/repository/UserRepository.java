package com.huejo.spring100studies.user.repository;

import com.huejo.spring100studies.user.entity.User;
import com.huejo.spring100studies.user.model.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    int countByEmail(String email);

    Optional<User> findByIdAndPassword(Long id, String password);

    Optional<User> findByUserNameAndPhone(String userName, String phone);

    Optional<User> findByEmail(String email);

    List<User> findByEmailContainsOrPhoneContainsOrUserNameContains(String email, String phone, String userName);

    long countByStatus(UserStatus userStatus);

    @Query("SELECT u FROM User u WHERE u.regDt BETWEEN :startDate AND :endDate")
    List<User> findToday(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}
