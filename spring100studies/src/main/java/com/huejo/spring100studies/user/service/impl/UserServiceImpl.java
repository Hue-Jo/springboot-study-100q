package com.huejo.spring100studies.user.service.impl;


import com.huejo.spring100studies.user.model.UserStatus;
import com.huejo.spring100studies.user.model.UserSummary;
import com.huejo.spring100studies.user.repository.UserRepository;
import com.huejo.spring100studies.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserSummary getUserStatusCount() {
        long usingUserCount = userRepository.countByStatus(UserStatus.USING);
        long stopUserCount = userRepository.countByStatus(UserStatus.STOP);
        long totalUserCount = userRepository.count();

        return UserSummary.builder()
                .usingUserCount(usingUserCount)
                .stopUserCount(stopUserCount)
                .totalUserCount(totalUserCount)
                .build();
    }
}
