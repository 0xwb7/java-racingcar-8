package racingcar.domain;

public final class Movable {
    private Movable() {
    }

    public static boolean isMovable(int random) {
        return random >= 4;
    }
}
