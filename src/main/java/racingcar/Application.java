package racingcar;
import java.util.*;


public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner scanner = new Scanner(System.in);

        int round;
        class Car {
            String name;
            int score = 0;

            Car(String name) {
                this.name = name;
            }
        }

        ArrayList<Car> Cars = new ArrayList<>();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = scanner.nextLine();
        String[] names = input.split(",");

        for(int i = 0; i < names.length; i++){
            if(names[i].length() > 5 || names[i].contains(" ") || names[i].isEmpty()){
                throw new IllegalArgumentException();
            } else {
                Cars.add(new Car(names[i]));
            }
        }

        System.out.println("시도할 회수는 몇회인가요?");

        if (scanner.hasNextInt()) {
            round = scanner.nextInt();
        } else {
            throw new IllegalArgumentException();
        }

        if(round <= 0){
            throw new IllegalArgumentException();
        }

        for(int i = 0; i < Cars.size(); i++){
            System.out.println(Cars.get(i).name);
        }
        System.out.println(round);
    }
}