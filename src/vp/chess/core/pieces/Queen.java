package vp.chess.core.pieces;

import java.util.ArrayList;
import static java.util.Arrays.asList;

import vp.chess.core.Piece;
import vp.chess.core.PlayerEnum;
import vp.chess.core.PositionEnum;
import vp.chess.core.MoveConfigEnum;

public class Queen extends Piece {

    public Queen(PositionEnum pos, PlayerEnum player) {
        super(pos, player);
    }

    @Override
    public PiecesEnum getPiecesEnumValue() {
        return PiecesEnum.Queen;
    }

    @Override
    public ArrayList<MoveConfigEnum> getMoveConfig() {
        return new ArrayList<MoveConfigEnum>(asList(MoveConfigEnum.STRAIGHT, MoveConfigEnum.CROSS));
    }

}