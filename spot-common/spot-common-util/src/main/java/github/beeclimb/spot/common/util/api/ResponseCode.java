package github.beeclimb.spot.common.util.api;

/**
 * @author jun.ma
 * @date 2022/6/7 14:09:00
 */
public interface ResponseCode {
    /**
     * 获取状态码
     */
    int getCode();

    /**
     * 获取状态信息
     */
    String getMessage();

}
