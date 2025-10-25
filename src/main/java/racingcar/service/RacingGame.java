package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.CarState;
import racingcar.domain.Movable;
import racingcar.util.RandomNumber;

import java.util.ArrayList;
import java.util.List;

public record RacingGame(List<Car> cars, int rounds) {

    public static RacingGame of(List<String> carNames, int tryCount) {

        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }

        return new RacingGame(cars, tryCount);
    }

    public List<CarState> playRound() {
        for (Car car : cars) {
            int random = RandomNumber.pickRandomNumber();

            if (Movable.isMovable(random)) {
                car.move();
            }
        }

        return snapshot();
    }

    public List<String> winners() {
        int max = 0;

        for (Car car : cars) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
        }

        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() == max) {
                winners.add(car.getCarName());
            }
        }

        return winners;
    }

    private List<CarState> snapshot() {
        List<CarState> carStates = new ArrayList<>();

        for (Car car : cars) {
            carStates.add(new CarState(car.getCarName(), car.getPosition()));
        }

        return carStates;
    }
}
