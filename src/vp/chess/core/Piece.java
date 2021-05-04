package vp.chess.core;

import java.awt.Image;
import java.util.ArrayList;

public abstract class Piece {
    public enum PiecesEnum {
        King, Queen, Rook, Bishop, Knight, Pawn;
    }

    public abstract ArrayList<Move> getLegalMoves(GameState state);

    public Image getImage() {
        return null;
    }
}
