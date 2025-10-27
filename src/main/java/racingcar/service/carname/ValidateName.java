package racingcar.service.carname;

import racingcar.exception.ErrorCode;
import racingcar.exception.RacingException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class ValidateName {
    private ValidateName() {
    }

    public static String validateName(String carName) {
        if (carName == null || carName.isBlank()) {
            throw new RacingException(ErrorCode.INPUT_NAME_NULL);
        }

        String trimmedCarName = carName.trim();

        if (trimmedCarName.isEmpty()) {
            throw new RacingException(ErrorCode.INPUT_NAME_EMPTY);
        }

        return trimmedCarName;
    }

    public static boolean isDuplicated(List<String> carNames) {
        Set<String> carNamesSet = new HashSet<>(carNames);

        return carNamesSet.size() != carNames.size();
    }
}
