package racingcar.service.carname;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import java.util.List;


class ValidateNameTest {

    @Test
    void 자동차_이름이_공백이나_null값이면_예외처리한다() {
        String nullInput = null;
        String blankInput = " ";

        assertThatThrownBy(() -> ValidateName.validateName(nullInput))
            .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> ValidateName.validateName(blankInput))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값의_양끝_공백을_제거한다() {
        String carName = "   car1, car2   ";
        String trimmedCarName = ValidateName.validateName(carName);
        assertThat(trimmedCarName).isEqualTo("car1, car2");
    }

    @Test
    void 자동차_이름이_중복이면_True를_반환한다() {
        var carNames = List.of("car1", "car1");
        boolean result = ValidateName.isDuplicated(carNames);

        assertThat(result).isTrue();
    }
}
