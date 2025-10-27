package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MovableTest {

    @Test
    void 난수가_4이상인_경우에만_true를_반환한다() {
        int three = 3;
        int four = 4;

        assertThat(Movable.isMovable(three)).isFalse();
        assertThat(Movable.isMovable(four)).isTrue();
    }
}
