package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Race {
    private ArrayList<Car> cars;
    private int round = 0;

    Race(){}

    public ArrayList<Car> raceStart(){
        cars = this.setupCars();
        round = this.inputRound();
        cars = this.progressRounds(round, cars);
        return cars;
    }

    private boolean isDuplicateName(ArrayList<Car> cars){
        Set<String> nameSet = new HashSet<>();

        for(int i = 0; i < cars.size() ; i++) {
            if (!nameSet.add(cars.get(i).getName())) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<Car> setupCars(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");
        ArrayList<Car> cars = new ArrayList<>();

        for(int i = 0; i < names.length; i++){
            if(names[i].length() > 5 || names[i].contains(" ") || names[i].isEmpty()){
                throw new IllegalArgumentException();
            }
            cars.add(new Car(names[i]));
        }
        if(isDuplicateName(cars)){
            throw new IllegalArgumentException();
        }
        return cars;
    }

    private int inputRound(){
        System.out.println("시도할 회수는 몇회인가요?");
        int round = 0;

        try {
            round = Integer.parseInt(Console.readLine().trim());
        } catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
        if(round <= 0){
            throw new IllegalArgumentException();
        }
        System.out.println(" ");
        return round;
    }

    private ArrayList<Car> moveCars(ArrayList<Car> cars){
        int random = 0;

        for (int i = 0; i < cars.size(); i++){
            random = Randoms.pickNumberInRange(0, 9);
            if(random >= 4){
                cars.get(i).move();
            }
        }
        return cars;
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

    private ArrayList<Car> progressRounds(int round, ArrayList<Car> cars){
        System.out.println("실행 결과");
        for (int i = 0; i < round; i++){
            moveCars(cars);
            printScore(cars);
            System.out.println(" ");
        }
        return cars;
    }
}
