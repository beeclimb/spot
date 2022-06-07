package github.beeclimb.spot.common.util.api;

/**
 * @author jun.ma
 * @date 2022/6/7 14:32:00
 */

public enum ResponseCodeEnum implements ResponseCode {
    SUCCESS(200, "successful"),
    FAILED(500, "failed");

    private final int code;
    private final String message;

    ResponseCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public static String getMessage(int code) {
        for (ResponseCodeEnum r : ResponseCodeEnum.values()) {
            if (r.getCode() == code) {
                return r.getMessage();
            }
        }
        return null;
    }

}
