package response;

public enum ResponseCode {

    OK(200, "OK");

    private int httpStatus;
    private String message;

    ResponseCode(int httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseCode{" +
                "httpStatus=" + httpStatus +
                ", message='" + message + '\'' +
                '}';
    }
}
