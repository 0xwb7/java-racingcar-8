package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public final class RandomNumber {
    private static final int RANDOM_MIN_NUM = 0;
    private static final int RANDOM_MAX_NUM = 9;
    private RandomNumber() {
    }

    public static int pickRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_MIN_NUM, RANDOM_MAX_NUM);
    }
}
