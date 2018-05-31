package pl.sda.games.millionairs;

import pl.sda.games.FileOperator;
import pl.sda.games.IPlayable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Millionairs implements IPlayable {
    private Question question;
    private List<Question> questionsOfLevel = new ArrayList<>();
    int currentLevel = 1;
    private Scanner sc = new Scanner(System.in);
    private String givenAnswer;
    private String correctAnswer;


    @Override
    public void start() {
        startGame();

    }

    public void startGame() {
        askQuestionOfLevel(currentLevel);
        answerQuestion();



    }


    @Override
    public int getNumber() {
        return 3;
    }

    @Override
    public String getDescription() {
        return "Milionairs";
    }

    private Question askQuestionOfLevel(int current) {
        FileOperator fileOperator = new FileOperator();
        fileOperator.readFileMillionairs();
        String qLevel = String.valueOf(currentLevel);
        System.out.println(qLevel);
        for (String q : fileOperator.getMillionairsQuestionList()) {
                questionsOfLevel.add(fileOperator.parseToQuestion(q));
        }
        Random rn = new Random();
        int randomQuestionNumber = rn.nextInt(questionsOfLevel.size());
        question = questionsOfLevel.get(randomQuestionNumber);
        System.out.println(question.getQuestion());
        System.out.println("A : " + question.getAnswerA());
        System.out.println("B : " + question.getAnswerB());
        System.out.println("C : " + question.getAnswerC());
        System.out.println("D : " + question.getAnswerD());
        return question;
    }

    private void answerQuestion(){
        givenAnswer = sc.next().trim().toUpperCase();
        correctAnswer = String.valueOf(question.getCorrectAnswer());
        if (givenAnswer.equals(correctAnswer)){
            System.out.println("Brawo !");
            currentLevel++;
        }else{
            System.out.println("You lose");
        }

    }

//    private int incrementLevel(int questionLevel){
//
//
//
//        return
    //}

    }



