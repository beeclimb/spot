package github.beeclimb.spot.common.util.api;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jun.ma
 * @date 2022/6/7 14:42:00
 */
@Getter
@Setter
public class Response<T> {
    /**
     * 状态码
     */
    private int code;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 数据封装
     */
    private T data;

    private Response() {
    }

    private Response(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Response<T> success(T data) {
        return new Response<T>(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getMessage(), data);
    }

    public static <T> Response<T> success() {
        return new Response<T>(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getMessage(), null);
    }

    public static <T> Response<T> fail() {
        return new Response<T>(ResponseCodeEnum.FAILED.getCode(), ResponseCodeEnum.FAILED.getMessage(), null);
    }

    public static <T> Response<T> fail(ResponseCode responseCode) {
        return new Response<T>(responseCode.getCode(), responseCode.getMessage(), null);
    }

    public static <T> Response<T> fail(String message) {
        return new Response<T>(ResponseCodeEnum.FAILED.getCode(), message, null);
    }

}
