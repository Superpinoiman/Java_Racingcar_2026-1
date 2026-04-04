package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RaceSetup {
    private ArrayList<Car> cars;
    private int round;

    RaceSetup(){}

    public void raceSetup() {
        cars = this.setupCars();
        this.inputRound();
    }

    public ArrayList<Car> getCarsList() {
        return cars;
    }

    public int getRound() {
        return round;
    }

    private boolean isDuplicateName(ArrayList<Car> cars) {
        Set<String> nameSet = new HashSet<>();

        for (int i = 0; i < cars.size() ; i++) {
            if (!nameSet.add(cars.get(i).getName())) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<Car> setupCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");
        ArrayList<Car> cars = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            if (names[i].length() > 5 || names[i].contains(" ") || names[i].isEmpty()) {
                throw new IllegalArgumentException();
            }
            cars.add(new Car(names[i]));
        }
        if (isDuplicateName(cars)) {
            throw new IllegalArgumentException();
        }
        return cars;
    }

    private void inputRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            this.round = Integer.parseInt(Console.readLine().trim());
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        if (this.round <= 0) {
            throw new IllegalArgumentException();
        }
        System.out.println(" ");
    }
}
