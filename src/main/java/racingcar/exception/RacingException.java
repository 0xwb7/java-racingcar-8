package racingcar.exception;

public class RacingException extends IllegalArgumentException {
    public RacingException(ErrorCode errorCode) {
        super(errorCode.message());
    }
}
