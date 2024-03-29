package com.hoondragonite.aboutme.repository;

import java.util.Optional;

import com.hoondragonite.aboutme.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    //소셜 로그인으로 반환되는 값 중 email을 통해 이미 생성된 사용자인지 처음 가입하는 사용자인지 판단하기 위함
    Optional<User> findByEmail(String email);
}