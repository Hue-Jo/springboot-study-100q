package com.huejo.spring100studies.util;

import lombok.experimental.UtilityClass;
import org.springframework.security.crypto.bcrypt.BCrypt;

@UtilityClass
public class PasswordUtils {


    // 입력한 패스워드를 해시된 패스워드랑 비교하는 함수
    public static boolean equalPassword(String password, String encryptedPassword) {
        return BCrypt.checkpw(password, encryptedPassword);
    }
}
