package vp.chess.core;

import java.util.ArrayList;

public class GameState {
    private final ArrayList<Piece> pieces;

    public GameState(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    public ArrayList<Piece> getPieces() {
        return this.pieces;
    }
}
