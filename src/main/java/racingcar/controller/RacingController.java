package racingcar.controller;

import racingcar.domain.CarState;
import racingcar.model.RacingGame;
import racingcar.model.carname.SplitCarName;
import racingcar.model.carname.ValidateName;
import racingcar.model.trycount.ParseCount;
import racingcar.model.trycount.ValidateCount;
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

        RacingGame racingGame = RacingGame.of(carNames, tryCount);

        OutputView.printResult();
        for (int round = 0; round < racingGame.rounds(); round++) {
            for (CarState carState : racingGame.playRound()) {
                OutputView.printRound(carState.carName(), carState.position());
            }

            OutputView.println();
        }
        OutputView.printWinner(racingGame.winners());
    }
}
