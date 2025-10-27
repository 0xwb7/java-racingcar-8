package racingcar.parser;

import racingcar.exception.ErrorCode;
import racingcar.exception.RacingException;
import racingcar.validator.ValidateName;

import java.util.ArrayList;
import java.util.List;

public final class SplitCarName {
    private static final String SPLIT_DELIMITER = ",";
    private static final int GET_LAST_TOKEN_NUMBER = -1;
    private static final int MAXIMUM_LENGTH_OF_NAME = 5;

    private SplitCarName() {
    }

    public static List<String> splitCarName(String carName) {
        String[] tokens = carName.split(SPLIT_DELIMITER, GET_LAST_TOKEN_NUMBER);
        List<String> carNames = new ArrayList<>();

        for (String token : tokens) {
            String name = token.trim();

            if (name.isEmpty()) {
                throw new RacingException(ErrorCode.INPUT_NAME_EMPTY);
            }

            if (name.length() > MAXIMUM_LENGTH_OF_NAME) {
                throw new RacingException(ErrorCode.INPUT_NAME_TOO_LONG);
            }

            carNames.add(name);
        }

        if (ValidateName.isDuplicated(carNames)) {
            throw new RacingException(ErrorCode.NO_DUPLICATE_CAR_NAME);
        }

        return carNames;
    }
}
