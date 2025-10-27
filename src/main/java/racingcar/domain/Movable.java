package racingcar.domain;

public final class Movable {
    private static final int MOVABLE_NUMBER = 4;

    private Movable() {
    }

    public static boolean isMovable(int random) {
        return random >= MOVABLE_NUMBER;
    }
}
