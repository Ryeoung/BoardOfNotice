package com.rsuport.notice.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum ResponseStatus {
    SUCCESS("success", "성공"),
    EXTENSION_NOT_FOUND("fail01", "해당 게시물를 찾지 못했습니다."),
    EXTENSION_EXISIT("fail02", "해당 게시물은 이미 존재합니다."),
    DB_ACCESS_FAIL_ERROR("fail03","DB 관련된 에러가 발생하였습니다."),
    NO_VALID_ARGUMENT("fail04", "입력하신 데이터 값이 타당하지 않습니다."),
    INTERNAL_SERVER_ERROR("fail05","내부 서버 에러가 발생했습니다.");

    String code;
    String msg;

    ResponseStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
