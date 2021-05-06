package vp.chess.common;

import java.awt.Color;

public class Config {
    public static final int CELL_SIZE = 100;
    public static final int CELLS_PER_ROW = 8;
    public static final int CELLS_PER_COL = 8;
    public static final int BOARD_WIDTH = CELL_SIZE * CELLS_PER_ROW;
    public static final int BOARD_HEIGHT = CELL_SIZE * CELLS_PER_COL;

    public static final int IMAGE_SIZE = 60;
    public static final int IMAGE_OFFSET = (CELL_SIZE - IMAGE_SIZE) / 2;

    public static final Color LIGHT_CELL_COLOR = new Color(232, 235, 239);
    public static final Color DARK_CELL_COLOR = new Color(125, 135, 150);

    public static final Color SELECTED_COLOR = new Color(255, 251, 204, 128);

    // This format will be formated with two variables,
    // position (exact 2 letters)
    // piece (max 6 letters)
    public static final String CLICK_MESSAGE_FORMAT = "Cell at %1$2s with %2$-6s is clicked";
}
