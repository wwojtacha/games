package pl.sda.games;

import pl.sda.games.millionairs.Question;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileOperator {

    private final String words = "words.txt";
    private final String millionairsQuestions = "millionairs_questions.txt";
    List<String> wordsList = new ArrayList<>();
    List<String> millionairsQuestionList = new ArrayList<>();
    private final String SEPARATOR = ";";

    public List<String> getWordsList() {
        return wordsList;
    }

    public List<String> getMillionairsQuestionList() {
        return millionairsQuestionList;
    }

    public void readFile(){

        //Random rn = new Random();
        try (BufferedReader br = new BufferedReader(new FileReader(words))){
            String line = br.readLine();
            while(line != null){
                wordsList.add(line);
                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void readFileMillionairs() {

        try (BufferedReader br = new BufferedReader(new FileReader(millionairsQuestions))) {
            String line = br.readLine();
            while (line != null) {
                millionairsQuestionList.add(line);
                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public Question parseToQuestion(String line){
            String [] splits = line.split(SEPARATOR);

            String q = splits[0];
            String answerA = splits[1];
            String answerB = splits[2];
            String answerC = splits[3];
            String answerD = splits[4];
            int correctAnswer = Integer.parseInt(splits[5]);
            int level = Integer.parseInt(splits[6]);

            Question question = new Question(q, answerA, answerB, answerC, answerD, correctAnswer, level);
            return question;
        }

    }









