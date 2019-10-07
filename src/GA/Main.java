package GA;
import GA.shapes.Shape;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println(
                "Welcome to Rock, Paper, Scissors!\n" +
                "MAIN MENU\n" +
                "=====\n");
        game();
    }

    static HashMap<String, Player> history = new HashMap<>();

    private static void game() {
        System.out.println(
                "1. Type 'play' to play.\n" +
                "2. Type 'history' to view your game history.\n" +
                "3. Type 'quit' to stop playing."
        );

        String selectOption = scanner.nextLine();

        if(equals(selectOption, "Play")) {
            gamePlay();
            game();
        } else if (equals(selectOption, "history")) {
             history();
             game();
        } else if (equals(selectOption, "quit")) {
            return;
        } else {
            System.out.println("Wrong input try again");
            game();
        }
    }

    private static void history() {
        history.keySet().forEach(pl -> {
                System.out.println(pl + ": ");
                int i = 1;
                history.get(pl).getMoves().forEach((el) -> {
                    System.out.println("***" + el);
                });
        });
    }

    private static void gamePlay() {
        System.out.println( "=====\n" +
                "1. Type 'players' to play 2 player game.\n" +
                "2. Type 'bot' to play against bot.\n"
        );

        String selectOption = scanner.nextLine();
        if (equals(selectOption, "players")) {
            System.out.println("Type player1 name:");
            String player1Name = scanner.nextLine();
            Player player1 = setOrCreateIfNew(player1Name);

            System.out.println("Type player2 name:");
            String player2Name = scanner.nextLine();
            Player player2 = setOrCreateIfNew(player2Name);

            move(player1, player2);
            updateHistory(player1);
            updateHistory(player2);
        } else if (equals(selectOption, "bot")) {
            System.out.println("Type player's name:");
            String player1Name = scanner.nextLine();
            Player player1 = setOrCreateIfNew(player1Name);
            Player computer = new ComputerPlayer();
            move(player1, computer);
            updateHistory(player1);
        }


    }

    private static Player setOrCreateIfNew(String player1Name) {
        Player player;
        if (!history.containsKey(player1Name)) {
            player = new HumanPlayer(player1Name);
        } else {
            player = history.get(player1Name);
        }
        return player;
    }

    private static void updateHistory(Player player1) {
        if (!history.containsKey(player1.getName())) {
            ArrayList newPlayer = new ArrayList<String>();
            newPlayer.add(player1.getMoves());
            history.put(player1.getName(), player1);
        }
    }

    private static void move(Player player1, Player player2) {
        String shapePlayer1;
        String shapePlayer2;
        Shape player1Pick;
        Shape player2Pick;
        if (player2 instanceof HumanPlayer) {
            System.out.println(player1.getName() + " type 'rock', 'paper', or 'scissors' to play.");
            shapePlayer1 = scanner.nextLine();
            System.out.println(player2.getName() + " type 'rock', 'paper', or 'scissors' to play.");
            shapePlayer2 = scanner.nextLine();
            player1Pick = HumanPlayer.selectFigure(shapePlayer1);
            player2Pick = HumanPlayer.selectFigure(shapePlayer2);
        } else {
            System.out.println("Type 1 'rock', 'paper', or 'scissors' to play.");
            shapePlayer1 = scanner.nextLine();
            player1Pick = HumanPlayer.selectFigure(shapePlayer1);
            player2Pick = ComputerPlayer.selectFigure("");
        }
        System.out.println("=====================================");
        System.out.println(player1Pick.compare(player2Pick,  player1, player2));
        System.out.println("=====================================\n");
    }

    private static boolean equals(String selectOption, String option) {
        return selectOption.equalsIgnoreCase(option);
    }
}
