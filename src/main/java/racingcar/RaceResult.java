package racingcar;

import java.util.ArrayList;

public class RaceResult {
    RaceResult(){}

    public void printWinner(ArrayList<Car> cars) {
        boolean flag = true;

        cars = this.findWinner(cars);
        System.out.print("최종 우승자 : ");

        for (int i = 0; i < cars.size(); i++){
            if(cars.get(i).isWinner() && !flag){
                System.out.print(", ");
                System.out.print(cars.get(i).getName());
            }
            if(cars.get(i).isWinner() && flag) {
                System.out.print(cars.get(i).getName());
                flag = false;
            }
        }
    }

    private ArrayList<Car> findWinner(ArrayList<Car> cars){
        int maxScore = 0;

        for(int i = 0; i < cars.size(); i++){
            if(cars.get(i).getScore() >= maxScore){
                maxScore = cars.get(i).getScore();
            }
        }

        for(int i = 0; i < cars.size(); i++){
            if(cars.get(i).getScore() == maxScore){
                cars.get(i).win();
            }
        }
        return cars;
    }
}
