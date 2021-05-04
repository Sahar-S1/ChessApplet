package vp.microproject.chess.common;

import java.awt.Color;

public class Config {
    public static final int CELL_SIZE = 100;
    public static final int CELLS_PER_ROW = 8;
    public static final int CELLS_PER_COL = 8;
    public static final int BOARD_WIDTH = CELL_SIZE * CELLS_PER_ROW;
    public static final int BOARD_HEIGHT = CELL_SIZE * CELLS_PER_COL;

    public static final Color LIGHT_CELL_COLOR = new Color(232, 235, 239);
    public static final Color DARK_CELL_COLOR = new Color(125, 135, 150);

    public static final Color SELECTED_COLOR = new Color(255, 251, 204, 128);
}
