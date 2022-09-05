package com.project.jobis.scrap.controller.response;

import com.project.jobis.exception.ErrorCode;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScrapData<T> {
    private Result result;
    private List<T> data;
    private String errMsg;
    private String company;
    private Long userId;

    public static <T> ScrapData<T> success(T data, String message) {
        return (ScrapData<T>) ScrapData.builder()
                .result(Result.SUCCESS)
                .data((List<Object>) data)
                .build();
    }

    public static <T> ScrapData<T> success(T data) {
        return success(data, null);
    }

    public static ScrapData fail(String message, String errorCode) {
        return ScrapData.builder()
                .result(Result.FAIL)
                .errMsg(message)
                .build();
    }

    public static ScrapData fail(ErrorCode errorCode) {
        return ScrapData.builder()
                .result(Result.FAIL)
                .errMsg(errorCode.getErrorMsg())
                .build();
    }

    public enum Result {
        SUCCESS, FAIL
    }
}
