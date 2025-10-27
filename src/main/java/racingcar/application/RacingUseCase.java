package racingcar.application;

import racingcar.parser.ParseCount;
import racingcar.parser.SplitCarName;
import racingcar.service.RacingService;
import racingcar.validator.ValidateCount;
import racingcar.validator.ValidateName;

import java.util.List;

public final class RacingUseCase {
    public RacingService returnElement(String carName, String tryCount) {
        List<String> carNames = SplitCarName.splitCarName(ValidateName.validateName(carName));
        int rounds = ParseCount.parseCount(ValidateCount.validateCount(tryCount));

        return RacingService.of(carNames, rounds);
    }
}
