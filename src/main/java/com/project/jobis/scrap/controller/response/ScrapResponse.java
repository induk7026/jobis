package com.project.jobis.scrap.controller.response;

import com.project.jobis.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScrapResponse<T> {
    private Result result;
    private T data;
    private String message;
    private String errorCode;
    private String appVer;
    private String hostNm;
    private String workerResDt;
    private String workerReqDt;

    public static <T> ScrapResponse<T> success(T data, String message) {
        return (ScrapResponse<T>) ScrapResponse.builder()
                .result(Result.SUCCESS)
                .data(data)
                .message(message)
                .build();
    }

    public static <T> ScrapResponse<T> success(T data) {
        return success(data, null);
    }

    public static ScrapResponse fail(String message, String errorCode) {
        return ScrapResponse.builder()
                .result(Result.FAIL)
                .message(message)
                .errorCode(errorCode)
                .build();
    }

    public static ScrapResponse fail(ErrorCode errorCode) {
        return ScrapResponse.builder()
                .result(Result.FAIL)
                .message(errorCode.getErrorMsg())
                .errorCode(errorCode.name())
                .build();
    }

    public enum Result {
        SUCCESS, FAIL
    }
}
