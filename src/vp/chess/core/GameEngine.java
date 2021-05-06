package vp.chess.core;

import java.util.ArrayList;

import vp.chess.core.pieces.*;

public class GameEngine {
    // Singleton
    private static GameEngine me;

    public static GameEngine getInstance() {
        if (GameEngine.me == null)
            GameEngine.me = new GameEngine();
        return GameEngine.me;
    }
    // Singleton End

    private GameState currentState;

    private GameEngine() {
        this.currentState = new GameState(GameEngine.getInitialPieces());
    }

    public GameState getCurrentState() {
        return currentState;
    }

    private static ArrayList<Piece> getInitialPieces() {
        ArrayList<Piece> initialPieces = new ArrayList<Piece>();
        for (PlayerEnum player : PlayerEnum.values()) {
            int row;

            row = (player == PlayerEnum.WHITE) ? 6 : 1; // Second or Pawns Row

            // Pawns
            for (PositionEnum pos : PositionEnum.getPositionsByRow(row)) {
                initialPieces.add(new Pawn(pos, player));
            }

            row = (player == PlayerEnum.WHITE) ? 7 : 0; // First or Kings Row

            // Rooks
            initialPieces.add(new Rook(PositionEnum.get(row, 0), player));
            initialPieces.add(new Rook(PositionEnum.get(row, 7), player));
            // Knights
            initialPieces.add(new Knight(PositionEnum.get(row, 1), player));
            initialPieces.add(new Knight(PositionEnum.get(row, 6), player));
            // Bishops
            initialPieces.add(new Bishop(PositionEnum.get(row, 2), player));
            initialPieces.add(new Bishop(PositionEnum.get(row, 5), player));
            // Queen
            // col = (player == Players.WHITE) ? 3 : 4;
            initialPieces.add(new Queen(PositionEnum.get(row, 3), player));
            // King
            // col = (player == Players.WHITE) ? 4 : 3;
            initialPieces.add(new King(PositionEnum.get(row, 4), player));
        }

        return initialPieces;
    }
}
