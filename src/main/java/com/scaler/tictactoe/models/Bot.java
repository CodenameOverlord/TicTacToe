package com.scaler.tictactoe.models;

public class Bot extends Player {

    public Bot(char symbol, String name, PlayerType type, BotDifficultyLevel botDifficultyLevel) {
        super(symbol, name, type);
        this.botDifficultyLevel = botDifficultyLevel;
    }

    private BotDifficultyLevel botDifficultyLevel;

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }
}
