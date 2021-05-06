package vp.chess.core;

import java.util.ArrayList;

public enum PositionEnum {
    a0, b0, c0, d0, e0, f0, g0, h0, // 0st Row
    a1, b1, c1, d1, e1, f1, g1, h1, // 1st Row
    a2, b2, c2, d2, e2, f2, g2, h2, // 2st Row
    a3, b3, c3, d3, e3, f3, g3, h3, // 3st Row
    a4, b4, c4, d4, e4, f4, g4, h4, // 4st Row
    a5, b5, c5, d5, e5, f5, g5, h5, // 5st Row
    a6, b6, c6, d6, e6, f6, g6, h6, // 6st Row
    a7, b7, c7, d7, e7, f7, g7, h7; // 7st Row

    /* row and col should be between between 0 and 7 */
    public static PositionEnum get(int row, int col) {
        assert (0 <= row && row <= 7) && (0 <= col && col <= 7);
        return PositionEnum.valueOf(((char) (col + 97) + Integer.valueOf(row).toString()));
    }

    /* Return int between 0 and 7 */
    public int getRow() {
        return Integer.parseInt(this.name().substring(1, 2));
    }

    /* Return int between 0 and 7 */
    public int getColumn() {
        return ((int) this.name().charAt(0)) - 97;
    }

    public static PositionEnum[] getPositionsByRow(int row) {
        ArrayList<PositionEnum> positions = new ArrayList<PositionEnum>();
        for (PositionEnum position : PositionEnum.values()) {
            if (position.getRow() == row)
                positions.add(position);
        }
        return positions.toArray(new PositionEnum[8]);
    }

    public static PositionEnum[] getPositionsByCol(int col) {
        ArrayList<PositionEnum> positions = new ArrayList<PositionEnum>();
        for (PositionEnum position : PositionEnum.values()) {
            if (position.getColumn() == col)
                positions.add(position);
        }
        return positions.toArray(new PositionEnum[8]);
    }
}
