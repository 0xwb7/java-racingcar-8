package racingcar.exception;

public enum ErrorCode {
    INPUT_NAME_NULL("입력값이 존재하지 않습니다."),
    INPUT_NAME_EMPTY("이름은 비어있을 수 없습니다."),
    INPUT_NAME_TOO_LONG("자동차 이름은 5자 이하여야 합니다."),
    NO_DUPLICATE_CAR_NAME("자동차 이름은 중복될 수 없습니다."),
    INPUT_COUNT_NULL("시도 횟수 입력값이 존재하지 않습니다."),
    INPUT_COUNT_EMPTY("시도 횟수는 비어있을 수 없습니다."),
    INPUT_COUNT_NOT_POSITIVE("시도 횟수는 양의 정수여야 합니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
