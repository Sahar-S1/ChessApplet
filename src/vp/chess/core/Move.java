package vp.chess.core;

import vp.chess.core.pieces.King;
import vp.chess.core.pieces.Rook;

public class Move {
    private final Piece piece;
    private final PositionEnum src;
    private final PositionEnum dest;
    private final boolean isCastling;

    public Move(Piece piece, PositionEnum src, PositionEnum dest, boolean isCastling) {
        this.piece = piece;
        this.src = src;
        this.dest = dest;
        this.isCastling = isCastling;

        if (this.isCastling)
            assert (piece instanceof King || piece instanceof Rook);
    }

    public Move(Piece piece, PositionEnum src, PositionEnum dest) {
        this(piece, src, dest, false);
    }

    public Piece getPiece() {
        return this.piece;
    }

    public PositionEnum getSrc() {
        return this.src;
    }

    public PositionEnum getDest() {
        return this.dest;
    }

    public boolean isCastling() {
        return this.isCastling;
    }
}
