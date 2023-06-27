package com.pmn.gmt.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    UNAUTHENTICATED_USER(401, "인증되지 않은 사용자입니다."),

    INVALID_FILTER(404,"유효하지 않은 필터입니다."),
    NOT_FOUND_TEACHER(404,"존재하지 않는 교사입니다."),

    NOT_FOUND_CLASSROOM(404,"존재하지 않는 교실입니다."),
    USER_NOT_FOUND(404, "존재하지 않는 학생입니다."),

    ROLE_NOT_EXIST( 404, "역할이 존재하지 않습니다."),
    UNAUTHORIZED(401,"권한이 없습니다."),
    EXPIRED_TOKEN(401, "토큰이 만료되었습니다."),

    INTERNAL_SERVER_ERROR(500,"서버 에러");

    private final int status;
    private final String description;
}
