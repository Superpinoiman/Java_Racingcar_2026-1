package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Race {
    private ArrayList<Car> cars = new ArrayList<>();
    private int round = 0;

    Race(){}

    public void raceStart(){
        cars = this.inputCars();
        round = this.inputRound();
        cars = this.rounding(round, cars);
        cars = this.findWinner(cars);
        this.award(cars);
    }

    private boolean nameAgain(ArrayList<Car> cars){
        Set<String> nameSet = new HashSet<>();

        for(int i = 0; i < cars.size() ; i++) {
            if (!nameSet.add(cars.get(i).getName())) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<Car> inputCars(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");
        ArrayList<Car> cars = new ArrayList<>();

        for(int i = 0; i < names.length; i++){
            if(names[i].length() > 5 || names[i].contains(" ") || names[i].isEmpty()){
                throw new IllegalArgumentException();
            } else {
                cars.add(new Car(names[i]));
            }
        }
        if(nameAgain(cars)){
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

    private ArrayList<Car> racing(ArrayList<Car> cars){
        int random = 0;

        for (int i = 0; i < cars.size(); i++){
            random = Randoms.pickNumberInRange(0, 9);
            if(random >= 4){
                cars.get(i).move();
            }
        }
        return cars;
    }


    private void chart(ArrayList<Car> cars){
        for(int i = 0; i < cars.size(); i++){
            System.out.print(cars.get(i).getName() + " : ");
            for(int j = 0; j < cars.get(i).getScore(); j++){
                System.out.print("-");
            }
            System.out.println(" ");
        }
    }

    private ArrayList<Car> rounding(int round, ArrayList<Car> Cars){
        System.out.println("실행 결과");
        for (int i = 0; i < round; i++){
            racing(Cars);
            chart(Cars);
            System.out.println(" ");
        }
        return Cars;
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

    private void award(ArrayList<Car> cars) {
        boolean flag = true;
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
}
