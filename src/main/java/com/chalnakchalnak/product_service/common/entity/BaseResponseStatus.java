package com.chalnakchalnak.product_service.common.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@AllArgsConstructor
public enum BaseResponseStatus {

    // 400 Bad Request - 잘못된 파라미터
    BAD_REQUEST_INVALID_PARAM(HttpStatus.BAD_REQUEST, 400, "잘못된 요청입니다. 파라미터를 확인해주세요."),

    // 404 Not Found - 잘못된 경로 요청
    NOT_FOUND(HttpStatus.NOT_FOUND, 404, "요청한 리소스를 찾을 수 없습니다."),

    // 405 Method Not Allowed - 허용되지 않은 HTTP 메서드
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, 405, "허용되지 않은 HTTP 메서드입니다."),

    // 500 Internal Server Error - 서버 내부 에러
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 500,"서버 내부 오류가 발생했습니다. 관리자에게 문의해주세요."),

    /**
     * 400 : security 에러
     */
    NO_SIGN_IN(HttpStatus.UNAUTHORIZED, 402, "로그인을 먼저 진행해주세요"),

    /**
     * 900: 기타 에러
     */
   INVALID_INPUT(HttpStatus.BAD_REQUEST, 902, "유효하지 입력입니다"),


    NO_EXISTS_PRODUCT(HttpStatus.NOT_FOUND, 2200, "존재하지 않는 상품입니다."),

    /**
     * 3000: product service error
     */
    FAILED_TO_GET_DATA(HttpStatus.NOT_FOUND, 2201, "데이터 조회에 실패했습니다. "),

    /**
     * 6000: gpt-api error
     */
    // S3
    S3_UPLOAD_FAIL(HttpStatus.BAD_REQUEST, 2202, "파일 업로드에 실패하였습니다."),

    FAILED_TO_DELETE_THUMBNAIL(HttpStatus.INTERNAL_SERVER_ERROR, 2203, "썸네일 이미지는 삭제 불가능합니다."),
    NO_EXISTS_IMAGE(HttpStatus.NOT_FOUND, 2204, "존재하지 않는 이미지입니다."),
    UNABLE_TO_CALCULATE_HMAC(HttpStatus.INTERNAL_SERVER_ERROR, 2205, "HMAC을 계산할 수 없습니다"),

    // outbox
    FAILED_TO_SAVE_OUTBOX(HttpStatus.INTERNAL_SERVER_ERROR, 2206, "아웃박스 저장에 실패했습니다."),
    NO_EXISTS_OUTBOX(HttpStatus.NOT_FOUND, 2207, "존재하지 않는 아웃박스입니다."),
    ;

    private final HttpStatusCode httpStatusCode;
    private final int code;
    private final String message;
}
