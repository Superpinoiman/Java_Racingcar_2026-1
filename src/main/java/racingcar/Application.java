package racingcar;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Race race = new Race();
        RaceResult result = new RaceResult();
        race.raceStart();
        result.showResult(race.getCars());
    }
}
