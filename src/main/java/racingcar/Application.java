package racingcar;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ArrayList<Car> cars;
        Race race = new Race();
        RaceResult result = new RaceResult();
        cars = race.raceStart();
        result.showResult(cars);
    }
}
