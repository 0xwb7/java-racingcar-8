package racingcar.service.trycount;

import org.junit.jupiter.api.Test;
import racingcar.parser.ParseCount;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParseCountTest {

    @Test
    void 문자열을_정수로_바꿔준다() {
        String count = "10";
        int tryCount = ParseCount.parseCount(count);

        assertThat(tryCount).isEqualTo(10);
    }

    @Test
    void 숫자가_아닌_문자열이_들어온_경우_예외처리한다() {
        String notNumber = "abc";

        assertThatThrownBy(() -> ParseCount.parseCount(notNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음수나_0이_들어오면_예외처리한다() {
        String zero = "0";
        String negative = "-3";

        assertThatThrownBy(() -> ParseCount.parseCount(zero))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> ParseCount.parseCount(negative))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
