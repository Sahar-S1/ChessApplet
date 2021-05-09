package vp.chess.core.pieces;

import java.util.ArrayList;
import static java.util.Arrays.asList;

import vp.chess.core.Piece;
import vp.chess.core.PlayerEnum;
import vp.chess.core.PositionEnum;
import vp.chess.core.MoveConfigEnum;

public class Knight extends Piece {

    public Knight(PositionEnum pos, PlayerEnum player) {
        super(pos, player);
    }

    @Override
    public PiecesEnum getPiecesEnumValue() {
        return PiecesEnum.Knight;
    }

    @Override
    public ArrayList<MoveConfigEnum> getMoveConfig() {
        return new ArrayList<MoveConfigEnum>(asList(MoveConfigEnum.L_SHAPE, MoveConfigEnum.JUMP));
    }

}