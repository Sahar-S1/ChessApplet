package vp.chess.common;

import java.awt.Color;

public class Config {
    public static final int CELL_SIZE = 100;
    public static final int CELLS_PER_ROW = 8;
    public static final int CELLS_PER_COL = 8;
    public static final int BOARD_WIDTH = CELL_SIZE * CELLS_PER_ROW;
    public static final int BOARD_HEIGHT = CELL_SIZE * CELLS_PER_COL;

    // This format will be formated with two character variables,
    // Piece Code (k/q/r/b/n/p)
    // Piece Color (l/d)
    public static final String IMAGE_URL = "https://commons.m.wikimedia.org/wiki/Special:Redirect/file/Chess_%c%ct60.png";
    public static final int IMAGE_SIZE = 60;
    public static final int IMAGE_OFFSET = (CELL_SIZE - IMAGE_SIZE) / 2;

    public static final Color LIGHT_CELL_COLOR = new Color(232, 235, 239);
    public static final Color DARK_CELL_COLOR = new Color(125, 135, 150);

    public static final Color SELECTED_COLOR = new Color(255, 251, 204, 128);

    public static final Color POSSIBLE_MOVE_COLOR = new Color(102, 255, 0, 128);

    public static final Color KILL_MOVE_COLOR = new Color(221, 44, 0, 128);

    // This format will be formated with two variables,
    // position (exact 2 letters)
    // piece (max 6 letters)
    public static final String CLICK_MESSAGE_FORMAT = "Cell at %1$2s with %2$-6s is clicked";
}
