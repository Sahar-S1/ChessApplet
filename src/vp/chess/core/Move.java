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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Move other = (Move) obj;
        if (src != other.src)
            return false;
        if (dest != other.dest)
            return false;
        if (piece == null) {
            if (other.piece != null)
                return false;
        } else if (!piece.equals(other.piece))
            return false;
        if (isCastling != other.isCastling)
            return false;
        return true;
    }
}
