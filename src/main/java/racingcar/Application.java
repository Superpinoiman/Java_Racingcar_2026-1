package racingcar;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RaceSetup setup = new RaceSetup();
        setup.raceSetup();

        Race race = new Race(setup.getCarsList(), setup.getRound());
        race.progressRounds();

        RaceResult result = new RaceResult(setup.getCarsList());
        result.printWinner();
    }
}
