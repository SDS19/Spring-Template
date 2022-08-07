package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Return value of all RPC methods.
 *
 * Normally the different modules of distributed system return different data types,
 * to simplify the data processing of service consumer, we use the unified return
 * value data type: ReturnEntity<T>
 *
 * @param <T> data type of transferred data
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultEntity<T> {

    public static final String SUCCESS = "SUCCESS";
    public static final String FAILED = "FAILED";

    private String result;//response result

    private String message;//failed message

    private T data;//transferred data

    public static <T> ResultEntity<T> successWithoutData() {
        return new ResultEntity<>(SUCCESS, null, null);
    }

    public static <T> ResultEntity<T> successWithData(T data) {
        return new ResultEntity<>(SUCCESS, null, data);
    }

    public static <T> ResultEntity<T> failed(String msg) {
        return new ResultEntity<>(FAILED, msg, null);
    }
}
