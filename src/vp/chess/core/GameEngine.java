package vp.chess.core;

import java.util.ArrayList;

import vp.chess.common.utils.MoveUtils;
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
    private PlayerEnum currentPlayer;

    private GameEngine() {
        this.currentState = new GameState(GameEngine.getInitialPieces());
        this.currentPlayer = PlayerEnum.WHITE;
    }

    public GameState getCurrentState() {
        return currentState;
    }

    public PlayerEnum getCurrentPlayer() {
        return currentPlayer;
    }

    public ArrayList<Move> getPossibleMoves(Piece clickedPiece) {
        ArrayList<Move> possibleMoves = new ArrayList<Move>();

        if (clickedPiece != null && clickedPiece.getPlayer().equals(this.currentPlayer)) {
            PlayerEnum player = this.currentPlayer;
            ArrayList<MoveConfigEnum> config = clickedPiece.getMoveConfig();
            PositionEnum pos = clickedPiece.getPos();
            int row = pos.getRow(), col = pos.getColumn();

            // NOTE Add all possible positions according to config
            ArrayList<PositionEnum> possiblePositions = new ArrayList<PositionEnum>();
            if (config.contains(MoveConfigEnum.STRAIGHT)) {
                possiblePositions.addAll(MoveUtils.getRow(row, col));
                possiblePositions.addAll(MoveUtils.getColumn(row, col));
            }
            if (config.contains(MoveConfigEnum.CROSS)) {
                possiblePositions.addAll(MoveUtils.getDiagonal(row, col));
                possiblePositions.addAll(MoveUtils.getAntiDiagonal(row, col));
            }
            if (config.contains(MoveConfigEnum.NEIGHNOURS)) {
                possiblePositions.addAll(MoveUtils.getNeighbours(row, col));
            }
            if (config.contains(MoveConfigEnum.L_SHAPE)) {
                possiblePositions.addAll(MoveUtils.getL(row, col));
            }
            if (config.contains(MoveConfigEnum.ONE_STEP_AHEAD_MOVE)) {
                int r = (player.isBlack()) ? row + 1 : row - 1;
                if (PositionEnum.canGet(r, col)) {
                    possiblePositions.add(PositionEnum.get(r, col));
                }
            }
            if (config.contains(MoveConfigEnum.ONE_STEP_CROSS_KILL)) {
                // TODO
                // possiblePositions.add(); // LEFT Cross
                // possiblePositions.add(); // RIGHT Cross
            }
            if (config.contains(MoveConfigEnum.TWO_STEP_AHAED_FIRST_MOVE)) {
                // TODO
                // possiblePositions.add();
            }

            // NOTE Remove all positions that are blocking if it doen't JUMP
            if (!config.contains(MoveConfigEnum.JUMP)) {
                // TODO
            }

            // NOTE Remove all positions where same player's pieces are placed
            // TODO

            // NOTE Convert Positions to Move
            for (PositionEnum position : possiblePositions) {
                // Sorry for bad naming convention!!
                // position is destination and pos is source
                possibleMoves.add(new Move(clickedPiece, pos, position));
            }
        }

        return possibleMoves;
    }

    public boolean makeMove(Move move) {
        // Returns succes of makeMove
        if (this.getPossibleMoves(move.getPiece()).contains(move)) {
            for (Piece piece : this.currentState.getPieces()) {
                if (piece.getPos() == move.getSrc()) {
                    piece.setPos(move.getDest());
                }
            }
            this.nextPlayer();
            return true;
        }
        return false;
    }

    private void nextPlayer() {
        this.currentPlayer = this.currentPlayer.isWhite() ? PlayerEnum.BLACK : PlayerEnum.WHITE;
    }

    private static ArrayList<Piece> getInitialPieces() {
        ArrayList<Piece> initialPieces = new ArrayList<Piece>();
        for (PlayerEnum player : PlayerEnum.values()) {
            int row;

            row = (player == PlayerEnum.WHITE) ? 6 : 1; // Second or Pawns Row

            // Pawns
            for (PositionEnum pos : MoveUtils.getRow(row, -1)) {
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
