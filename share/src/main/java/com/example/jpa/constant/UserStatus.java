package com.example.jpa.constant;

/**
 * 유저의 상태 타입을 관리하는 Enum 입니다.
 *
 * @author newbalancer
 * @see com.example.jpa.domain.user.User
 */
public enum UserStatus {
    /**
     * 일반적인 회원 가입 상태
     */
    DEFAULT,
    /**
     * 차단 유저
     */
    BLOCK,
    /**
     * 휴면 유저
     */
    DORMANCY,
    /**
     * 휴면 대기 상태
     */
    DORMANCY_READY,
    /**
     * 탈퇴
     */
    DELETE
}
