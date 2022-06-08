package github.beeclimb.spot.common.util.exception;

import github.beeclimb.spot.common.util.api.ResponseCode;

/**
 * 服务端异常类
 *
 * @author jun.ma
 * @date 2022/6/7 23:06:00
 */
public class ApiException extends RuntimeException {
    ResponseCode responseCode;

    public ApiException(ResponseCode responseCode) {
        super(responseCode.getMessage());
        this.responseCode = responseCode;
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResponseCode getResponseCode() {
        return responseCode;
    }

}
