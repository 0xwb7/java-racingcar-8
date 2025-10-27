package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RacingController;
import racingcar.exception.RacingException;

public class Application {
    public static void main(String[] args) {
        try {
            new RacingController().run();
        } catch (RacingException e) {
            System.out.println(e.getMessage());
        } finally {
            Console.close();
        }
    }
}
