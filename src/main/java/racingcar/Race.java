package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;


public class Race {
    private ArrayList<Car> cars;
    private int round;

    Race(ArrayList<Car> cars, int round) {
        this.cars = cars;
        this.round = round;
    }

    public void progressRounds() {
        System.out.println("실행 결과");
        for (int i = 0; i < this.round; i++) {
            moveCars();
            printScore();
            System.out.println(" ");
        }
    }

    private void moveCars() {
        int random;

        for (int i = 0; i < this.cars.size(); i++) {
            random = Randoms.pickNumberInRange(0, 9);
            if (random >= 4) {
                this.cars.get(i).move();
            }
        }
    }

    private void printScore() {
        for (int i = 0; i < this.cars.size(); i++) {
            System.out.print(this.cars.get(i).getName() + " : ");
            for (int j = 0; j < this.cars.get(i).getScore(); j++) {
                System.out.print("-");
            }
            System.out.println(" ");
        }
    }
}
