package racingcar.service;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarState;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    void 자동차_이름_라운드_수_car_객체생성_잘_되는지_확인() {
        List<String> carNames = List.of("car1", "car2", "car3");
        int rounds = 3;

        RacingGame game = RacingGame.of(carNames, rounds);

        assertThat(game.rounds()).isEqualTo(rounds);
        assertThat(game.cars())
                .hasSize(3)
                .extracting(Car::getCarName)
                .containsExactly("car1", "car2", "car3");
    }

    @Test
    void 스냅샷_사이즈_체크() {
        RacingGame game = RacingGame.of(List.of("car1", "car2", "car3"), 1);
        List<CarState> carStates = game.playRound();

        assertThat(carStates).hasSize(3);
        assertThat(carStates).extracting(CarState::carName)
                .containsExactly("car1", "car2", "car3");
    }

    @Test
    void 우승자_확인_테스트() {
        RacingGame game = RacingGame.of(List.of("car1", "car2", "car3"), 1);

        for (Car car : game.cars()) {
            if (car.getCarName().equals("car1") ||  car.getCarName().equals("car2")) {
                car.move();
            }
        }

        List<String> winner = game.winners();
        assertThat(winner).containsExactly("car1", "car2");
    }
}
