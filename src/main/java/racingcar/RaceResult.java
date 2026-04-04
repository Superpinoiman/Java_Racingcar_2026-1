package racingcar;

import java.util.ArrayList;

public class RaceResult {
    private ArrayList<Car> cars;
    RaceResult(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public void printWinner() {
        boolean flag = true;

        this.findWinner();
        System.out.print("최종 우승자 : ");

        for (int i = 0; i < this.cars.size(); i++) {
            if (this.cars.get(i).isWinner() && !flag) {
                System.out.print(", ");
                System.out.print(this.cars.get(i).getName());
            }
            if (this.cars.get(i).isWinner() && flag) {
                System.out.print(this.cars.get(i).getName());
                flag = false;
            }
        }
    }

    private void findWinner() {
        int maxScore = 0;

        for (int i = 0; i < this.cars.size(); i++) {
            if (this.cars.get(i).getScore() >= maxScore) {
                maxScore = this.cars.get(i).getScore();
            }
        }

        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getScore() == maxScore) {
                cars.get(i).win();
            }
        }
    }
}
