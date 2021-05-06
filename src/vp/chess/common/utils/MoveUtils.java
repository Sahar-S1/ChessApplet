package vp.chess.common.utils;

import java.util.ArrayList;
import vp.chess.core.PositionEnum;

public class MoveUtils {
    public static ArrayList<PositionEnum> getRow(int row, int col) {
        ArrayList<PositionEnum> positions = new ArrayList<PositionEnum>();
        for (int i = 0; i < 8; i++) {
            positions.add(PositionEnum.get(row, i));
        }
        return positions;
    }

    public static ArrayList<PositionEnum> getColumn(int row, int col) {
        ArrayList<PositionEnum> positions = new ArrayList<PositionEnum>();
        for (int i = 0; i < 8; i++) {
            positions.add(PositionEnum.get(i, col));
        }
        return positions;
    }

    public static ArrayList<PositionEnum> getNeighbours(int row, int col) {
        ArrayList<PositionEnum> positions = new ArrayList<PositionEnum>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                try {
                    positions.add(PositionEnum.get(row + i, col + j));
                } catch (IndexOutOfBoundsException exception) {
                }
            }
        }
        positions.remove(PositionEnum.get(row, col));
        return positions;
    }

    // Diagonals go from south-west to north-east on a chess board
    public static ArrayList<PositionEnum> getDiagonal(int row, int col) {
        ArrayList<PositionEnum> positions = new ArrayList<PositionEnum>();
        // TODO: Implement this
        return positions;
    }

    // Anti-Diagonals go from south-east to north-west on a chess board
    public static ArrayList<PositionEnum> getAntiDiagonal(int row, int col) {
        ArrayList<PositionEnum> positions = new ArrayList<PositionEnum>();
        // TODO: Implement this
        return positions;
    }

    // For Knight L-Shaped Moves
    public static ArrayList<PositionEnum> getL(int row, int col) {
        ArrayList<PositionEnum> positions = new ArrayList<PositionEnum>();
        // TODO: Implement this
        return positions;
    }
}
