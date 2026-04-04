package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;


public class Race {
    Race(){}

    public void progressRounds(ArrayList<Car> cars, int round){
        System.out.println("실행 결과");
        for (int i = 0; i < round; i++){
            moveCars(cars);
            printScore(cars);
            System.out.println(" ");
        }
    }

    private void moveCars(ArrayList<Car> cars){
        int random;

        for (int i = 0; i < cars.size(); i++){
            random = Randoms.pickNumberInRange(0, 9);
            if(random >= 4){
                cars.get(i).move();
            }
        }
    }

    private void printScore(ArrayList<Car> cars){
        for(int i = 0; i < cars.size(); i++){
            System.out.print(cars.get(i).getName() + " : ");
            for(int j = 0; j < cars.get(i).getScore(); j++){
                System.out.print("-");
            }
            System.out.println(" ");
        }
    }
}
