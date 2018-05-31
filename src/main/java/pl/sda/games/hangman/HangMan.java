package pl.sda.games.hangman;

import pl.sda.games.FileOperator;
import pl.sda.games.IPlayable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class HangMan implements IPlayable {

    private int numberOfLifes;
    private int wordLength;
    private String difficulty;
    private Scanner sc = new Scanner(System.in);
    private List<String> wordsOfLength = new ArrayList<>();
    private String [] randomWord;
    private String [] guessedWord;
    private String guessedLetter;

    @Override
    public void start() {

        setDifficulty();
        chooseWord();
        startGame();
    }


    public void startGame() {

        boolean isWon = false;

        while (!isWon && numberOfLifes > 0) {
        System.out.println("Guess a letter: ");
        guessedLetter = sc.next();
            boolean isGuessed = false;
            for (int i = 0; i < randomWord.length; i++) {
                if (guessedLetter.equals(randomWord[i])) {
                    guessedWord[i] = guessedLetter;
                    isGuessed = true;
                }
            }
            if (!isGuessed){
                numberOfLifes--;
                System.out.println("Wrong");
            }else{
                System.out.println("Nice");
            }

            if (isArrayFilled()){
                isWon = true;
            }
//                if(isGuessed){
//                    System.out.println("Wrong guess. Give another letter");
//                    numberOfLifes--;
//                }

            }
            if (isWon){
                System.out.println("Congratulations!");
                printPresentState();
                System.out.println("The word is " + Arrays.toString(randomWord));
            }else{
                System.out.println("Sorry, you lose!");

            }
            //System.out.println(Arrays.toString(guessedWord));
        }


        private boolean isArrayFilled(){
            for(String letter : guessedWord){
                if (letter.equals("_")){
                    return false;
                }
            }
            return true;
        }


    private void setDifficulty() {
        System.out.println("Choose a difficulty level: low medium hard");
        difficulty = sc.next().trim().toLowerCase();
        if (difficulty.equals("low")) {
            numberOfLifes = 10;
            wordLength = 4;
        } else if (difficulty.equals("medium")) {
            numberOfLifes = 5;
            wordLength = 6;
        } else {
            numberOfLifes = 3;
            wordLength = 8;
        }
    }

    private void chooseWord() {
        FileOperator fileOperator = new FileOperator();
        fileOperator.readFile();
        //System.out.println(fileOperator.getWordsList());
        for (String word : fileOperator.getWordsList()) {
            if (word.length() == wordLength){
                wordsOfLength.add(word);
        }
    }
        System.out.println(wordsOfLength);
    Random rn = new Random();
        int randomIndex = rn.nextInt(wordsOfLength.size());
    randomWord = wordsOfLength.get(randomIndex).split("");
        System.out.println(Arrays.toString(randomWord));

        guessedWord = new String[randomWord.length];
        for (int i = 0; i < guessedWord.length; i++){
            guessedWord[i] = "_";
        }
        System.out.println(Arrays.toString(guessedWord));
}

    private void printPresentState(){
        String result = "";
    for (int i = 0; i < guessedWord.length; i++){
        result += guessedWord[i];
    }
        System.out.println("You entered: " + result);
}

    @Override
    public int getNumber() {
        return 2;
    }

    @Override
    public String getDescription() {
        return "Hangman";
    }


}
