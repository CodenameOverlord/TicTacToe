package com.scaler.tictactoe;

import com.scaler.tictactoe.controllers.GameController;
import com.scaler.tictactoe.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the dimension of the game");
        int dimension = scanner.nextInt();
        System.out.println("Will there be any bots? y/n");
        String isBot = scanner.next();
        List<Player> players = new ArrayList<>();
        int numberOfHumanPlayers = dimension-1;
        if("y".equalsIgnoreCase(isBot)){
            numberOfHumanPlayers = numberOfHumanPlayers - 1;

            System.out.println("What is the name of the bot ? ");
            String name = scanner.next();

            System.out.println("What is the symbol of the bot: ");
            String symbol = scanner.next();

            //Get the difficulty level.

            players.add(new Bot(symbol.charAt(0),name, PlayerType.BOT, BotDifficultyLevel.EASY));
        }

        for (int i = 0; i < numberOfHumanPlayers; i++) {
            System.out.println("What is the name of the player: " + (i+1));
            String name = scanner.next();

            System.out.println("What is the symbol of the player: " + (i+1));
            String symbol = scanner.next();

            players.add(new Player(symbol.charAt(0), name, PlayerType.HUMAN));
        }

        GameController gameController = new GameController();
        Game game  = gameController.createGame(players, dimension);
    }
}