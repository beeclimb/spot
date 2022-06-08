package github.beeclimb.spot.common.util.exception;

import github.beeclimb.spot.common.util.api.Response;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jun.ma
 * @date 2022/6/7 22:54:00
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 全局 api exception 处理
     */
    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public Response handle(ApiException e) {
        if (e.getResponseCode() != null) {
            return Response.fail(e.getResponseCode());
        }
        return Response.fail(e.getMessage());
    }

}
