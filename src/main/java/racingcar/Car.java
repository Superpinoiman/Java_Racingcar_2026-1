package racingcar;

public class Car {
    private String name;
    private int score = 0;
    private boolean winner = false;

    Car(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int getScore(){
        return this.score;
    }

    public boolean isWinner(){
        if(this.winner) {
            return true;
        }
        return false;
    }

    public void move() {
        this.score++;
    }

    public void win(){
        this.winner = true;
    }

}
