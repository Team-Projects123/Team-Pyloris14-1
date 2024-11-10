package com.user.model;

public class Game {
    private int gameId;
    private String playerX;
    private String playerO;
    private String boardState; // A string to represent the board state, e.g., "XOXOXOXOX"
    private String status; // "in_progress", "win_X", "win_O", "draw"

    // Constructors
    public Game(int gameId, String playerX, String playerO, String boardState, String status) {
        this.gameId = gameId;
        this.playerX = playerX;
        this.playerO = playerO;
        this.boardState = boardState;
        this.status = status;
    }

    // Getters and Setters
    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getPlayerX() {
        return playerX;
    }

    public void setPlayerX(String playerX) {
        this.playerX = playerX;
    }

    public String getPlayerO() {
        return playerO;
    }

    public void setPlayerO(String playerO) {
        this.playerO = playerO;
    }

    public String getBoardState() {
        return boardState;
    }

    public void setBoardState(String boardState) {
        this.boardState = boardState;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
