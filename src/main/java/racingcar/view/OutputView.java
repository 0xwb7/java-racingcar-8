package racingcar.view;

import java.util.List;

public final class OutputView {
    private static final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String NUM_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String RESULT = "실행 결과";
    private static final String WINNER = "최종 우승자 : ";

    public static void printInputName() {
        System.out.println(NAME_INPUT_MESSAGE);
    }

    public static void printInputNum() {
        System.out.println(NUM_INPUT_MESSAGE);
    }

    public static void printResult() {
        System.out.println();
        System.out.println(RESULT);
    }

    public static void printRound(String carName, int cnt) {
        System.out.println(carName + " : " + "-".repeat(Math.max(0, cnt)));
    }

    public static void printWinner(List<String> winners) {
        System.out.println(WINNER + String.join(", ", winners));
    }

    public static void println() {
        System.out.println();
    }
}
