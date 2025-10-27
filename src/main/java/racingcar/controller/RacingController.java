package racingcar.controller;

import racingcar.application.RacingUseCase;
import racingcar.domain.CarState;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final RacingUseCase racingUseCase = new RacingUseCase();

    public void run() {
        OutputView.printInputName();
        String carName = InputView.carNameInput();

        OutputView.printInputNum();
        String count = InputView.numberInput();

        RacingService game = racingUseCase.returnElement(carName, count);
        playGame(game);
    }

    private void playGame(RacingService game) {
        OutputView.printResult();

        for (int round = 0; round < game.rounds(); round++) {
            for (CarState carstate : game.playRound()) {
                OutputView.printRound(carstate.carName(), carstate.position());
            }

            OutputView.println();
        }
        OutputView.printWinner(game.winners());
    }
}
