-- SQL for creating the "games" table
CREATE TABLE IF NOT EXISTS games (
    game_id INTEGER PRIMARY KEY AUTOINCREMENT,
    player_x TEXT NOT NULL,
    player_o TEXT NOT NULL,
    board_state TEXT NOT NULL,
    status TEXT NOT NULL
);
