package vp.chess.core.pieces;

import java.util.ArrayList;
import static java.util.Arrays.asList;

import vp.chess.core.Piece;
import vp.chess.core.PlayerEnum;
import vp.chess.core.PositionEnum;
import vp.chess.core.MoveConfigEnum;

public class Rook extends Piece {

    public Rook(PositionEnum pos, PlayerEnum player) {
        super(pos, player);
    }

    @Override
    public PiecesEnum getPiecesEnumValue() {
        return PiecesEnum.Rook;
    }

    @Override
    public ArrayList<MoveConfigEnum> getMoveConfig() {
        return new ArrayList<MoveConfigEnum>(asList(MoveConfigEnum.STRAIGHT));
    }

    @Override
    public ArrayList<MoveConfigEnum> getKillConfig() {
        return this.getMoveConfig();
    }

}