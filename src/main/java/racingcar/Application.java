package racingcar;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RaceSetup setup = new RaceSetup();
        Race race = new Race();
        RaceResult result = new RaceResult();
        setup.raceSetup();
        race.progressRounds(setup.getCarsList(),setup.getRound());
        result.printWinner(setup.getCarsList());
    }
}
