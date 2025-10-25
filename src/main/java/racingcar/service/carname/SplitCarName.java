package racingcar.service.carname;

import racingcar.exception.ErrorCode;
import racingcar.exception.RacingException;

import java.util.ArrayList;
import java.util.List;

public final class SplitCarName {
    private SplitCarName() {
    }

    public static List<String> splitCarName(String carName) {
        String[] tokens = carName.split(",");
        List<String> carNames = new ArrayList<>();

        for (String token : tokens) {
            String name = token.trim();

            if (name.isEmpty()) {
                throw new RacingException(ErrorCode.INPUT_NAME_EMPTY);
            }

            if (name.length() > 5) {
                throw new RacingException(ErrorCode.INPUT_NAME_TOO_LONG);
            }

            carNames.add(name);
        }

        if (carNames.isEmpty()) {
            throw new RacingException(ErrorCode.AT_LEAST_ONE_CAR);
        }

        if (ValidateName.isDuplicated(carNames)) {
            throw new RacingException(ErrorCode.NO_DUPLICATE_CAR_NAME);
        }

        return carNames;
    }
}
