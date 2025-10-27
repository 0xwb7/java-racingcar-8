package racingcar.controller;

import racingcar.domain.CarState;
import racingcar.service.RacingService;
import racingcar.parser.SplitCarName;
import racingcar.validator.ValidateName;
import racingcar.parser.ParseCount;
import racingcar.validator.ValidateCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {
    public void run() {
        OutputView.printInputName();
        String carName = InputView.carNameInput();
        List<String> carNames = SplitCarName.splitCarName(ValidateName.validateName(carName));

        OutputView.printInputNum();
        String count = InputView.numberInput();
        int tryCount = ParseCount.parseCount(ValidateCount.validateCount(count));

        RacingService racingService = RacingService.of(carNames, tryCount);

        OutputView.printResult();
        for (int round = 0; round < racingService.rounds(); round++) {
            for (CarState carState : racingService.playRound()) {
                OutputView.printRound(carState.carName(), carState.position());
            }

            OutputView.println();
        }
        OutputView.printWinner(racingService.winners());
    }
}
