package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public final class RandomNumber {
    private RandomNumber() {
    }

    public static int pickRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
