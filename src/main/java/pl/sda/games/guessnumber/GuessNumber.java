package pl.sda.games.guessnumber;

import pl.sda.games.IPlayable;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber implements IPlayable {
    private String difficulty;
    private int numberOfLives;
    private int pickedNumber;
    private int guessedNumber;
    private Scanner sc = new Scanner(System.in);


    @Override
    public void start() {
        setDifficulty();
        startGame();
    }

    private void startGame(){
        Random rn = new Random();
        pickedNumber = rn.nextInt(100 + 1);
        System.out.println("Give a number from 1 to 100");
        guessedNumber = sc.nextInt();
        while(pickedNumber != guessedNumber && numberOfLives > 0){
            if (guessedNumber > pickedNumber){
                System.out.println("Number too big");
                numberOfLives--;
                guessedNumber = sc.nextInt();
            } else if(guessedNumber < pickedNumber){
                System.out.println("Number to small");
                numberOfLives--;
                guessedNumber = sc.nextInt();
            }else{
                System.out.println("Congratulations. You guessed the number!");
            }
            if (guessedNumber == pickedNumber){

            }
        }
            System.out.println("You lost all lives");


    }

    private void setDifficulty(){
        System.out.println("Choose difficulty level: low, medium, hard");
        difficulty = sc.next().trim().toLowerCase();
        if (difficulty.equals("low")){
            numberOfLives = 10;
        }else if(difficulty.equals("medium")){
            numberOfLives = 5;
        }else{
            numberOfLives = 3;
        }

    }
    @Override
    public int getNumber() {
        return 1;
    }

    @Override
    public String getDescription() {
        return "Guess a number";
    }
}
