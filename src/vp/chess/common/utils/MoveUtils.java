package vp.chess.common.utils;

import java.util.ArrayList;
import vp.chess.core.PositionEnum;

public class MoveUtils {
    public static ArrayList<PositionEnum> getRow(int row, int col) {
        // If col is -1, the current cell is not removed
        ArrayList<PositionEnum> positions = new ArrayList<PositionEnum>();
        for (int i = 0; i < 8; i++) {
            positions.add(PositionEnum.get(row, i));
        }
        if (col == -1)
            positions.remove(PositionEnum.get(row, col));
        return positions;
    }

    public static ArrayList<PositionEnum> getColumn(int row, int col) {
        // If row is -1, the current cell is not removed
        ArrayList<PositionEnum> positions = new ArrayList<PositionEnum>();
        for (int i = 0; i < 8; i++) {
            positions.add(PositionEnum.get(i, col));
        }
        if (row == -1)
            positions.remove(PositionEnum.get(row, col));
        return positions;
    }

    public static ArrayList<PositionEnum> getNeighbours(int row, int col) {
        ArrayList<PositionEnum> positions = new ArrayList<PositionEnum>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                addPositionIfPossible(positions, row + i, col + j);
            }
        }
        positions.remove(PositionEnum.get(row, col));
        return positions;
    }

    // Diagonals go from south-west to north-east on a chess board
    public static ArrayList<PositionEnum> getDiagonal(int row, int col) {
        ArrayList<PositionEnum> positions = new ArrayList<PositionEnum>();

        int r, c;

        // Add Positions SW to Current Position
        r = (row + 1);
        c = (col - 1);
        while (PositionEnum.canGet(r, c)) {
            positions.add(0, PositionEnum.get(r, c));
            r++;
            c--;
        }

        // Add Current Position
        positions.add(PositionEnum.get(row, col));

        // Add Positions NE to Current Position
        r = (row - 1);
        c = (col + 1);
        while (PositionEnum.canGet(r, c)) {
            positions.add(PositionEnum.get(r, c));
            r--;
            c++;
        }

        positions.remove(PositionEnum.get(row, col));
        return positions;
    }

    // Anti-Diagonals go from south-east to north-west on a chess board
    public static ArrayList<PositionEnum> getAntiDiagonal(int row, int col) {
        ArrayList<PositionEnum> positions = new ArrayList<PositionEnum>();

        int r, c;

        // Add Positions SE to Current Position
        r = (row + 1);
        c = (col + 1);
        while (PositionEnum.canGet(r, c)) {
            positions.add(0, PositionEnum.get(r, c));
            r++;
            c++;
        }

        // Add Current Position
        positions.add(PositionEnum.get(row, col));

        // Add Positions NW to Current Position
        r = (row - 1);
        c = (col - 1);
        while (PositionEnum.canGet(r, c)) {
            positions.add(PositionEnum.get(r, c));
            r--;
            c--;
        }

        positions.remove(PositionEnum.get(row, col));
        return positions;
    }

    // For Knight L-Shaped Moves
    public static ArrayList<PositionEnum> getL(int row, int col) {
        ArrayList<PositionEnum> positions = new ArrayList<PositionEnum>();

        // NW and NE
        addPositionIfPossible(positions, row - 2, col - 1);
        addPositionIfPossible(positions, row - 2, col + 1);
        // WN and WS
        addPositionIfPossible(positions, row - 1, col - 2);
        addPositionIfPossible(positions, row + 1, col - 2);
        // SW and SE
        addPositionIfPossible(positions, row + 2, col + 1);
        addPositionIfPossible(positions, row + 2, col - 1);
        // EN and WN
        addPositionIfPossible(positions, row - 1, col + 2);
        addPositionIfPossible(positions, row + 1, col + 2);

        return positions;
    }

    private static void addPositionIfPossible(ArrayList<PositionEnum> positions, int row, int col) {
        if (PositionEnum.canGet(row, col))
            positions.add(PositionEnum.get(row, col));
    }
}
