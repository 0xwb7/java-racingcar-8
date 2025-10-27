package racingcar.service.carname;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import java.util.List;


class SplitCarNameTest {

    @Test
    void 자동차_이름은_쉼표로_구분한다() {
        String carName = "car1, car2, car3";
        List<String> carNames = SplitCarName.splitCarName(carName);
        assertThat(carNames).containsExactly("car1", "car2", "car3");
    }

    @Test
    void 자동차_이름이_공백이면_예외한다() {
        String carName = "car1, ,car3";
        assertThatThrownBy(() -> SplitCarName.splitCarName(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름은_다섯_글자를_넘길_수_없다() {
        String carName = "car1, car2, longname";

        assertThatThrownBy(() -> SplitCarName.splitCarName(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름은_중복_불가능하다() {
        String carName = "car1, car1";

        assertThatThrownBy(() -> SplitCarName.splitCarName(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
