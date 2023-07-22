package com.scaler.tictactoe.models;

import com.scaler.tictactoe.exceptions.InvalidGameBuildException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameStatus gameStatus;
    private int nextPlayerIndex;
    public static Builder getBuilder() {
        return new Builder();
    }
    private Player winner;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }
    public void displayBoard() {
        this.board.display();
    }
    public Player getWinner() {
        return winner;
    }

    public static class Builder{
        private int dimension;
        private List<Player> players;
        private Board board;



        public int getDimension() {
            return dimension;
        }


        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Game build() throws InvalidGameBuildException {
            if(!isValid()){
                throw new InvalidGameBuildException("Game data is invalid");
            }
            Game game = new Game();
            game.setPlayers(players);
            game.setBoard(new Board(dimension));
            game.setGameStatus(GameStatus.IN_PROGRESS);
            game.setMoves(new ArrayList<>());
            game.setNextPlayerIndex(0);
            return game;
        }

        private boolean isValid() throws InvalidGameBuildException {
            boolean returnVal = false;
            if(this.dimension<3){
                throw new InvalidGameBuildException("Dimension is less than 3");
            }
            if( this.players.size()!=this.dimension-1 ){
                throw new InvalidGameBuildException("Issue with number of Players");
            }
            if(!isUniqueSymbol(players)){
                throw new InvalidGameBuildException("Players symbol not unique");
            }
            returnVal = true;
            return returnVal;
        }

        private boolean isUniqueSymbol(List<Player> players) {
            HashSet<Character> hs = new HashSet<>();
            for(Player p: players){
                hs.add(p.getSymbol());
            }
            return hs.size()== players.size();
        }




    }
}
