package com.user.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.user.model.Game;
public class GameDAO {
    private final String url = "jdbc:sqlite:tic_tac_toe.db";

    public GameDAO() {
        try (Connection conn = DriverManager.getConnection(url)) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS games (" +
                    "game_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "player_x TEXT NOT NULL," +
                    "player_o TEXT NOT NULL," +
                    "board_state TEXT NOT NULL," +
                    "status TEXT NOT NULL)";
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(createTableSQL);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addGame(Game game) {
        String sql = "INSERT INTO games(player_x, player_o, board_state, status) VALUES(?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, game.getPlayerX());
            pstmt.setString(2, game.getPlayerO());
            pstmt.setString(3, game.getBoardState());
            pstmt.setString(4, game.getStatus());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Game getGameById(int gameId) {
        String sql = "SELECT * FROM games WHERE game_id = ?";
        Game game = null;

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, gameId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                game = new Game(
                        rs.getInt("game_id"),
                        rs.getString("player_x"),
                        rs.getString("player_o"),
                        rs.getString("board_state"),
                        rs.getString("status"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return game;
    }

    public List<Game> getAllGames() {
        List<Game> games = new ArrayList<>();
        String sql = "SELECT * FROM games";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                games.add(new Game(
                        rs.getInt("game_id"),
                        rs.getString("player_x"),
                        rs.getString("player_o"),
                        rs.getString("board_state"),
                        rs.getString("status")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return games;
    }

    public void updateGameStatus(int gameId, String newStatus) {
        String sql = "UPDATE games SET status = ? WHERE game_id = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newStatus);
            pstmt.setInt(2, gameId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteGame(int gameId) {
        String sql = "DELETE FROM games WHERE game_id = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, gameId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
