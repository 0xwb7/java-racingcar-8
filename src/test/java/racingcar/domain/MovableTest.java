package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MovableTest {

    @Test
    void 난수가_4이상인_경우에만_true를_반환한다() {
        int zero = 0;
        int three = 3;
        int four = 4;
        int nine = 9;

        assertThat(Movable.isMovable(zero)).isFalse();
        assertThat(Movable.isMovable(three)).isFalse();
        assertThat(Movable.isMovable(four)).isTrue();
        assertThat(Movable.isMovable(nine)).isTrue();
    }
}
