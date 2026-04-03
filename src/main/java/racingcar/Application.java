package racingcar;
import java.util.*;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ArrayList<Car> Cars = inputCars();
        int round = inputRound();
        Cars = rounding(round, Cars);
        Cars = findWinner(Cars);
        award(Cars);
    }

    private static boolean nameAgain(ArrayList<Car> Cars){
        Set<String> nameSet = new HashSet<>();
        for(int i = 0; i < Cars.size() ; i++) {
            if (!nameSet.add(Cars.get(i).getName())) {
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

    private static ArrayList<Car> racing(ArrayList<Car> Cars){
        int random = 0;
        for (int i = 0; i < Cars.size(); i++){
            random = Randoms.pickNumberInRange(0, 9);
            if(random >= 4){
                Cars.get(i).move();
            }
        }
        return Cars;
    }

    private static ArrayList<Car> rounding(int round, ArrayList<Car> Cars){
        System.out.println("실행 결과");
        for (int i = 0; i < round; i++){
            racing(Cars);
            chart(Cars);
            System.out.println(" ");
        }
        return Cars;
    }

    private static void chart(ArrayList<Car> Cars){
        for(int i = 0; i < Cars.size(); i++){
            System.out.print(Cars.get(i).getName() + " : ");
            for(int j = 0; j < Cars.get(i).getScore(); j++){
                System.out.print("-");
            }
            System.out.println(" ");
        }
    }

    private static ArrayList<Car> findWinner(ArrayList<Car> Cars){
        int maxScore = 0;

        for(int i = 0; i < Cars.size(); i++){
            if(Cars.get(i).getScore() >= maxScore){
                maxScore = Cars.get(i).getScore();
            }
        }

        for(int i = 0; i < Cars.size(); i++){
            if(Cars.get(i).getScore() == maxScore){
                Cars.get(i).win();
            }
        }

        return Cars;
    }

    private static void award(ArrayList<Car> Cars) {
        boolean flag = true;
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < Cars.size(); i++){
            if(Cars.get(i).isWinner() && !flag){
                System.out.print(", ");
                System.out.print(Cars.get(i).getName());
            }
            if(Cars.get(i).isWinner() && flag) {
                System.out.print(Cars.get(i).getName());
                flag = false;
            }
        }
    }
}
