package racingcar.service.trycount;

import org.junit.jupiter.api.Test;
import racingcar.validator.ValidateCount;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class ValidateCountTest {

    @Test
    void 시도횟수_입력값이_공백이거나_null이면_예외처리한다() {
        String nullInput = null;
        String blankInput = " ";

        assertThatThrownBy(() -> ValidateCount.validateCount(nullInput))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> ValidateCount.validateCount(blankInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값의_양끝_공백을_제거한다() {
        String count = "  10 ";
        String trimmedCount = ValidateCount.validateCount(count);

        assertThat(trimmedCount).isEqualTo("10");
    }

}
