package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public final class InputView {
    private InputView() {
    }

    public static String carNameInput() {
        return Console.readLine();
    }

    public static String numberInput() {
        return Console.readLine();
    }
}
