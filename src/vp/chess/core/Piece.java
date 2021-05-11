package vp.chess.core;

import java.awt.Image;
import java.util.ArrayList;

import vp.chess.common.utils.PieceImageLoader;

public abstract class Piece {
    public enum PiecesEnum {
        King, Queen, Rook, Bishop, Knight, Pawn;
    }

    private PositionEnum pos;
    private final PlayerEnum player;
    private final Image img;
    private boolean isFirstMove;

    protected Piece(PositionEnum pos, PlayerEnum player) {
        this.pos = pos;
        this.player = player;
        this.img = PieceImageLoader.getImg(this.getPiecesEnumValue(), this.player);
        this.isFirstMove = true;
    }

    public PositionEnum getPos() {
        return this.pos;
    }

    public PlayerEnum getPlayer() {
        return this.player;
    }

    public Image getImage() {
        return this.img;
    }

    public boolean isFirstMove() {
        return this.isFirstMove;
    }

    public void setPos(PositionEnum pos) {
        if (this.isFirstMove)
            this.isFirstMove = false;
        this.pos = pos;
    }

    @Override
    public String toString() {
        return this.getPiecesEnumValue().toString();
    }

    public abstract ArrayList<MoveConfigEnum> getMoveConfig();

    public abstract PiecesEnum getPiecesEnumValue();

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Piece other = (Piece) obj;
        if (player != other.player)
            return false;
        if (pos != other.pos)
            return false;
        return true;
    }

}
