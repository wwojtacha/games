package pl.sda.games;

import pl.sda.games.guessnumber.GuessNumber;
import pl.sda.games.hangman.HangMan;
import pl.sda.games.millionairs.Millionairs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class GameOperator implements IPlayable{

    List<IPlayable> games = new ArrayList<>();

    public GameOperator() {
        games.add(new GuessNumber());
        games.add(new HangMan());
        games.add(new Millionairs());
    }

    public void start(){

            System.out.println("Hello. Choose a game: ");

        int numberOfGame = 0;
        while(numberOfGame != -1) {
            for (IPlayable playable : games) {
                System.out.println(playable.getDescription() + " - " + playable.getNumber());
            }

            Scanner sc = new Scanner(System.in);
            numberOfGame = sc.nextInt();
            System.out.println("You chose" + numberOfGame);
            getGame(numberOfGame).start();
        }
    }

    @Override
    public int getNumber() {
        return 0;
    }

    @Override
    public String getDescription() {
        return null;
    }

    private IPlayable getGame(int numberOfGame){
        Optional<IPlayable> optional = games.stream().filter(game -> game.getNumber() == numberOfGame).findFirst();
        if(optional.isPresent()) return optional.get();
        return games.get(0);
        }





}
