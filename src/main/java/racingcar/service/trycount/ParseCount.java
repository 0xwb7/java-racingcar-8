package racingcar.service.trycount;

import racingcar.exception.ErrorCode;
import racingcar.exception.RacingException;

public final class ParseCount {
    private ParseCount() {
    }

    public static int parseCount(String count) {
        int tryCount = Integer.parseInt(count);

        if (tryCount <= 0) {
            throw new RacingException(ErrorCode.INPUT_COUNT_NOT_POSITIVE);
        }

        return tryCount;
    }
}
