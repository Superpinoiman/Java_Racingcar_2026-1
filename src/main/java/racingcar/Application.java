package racingcar;
import java.util.*;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ArrayList<Car> Cars = inputCars();
        int round = inputRound();
        for(int i = 0; i < Cars.size(); i++){
            System.out.println(Cars.get(i).name);
        }
        System.out.println(round);
    }

    static class Car {
        String name;
        int score = 0;

        Car(String name) {
            this.name = name;
        }
    }

    private static boolean nameAgain(ArrayList<Car> Cars){
        Set<String> nameSet = new HashSet<>();
        for(int i = 0; i < Cars.size() ; i++) {
            if (!nameSet.add(Cars.get(i).name)) {
                return true;
            }
        }
        return false;
    }

    private static ArrayList<Car> inputCars(){
        ArrayList<Car> Cars = new ArrayList<>();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");

        for(int i = 0; i < names.length; i++){
            if(names[i].length() > 5 || names[i].contains(" ") || names[i].isEmpty()){
                throw new IllegalArgumentException();
            } else {
                Cars.add(new Car(names[i]));
            }
        }
        if(nameAgain(Cars)){
            throw new IllegalArgumentException();
        }
        return Cars;
    }

    private static int inputRound(){
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
}