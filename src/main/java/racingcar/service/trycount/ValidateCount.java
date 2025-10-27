package racingcar.service.trycount;

import racingcar.exception.ErrorCode;
import racingcar.exception.RacingException;

public final class ValidateCount {
    private ValidateCount() {
    }

    public static String validateCount(String count) {
        if (count == null || count.isBlank()) {
            throw new RacingException(ErrorCode.INPUT_COUNT_NULL);
        }

        return count.trim();
    }
}
