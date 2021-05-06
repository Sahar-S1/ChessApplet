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

    protected Piece(PositionEnum pos, PlayerEnum player) {
        this.pos = pos;
        this.player = player;
        this.img = PieceImageLoader.getImg(this.getPiecesEnumValue(), this.player);
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

    public void setPos(PositionEnum pos) {
        this.pos = pos;
    }

    @Override
    public String toString() {
        return this.getPiecesEnumValue().toString();
    }

    public abstract ArrayList<MoveConfigEnum> getMoveConfig();

    public abstract ArrayList<MoveConfigEnum> getKillConfig();

    public abstract PiecesEnum getPiecesEnumValue();
}
